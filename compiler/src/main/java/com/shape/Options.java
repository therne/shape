package com.shape;

import java.util.HashMap;
import java.util.Map;

public class Options {
    private static Map<String, String> config = new HashMap<String, String>();
    private static Map<String, String> alias = new HashMap<String, String>();

    static {
        // Option alias
        alias.put("o", "console-print");

        // Default Options
        config.put("console-print", "true");
    }

    public static void parseArgument(Map<String, String> argumentMap) {
        for (Map.Entry<String, String> entry : argumentMap.entrySet()) {
            String key = entry.getKey(), value = entry.getValue();
            String aliasConfig = alias.get(key);
            config.put(aliasConfig != null ? aliasConfig : key, value);
        }
    }

    public static void setPrintInConsole() {
        config.put("console-print", "true ");
    }

    public static boolean getPrintInConsole() {
        String printConsole = config.get("console-print");
        return printConsole != null && printConsole.equals("true");
    }
}
