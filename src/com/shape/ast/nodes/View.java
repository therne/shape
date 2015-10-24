package com.shape.ast.nodes;

import com.shape.ast.attributes.Attribute;
import com.shape.ast.styles.Style;
import com.shape.ast.attributes.StyleAttribute;

import java.util.ArrayList;

/**
 * View Node - including other Views, ViewGroup (Layouts)
 */
public class View extends Node {

    private String className;

    // attributes - special
    private String id;
    private String styleResourceName;
    private ArrayList<Style> stylesApplied = new ArrayList<>();

    public View(String className) {
        this.className = className;
    }

    public void setId(String id) {
        this.id = id;
        addAttribute(new Attribute("id", "@+id/" + id));
    }

    public void applyStyle(Style style) {
        stylesApplied.add(style);
        style.getAttributes().forEach(super::addAttribute);
    }

    public void setStyleResourceName(String name) {
        this.styleResourceName = name;
        addAttribute(new StyleAttribute(name));
    }

    public String getStyleResourceName() {
        return styleResourceName;
    }

    public String getClassName() {
        return className;
    }

    public String getId() {
        return id;
    }
}
