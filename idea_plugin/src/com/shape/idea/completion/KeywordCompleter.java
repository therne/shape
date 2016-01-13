package com.shape.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.ProcessingContext;
import com.shape.idea.psi.ShapeTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class KeywordCompleter extends BaseCompletionProvider {

    private static final InsertHandler<LookupElement> SPACE_INSERTER = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
            Editor editor = context.getEditor();
            int cursorOffset = editor.getCaretModel().getOffset();
            editor.getDocument().insertString(cursorOffset, " ");
            editor.getCaretModel().moveToOffset(cursorOffset + 1);
        }
    };

    private static final ArrayList<LookupElement> LOOKUP_LIST = new ArrayList<LookupElement>();
    static {
        LOOKUP_LIST.add(LookupElementBuilder.create("import").withInsertHandler(SPACE_INSERTER));
        LOOKUP_LIST.add(LookupElementBuilder.create("use").withInsertHandler(SPACE_INSERTER));
        LOOKUP_LIST.add(LookupElementBuilder.create("style").withInsertHandler(SPACE_INSERTER));
        LOOKUP_LIST.add(LookupElementBuilder.create("mixin").withInsertHandler(SPACE_INSERTER));
        LOOKUP_LIST.add(LookupElementBuilder.create("as").withInsertHandler(SPACE_INSERTER));
    }

    @Override
    PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement()
                .withElementType(ShapeTypes.IDENTIFIER)
                .withParent(PsiFile.class);
    }


    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {
        resultSet.addAllElements(LOOKUP_LIST);
    }
}
