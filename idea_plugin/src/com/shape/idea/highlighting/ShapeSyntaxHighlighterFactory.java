package com.shape.idea.highlighting;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
 
public class ShapeSyntaxHighlighterFactory extends com.intellij.openapi.fileTypes.SyntaxHighlighterFactory {
    @NotNull
    @Override
    public com.intellij.openapi.fileTypes.SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new ShapeSyntaxHighlighter();
    }
}