package com.shape.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class ShapePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.plugins.withId('com.android.application') {
            project.apply plugin: ShapeAndroidPlugin
        }

        project.plugins.withId('com.android.library') {
            project.apply plugin: ShapeAndroidPlugin
        }
    }
}