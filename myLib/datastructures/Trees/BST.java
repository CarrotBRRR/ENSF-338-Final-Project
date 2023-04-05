package myLib.datastructures.Trees;

import java.util.Queue;

import java.util.LinkedList;
import myLib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    // Constructors
    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    // Root Setters and Getters
    public void setRoot(TNode root) {
        this.root = root;
    }
    
    public TNode getRoot() {
        return root;
    }    

    // Insert method
    public void Insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        Insert(newNode);
    }

    public void Insert(TNode node) {
        if (this.root == null) {
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
        }
    }

    // Search method
    public TNode Search(int data) {
        TNode current = this.root;

        while (current.getData() != data) {
            if (data < current.getData()) {
                current = current.getLeft();
            } 
            else {
                current = current.getRight();
            }
            if(current == null){
                return null;
            }
        }

        return current;
    }

    // Delete method
    public void Delete(int val) {
        TNode nodeToDelete = Search(val);
        if (nodeToDelete == null) {
            System.out.println("Value not found in the tree");
        } else {
            Delete(nodeToDelete);
        }
    }

    public void Delete(TNode nodeToDelete) {
        TNode parent = nodeToDelete.getParent();
    
        // Case 1: nodeToDelete is leaf
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (parent == null) { // Node to delete is root
                this.root = null;
            } else if (nodeToDelete == parent.getLeft()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    
        // Case 2: nodeToDelete has one child
        else if (nodeToDelete.getLeft() == null || nodeToDelete.getRight() == null) {
            TNode child;
            if (nodeToDelete.getLeft() != null) {
                child = nodeToDelete.getLeft();
            } 
            else {
                child = nodeToDelete.getRight();
            }

            if (parent == null) { // nodeToDelete is root
                this.root = child;
                child.setParent(null);
            } 
            else if (nodeToDelete == parent.getLeft()) {
                parent.setLeft(child);
                child.setParent(parent);
            } 
            else {
                parent.setRight(child);
                child.setParent(parent);
            }
        }
    
        // Case 3: The node to delete has two children
        else {
            TNode successor = getSuccessor(nodeToDelete);
            TNode successorParent = successor.getParent();
    
            // Replace node to delete with its successor
            if (parent == null) { // nodeToDelete is root
                this.root = successor;
            } else if (nodeToDelete == parent.getLeft()) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setParent(parent);
    
            // Link successor with the children of node to delete
            successor.setLeft(nodeToDelete.getLeft());
            nodeToDelete.getLeft().setParent(successor);
            if (successor != nodeToDelete.getRight()) {
                successorParent.setLeft(successor.getRight());
                if (successor.getRight() != null) {
                    successor.getRight().setParent(successorParent);
                }
                successor.setRight(nodeToDelete.getRight());
                nodeToDelete.getRight().setParent(successor);
            }
        }
    }
    
    // Helper method to get the successor of a node
    private TNode getSuccessor(TNode node) {
        TNode succ = node.getRight();
        while (succ.getLeft() != null) {
            succ = succ.getLeft();
        }
        return succ;
    }

    // In-order print method
    public String printInOrder(){
        String inOrderData = getInOrder(root);
        System.out.println(inOrderData);
        return inOrderData;
    }
    
    public String getInOrder(TNode node) {
        String result = "";

        if (node == null) {
            return "";
        }
        if (node.getLeft() != null){
            result += getInOrder(node.getLeft());
        }

        result += String.valueOf(node.getData()) + " ";
        
        if (node.getRight() != null){
            result += getInOrder(node.getRight());
        }
        return result;
    }

    public String printBF(){
        String BFOrderData = getBFOrder(root);
        System.out.println(BFOrderData);
        return BFOrderData;
    }


    public String getBFOrder(TNode node) {
        String result = "";
        if (node == null) {
            System.out.println("Tree is empty");
            return result;
        }
    
        Queue<TNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.poll();
                result += current.getData() + " ";
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            result = result.substring(0, result.length() - 1); // remove space after last entry
            result += "\n";
        }
        return result.substring(0, result.length() - 1); // remove extra \n
    }
}
