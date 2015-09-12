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

public class ShapeExpressionImpl extends ASTWrapperPsiElement implements ShapeExpression {

  public ShapeExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeClassName getClassName() {
    return findChildByClass(ShapeClassName.class);
  }

  @Override
  @Nullable
  public ShapeExpression getExpression() {
    return findChildByClass(ShapeExpression.class);
  }

  @Override
  @Nullable
  public ShapeLogicalExpr getLogicalExpr() {
    return findChildByClass(ShapeLogicalExpr.class);
  }

  @Override
  @Nullable
  public ShapeNumericExpr getNumericExpr() {
    return findChildByClass(ShapeNumericExpr.class);
  }

  @Override
  @Nullable
  public ShapeSingleExpr getSingleExpr() {
    return findChildByClass(ShapeSingleExpr.class);
  }

  @Override
  @Nullable
  public ShapeTypeCastingExpr getTypeCastingExpr() {
    return findChildByClass(ShapeTypeCastingExpr.class);
  }

}
