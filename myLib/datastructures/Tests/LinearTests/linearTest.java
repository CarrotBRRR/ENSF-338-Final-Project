package myLib.datastructures.Tests.LinearTests;
import myLib.datastructures.Linear.*;
import myLib.datastructures.nodes.DNode;
public class linearTest {
    public static void main(String[] args) {
        DLL test = new DLL();
        DNode node0 = new DNode(0);
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        DNode node5 = new DNode(5);
        DNode node6 = new DNode(6);

        test.InsertHead(node6);
        test.InsertTail(node5);
        test.InsertHead(node2);
        test.InsertTail(node3);
        test.InsertHead(node4);
        test.Insert(node0, 3);
        test.Print();

        System.out.println();
        System.out.println(test.getHead().getBefore().getData());
    }
}

