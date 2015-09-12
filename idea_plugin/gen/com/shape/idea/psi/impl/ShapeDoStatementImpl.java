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

public class ShapeDoStatementImpl extends ASTWrapperPsiElement implements ShapeDoStatement {

  public ShapeDoStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitDoStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ShapeExpression getExpression() {
    return findNotNullChildByClass(ShapeExpression.class);
  }

  @Override
  @NotNull
  public ShapeStatement getStatement() {
    return findNotNullChildByClass(ShapeStatement.class);
  }

}
