// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.kotlin.idea.codeInsight

import com.intellij.codeInsight.daemon.QuickFixActionRegistrar
import com.intellij.codeInsight.quickfix.UnresolvedReferenceQuickFixProvider
import com.intellij.psi.PsiReference
import org.jetbrains.kotlin.diagnostics.Severity
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.highlighter.Fe10QuickFixProvider
import com.intellij.openapi.application.runReadAction
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode

class KotlinUnresolvedReferenceQuickFixProvider: UnresolvedReferenceQuickFixProvider<PsiReference>() {
    override fun registerFixes(reference: PsiReference, registrar: QuickFixActionRegistrar) {
        val element = reference.element as? KtElement ?: return
        val project = element.project
        val bindingContext = runReadAction { element.analyze(BodyResolveMode.PARTIAL_WITH_DIAGNOSTICS) }
        val diagnostics = bindingContext.diagnostics.filter {
            it.severity == Severity.ERROR
        }.ifEmpty { return }

        val quickFixProvider = Fe10QuickFixProvider.getInstance(project)
        diagnostics.groupBy { it.psiElement }.forEach { (psiElement, sameElementDiagnostics) ->
            val textRange = psiElement.textRange
            if (textRange in element.textRange) {
                sameElementDiagnostics.groupBy { it.factory }.forEach { (_, sameTypeDiagnostic) ->
                    val quickFixes = quickFixProvider.createUnresolvedReferenceQuickFixes(sameTypeDiagnostic)
                    quickFixes.values().forEach {
                        registrar.register(textRange, it, null)
                    }
                }
            }
        }
    }

    override fun getReferenceClass(): Class<PsiReference> = PsiReference::class.java
}