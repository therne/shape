// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ShapeForStatement extends PsiElement {

  @NotNull
  List<ShapeExpression> getExpressionList();

  @NotNull
  ShapeStatement getStatement();

  @Nullable
  ShapeVariableDeclaration getVariableDeclaration();

}
