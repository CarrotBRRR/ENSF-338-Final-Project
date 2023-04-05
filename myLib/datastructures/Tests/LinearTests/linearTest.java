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

        test.InsertTail(node5);
        test.InsertHead(node0);
        test.InsertTail(node4);
        test.InsertTail(node1);
        test.InsertTail(node2);
        test.Insert(node6, 6);
        test.SortedInsert(node3);
        test.Sort();
        test.Print();
        System.out.println(test.getTail().getData());
    }
}
