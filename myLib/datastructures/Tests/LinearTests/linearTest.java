package myLib.datastructures.Tests.LinearTests;
import myLib.datastructures.Linear.*;
import myLib.datastructures.nodes.DNode;
public class linearTest {
    public static void main(String[] args) {
        /* Nodes used for testing */
        DNode node0 = new DNode(0);
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        DNode node5 = new DNode(5);
        DNode node6 = new DNode(6);
        DNode node7 = new DNode(7);
        DNode node8 = new DNode(8);
        DNode node9 = new DNode(9);
        DNode node10 = new DNode(10);

        /* SLL tests */
        SLL testSLL0 = new SLL();
        SLL testSLL1 = new SLL(node0);

        // default constructor
        if (testSLL0.getHead() == null && testSLL0.getTail() == null) {
            System.out.println("Default SLL constructor test passed...");
        } else {
            System.out.println("Default SLL constructor test failed...");
        }

        // Parametized constructor
        if (testSLL1.getHead() == node0 && testSLL1.getTail() == node0) {
            System.out.println("Parametized SLL constructor test passed...");
        } else {
            System.out.println("Parametized SLL constructor test failed...");
        }

        // InsertHead test
        testSLL0.InsertHead(node1);
        if (testSLL0.getHead() == node1 && testSLL0.getTail() == node1 && testSLL0.getHead().getNext() == null) {
            System.out.println("SLL InsertHead method test1 passed...");
        } else {
            System.out.println("SLL InsertHead method test1 failed...");
        }

        testSLL0.InsertHead(node2);
        if (testSLL0.getHead() == node2 && testSLL0.getTail() == node1 && testSLL0.getHead().getNext() == node1) {
            System.out.println("SLL InsertHead method test2 passed...");
        } else {
            System.out.println("SLL InsertHead method test2 failed...");
        }

        testSLL0.Clear();

        // InsertTail test
        testSLL0.InsertTail(node1);
        if (testSLL0.getHead() == node1 && testSLL0.getTail() == node1 && testSLL0.getHead().getNext() == null) {
            System.out.println("SLL InsertTail method test1 passed...");
        } else {
            System.out.println("SLL InsertTail method test1 failed...");
        }

        testSLL0.InsertTail(node2);
        if (testSLL0.getHead() == node1 && testSLL0.getTail() == node2 && testSLL0.getHead().getNext() == node2) {
            System.out.println("SLL InsertTail method test2 passed...");
        } else {
            System.out.println("SLL InsertTail method test2 failed...");
        }

        testSLL0.Clear();
        
        // Insert Method tests
        testSLL0.Insert(node1,1);
        if (testSLL0.getHead() == node1 && testSLL0.getTail() == node1 && testSLL0.getHead().getNext() == null) {
            System.out.println("SLL Insert method test1 passed...");
        } else {
            System.out.println("SLL Insert method test1 failed...");
        }

        testSLL0.Insert(node2, 1);
        if (testSLL0.getHead() == node2 && testSLL0.getTail() == node1 && testSLL0.getHead().getNext() == node1) {
            System.out.println("SLL Insert method test2 passed...");
        } else {
            System.out.println("SLL Insert method test2 failed...");
        }

        testSLL0.Insert(node3, 3);
        if (testSLL0.getTail() == node3 && testSLL0.getTail().getNext() == null) {
            System.out.println("SLL Insert method test3 passed...");
        } else {
            System.out.println("SLL Insert method test3 failed...");
        }

        testSLL0.Clear();

        
    }   
}

