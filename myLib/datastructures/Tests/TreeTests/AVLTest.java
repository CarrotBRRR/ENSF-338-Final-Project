package myLib.datastructures.Tests.TreeTests;

import org.junit.*;
import static org.junit.Assert.*;

import myLib.datastructures.nodes.TNode;
import myLib.datastructures.Trees.*;

public class AVLTest {
    private AVL tree;
    
    @Before
    public void setup() {
        tree = new AVL();
        tree.Insert(new TNode(10, 0, null, null, null));
        tree.Insert(new TNode(20, 0, null, null, null));
        tree.Insert(new TNode(30, 0, null, null, null));
        tree.Insert(new TNode(40, 0, null, null, null));
        tree.Insert(new TNode(50, 0, null, null, null));
    }

    @Test
    public void testConstructors(){
        AVL test = new AVL();
        AVL test2 = new AVL(10);
        TNode root = tree.getRoot();
        AVL test3 = new AVL(root);
        
        assertEquals(10, test2.getRoot().getData());
        assertEquals(tree.printBF(), test3.printBF());
        assertNull(test.getRoot());
    }

    @Test
    public void testGetters(){
        AVL test = new AVL();
        test.setRoot(tree.getRoot());
        assertEquals(test.getRoot(), tree.getRoot());
    }

    @Test
    public void testSetter(){
            // Create Unbalanced BST Tree
            BST BSTTree = new BST();
            BSTTree.Insert(new TNode(10, 0, null, null, null));
            BSTTree.Insert(new TNode(20, 0, null, null, null));
            BSTTree.Insert(new TNode(30, 0, null, null, null));
            BSTTree.Insert(new TNode(40, 0, null, null, null));
            BSTTree.Insert(new TNode(50, 0, null, null, null));

            tree.setRoot(BSTTree.getRoot());
            String expected = "30\n20 40\n10 50";
            String actual = tree.printBF();
            assertEquals(expected, actual);
    }

    @Test
    public void testInsert() {
        // Test Insert an int Value
        tree.Insert(1);
        String expected = "1 10 20 30 40 50";
        String actual = tree.printInOrder();
        assertEquals(expected, actual);

        // Test Insert a Node
        tree.Insert(new TNode(25, 0, null, null, null));
        expected = "1 10 20 25 30 40 50";
        actual = tree.printInOrder();
        assertEquals(expected, actual);

        // Check if the Tree is still balanced
        expected = "30\n20 40\n10 25 50\n1";
        actual = tree.printBF();
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        // Create new Balanced AVL to test deletion and balancing after
        tree = new AVL();
        tree.Insert(8);
        tree.Insert(3);
        tree.Insert(10);
        tree.Insert(1);
        tree.Insert(6);
        tree.Insert(14);
        tree.Insert(4);
        tree.Insert(7);
        tree.Insert(13);
        
        // Test Deleting Leaf
        tree.Delete(4);
        String expected = "8\n3 10\n1 6 14\n7 13";
        String actual = tree.printBF();
        assertEquals(expected, actual);

        // Test Deleting Parent with 1 Child
        tree.Delete(14);
        expected = "8\n3 10\n1 6 13\n7";
        actual = tree.printBF();
        assertEquals(expected, actual);

        // Test Deleting Parent with 2 Child
        tree.Delete(3);
        expected = "8\n6 10\n1 7 13";
        actual = tree.printBF();
        assertEquals(expected, actual);
        
        // Test Deleting value not in tree
        tree.Delete(3);
        expected = "8\n6 10\n1 7 13";
        actual = tree.printBF();
        assertEquals(expected, actual);
    }

    @Test
    public void testInherited(){
        // Test Search
        TNode node = tree.Search(10);
        assertNotNull(node);
        assertEquals(10, node.getData());

        // Test printInOrder
        assertEquals("10 20 30 40 50", tree.printInOrder());

        // Test printBF
        assertEquals("30\n20 40\n10 50", tree.printBF());
    }

    @Test 
    public void testSelfBalance(){
        String expected = "30\n20 40\n10 50";
        String actual = tree.printBF();
        assertEquals(expected, actual);
    }

    @Test
    public void testBalance() {
        // Create Unbalanced BST Tree
        BST BSTTree = new BST();
        BSTTree.Insert(new TNode(10, 0, null, null, null));
        BSTTree.Insert(new TNode(20, 0, null, null, null));
        BSTTree.Insert(new TNode(30, 0, null, null, null));
        BSTTree.Insert(new TNode(40, 0, null, null, null));
        BSTTree.Insert(new TNode(50, 0, null, null, null));

        // Construct an new AVL using the root of unbalanced BST Tree
        // Test if the AVL now Balanced
        tree = new AVL(BSTTree.getRoot());
        String expected = "30\n20 40\n10 50";
        String actual = tree.printBF();
        assertEquals(expected, actual);
    }
}

