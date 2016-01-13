package com.shape.idea.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ProcessingContext;
import com.intellij.util.xml.ResolvingConverter;
import com.shape.ast.attributes.Attribute;
import com.shape.dictionary.AndroidDictionary;
import com.shape.idea.fakedom.FakeDomConvertContext;
import com.shape.idea.psi.*;
import org.jetbrains.android.dom.AndroidDomUtil;
import org.jetbrains.android.dom.attrs.AttributeDefinition;
import org.jetbrains.android.dom.attrs.AttributeDefinitions;
import org.jetbrains.android.dom.attrs.AttributeFormat;
import org.jetbrains.android.facet.AndroidFacet;
import org.jetbrains.android.resourceManagers.LocalResourceManager;
import org.jetbrains.android.resourceManagers.ResourceManager;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.EnumSet;

import static org.jetbrains.android.util.AndroidUtils.SYSTEM_RESOURCE_PACKAGE;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class AttrValueCompleter extends BaseCompletionProvider {
    private static final InsertHandler<LookupElement> COMMA_INSERTER = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
            Editor editor = context.getEditor();
            int cursorOffset = editor.getCaretModel().getOffset();
            editor.getDocument().insertString(cursorOffset,  ", ");
            editor.getCaretModel().moveToOffset(cursorOffset + 2);
        }
    };

    @Override
    PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement().withSuperParent(2, ShapeAttrValue.class).withElementType(
                TokenSet.create(ShapeTypes.IDENTIFIER, ShapeTypes.STR));
    }

    @Override
    protected void addCompletions(@NotNull final CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        PsiElement elem = completionParameters.getPosition().getParent().getParent().getParent();
        ShapeAttributePair attrPair = (ShapeAttributePair) elem;
        Attribute attribute = ShapeAttrUtils.getAttribute(attrPair);

        AndroidFacet facet = AndroidFacet.getInstance(elem);
        if (facet == null) return;
        ResourceManager resourceManager = facet.getResourceManager(SYSTEM_RESOURCE_PACKAGE);
        if (resourceManager == null) return;

        // load attribute autocompletion information
        AttributeDefinitions attrDefs = resourceManager.getAttributeDefinitions();
        AttributeDefinition definition = attrDefs.getAttrDefByName(attribute.getConvertedKey());

        // try to lookup once again
        if (definition == null) definition = attrDefs.getAttrDefByName(attribute.getConvertedKeyWithNamespace());
        if (definition == null) return;

        ResolvingConverter converter = AndroidDomUtil.getConverter(definition);
        if (converter == null) return;

        Collection completions = converter.getVariants(new FakeDomConvertContext(attrPair));
        for (Object result : completions) {
            String value = String.valueOf(result);
            if (!value.startsWith("@")) value = AndroidDictionary.shapeParam(value);
            resultSet.addElement(LookupElementBuilder.create(value).withInsertHandler(COMMA_INSERTER));
        }
    }
}
