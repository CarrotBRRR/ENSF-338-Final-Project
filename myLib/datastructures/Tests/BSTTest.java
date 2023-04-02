package myLib.datastructures.Tests;


import org.junit.Test;
import static org.junit.Assert.*;

import myLib.datastructures.Trees.BST;

public class BSTTest {
    @Test
    public void testInsertAndSearch() {
        BST bst = new BST();
        bst.Insert(5);
        bst.Insert(2);
        bst.Insert(7);
        bst.Insert(1);
        bst.Insert(3);
        bst.Insert(6);
        bst.Insert(8);

        assertEquals(5, bst.getRoot().getData());
        assertEquals(2, bst.getRoot().getLeft().getData());
        assertEquals(7, bst.getRoot().getRight().getData());
        assertEquals(1, bst.getRoot().getLeft().getLeft().getData());
        assertEquals(3, bst.getRoot().getLeft().getRight().getData());
        assertEquals(6, bst.getRoot().getRight().getLeft().getData());
        assertEquals(8, bst.getRoot().getRight().getRight().getData());

        assertEquals(null, bst.Search(10));
        assertEquals(bst.getRoot(), bst.Search(5));
        assertEquals(bst.getRoot().getRight().getRight(), bst.Search(8));
        assertEquals(bst.getRoot().getLeft().getRight(), bst.Search(3));
    }

    @Test
    public void testDelete() {
        BST bst = new BST();
        bst.Insert(5);
        bst.Insert(2);
        bst.Insert(7);
        bst.Insert(1);
        bst.Insert(3);
        bst.Insert(6);
        bst.Insert(8);

        bst.Delete(5);
        assertEquals(6, bst.getRoot().getData());
        assertEquals(2, bst.getRoot().getLeft().getData());
        assertEquals(7, bst.getRoot().getRight().getData());
        assertEquals(1, bst.getRoot().getLeft().getLeft().getData());
        assertEquals(3, bst.getRoot().getLeft().getRight().getData());
        assertEquals(null, bst.Search(5));

        bst.Delete(2);
        assertEquals(6, bst.getRoot().getData());
        assertEquals(3, bst.getRoot().getLeft().getData());
        assertEquals(7, bst.getRoot().getRight().getData());
        assertEquals(1, bst.getRoot().getLeft().getLeft().getData());
        assertEquals(null, bst.Search(2));
    }
}

