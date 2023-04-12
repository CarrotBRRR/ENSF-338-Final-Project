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
        super.getRoot().setBalance(getBalFactor(super.getRoot()));
        while(true){
            balance(super.getRoot());
            if(getBalFactor(super.getRoot()) > -1 && getBalFactor(super.getRoot())< 1){
                break;
            }
        }
    }

    @Override
    public void setRoot(TNode node){
        AVL temp = new AVL(node);
        super.setRoot(temp.getRoot());
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
    // getHeight
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
    // Calculate Balance from Left Height - Right Height
    public int getBalFactor(TNode node){
        int LH = getHeight(node.getLeft());
        int RH = getHeight(node.getRight());
        int result = LH - RH;
        return result;
    }
    
    // Balance Function
    public void balance(TNode node) {
        if (node == null) {
            return;
        }

        int balanceFactor = node.getBalance();

        if (balanceFactor > 1) {
            if (getBalFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            rotateRight(node);

        } else if (balanceFactor < -1) {
            if (getBalFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
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

        if(super.getRoot() == node){
            super.setRoot(pivot);
        }

        node.setBalance(getBalFactor(node));
        pivot.setBalance(getBalFactor(pivot));

        return pivot;
    }

    // Perform a left rotation at the given node
    private TNode rotateLeft(TNode node) {
        TNode pivot = node.getRight();

        pivot.setParent(node.getParent());
        node.setParent(pivot);

        node.setRight(pivot.getLeft());
        pivot.setLeft(node);

        if(super.getRoot() == node){
            super.setRoot(pivot);
        }

        node.setBalance(node.getBalance() - 1 - Math.max(0, pivot.getBalance()));
        pivot.setBalance(pivot.getBalance() - 1 + Math.min(0, node.getBalance()));

        return pivot;
    }
}
