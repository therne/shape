package com.shape.idea.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import java.util.HashMap;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.shape.idea.parser.ShapeParserDefinition.*;
import static com.shape.idea.psi.ShapeTypes.*;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public abstract class ShapeSyntaxColors  {
    private static final HashMap<String, TextAttributesKey> COLOR_MAP = new HashMap<>();
    private static final HashMap<IElementType, TextAttributesKey[]> ATTR_MAP = new HashMap<>();
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    static {
        // Define all colors
        registerColor(LINE_COMMENT, "LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
        registerColor(BLOCK_COMMENT, "BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        registerColor(TokenType.BAD_CHARACTER, "BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

        registerColor(TokenSet.create(LBRACE, RBRACE), "BRACES", DefaultLanguageHighlighterColors.BRACES);
        registerColor(TokenSet.create(LBRACK, RBRACK), "BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
        registerColor(TokenSet.create(LPAREN, RPAREN), "PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);

        registerColor(DOT, "DOT", DefaultLanguageHighlighterColors.DOT);
        registerColor(COLON, "COLON", HighlighterColors.TEXT);
        registerColor(COMMA, "COMMA", DefaultLanguageHighlighterColors.COMMA);
        registerColor(SEMICOLON, "SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
        registerColor(IDENTIFIER, "IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

        registerColor(STR, "STRING", DefaultLanguageHighlighterColors.STRING);
        registerColor(NUMBERS, "NUMBER", DefaultLanguageHighlighterColors.NUMBER);
        registerColor(KEYWORDS, "KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
        registerColor(OPERATORS, "OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

        registerColor(VIEW_NAME, "VIEW_NAME", DefaultLanguageHighlighterColors.MARKUP_TAG);
        registerColor(ATTR_VALUE, "ATTR_VALUE", DefaultLanguageHighlighterColors.STRING);
    }

    public static void registerColor(IElementType type, String name, TextAttributesKey value) {
        TextAttributesKey newValue = createTextAttributesKey("SHAPE_" + name, value);
        COLOR_MAP.put(name, newValue);
        ATTR_MAP.put(type, new TextAttributesKey[]{newValue});
    }

    public static void registerColor(TokenSet set, String name, TextAttributesKey value) {
        TextAttributesKey newValue = createTextAttributesKey("SHAPE_" + name, value);
        COLOR_MAP.put(name, newValue);

        IElementType[] types = set.getTypes();
        for (IElementType elem : types) ATTR_MAP.put(elem, new TextAttributesKey[]{newValue});
    }

    public static TextAttributesKey getColor(String name) {
        return COLOR_MAP.get(name);
    }

    public static TextAttributesKey[] getAttr(IElementType elem) {
        return ATTR_MAP.getOrDefault(elem, EMPTY_KEYS);
    }
}
