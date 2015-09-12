package com.shape.ast.attributes;

import com.shape.ast.Modifier;
import com.shape.dictionary.AndroidDictionary;

import java.util.ArrayList;
import java.util.List;

public class Attribute {
    public String namespace;
    public String key;
    public String value;
    public String originalKey;
    private List<Modifier> modifiers = new ArrayList<>();

    public Attribute(String key, String value) {
        this("android", key, value);
    }

    public Attribute(String namespace, String key, String value) {
        this.namespace = namespace;
        this.key = AndroidDictionary.attributeName(key);
        this.value = value;

        this.originalKey = key;
//        this.originalValue = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public boolean hasModifier() {
        return modifiers.size() != 0;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    /**
     * @return Android XML style attribute code. (ns:key="value")
     */
    @Override
    public String toString() {
        return namespace + ":" + key + "=\"" + value + "\"";
    }
}
