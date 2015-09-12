package com.shape.ast;

import com.shape.ast.nodes.View;

/**
 * Modifies node's attribute (add or modify) after parser writing AST.
 * @author Vista
 */
public interface Modifier {
    void applyAction(View view);
}
