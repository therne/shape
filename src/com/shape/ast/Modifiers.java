package com.shape.ast;

import com.shape.ast.attributes.Attribute;
import com.shape.ast.nodes.View;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class Modifiers {

    /**
     * Sets width or height to 0dp when layout_weight is given.
     */
    public static Modifier weightModifier() {
        return WEIGHT_MODIFIER;
    }

    private static final Modifier WEIGHT_MODIFIER = (view) -> {
        // parent LinearLayout
        View parent = (View) view.getParent();
        String targetName;

        if (parent == null) return;

        Attribute orient = parent.getAttrMap().get("orientation");
        if (orient != null && orient.getValue().equals("vertical")) targetName = "layout_height";
        else targetName = "layout_width";

        // modify to 0dp
        view.getAttrMap().get(targetName).value = "0dp";
    };
}
