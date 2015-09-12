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
        return "# You are reading the \".properties\" entry.\n" +
                "! The exclamation mark can also mark text as comments.\n" +
                "website = http://en.wikipedia.org/\n" +
                "language = English\n" +
                "# The backslash below tells the application to continue reading\n" +
                "# the value onto the next line.\n" +
                "message = Welcome to \\\n" +
                "          Wikipedia!\n" +
                "# Add spaces to the key\n" +
                "key\\ with\\ spaces = This is the value that could be looked up with the key \"key with spaces\".\n" +
                "# Unicode\n" +
                "tab : \\u0009";
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
