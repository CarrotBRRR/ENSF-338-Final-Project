package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

// Just using this to test

public class Main {
    public static void main(String[] args) {
        DLL test = new DLL();
        DNode test1 = new DNode(1);
        DNode test2 = new DNode(2);
        DNode test3 = new DNode(3);
        DNode test4 = new DNode(4);
        DNode test5 = new DNode(5);
        DNode test6 = new DNode(6);
        DNode test7 = new DNode(7);
        DNode test8 = new DNode(8);
        DNode test9 = new DNode(9);
        DNode test10 = new DNode(10);

        test.InsertHead(test6);
        test.InsertHead(test2);
        test.InsertHead(test4);
        test.InsertHead(test1);
        test.InsertHead(test3);
        test.InsertTail(test5);
        test.Print();
        test.Clear();
        test.Print();
    }
}
