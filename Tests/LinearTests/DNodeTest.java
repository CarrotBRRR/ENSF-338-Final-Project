package Tests.LinearTests;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DNodeTest {
    
    @Test
    public void testDefaultConstructor() {
        DNode node = new DNode();
        assertEquals(0, node.getData());
        assertNull(node.getNext());
        assertNull(node.getBefore());
    }

    @Test
    public void testParametizedConstructor() {
        DNode node = new DNode(1);
        assertEquals(1, node.getData());
        assertNull(node.getNext());
        assertNull(node.getBefore());
    }

    @Test
    public void testSetData() {
        DNode node = new DNode(1);
        assertEquals(1, node.getData());

        node.setData(2);
        assertEquals(2, node.getData());
    }

    @Test
    public void testSetNext() {
        DNode node = new DNode();
        DNode next = new DNode();

        assertNull(node.getNext());

        node.setNext(next);
        assertEquals(next, node.getNext());
    }

    @Test
    public void testSetBefore() {
        DNode node = new DNode();
        DNode before = new DNode();

        assertNull(node.getBefore());

        node.setBefore(before);
        assertEquals(before, node.getBefore());
    }

    @Test
    public void testGetData() {
        DNode node = new DNode(420);
        assertEquals(420, node.getData());
    }

    @Test
    public void testGetNext() {
        DNode node = new DNode();
        DNode next = new DNode();

        node.setNext(next);

        assertEquals(node.getNext(), next);
    }

    @Test
    public void testGetBefore() {
        DNode node = new DNode();
        DNode before = new DNode();

        node.setBefore(before);

        assertEquals(node.getBefore(), before);
    }
}
