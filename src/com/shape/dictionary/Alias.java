package com.shape.dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Aliases
 * @author Vista
 */
public class Alias {
    private Map<String, String> dictionary = new HashMap<>();

    public void add(String original, String... aliases) {
        for (String alias : aliases) dictionary.put(alias, original);
    }

    public String get(String name) {
        return dictionary.getOrDefault(name, name);
    }
}
