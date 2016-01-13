package com.shape.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
abstract class BaseCompletionProvider extends CompletionProvider<CompletionParameters> {

    abstract PsiElementPattern<? extends PsiElement, ? extends PsiElementPattern<?,?>> pattern();
}
