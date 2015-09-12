package com.shape.idea;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import org.jetbrains.annotations.NotNull;
 
public class ShapeFileTypeFactory extends com.intellij.openapi.fileTypes.FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(ShapeFileType.INSTANCE, "shp");
    }
}