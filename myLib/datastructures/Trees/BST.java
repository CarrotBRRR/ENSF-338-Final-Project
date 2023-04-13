package myLib.datastructures.Trees;

import myLib.datastructures.nodes.TNode;
import myLib.datastructures.Linear.QueueLL;

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
        // Create a new TNode to insert, and use node insertion method
        TNode newNode = new TNode(val, 0, null, null, null);
        Insert(newNode);
    }

    public void Insert(TNode node) {
        if (this.root == null) {
            // If there is no root, then set root
            this.root = node;
        } else {
            TNode current = this.root;
            TNode parent;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    // If the data in node is less than current node, go left
                    current = current.getLeft();
                    if (current == null) {
                        // If found a space, insert
                        parent.setLeft(node);
                        node.setParent(parent);
                        break;
                    }
                } 
                else {
                    // If not less than, default to the right
                    current = current.getRight();
                    if (current == null) {
                        // If found a space, insert
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
            // While the data is not found
            // Check if less than
            if (data < current.getData()) {
                // If less than, go left
                current = current.getLeft();
            } 
            else {
                // If not less than, go right
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
        // Find the node to delete
        TNode nodeToDelete = Search(val);
        if (nodeToDelete == null) {
            // If node is not in tree, println
            System.out.println("Value not found in the tree");
        } else {
            // Delete found node
            Delete(nodeToDelete);
        }
    }

    public void Delete(TNode nodeToDelete) {
        TNode parent = nodeToDelete.getParent();
    
        // Case 1: nodeToDelete is leaf
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (parent == null) { 
                // Node to delete is root
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
            // Get the child
            if (nodeToDelete.getLeft() != null) {
                child = nodeToDelete.getLeft();
            } 
            else {
                child = nodeToDelete.getRight();
            }

            if (parent == null) { 
                // nodeToDelete is root
                this.root = child;
                child.setParent(null);
            } 
            else if (nodeToDelete == parent.getLeft()) {
                // set new child to parent, set new parent to child
                parent.setLeft(child);
                child.setParent(parent);
            } 
            else {
                // set new child to parent, set new parent to child
                parent.setRight(child);
                child.setParent(parent);
            }
        }
    
        // Case 3: The node to delete has two children
        else {
            TNode successor = getSuccessor(nodeToDelete);
            TNode successorParent = successor.getParent();
    
            // Replace node to delete with its successor
            if (parent == null) { 
                // nodeToDelete is root
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
        // Get the succ
        // Succ should be smallest of the right subtree
        // ie. Go right, then as far left as possible
        TNode succ = node.getRight();
        while (succ.getLeft() != null) {
            // Go left whenever possible
            succ = succ.getLeft();
        }
        return succ;
    }

    // In-order print method
    public String printInOrder(){
        // Print Tree in order
        String inOrderData = getInOrder(root);
        System.out.println(inOrderData);
        inOrderData = inOrderData.substring(0, inOrderData.length() - 1);
        return inOrderData;
    }
    
    public String getInOrder(TNode node) {
        String result = "";

        if (node == null) {
            // Tree is empty
            return result;
        }
        if (node.getLeft() != null){
            // Go left if possible, and call self
            result += getInOrder(node.getLeft());
        }

        // add spacing
        result += String.valueOf(node.getData()) + " ";
        
        if (node.getRight() != null){
            // After adding all the lefts, 
            // add all the rights, left of right first
            result += getInOrder(node.getRight());
        }
        return result;
    }

    public String printBF(){
        // Print Breadth-First
        String BFOrderData = getBFOrder(root);
        System.out.println(BFOrderData);
        return BFOrderData;
    }


    public String getBFOrder(TNode node) {
        String result = "";
        if (node == null) {
            // Tree is empty
            return result;
        }
    
        // Create a queue object, enqueue the root's data
        QueueLL queue = new QueueLL();
        queue.Enqueue(this.root.getData());

        while (!queue.Empty()) {
            // While there is still something in the queue
            int levelSize = queue.getLength();

            for (int i = 0; i < levelSize; i++) {
                // Look for the node with enqueued data
                TNode current = Search(queue.Dequeue());
                // Add to the return value
                result += current.getData() + " ";
                if (current.getLeft() != null) {
                    // Enqueue left first
                    queue.Enqueue(current.getLeft().getData());
                }
                if (current.getRight() != null) {
                    // Enqueue right second
                    queue.Enqueue(current.getRight().getData());
                }
            }
            // remove space after last entry of a line
            result = result.substring(0, result.length() - 1); 
            result += "\n";
        }
        // remove extra \n
        return result.substring(0, result.length() - 1); 
    }
}
