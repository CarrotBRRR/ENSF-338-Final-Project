package Tests.LinearTests;
import myLib.datastructures.Linear.SLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;


public class SLLTest {
    private SLL sll;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;

    @Before
    public void setUp() {
        sll = new SLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

    @Test
    public void testInsertHead() {
        sll.InsertHead(node1);
        assertEquals(1, sll.getLength());
        assertEquals(node1, sll.getHead());

        sll.InsertHead(node2);
        assertEquals(2, sll.getLength());
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());

        sll.InsertHead(node3);
        assertEquals(3, sll.getLength());
        assertEquals(node3, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
        assertEquals(node1, sll.getHead().getNext().getNext());
    }

    @Test
    public void testInsertTail() {
        sll.InsertTail(node1);
        assertEquals(1, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node1, sll.getTail());

        sll.InsertTail(node2);
        assertEquals(2, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getTail());

        sll.InsertTail(node3);
        assertEquals(3, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node3, sll.getTail());
    }

    @Test
    public void testInsert() {
        sll.Insert(node1, 1);
        assertEquals(1, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node1, sll.getTail());

        sll.Insert(node2, 2);
        assertEquals(2, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getTail());

        sll.Insert(node3, 2);
        assertEquals(3, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node3, sll.getHead().getNext());
        assertEquals(node2, sll.getTail());

        sll.Insert(node4, 4);
        assertEquals(4, sll.getLength());
        assertEquals(node1, sll.getHead());
        assertEquals(node3, sll.getHead().getNext());
        assertEquals(node2, sll.getHead().getNext().getNext());
        assertEquals(node4, sll.getTail());
    }

    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        sll.SortedInsert(node2);
        assertEquals(node2, sll.DeleteHead());

        sll.SortedInsert(node2);
        assertEquals(1, sll.getLength());
        sll.SortedInsert(node1);
        assertEquals(2, sll.getLength());
        sll.SortedInsert(node3);
        assertEquals(3, sll.getLength());
        assertEquals(node1, sll.DeleteHead());
        assertEquals(node2, sll.DeleteHead());
        assertEquals(node3, sll.DeleteHead());
    }

    @Test
    public void testSearch() {

        assertNull(sll.Search(node1));

        sll.InsertHead(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        assertEquals(node1, sll.Search(node1));
        assertEquals(node2, sll.Search(node2));
        assertEquals(node3, sll.Search(node3));
    }

    @Test
    public void testDeleteHead() {
        assertNull(sll.DeleteHead());

        sll.InsertHead(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        assertEquals(node1, sll.DeleteHead());
        assertEquals(2, sll.getLength());
        assertEquals(node2, sll.DeleteHead());
        assertEquals(1, sll.getLength());
        assertEquals(node3, sll.DeleteHead());
        assertEquals(0, sll.getLength());
        assertNull(sll.DeleteHead());
    }

    @Test
    public void testDeleteTail() {
        assertNull(sll.DeleteTail());

        sll.InsertHead(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        assertEquals(node3, sll.DeleteTail());
        assertEquals(2, sll.getLength());
        assertEquals(node2, sll.DeleteTail());
        assertEquals(1, sll.getLength());
        assertEquals(node1, sll.DeleteTail());
        assertEquals(0, sll.getLength());
        assertNull(sll.getHead());
    }

    @Test
    public void testDelete() {
        assertNull(sll.Delete(node1));
        
        sll.InsertHead(node1);
        assertEquals(node1, sll.Delete(node1));

        sll.InsertHead(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        assertEquals(node3, sll.Delete(node3));
        assertEquals(2, sll.getLength());
        assertEquals(node2, sll.Delete(node2));
        assertEquals(1, sll.getLength());
        assertEquals(node1, sll.Delete(node1));
        assertEquals(0, sll.getLength());
        assertNull(sll.getHead());
    }

    @Test
    public void testSort() {
        sll.InsertHead(node4);
        sll.InsertTail(node1);
        sll.InsertHead(node2);
        sll.InsertTail(node5);
        sll.InsertTail(node3);

        sll.Sort();

        assertEquals(sll.getHead(), node1);
        assertEquals(sll.getHead().getNext(), node2);
        assertEquals(sll.getHead().getNext().getNext(), node3);
        assertEquals(sll.getHead().getNext().getNext().getNext(), node4);
        assertEquals(sll.getTail(), node5);
        assertNull(node5.getNext());
    }

    @Test
    public void testClear() {
        sll.Clear();
        assertNull(sll.getHead());

        sll.InsertHead(node1);
        sll.Clear();
        assertNull(sll.getHead());
        assertEquals(0, sll.getLength());

        sll.InsertHead(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        sll.Clear();
        assertNull(sll.getHead());
        assertEquals(0, sll.getLength());
    }
}