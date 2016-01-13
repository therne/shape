package com.shape.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.intellij.util.xml.ResolvingConverter;
import com.shape.ast.attributes.Attribute;
import com.shape.dictionary.AndroidDictionary;
import com.shape.idea.fakedom.FakeDomConvertContext;
import com.shape.idea.psi.ShapeAttrUtils;
import com.shape.idea.psi.ShapeAttributePair;
import com.shape.idea.psi.ShapeStyleReference;
import com.shape.idea.psi.ShapeTypes;
import org.jetbrains.android.dom.AndroidDomUtil;
import org.jetbrains.android.dom.attrs.AttributeDefinition;
import org.jetbrains.android.dom.attrs.AttributeDefinitions;
import org.jetbrains.android.facet.AndroidFacet;
import org.jetbrains.android.resourceManagers.ResourceManager;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

import static org.jetbrains.android.util.AndroidUtils.SYSTEM_RESOURCE_PACKAGE;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class StyleCompleter extends BaseCompletionProvider {
    private static final InsertHandler<LookupElement> SPACE_INSERTER = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
            Editor editor = context.getEditor();
            int cursorOffset = editor.getCaretModel().getOffset();
            editor.getDocument().insertString(cursorOffset,  " ");
            editor.getCaretModel().moveToOffset(cursorOffset + 1);
        }
    };

    @Override
    PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement().withParent(ShapeStyleReference.class)
                .withElementType(ShapeTypes.DOT_HEAD_NAME);
    }

    @Override
    protected void addCompletions(@NotNull final CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        // TODO: Style autocompletion
    }
}
