package com.shape.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.Plugin
import org.gradle.api.Project

public class ShapePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        BaseExtension android

        def isLibrary = project.plugins.hasPlugin(LibraryPlugin)
        if (isLibrary) {
            android = project.extensions.getByType(LibraryExtension)
            android.libraryVariants.all { configureTask(project, it) }

        } else {
            android = project.extensions.getByType(AppExtension)
            android.applicationVariants.all { configureTask(project, it) }
        }

        android.testVariants.all { configureTask(project, it) }

        // add build configurations
        android.aaptOptions.ignoreAssetsPattern = "!*.shp"
    }

    /**
     * Configure shape converting task.
     * @param project {@link Project}
     * @param variant Android build variant {@see BaseVariant}
     */
    static configureTask(Project project, BaseVariant variant) {
        ShapeConvertTask shapeConvertTask = project.task(
                "compileShape${variant.name.capitalize()}Resources",
                type: ShapeConvertTask
        ) as ShapeConvertTask

        shapeConvertTask.inputDir = project.file("build/intermediates/res/$variant.name/")
        shapeConvertTask.dependsOn variant.mergeResources
        variant.outputs.each {
            it.processResources.dependsOn shapeConvertTask
        }
    }
}