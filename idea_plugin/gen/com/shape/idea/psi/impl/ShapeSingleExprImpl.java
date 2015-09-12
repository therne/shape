// This is a generated file. Not intended for manual editing.
package com.shape.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.shape.idea.psi.ShapeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.shape.idea.psi.*;

public class ShapeSingleExprImpl extends ASTWrapperPsiElement implements ShapeSingleExpr {

  public ShapeSingleExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitSingleExpr(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeNumericExpr getNumericExpr() {
    return findChildByClass(ShapeNumericExpr.class);
  }

  @Override
  @Nullable
  public ShapeTypeCastingExpr getTypeCastingExpr() {
    return findChildByClass(ShapeTypeCastingExpr.class);
  }

}
