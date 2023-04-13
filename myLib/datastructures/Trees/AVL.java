package myLib.datastructures.Trees;
import myLib.datastructures.nodes.TNode;

public class AVL extends BST{

    // Constructors
    public AVL(){
        super();
    }

    public AVL(int val){
        super(val);
    }
    
    public AVL(TNode obj) {
        super(obj);
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        while(true){
            // Balance if it's not balanced
            balance(super.getRoot());
            if(getBalFactor(super.getRoot()) > -1 && getBalFactor(super.getRoot())< 1){
                break;
            }
        }
    }

    // Root Setter
    @Override
    public void setRoot(TNode node){
        // Create a new tree from node
        AVL temp = new AVL(node);
        super.setRoot(temp.getRoot());
    }

    // Insertion
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        // Balance after inserting
        balance(super.getRoot());
    }
    
    // Deletion
    @Override
    public void Delete(TNode node){
        super.Delete(node);
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        // Balance after deleting
        balance(super.getRoot());
    }

    // Helper methods
    public int getHeight(TNode node){
        if(node == null){
            // if leaf
            return -1;
        }
        int LH = getHeight(node.getLeft());
        int RH = getHeight(node.getRight());
        // return the larger value + 1
        if(LH > RH){
            return LH + 1;
        } else {
            return RH + 1; 
        }
    }

    public int getBalFactor(TNode node){
        // Calculate Balance from Left Height - Right Height
        int LH = getHeight(node.getLeft());
        int RH = getHeight(node.getRight());
        int result = LH - RH;
        return result;
    }
    
    // Balance method
    public void balance(TNode node) {
        // Balance it
        if (node == null) {
            return; // if nothing, then nothing
        }

        int balanceFactor = node.getBalance();

        if (balanceFactor > 1) {
            // If left heavy
            if (getBalFactor(node.getLeft()) < 0) {
                // if left tree is right heavy
                // Rotate Left subtree left
                node.setLeft(rotateLeft(node.getLeft()));
            }
            // Rotate right
            rotateRight(node);

        } else if (balanceFactor < -1) {
            // If right heavy
            if (getBalFactor(node.getRight()) > 0) {
                // if right tree is left heavy
                // Rotate Right subtree right
                node.setRight(rotateRight(node.getRight()));
            }
            // Rotate Left
            rotateLeft(node);
        }
        // Set balance
        node.setBalance(getBalFactor(node));
    }

    // Rotations
    private TNode rotateRight(TNode node) {
        // Perform a right rotation at the given node
        TNode pivot = node.getLeft();

        // Set pivot's parent to parent of node
        pivot.setParent(node.getParent()); 
        // Set node's parent to pivot
        node.setParent(pivot);

        // Set node's left to be pivot's right
        node.setLeft(pivot.getRight());
        // Set pivot's right to node
        pivot.setRight(node);

        if(super.getRoot() == node){
            // if node is root, set root to pivot
            super.setRoot(pivot);
        }

        // Set balance factors
        node.setBalance(getBalFactor(node));
        pivot.setBalance(getBalFactor(pivot));

        return pivot;
    }


    private TNode rotateLeft(TNode node) {
        // Perform a left rotation at the given node
        TNode pivot = node.getRight();

        // Set pivot's parent to parent of node
        pivot.setParent(node.getParent());
        // Set node's parent to pivot
        node.setParent(pivot);


        // Set node's right to be pivot's left
        node.setRight(pivot.getLeft());
        // Set pivot's left to node
        pivot.setLeft(node);

        if(super.getRoot() == node){
            // if node is root, set root to pivot
            super.setRoot(pivot);
        }

        // Set Balance Factors
        node.setBalance(node.getBalance() - 1 - Math.max(0, pivot.getBalance()));
        pivot.setBalance(pivot.getBalance() - 1 + Math.min(0, node.getBalance()));

        return pivot;
    }
}
