package myLib.datastructures.Linear;

import myLib.datastructures.nodes.SNode;

// Just using this to test

public class Main {
    public static void main(String[] args) {
        StackLL test = new StackLL();
        SNode test1 = new SNode(1);
        SNode test2 = new SNode(2);
        SNode test3 = new SNode(3);
        SNode test4 = new SNode(4);
        SNode test5 = new SNode(5);
        SNode test6 = new SNode(6);
        SNode test7 = new SNode(7);
        SNode test8 = new SNode(8);
        SNode test9 = new SNode(9);
        SNode test10 = new SNode(10);

        test.Push(test1);
        test.Push(test2);
        test.Push(test4);
        test.Push(test6);
        test.Push(test3);
        test.Push(test10);
        test.Print();
        System.out.println();
        test.Pop();
        System.out.println(test.Seek(test2));
        test.Print();
        
    }
}
