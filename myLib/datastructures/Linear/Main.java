package myLib.datastructures.Linear;

import myLib.datastructures.nodes.SNode;

// Just using this to test

public class Main {
    public static void main(String[] args) {
        QueueLL test = new QueueLL();
        SNode test1 = new SNode(1);
        SNode test2 = new SNode(2);
        SNode test3 = new SNode(3);
        SNode test4 = new SNode(4);
        SNode test5 = new SNode(5);
        SNode test6 = new SNode(6);
        SNode test7 = new SNode(7);
        SNode test8 = new SNode(8);
        SNode test9 = new SNode(9);

        SLL testSLL = new SLL();
        testSLL.InsertHead(test6);
        testSLL.InsertHead(test7);
        testSLL.InsertTail(test9);
        testSLL.Insert(test8, 2);
        testSLL.Print();
        testSLL.Clear();
        System.out.println();
        testSLL.Print();
        System.out.println();
        test.Enqueue(test5);
        test.Enqueue(test4);
        test.Enqueue(test3);
        test.Enqueue(test2);
        test.Enqueue(test1);
        test.Dequeue();
        test.Dequeue();
        test.Print();
        test.Clear();
        test.Print();

    }
}
