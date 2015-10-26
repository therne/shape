package com.shape;

import java.util.HashMap;
import java.util.Map;

public class Options {
    private static Map<String, String> config = new HashMap<>();
    private static Map<String, String> alias = new HashMap<>();

    static {
        // Option alias
        alias.put("o", "console-print");

        // Default Options
        config.put("console-print", "true");
    }

    public static void parseArgument(Map<String, String> argumentMap) {
        for (Map.Entry<String, String> entry : argumentMap.entrySet()) {
            String key = entry.getKey(), value = entry.getValue();
            config.put(alias.getOrDefault(key, key), value);
        }
    }

    public static void setPrintInConsole() {
        config.put("console-print", "true ");
    }

    public static boolean getPrintInConsole() {
        return config.getOrDefault("console-print", "").equals("true");
    }
}
