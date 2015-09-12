package com.shape.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeCompletionContributor extends CompletionContributor {
    public ShapeCompletionContributor() {
        extend(CompletionType.BASIC, AttrKeyCompleter.pattern(), new AttrKeyCompleter());
        extend(CompletionType.BASIC, ViewNameCompleter.pattern(), new ViewNameCompleter());
        extend(CompletionType.BASIC, KeywordCompleter.pattern(), new KeywordCompleter());
    }
}
