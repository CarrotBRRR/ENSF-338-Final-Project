package myLib.datastructures.Tests;

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

        System.out.println("AVL TEST 79456");
        AVL tree4 = new AVL();

        tree4.Insert(7);
        tree4.printBF();

        tree4.Insert(9);
        tree4.printBF();

        tree4.Insert(4);
        tree4.printBF();

        tree4.Insert(5);
        tree4.printBF();

        tree4.Insert(6);
        tree4.printBF();

        System.out.println("AVL TEST DELETE");
        AVL tree5 = new AVL();
        tree5.Insert(5);
        tree5.Insert(4);
        tree5.Insert(3);
        tree5.Insert(2);
        tree5.Insert(1);
        tree5.printBF();

        tree5.Delete(2);
        tree5.printBF();

    }
}
