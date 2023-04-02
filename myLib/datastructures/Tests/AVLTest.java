package myLib.datastructures.Tests;

import org.junit.Test;
import static org.junit.Assert.*;

import myLib.datastructures.Trees.AVL;

public class AVLTest {

    @Test
    public void testInsert() {
        AVL avl = new AVL();

        avl.insert(5);
        avl.insert(4);
        avl.insert(6);
        avl.insert(7);
        avl.insert(3);
        avl.insert(2);

        assertEquals("2 3 4 5 6 7 ", avl.inOrder());
    }

    @Test
    public void testDelete() {
        AVL avl = new AVL();

        avl.insert(5);
        avl.insert(4);
        avl.insert(6);
        avl.insert(7);
        avl.insert(3);
        avl.insert(2);

        assertTrue(avl.Search(6) != null);

        avl.delete(6);

        assertNull(avl.Search(6));
        assertEquals("2 3 4 5 7 ", avl.inOrder());
    }
}
