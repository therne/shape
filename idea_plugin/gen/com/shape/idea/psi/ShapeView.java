// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ShapeView extends PsiElement {

  @NotNull
  List<ShapeIdDefinition> getIdDefinitionList();

  @NotNull
  List<ShapeStyleReference> getStyleReferenceList();

  @Nullable
  ShapeViewAttributeBlock getViewAttributeBlock();

  @Nullable
  ShapeViewBlock getViewBlock();

  @NotNull
  ShapeViewName getViewName();

}
