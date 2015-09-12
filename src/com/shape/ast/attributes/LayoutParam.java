package com.shape.ast.attributes;

import com.shape.dictionary.Alias;

public class LayoutParam extends Attribute {
    /**
     * Layout params - layout_width, layout_height.
     */
    private static final Alias PARAM_ALIAS = new Alias();
    static {
        PARAM_ALIAS.add("match_parent", "fill_parent", "match");
        PARAM_ALIAS.add("wrap_content", "wrap");
    }

//    public Dimension explicitValue;

    public LayoutParam(String key, String value) {
        super(key, PARAM_ALIAS.get(value));
    }

//    public LayoutParam(String key, Dimension value) {
//        super(key, value.toString());
//        this.explicitValue = value;
//    }
}
