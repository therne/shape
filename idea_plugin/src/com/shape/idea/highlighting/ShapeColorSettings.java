package com.shape.idea.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.shape.idea.ShapeIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static com.shape.idea.highlighting.ShapeSyntaxColors.getColor;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeColorSettings implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
            new AttributesDescriptor("Line comment", getColor("LINE_COMMENT")),
            new AttributesDescriptor("Block comment", getColor("LINE_COMMENT")),
            new AttributesDescriptor("Keyword", getColor("KEYWORD")),
            new AttributesDescriptor("Identifier", getColor("IDENTIFIER")),
            new AttributesDescriptor("String", getColor("STRING")),
            new AttributesDescriptor("Semicolon", getColor("SEMICOLON")),
            new AttributesDescriptor("Colon", getColor("COLON")),
            new AttributesDescriptor("Dot", getColor("DOT")),
            new AttributesDescriptor("Comma", getColor("COMMA")),
            new AttributesDescriptor("Operator", getColor("OPERATOR")),
            new AttributesDescriptor("Braces", getColor("BRACES")),
            new AttributesDescriptor("Brackets", getColor("BRACKETS")),
            new AttributesDescriptor("Parentheses", getColor("PARENTHESES")),
            new AttributesDescriptor("Bad character", getColor("BAD_CHARACTER")),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return ShapeIcons.FILE;
    }

    @NotNull
    @Override
    public com.intellij.openapi.fileTypes.SyntaxHighlighter getHighlighter() {
        return new ShapeSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return  "/**\n" +
                " * This is a block comment!\n" +
                " */\n" +
                "import android.support.v4.view.ViewPager\n" +
                "Linear (vertical, width: match, padding: 16 24 16 24dp) {\n" +
                "    // you can import view names\n" +
                "    ViewPager #pager (width: 100%, height: match)\n" +
                "    Button .bigButton #ok (width: match, text: \"Style test\")\n" +
                "}\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Shape";
    }
}
