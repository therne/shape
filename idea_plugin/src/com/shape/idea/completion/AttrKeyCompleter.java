package com.shape.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ProcessingContext;
import com.shape.dictionary.AndroidDictionary;
import com.shape.idea.psi.ShapeAttrKey;
import com.shape.idea.psi.ShapeAttrValue;
import com.shape.idea.psi.ShapeTypes;
import org.jetbrains.android.dom.attrs.AttributeDefinitions;
import org.jetbrains.android.facet.AndroidFacet;
import org.jetbrains.android.resourceManagers.ResourceManager;
import org.jetbrains.annotations.NotNull;

import static org.jetbrains.android.util.AndroidUtils.SYSTEM_RESOURCE_PACKAGE;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class AttrKeyCompleter extends BaseCompletionProvider {
    @Override
    PsiElementPattern pattern() {
        return PlatformPatterns.psiElement().withParent(ShapeAttrKey.class).withElementType(ShapeTypes.IDENTIFIER);
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        AndroidFacet facet = AndroidFacet.getInstance(completionParameters.getPosition());
        if (facet == null) return;
        ResourceManager resourceManager = facet.getResourceManager(SYSTEM_RESOURCE_PACKAGE);
        if (resourceManager == null) return;

        // load attribute autocompletion information
        AttributeDefinitions attrDefs = resourceManager.getAttributeDefinitions();
        if (attrDefs == null) return;

        for (String key : attrDefs.getAttributeNames()) {
            resultSet.addElement(LookupElementBuilder.create(AndroidDictionary.shapeAttrName(key))
                    .withInsertHandler(new InsertHandler<LookupElement>() {
                        @Override
                        public void handleInsert(InsertionContext context, LookupElement item) {
                            Editor editor = context.getEditor();
                            int cursorOffset = editor.getCaretModel().getOffset();
                            editor.getDocument().insertString(cursorOffset,  ": ");
                            editor.getCaretModel().moveToOffset(cursorOffset + 2);
                        }
                    })
            );
        }
    }
}
