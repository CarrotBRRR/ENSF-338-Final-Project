package myLib.datastructures.Trees;

public class treetest {
    
    public static void main(String[] args){

        System.out.println("BST TEST");

        BST tree = new BST();
        
        tree.Insert(4);
        tree.Insert(1);
        tree.Insert(9);
        tree.Insert(8);
        tree.Insert(6);
        tree.Insert(7);
        tree.Insert(5);
        tree.Insert(3);

        tree.printBF();

        System.out.println("AVL INSERT TEST");
        AVL tree2 = new AVL();

        tree2.Insert(1);
        tree2.printBF();
        
        tree2.Insert(2);
        tree2.printBF();

        tree2.Insert(3);
        tree2.printBF();

        tree2.Insert(4);
        tree2.printBF();

    }
}
