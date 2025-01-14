// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.compiler

import org.jetbrains.kotlin.config.LanguageVersionSettings
import org.jetbrains.kotlin.idea.MainFunctionDetector
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.idea.util.application.withPsiAttachment
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.utils.KotlinExceptionWithAttachments

internal class IdeMainFunctionDetectorFactory : MainFunctionDetector.Factory {
    override fun createMainFunctionDetector(
        trace: BindingTrace,
        languageVersionSettings: LanguageVersionSettings
    ): MainFunctionDetector {
        return MainFunctionDetector(languageVersionSettings) { function ->
            function.resolveToDescriptorIfAny(bodyResolveMode = BodyResolveMode.FULL)
                ?: throw KotlinExceptionWithAttachments("No descriptor resolved for $function")
                    .withPsiAttachment("function.text", function)
        }
    }
}