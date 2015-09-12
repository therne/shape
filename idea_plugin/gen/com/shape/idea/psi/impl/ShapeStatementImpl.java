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

public class ShapeStatementImpl extends ASTWrapperPsiElement implements ShapeStatement {

  public ShapeStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShapeVisitor) ((ShapeVisitor)visitor).visitStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ShapeAssignStatement getAssignStatement() {
    return findChildByClass(ShapeAssignStatement.class);
  }

  @Override
  @Nullable
  public ShapeBreakStatement getBreakStatement() {
    return findChildByClass(ShapeBreakStatement.class);
  }

  @Override
  @Nullable
  public ShapeContinueStatement getContinueStatement() {
    return findChildByClass(ShapeContinueStatement.class);
  }

  @Override
  @Nullable
  public ShapeDoStatement getDoStatement() {
    return findChildByClass(ShapeDoStatement.class);
  }

  @Override
  @Nullable
  public ShapeForStatement getForStatement() {
    return findChildByClass(ShapeForStatement.class);
  }

  @Override
  @Nullable
  public ShapeIfStatement getIfStatement() {
    return findChildByClass(ShapeIfStatement.class);
  }

  @Override
  @Nullable
  public ShapeReturnStatement getReturnStatement() {
    return findChildByClass(ShapeReturnStatement.class);
  }

  @Override
  @Nullable
  public ShapeStatementBlock getStatementBlock() {
    return findChildByClass(ShapeStatementBlock.class);
  }

  @Override
  @Nullable
  public ShapeSwitchStatement getSwitchStatement() {
    return findChildByClass(ShapeSwitchStatement.class);
  }

  @Override
  @Nullable
  public ShapeTryStatement getTryStatement() {
    return findChildByClass(ShapeTryStatement.class);
  }

  @Override
  @Nullable
  public ShapeWhileStatement getWhileStatement() {
    return findChildByClass(ShapeWhileStatement.class);
  }

}
