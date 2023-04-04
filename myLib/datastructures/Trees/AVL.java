package myLib.datastructures.Trees;
import myLib.datastructures.nodes.TNode;

public class AVL extends BST{
    
    public AVL(){
        super();
    }

    public AVL(int val){
        super(val);
    }
    
    public AVL(TNode obj) {
        super(obj);
    }

    // Balance after inserting
    @Override
    public void Insert(TNode node){
        super.Insert(node);
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        balance(super.getRoot());
    }
    // Balance after deleting
    @Override
    public void Delete(TNode node){
        super.Delete(node);
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        balance(super.getRoot());
    }

    public int getHeight(TNode node){
        if(node == null){
            return -1;
        }
        int LH = getHeight(node.getLeft());
        int RH = getHeight(node.getRight());
        if(LH > RH){
            return LH + 1;
        } else if(LH < RH){
            return RH + 1; 
        } else {
            return RH + 1;
        }
    }

    public int getBalFactor(TNode node){
        int LH = getHeight(node.getLeft());
        int RH = getHeight(node.getRight());
        int result = LH - RH;
        return result;
    }

    public void balance(TNode node) {
        if (node == null) {
            return;
        }

        int balanceFactor = node.getBalance();
        System.out.println("Balance Factor: " + balanceFactor);

        if (balanceFactor > 1) {
            if (node.getRight() != null && getBalFactor(node.getLeft()) < -1) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            rotateRight(node);

        } else if (balanceFactor < -1) {
            if (node.getLeft() != null && getBalFactor(node.getRight()) > 1) {
                node.setRight(rotateRight(node.getLeft()));
            }
            rotateLeft(node);

        }
        
        node.setBalance(getBalFactor(node));
    }

    // Rotation
    // Perform a right rotation at the given node
    private TNode rotateRight(TNode node) {
        TNode pivot = node.getLeft();

        pivot.setParent(node.getParent());
        node.setParent(pivot);

        node.setLeft(pivot.getRight());
        pivot.setRight(node);


        if(pivot.getRight() != null){
            pivot.getRight().setParent(node);
        }

        if(super.getRoot() == node){
            super.setRoot(pivot);
        }

        node.setBalance(getBalFactor(node));
        pivot.setBalance(getBalFactor(pivot));

        System.out.println("Rotated right");
        return pivot;
    }

    // Perform a left rotation at the given node
    private TNode rotateLeft(TNode node) {
        TNode pivot = node.getRight();
        pivot.setParent(node.getParent());
        node.setParent(pivot);

        node.setRight(pivot.getLeft());
        pivot.setLeft(node);


        if(pivot.getLeft() != null){
            pivot.getLeft().setParent(node);
        }

        if(super.getRoot() == node){
            super.setRoot(pivot);
        }

        node.setBalance(node.getBalance() - 1 - Math.max(0, pivot.getBalance()));
        pivot.setBalance(pivot.getBalance() - 1 + Math.min(0, node.getBalance()));

        System.out.println("Rotated left");
        return pivot;
    }
}
