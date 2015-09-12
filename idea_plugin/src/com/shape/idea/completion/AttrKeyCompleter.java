package com.shape.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.shape.idea.psi.ShapeAttrKey;
import com.shape.idea.psi.ShapeTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class AttrKeyCompleter extends CompletionProvider<CompletionParameters> {

    private static final String[] KEYS = new String[] {
            "width", "height", "margin", "marginStart", "marginEnd", "marginLeft", "marginRight", "marginTop", "marginBottom",
            "padding", "paddingTop", "paddingRight", "paddingBottom", "paddingLeft",
            "visible", "touchable", "focusable", "invisible", "gone", "top", "left", "right",
            "orientation", "centerInParent", "toRightOf", "toLeftOf", "above", "below", "alignBaseline",
            "background", "textColor", "hintText", "hintColor", "flex"
    };

    static PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement()
                .withElementType(ShapeTypes.IDENTIFIER)
                .withParent(ShapeAttrKey.class);
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        for (String key : KEYS) {
            resultSet.addElement(LookupElementBuilder.create(key)
                    .withInsertHandler((context, lookupElement) -> {
                        Editor editor = context.getEditor();
                        int cursorOffset = editor.getCaretModel().getOffset();
                        editor.getDocument().insertString(cursorOffset,  ": ");
                        editor.getCaretModel().moveToOffset(cursorOffset + 2);
                    })
            );
        }
    }
}
