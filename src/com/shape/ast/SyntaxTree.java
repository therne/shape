package com.shape.ast;

import com.shape.ast.nodes.Node;

public class SyntaxTree {
    private Node root;
    private Node current;

    public SyntaxTree() {
    }

    public void leave() {
        current = current.getParent();
    }

    public void addNode(Node node) {
        if (root == null) root = current = node;
        else current.addChild(node);
    }

    public void visit(Node node) {
        if (node.getParent() != null && node.getParent() != current)
            throw new IllegalArgumentException("you can only visit children of current node");
        current = node;
    }

    public Node getRoot() {
        return root;
    }

    public void visitNodes(RecursiveCallback callback) {
        callback.visit(root);
        visitNodes(root, callback);
    }

    private void visitNodes(Node node, RecursiveCallback callback) {
        for (Node child : node.getChildren()) {
            callback.visit(child);
            visitNodes(child, callback);
        }
    }

    public interface RecursiveCallback {
        void visit(Node node);
    }
}
