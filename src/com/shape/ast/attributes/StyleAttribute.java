package com.shape.ast.attributes;

public class StyleAttribute extends Attribute {
    public StyleAttribute(String value) {
        super("", "style", value);
    }

    @Override
    public String toString() {
        return "style=\"@style/"+value+"\"";
    }
}
