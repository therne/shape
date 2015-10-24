package com.shape.gradle

import com.shape.ast.Source
import com.shape.converter.XmlConverter
import com.shape.lexer.Lexer
import com.shape.lexer.TokenStream
import com.shape.parser.ModifyProcessor
import com.shape.parser.Parser
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import org.gradle.api.tasks.incremental.InputFileDetails
/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeIncrementalConvertTask extends DefaultTask {
    @InputDirectory
    def File inputDir

    @OutputDirectory
    def File outputDir

    @TaskAction
    def execute(IncrementalTaskInputs inputs) {
        List<InputFileDetails> allChanges = []
        inputs.outOfDate { allChanges.add it }

        // filter only .shp files
        def changes = allChanges.findAll { it.file.name.endsWith ".shp" }

        changes.each { change ->
            def doc = processSource(change.file)

            // create dir
            def outputDoc = new File(convertToOutputPath(change.file))
            def outputDir = outputDoc.toPath().parent.toFile()
            outputDir.mkdirs()

            // write
            outputDoc.withWriter { it.append doc }
        }

        inputs.removed { deleted ->
            new File(convertToOutputPath(deleted.file)).delete()
        }
    }

    def String convertToOutputPath(File source) {
        def match = source.path =~ /\/(\w+)\/$source.name/
        if (match.size() == 0) throw new Exception("Wrong shape file path : " + source.name)
        return "${outputDir.path}/${match[0][1]}/${shpNameToXml(source.name)}"
    }

    static def String shpNameToXml(String fileName) {
        return fileName.substring(0, fileName.length() - 4) + ".xml";
    }

    static def processSource(File source) {
        // lexing!
        Lexer lexer = new Lexer(source)
        TokenStream tokens = lexer.perform()

        // Parsing
        Parser parser = new Parser()
        Source src = parser.parse(source.getName(), tokens)

        // Run Modifier
        ModifyProcessor.modify(src.getAst())

        // Convert to XML
        XmlConverter converter = new XmlConverter()
        String doc = converter.performConvert(src.getAst())

        return doc
    }
}
