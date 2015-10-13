package com.shape.idea.highlighting;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import com.shape.idea.TokenType;
import com.shape.idea.psi.*;
import org.jetbrains.annotations.NotNull;

public class ShapeSyntaxAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        element.accept(new ShapeVisitor() {
            @Override
            public void visitViewName(@NotNull ShapeViewName o) {
                super.visitViewName(o);
                setHighlighting(o, holder, XmlHighlighterColors.HTML_TAG_NAME);
            }

            @Override
            public void visitAttrKey(@NotNull ShapeAttrKey o) {
                super.visitAttrKey(o);
                setHighlighting(o, holder, XmlHighlighterColors.HTML_ATTRIBUTE_NAME);
            }

            @Override
            public void visitAttrValue(@NotNull ShapeAttrValue o) {
                super.visitAttrValue(o);
                setHighlighting(o, holder, XmlHighlighterColors.HTML_ATTRIBUTE_VALUE);
            }
        });
    }

    private static void setHighlighting(@NotNull PsiElement element, @NotNull AnnotationHolder holder,
                                        @NotNull TextAttributesKey key) {
        holder.createInfoAnnotation(element, null).setEnforcedTextAttributes(TextAttributes.ERASE_MARKER);
        holder.createInfoAnnotation(element, null).setEnforcedTextAttributes(
                EditorColorsManager.getInstance().getGlobalScheme().getAttributes(key));
    }
}