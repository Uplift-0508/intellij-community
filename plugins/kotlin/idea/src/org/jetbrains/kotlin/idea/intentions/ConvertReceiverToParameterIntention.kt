// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.intentions

import com.intellij.codeInsight.intention.LowPriorityAction
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateBuilderImpl
import com.intellij.codeInsight.template.TemplateEditingAdapter
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.idea.base.resources.KotlinBundle
import org.jetbrains.kotlin.idea.codeinsight.api.classic.intentions.SelfTargetingOffsetIndependentIntention
import org.jetbrains.kotlin.idea.codeinsight.utils.ChooseStringExpression
import org.jetbrains.kotlin.idea.core.getOrCreateValueParameterList
import org.jetbrains.kotlin.idea.refactoring.changeSignature.*
import org.jetbrains.kotlin.idea.refactoring.resolveToExpectedDescriptorIfPossible
import org.jetbrains.kotlin.idea.util.application.executeWriteCommand
import org.jetbrains.kotlin.idea.util.application.isUnitTestMode
import com.intellij.openapi.application.runWriteAction
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import org.jetbrains.kotlin.psi.typeRefHelpers.setReceiverTypeReference

class ConvertReceiverToParameterIntention : SelfTargetingOffsetIndependentIntention<KtTypeReference>(
    KtTypeReference::class.java,
    KotlinBundle.lazyMessage("convert.receiver.to.parameter")
), LowPriorityAction {
    override fun isApplicableTo(element: KtTypeReference): Boolean = (element.parent as? KtNamedFunction)?.receiverTypeReference == element

    private fun configureChangeSignature(newName: String? = null): KotlinChangeSignatureConfiguration =
        object : KotlinChangeSignatureConfiguration {
            override fun configure(originalDescriptor: KotlinMethodDescriptor): KotlinMethodDescriptor = originalDescriptor.modify {
                it.receiver = null
                if (newName != null) {
                    it.parameters.first().name = newName
                }
            }

            override fun performSilently(affectedFunctions: Collection<PsiElement>) = true
        }

    override fun startInWriteAction() = false

    override fun applyTo(element: KtTypeReference, editor: Editor?) {
        val function = element.parent as? KtNamedFunction ?: return
        val descriptor = function.resolveToExpectedDescriptorIfPossible() as FunctionDescriptor

        val project = function.project

        if (editor != null && !isUnitTestMode()) {
            val receiverNames = suggestReceiverNames(project, descriptor)
            val defaultReceiverName = receiverNames.first()
            val receiverTypeRef = function.receiverTypeReference!!
            val psiFactory = KtPsiFactory(element)
            val newParameter = psiFactory.createParameter("$defaultReceiverName: Dummy").apply { typeReference!!.replace(receiverTypeRef) }

            project.executeWriteCommand(text) {
                function.setReceiverTypeReference(null)
                val addedParameter = function.getOrCreateValueParameterList().addParameterAfter(newParameter, null)

                with(PsiDocumentManager.getInstance(project)) {
                    commitDocument(editor.document)
                    doPostponedOperationsAndUnblockDocument(editor.document)
                }

                editor.caretModel.moveToOffset(function.startOffset)

                val templateBuilder = TemplateBuilderImpl(function)
                templateBuilder.replaceElement(addedParameter.nameIdentifier!!, ChooseStringExpression(receiverNames))
                TemplateManager.getInstance(project).startTemplate(
                    editor,
                    templateBuilder.buildInlineTemplate(),
                    object : TemplateEditingAdapter() {
                        private fun revertChanges() {
                            runWriteAction {
                                function.setReceiverTypeReference(addedParameter.typeReference)
                                function.valueParameterList!!.removeParameter(addedParameter)
                            }
                        }

                        override fun templateFinished(template: Template, brokenOff: Boolean) {
                            val newName = addedParameter.name
                            revertChanges()
                            if (!brokenOff) {
                                runChangeSignature(
                                    element.project,
                                    editor,
                                    function.resolveToExpectedDescriptorIfPossible() as FunctionDescriptor,
                                    configureChangeSignature(newName),
                                    function.receiverTypeReference!!,
                                    text
                                )
                            }
                        }

                        override fun templateCancelled(template: Template?) {
                            revertChanges()
                        }
                    }
                )
            }
        } else {
            runChangeSignature(element.project, editor, descriptor, configureChangeSignature(), element, text)
        }
    }
}
