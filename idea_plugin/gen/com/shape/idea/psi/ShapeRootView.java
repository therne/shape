// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ShapeRootView extends ShapeView {

  @NotNull
  List<ShapeIdDefinition> getIdDefinitionList();

  @NotNull
  List<ShapeStyleReference> getStyleReferenceList();

  @NotNull
  ShapeViewAttributeBlock getViewAttributeBlock();

  @Nullable
  ShapeViewBlock getViewBlock();

  @NotNull
  ShapeViewName getViewName();

}
