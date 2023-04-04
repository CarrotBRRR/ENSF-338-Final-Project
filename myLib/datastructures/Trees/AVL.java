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
            balance(root);
        }
    }

    // Getters and setters
    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode root) {
        if (root != null) {
            this.root = new TNode(root.getData(), 0, null, null, null);
            if (root.getLeft() != null) {
                this.Insert(root.getLeft());
            }
            if (root.getRight() != null) {
                this.Insert(root.getRight());
            }
        }
    }
    
    public void balance(TNode node) {
        if (node == null) {
            return;
        }
        
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        node.setBalance(leftHeight - rightHeight);


        int balanceFactor = node.getBalance();
        
        if (balanceFactor > 0) {
            if (node.getLeft().getBalance() < 0) {
                rotateLeft(node.getLeft());
            }
            rotateRight(node);
        } else if (balanceFactor < 0) {
            if (node.getRight().getBalance() > 0) {
                rotateRight(node.getRight());
            }
            rotateLeft(node);
        }

        leftHeight = getHeight(node.getLeft());
        rightHeight = getHeight(node.getRight());

        node.setBalance(leftHeight - rightHeight);
        System.out.println("LH: " + leftHeight + ", RH: " + rightHeight);
    }

    public int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
    
    @Override
    public void Insert(int value) {
        TNode newNode = new TNode(value, 0, null, null, null);
        Insert(newNode);
    }

    @Override
    public void Insert(TNode node) {
        if(root == null){
            this.root = node;
        } else {
            TNode current = this.root;
            TNode parent;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        node.setParent(parent);
                        break;
                    }
                } 
                else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        node.setParent(parent);
                        break;
                    }
                }
            }
            balance(root);
        }
    }
    
    @Override
    public void Delete(int value) {
        super.Delete(value);
        balance(root);
    }
    
    private void rotateLeft(TNode node) {
        TNode rightChild = node.getRight();
        TNode rightLeftChild = rightChild.getLeft();
        
        rightChild.setLeft(node);
        node.setRight(rightLeftChild);
        
        node.setBalance(node.getBalance() - 1 - Math.max(rightChild.getBalance(), 0));
        rightChild.setBalance(getHeight(rightChild.getLeft()) - getHeight(rightChild.getRight()));
        
        if (node == root) {
            this.root = rightChild;
        }
    }
    
    private void rotateRight(TNode node) {
        TNode leftChild = node.getLeft();
        TNode leftRightChild = leftChild.getRight();
        
        leftChild.setRight(node);
        node.setLeft(leftRightChild);
        
        node.setBalance( getHeight(node.getLeft()) - getHeight(node.getRight()) );
        leftChild.setBalance(getHeight(leftChild.getLeft()) - getHeight(leftChild.getRight()));

        if (node == root) {
            this.root = leftChild;
        }
    }
}