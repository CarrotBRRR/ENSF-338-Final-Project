package myLib.datastructures.Tests.TreeTests;

import static org.junit.Assert.*;

import myLib.datastructures.nodes.TNode;
import org.junit.Test;


public class TNodeTest {
    @Test
    public void testSettersAndGetters() {
        TNode node = new TNode();
        node.setData(10);
        assertEquals(10, node.getData());

        node.setBalance(1);
        assertEquals(1, node.getBalance());

        TNode left = new TNode();
        node.setLeft(left);
        assertEquals(left, node.getLeft());

        TNode right = new TNode();
        node.setRight(right);
        assertEquals(right, node.getRight());

        TNode parent = new TNode();
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }

    @Test
    public void testConstructors() {
        TNode parentTest = new TNode(1, 1, null, null, null);
        TNode leftTest = new TNode(2, 2, null, null, null);
        TNode rightTest = new TNode(3, 3, null, null, null);
        TNode node = new TNode(1, 1, parentTest, leftTest, rightTest);

        assertEquals(rightTest, node.getRight());
        assertEquals(leftTest, node.getLeft());
        assertEquals(parentTest, node.getParent());
        assertEquals(1, node.getBalance());
    }

    @Test
    public void testPrintMethod() {
        TNode node = new TNode(10, 0, null, null, null);
        node.print(); // should print "Data: 10, Balance: 0" to stdout
    }

    @Test
    public void testToStringMethod() {
        TNode node = new TNode(10, 0, null, null, null);
        assertEquals("10", node.toString());
    }
}

