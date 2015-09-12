package com.shape.ast.nodes;

import com.shape.ast.attributes.Attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Node {
    // parent, child nodes;
    private Node parent;
    private List<Node> children = new ArrayList<>();

    // attributes
    private List<Attribute> attributes = new ArrayList<>();
    private Map<String, Attribute> attributeMap = new HashMap<>();

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Node child) {
        child.setParent(this);
        children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addAttribute(Attribute attr) {
        Attribute old = attributeMap.get(attr.getKey());
        if (old != null) {
            old.value = attr.value;
            return;
        }
        attributes.add(attr);
        attributeMap.put(attr.getKey(), attr);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Map<String, Attribute> getAttrMap() {
        return attributeMap;
    }
}
