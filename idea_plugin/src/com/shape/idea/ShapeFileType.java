package com.shape.idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeFileType extends LanguageFileType {
    public static final ShapeFileType INSTANCE = new ShapeFileType();

    private ShapeFileType() {
        super(ShapeLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Shape";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Shape language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "shp";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ShapeIcons.FILE;
    }
}
