package Tests.TreeTests;

import org.junit.*;
import static org.junit.Assert.*;

import myLib.datastructures.nodes.TNode;
import myLib.datastructures.Trees.*;


public class BSTTest {
    private BST tree;

    @Before
    public void setup() {
        tree = new BST();
        tree.Insert(8);
        tree.Insert(3);
        tree.Insert(10);
        tree.Insert(1);
        tree.Insert(6);
        tree.Insert(14);
        tree.Insert(4);
        tree.Insert(7);
        tree.Insert(13);
    }

    @Test
    public void testConstructors(){
        BST test = new BST();
        BST test2 = new BST(10);
        TNode root = tree.getRoot();
        BST test3 = new BST(root);
        
        // Test BST(int val)
        assertEquals(10, test2.getRoot().getData());
        // Test BST(TNode node)
        assertEquals(tree.printBF(), test3.printBF());
        // Test BST()
        assertNull(test.getRoot());
    }

    @Test
    public void testSettersAndGetters(){
        // Test setRoot
        TNode test = new TNode(1, 0, null, null, null);
        tree.setRoot(test);
        TNode node = tree.getRoot();
        assertEquals(test, node);
    }

    @Test
    public void testInsert() {
        // Test Insert(int val)
        tree.Insert(5);
        String expected = "1 3 4 5 6 7 8 10 13 14";
        String actual = tree.printInOrder();
        assertEquals(expected, actual);

        // Test Insert(TNode node)
        TNode node = new TNode(9, 0, null, null, null);
        tree.Insert(node);
        expected = "1 3 4 5 6 7 8 9 10 13 14";
        actual = tree.printInOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        // Test Deleting Leaf
        tree.Delete(4);
        String expected = "1 3 6 7 8 10 13 14";
        String actual = tree.printInOrder();
        assertEquals(expected, actual);

        // Test Deleting Parent with 1 Child
        tree.Delete(14);
        expected = "1 3 6 7 8 10 13";
        actual = tree.printInOrder();
        assertEquals(expected, actual);

        // Test Deleting Parent with 2 Child
        tree.Delete(3);
        expected = "1 6 7 8 10 13";
        actual = tree.printInOrder();
        assertEquals(expected, actual);
        
        // Test Deleting value not in tree
        tree.Delete(3);
        expected = "1 6 7 8 10 13";
        actual = tree.printInOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        // Test Search
        TNode node = tree.Search(6);
        assertNotNull(node);
        assertEquals(6, node.getData());

        // Test Searching for something not in the tree
        TNode node2 = tree.Search(69);
        assertNull(node2);
    }

    @Test
    public void testPrintInOrder() {
        // Testing Printin in Order
        assertEquals("1 3 4 6 7 8 10 13 14", tree.printInOrder());
    }

    @Test
    public void testPrintBF() {
        // Testing Print Breadth First
        assertEquals("8\n3 10\n1 6 14\n4 7 13", tree.printBF());
    }
}
    
    



