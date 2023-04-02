package myLib.datastructures.Trees;

import myLib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    // Constructors
    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public AVL(TNode obj) {
        if (obj == null) {
            this.root = null;
        } else {
            this.root = new TNode(obj.getData(), 0, null, null, null);
            if (obj.getLeft() != null) {
                AVL leftTree = new AVL(obj.getLeft());
                this.root.setLeft(leftTree.getRoot());
            }
            if (obj.getRight() != null) {
                AVL rightTree = new AVL(obj.getRight());
                this.root.setRight(rightTree.getRoot());
            }
            balance();
        }
    }

    // Setters and Getters
    public void setRoot(TNode root) {
        this.root = root;
        if (root.getLeft() != null || root.getRight() != null) {
            balance();
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    // Helper functions to calculate balance factor
    private int height(TNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    private int balanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    // Helper function to balance the tree
    private void balance() {
        if (this.root == null) {
            return;
        }
        int balanceFactor = balanceFactor(this.root);
        if (balanceFactor > 1) {
            if (balanceFactor(this.root.getLeft()) >= 0) {
                this.root = rotateRight(this.root);
            } else {
                this.root.setLeft(rotateLeft(this.root.getLeft()));
                this.root = rotateRight(this.root);
            }
        } else if (balanceFactor < -1) {
            if (balanceFactor(this.root.getRight()) <= 0) {
                this.root = rotateLeft(this.root);
            } else {
                this.root.setRight(rotateRight(this.root.getRight()));
                this.root = rotateLeft(this.root);
            }
        }
    }

    // Helper functions for rotation
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    // Insertion methods
    public void insert(int val) {
        super.Insert(val);
        balance();
    }

    public void insert(TNode node) {
        super.Insert(node);
        balance();
    }

    // Deletion method
    public void delete(int val) {
        TNode nodeToDelete = Search(val);
        if (nodeToDelete == null) {
            System.out.println("Value " + val + " not found in the tree.");
            return;
        }
        super.Delete(nodeToDelete);
        balance();
    }
}
