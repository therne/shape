package com.shape.idea.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;
import com.shape.idea.parser.ShapeParserDefinition;

import java.io.Reader;
 
public class ShapeLexerAdapter extends MergingLexerAdapter {
    public ShapeLexerAdapter() {
        super(new FlexAdapter(new ShapeLexer((Reader) null)), TokenSet.orSet(ShapeParserDefinition.COMMENTS, ShapeParserDefinition.WHITE_SPACES));
    }
}