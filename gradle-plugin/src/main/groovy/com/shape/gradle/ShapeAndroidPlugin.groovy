package com.shape.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class ShapeAndroidPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def isLibrary = project.plugins.hasPlugin(LibraryPlugin)
        if (isLibrary) {
            def android = project.extensions.getByType(LibraryExtension)
        }
    }
}