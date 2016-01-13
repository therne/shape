package com.shape.dictionary;

import com.shape.util.Dictionary;

/**
 * Aliases
 * @author Vista
 */
public class Alias {
    private Dictionary<String, String> dictionary = new Dictionary<String, String>();

    public void add(String original, String... aliases) {
        for (String alias : aliases) dictionary.put(alias, original);
    }

    public String get(String name) {
        return dictionary.get(name, name);
    }
}
