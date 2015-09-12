package com.shape.idea.highlighting;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.shape.idea.lexer.ShapeLexer;
import org.jetbrains.annotations.NotNull;


public class ShapeSyntaxHighlighter extends SyntaxHighlighterBase {

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new ShapeLexer(null));
    }
 
    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return ShapeSyntaxColors.getAttr(tokenType);
    }
}