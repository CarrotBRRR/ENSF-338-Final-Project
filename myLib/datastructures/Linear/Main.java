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

        test.Enqueue(test5);
        test.Enqueue(test4);
        test.Enqueue(test3);
        test.Enqueue(test2);
        test.Enqueue(test1);
        test.Dequeue();

        System.out.println(test.Seek(test3));
        test.Print();
    }
}
