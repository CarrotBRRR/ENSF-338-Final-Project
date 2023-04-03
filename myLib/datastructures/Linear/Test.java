package myLib.datastructures.Linear;

import myLib.datastructures.nodes.SNode;

public class Test {
    public static void main(String args[]) {
        SLL testSLL = new SLL();
        SNode test1 = new SNode(1);
        SNode test2 = new SNode(2);
        SNode test3 = new SNode(3);
        SNode test4 = new SNode(4);
        testSLL.InsertHead(test1);
        testSLL.InsertTail(test2);
        testSLL.InsertTail(test3);
        testSLL.InsertTail(test4);
        testSLL.Print();
    }
}
