// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ShapeExpression extends PsiElement {

  @Nullable
  ShapeClassName getClassName();

  @Nullable
  ShapeExpression getExpression();

  @Nullable
  ShapeLogicalExpr getLogicalExpr();

  @Nullable
  ShapeNumericExpr getNumericExpr();

  @Nullable
  ShapeSingleExpr getSingleExpr();

  @Nullable
  ShapeTypeCastingExpr getTypeCastingExpr();

}
