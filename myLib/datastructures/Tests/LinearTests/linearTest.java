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

        test.Insert(node6, 1);
        test.InsertTail(node5);
        test.InsertTail(node2);
        test.InsertHead(node3);
        test.InsertTail(node4);
        test.Insert(node0, 4);
        test.Print();
        test.DeleteHead();
        test.DeleteTail();
        test.Sort();
        test.Print();

    }
}

