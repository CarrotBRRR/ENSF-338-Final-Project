package myLib.datastructures.Trees;

import java.util.Queue;
import java.util.LinkedList;
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
        this.root = obj;
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

    // Balance
    public void balance(TNode node) {
        if (node == null) {
            return;
        }

        int balanceFactor = node.getBalance();
        
        if (balanceFactor > 1) {
            if (node.getLeft() != null && node.getLeft().getBalance() < 0 ) {
                node.setLeft( rotateLeft(node.getRight()) );
            }
            rotateRight(node);
            System.out.println("Rotated right");
        } else if (balanceFactor < -1) {
            if (node.getRight() != null && node.getRight().getBalance() > 1) {
                node.setRight( rotateRight(node.getRight()) );
            }
            rotateLeft(node);
            System.out.println("Rotated left");
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        node.setBalance(leftHeight - rightHeight);
    }
    
    //getHeight method
    public int getHeight(TNode node){
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
    
    //Insert
    @Override
    public void Insert(int value) {
        TNode newNode = new TNode(value, 0, null, null, null);
        Insert(newNode);
    }

    @Override
    public void Insert(TNode node) {
        if(root == null){
            this.root = node;
            System.out.println("Root init Data:" + root.getData());
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

            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            node.setBalance(leftHeight - rightHeight);
            
            System.out.println("Root Balance: " + root.getBalance());
            balance(root);
        }
    }
    
    @Override
    public void Delete(int value) {
        super.Delete(value);
        balance(root);
    }
    
    // Rotation
    // Perform a right rotation at the given node
    private TNode rotateRight(TNode node) {
        TNode pivot = node.getLeft();
        pivot.setParent(node.getParent());
        node.setLeft(pivot.getRight());
        if (node.getLeft() != null) {
            node.getLeft().setParent(node);
        }
        pivot.setRight(node);
        node.setParent(pivot);
        if (pivot.getParent() != null) {
            if (pivot.getParent().getRight() == node) {
                pivot.getParent().setRight(pivot);
            } else {
                pivot.getParent().setLeft(pivot);
            }
        }
        node.setBalance(node.getBalance() + 1 - Math.min(0, pivot.getBalance()));
        pivot.setBalance(pivot.getBalance() + 1 + Math.max(0, node.getBalance()));
        return pivot;
    }
    

    // Perform a left rotation at the given node
    private TNode rotateLeft(TNode node) {
        TNode pivot = node.getRight();
        pivot.setParent(node.getParent());
        node.setRight(pivot.getLeft());
        if (node.getRight() != null) {
            node.getRight().setParent(node);
        }
        pivot.setLeft(node);
        node.setParent(pivot);
        if (pivot.getParent() != null) {
            if (pivot.getParent().getRight() == node) {
                pivot.getParent().setRight(pivot);
            } else {
                pivot.getParent().setLeft(pivot);
            }
        }
        node.setBalance(node.getBalance() - 1 - Math.max(0, pivot.getBalance()));
        pivot.setBalance(pivot.getBalance() - 1 + Math.min(0, node.getBalance()));
        return pivot;
    }

    @Override
    public void printBF() {
        if (this.root == null) {
            System.out.println("Tree is empty");
            return;
        }
    
        Queue<TNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode currentNode = queue.poll();
                System.out.print(currentNode.getData() + " ");
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
            System.out.println();
        }
    }
}