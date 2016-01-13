package com.shape;

import com.shape.error.ShapeError;
import com.shape.error.SyntaxError;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Log {
    private static String sourceFilePath;

    private static Map<String, Long> BENCH_TABLE = new HashMap<String, Long>();

    public static void setCurrentSource(File sourceFile) {
        sourceFilePath = sourceFile.getName();
    }

    public static void debug(String format, Object ...args) {
        System.out.printf(format + "\n", args);
    }

    public static void error(String message) {
        System.err.printf(message);
    }

    public static void error(ShapeError error) {
        if (error instanceof SyntaxError) syntaxError((SyntaxError) error);
        else System.err.printf("%s: %s\n", sourceFilePath, error.getMessage());
    }

    private static void syntaxError(SyntaxError error) {
        System.err.printf("%s:%d:%d: %s\n", sourceFilePath,
                error.getLineNo(), error.getColumnNo(), error.getMessage());
    }

    public static void benchStart(String msg) {
        BENCH_TABLE.put(msg, System.currentTimeMillis());
    }

    public static void benchEnd(String msg) {
        Long start = BENCH_TABLE.get(msg);
        if (start == null) {
            System.out.println(msg + " : Unknown");
            return;
        }

        System.out.println(msg + " : " + (System.currentTimeMillis() - start) + "ms");
        BENCH_TABLE.remove(msg);
    }
}
