package myLib.datastructures.Tests.TreeTests;

import myLib.datastructures.Trees.*;

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
        tree.Insert(2);

        System.out.println("printInOrder test:");
        tree.printInOrder();     
        System.out.println("printBF test:");
        tree.printBF();

        System.out.println("Delete Node w/ 2 Child (6)");
        tree.Delete(6);
        tree.printBF();
        System.out.println("Delete Node w/ 1 Child (7)");
        tree.Delete(7);
        tree.printBF();
        System.out.println("Delete Leaf (5)");
        tree.Delete(5);
        tree.printBF();

        System.out.println("AVL TEST 1234");
        AVL tree2 = new AVL();

        tree2.Insert(1);   
        tree2.Insert(2);     
        tree2.Insert(3);
        tree2.Insert(4);
        tree2.printBF();

        System.out.println("AVL TEST 4321");
        AVL tree3 = new AVL();

        tree3.Insert(4);
        tree3.Insert(3);
        tree3.Insert(2);
        tree3.Insert(1);
        tree3.printBF();

        System.out.println("AVL TEST 79456:");
        AVL tree4 = new AVL();

        tree4.Insert(7);
        tree4.Insert(9);
        tree4.Insert(4);
        tree4.Insert(5);
        System.out.println("AVL Before Insert 6:");
        tree4.printBF();

        System.out.println("AVL After Inserting 6:");
        tree4.Insert(6);
        tree4.printBF();

        System.out.println("AVL TEST DELETE:");
        AVL tree5 = new AVL();
        tree5.Insert(6);
        tree5.Insert(2);
        tree5.Insert(8);
        tree5.Insert(1);
        tree5.Insert(4);
        tree5.Insert(7);
        tree5.Insert(9);
        System.out.println("BEFORE DELETE");
        tree5.printBF();

        System.out.println("Delete Node w/ 2 Child (2)");
        tree5.Delete(2);
        tree5.printBF();

        System.out.println("Delete Node w/ 1 Child (4)");
        tree5.Delete(4);
        tree5.printBF();

        System.out.println("Delete Leaf Node (9)");

        tree5.Delete(9);
        tree5.printBF();

        BST tree6 = new BST();

        tree6.Insert(1);
        tree6.Insert(2);
        tree6.Insert(3);
        tree6.Insert(4);
        tree6.Insert(5);
        tree6.Insert(6);
        tree6.Insert(7);
        tree6.Insert(8);
        tree6.Insert(9);

        System.out.println("FULL TREE BALANCING ALGORITHM TEST");
        System.out.println("Before Balancing");
        tree6.printBF();
        AVL tree7 = new AVL(tree6.getRoot());

        System.out.println("After Balancing");
        tree7.printBF();

    }
}
