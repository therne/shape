package com.shape.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 * @author Vista
 */
class ShapeConvertTask extends DefaultTask {
    @InputDirectory
    def File inputDir

    @OutputDirectory
    def File outputDir

    @Input
    def inputProperty

    @TaskAction
    def execute(IncrementalTaskInputs inputs) {
        println inputs.incremental ?
                "CHANGED inputs considered out of date" :
                "ALL inputs considered out of date"

        def changes = []
        inputs.outOfDate { changes += it }

        changes.each {
            println "changed file : ${it.file.name}"
            // TODO: DO CONVERSION
        }

        inputs.removed { change ->
            println "removed : ${change.file.name}"
            change.file.delete()
        }
    }
}
