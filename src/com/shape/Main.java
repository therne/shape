package com.shape;

import com.shape.ast.Source;
import com.shape.converter.XmlConverter;
import com.shape.error.ShapeError;
import com.shape.lexer.Lexer;
import com.shape.parser.ModifyProcessor;
import com.shape.lexer.TokenStream;
import com.shape.parser.Parser;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("usage: less [-o] files ...");
            return;
        }

        // parameter inspection
        Map<String, String> options = new HashMap<>();
        List<File> sourceFiles = new ArrayList<>();

        String key = null;
        for (String arg : args) {
            if (arg.startsWith("--")) key = arg.substring(2);
            else if (arg.startsWith("-")) key = arg.substring(1);
            else if (key != null) {
                options.put(key, arg);
                key = null;
            }
            else sourceFiles.add(new File(arg));
        }

        // give option
        Options.parseArgument(options);

        // check source file existance
        for (File file : sourceFiles) {
            if (!file.exists()) {
                Log.error("error : " + file.getPath() + " file not found.");
                return;
            }
        }

        try {
            for (File source : sourceFiles) {
                Log.setCurrentSource(source);
                processSource(source);
            }
        } catch (ShapeError error) {
            Log.error(error);
        }
    }

    /**
     * Processes source.
     * @param source
     * @throws ShapeError
     */
    private static void processSource(File source) throws ShapeError {
        Log.debug("[SHAPE] Compiler Inspectation result");
        Log.debug("=============================");
        Log.benchStart("Total time spent");

        // Perform lexing!
        Log.benchStart("Lexing");
        Lexer lexer = new Lexer(source);
        TokenStream tokens = lexer.perform();
        Log.benchEnd("Lexing");

        // Parsing
        Log.benchStart("Parsing");
        Parser parser = new Parser();
        Source src = parser.parse(source.getName(), tokens);
        Log.benchEnd("Parsing");

        // Run Modifier
        Log.benchStart("Modification");
        ModifyProcessor.modify(src.getAst());
        Log.benchEnd("Modification");

        // Convert to XML
        Log.benchStart("Converting");
        XmlConverter converter = new XmlConverter();
        String doc = converter.performConvert(src.getAst());
        Log.benchEnd("Converting");

        Log.benchEnd("Total time spent");
        Log.debug("===============================\n");
        System.out.println(doc);
    }
}
