package myLib.datastructures.Tests.LinearTests;
import myLib.datastructures.Linear.*;
import myLib.datastructures.nodes.DNode;
public class linearTest {
    public static void main(String[] args) {
        QueueLL test = new QueueLL();
        DNode node0 = new DNode(0);
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        DNode node5 = new DNode(5);
        DNode node6 = new DNode(6);

        test.Enqueue(node6);
        test.Enqueue(node5);
        test.Enqueue(node2);
        test.Enqueue(node3);
        test.Enqueue(node4);
        test.Enqueue(node0);
        test.Dequeue();
        test.Print();

    }
}

