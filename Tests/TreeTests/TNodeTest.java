package Tests.TreeTests;

import static org.junit.Assert.*;

import myLib.datastructures.nodes.TNode;
import org.junit.Test;


public class TNodeTest {
    @Test
    public void testConstructors() {
        TNode parentTest = new TNode(1, 1, null, null, null);
        TNode leftTest = new TNode(2, 2, null, null, null);
        TNode rightTest = new TNode(3, 3, null, null, null);

        // Construct
        TNode node = new TNode(1, 1, parentTest, leftTest, rightTest);

        // Check right node
        assertEquals(rightTest, node.getRight());

        // Check left node
        assertEquals(leftTest, node.getLeft());

        // Check parent
        assertEquals(parentTest, node.getParent());

        // Check balance
        assertEquals(1, node.getBalance());
    }
    @Test
    public void testSettersAndGetters() {
        // Test setting data
        TNode node = new TNode();
        node.setData(10);
        assertEquals(10, node.getData());

        // Test setting balance
        node.setBalance(1);
        assertEquals(1, node.getBalance());
        
        // Test setting left
        TNode left = new TNode();
        node.setLeft(left);
        assertEquals(left, node.getLeft());

        // Test setting right
        TNode right = new TNode();
        node.setRight(right);
        assertEquals(right, node.getRight());

        // Test setting parent
        TNode parent = new TNode();
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }



    @Test
    public void testPrint() {
        // Testing Print method
        TNode node = new TNode(10, 0, null, null, null);
        String expected = "Data: 10, Balance: 0";
        String actual = node.print();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        // Testing conversion of data to string
        TNode node = new TNode(10, 0, null, null, null);
        assertEquals("10", node.toString());
    }
}

