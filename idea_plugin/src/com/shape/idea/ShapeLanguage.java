package com.shape.idea;

import com.intellij.lang.Language;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeLanguage extends Language {
    public static final ShapeLanguage INSTANCE = new ShapeLanguage();

    public ShapeLanguage() {
        super("Shape");
    }
}
