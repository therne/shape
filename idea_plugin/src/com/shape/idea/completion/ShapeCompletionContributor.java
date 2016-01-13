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
        add(new KeywordCompleter());
        add(new ViewNameCompleter());
        add(new AttrKeyCompleter());
        add(new AttrValueCompleter());
    }

    private void add(BaseCompletionProvider provider) {
        extend(CompletionType.BASIC, provider.pattern(), provider);
    }
}
