package com.shape.idea.psi;

import com.shape.ast.attributes.Attribute;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeAttrUtils {

    public static Attribute getAttribute(ShapeAttributePair pair) {
        String key = pair.getAttrKey().getText();
        String value = pair.getAttrValue() == null ? ""
                : destringify(pair.getAttrValue().getFirstChild().getText());

        return new Attribute(key, value);
    }

    private static String destringify(String str) {
        return str.startsWith("\"") ? str.substring(1, str.length()-1) : str;
    }
}
