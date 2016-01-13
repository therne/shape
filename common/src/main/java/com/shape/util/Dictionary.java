package com.shape.util;

import java.util.HashMap;

/**
 * Backported some convenient method from Java 7's Map.
 * @author Vista
 */
public class Dictionary<K, V> extends HashMap<K, V> {

    public V get(K key, V defaultValue) {
        V value = get(key);
        return value == null ? defaultValue : value;
    }
}
