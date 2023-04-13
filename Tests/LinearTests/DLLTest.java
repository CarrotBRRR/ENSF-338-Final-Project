package Tests.LinearTests;
import myLib.datastructures.Linear.DLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class DLLTest {
    private DLL dll;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;


    @Before
    public void setUp() {
        dll = new DLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

    @Test
    public void testInsertHead() {
        dll.InsertHead(node1);
        assertEquals(1, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertNull(dll.getHead().getBefore());
        assertNull(dll.getTail().getBefore());
        assertNull(dll.getHead().getNext());
        assertNull(dll.getTail().getNext());

        dll.InsertHead(node2);
        assertEquals(2, dll.getLength());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getHead().getNext());
        assertEquals(node2, node1.getBefore());
        assertEquals(node2, dll.getTail().getBefore());

        dll.InsertHead(node3);
        assertEquals(3, dll.getLength());
        assertEquals(node3, dll.getHead());
        assertEquals(node2, dll.getHead().getNext());
        assertEquals(node1, dll.getHead().getNext().getNext());
        assertEquals(node3, node2.getBefore());
        assertEquals(node3, dll.getTail().getBefore().getBefore());
    }

    @Test 
    public void testInsertTail() {
        assertEquals(0, dll.getLength());

        dll.InsertTail(node1);
        assertEquals(1, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());
        assertNull(dll.getHead().getBefore());
        assertNull(dll.getTail().getBefore());
        assertNull(dll.getHead().getNext());
        assertNull(dll.getTail().getNext());
        assertEquals(1, dll.getLength());

        dll.InsertTail(node2);
        assertEquals(2, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node2, dll.getTail());
        assertEquals(dll.getHead().getNext(), node2);
        assertEquals(dll.getTail().getBefore(), node1);

        dll.InsertTail(node3);
        assertEquals(3, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node2, dll.getTail().getBefore());
        assertEquals(node1, dll.getTail().getBefore().getBefore());
    }

    @Test 
    public void testInsert() {
        assertEquals(0, dll.getLength());

        dll.Insert(node1, 1);
        assertEquals(1, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());
        assertNull(dll.getHead().getBefore());
        assertNull(dll.getTail().getBefore());
        assertEquals(1, dll.getLength());

        dll.Insert(node2, 2);
        assertEquals(2, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node2, dll.getTail());
        assertEquals(dll.getHead().getNext(), node2);
        assertEquals(dll.getTail().getBefore(), node1);
        assertEquals(2, dll.getLength());

        dll.Insert(node3, 2);
        assertEquals(3, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertEquals(node2, dll.getTail());
        assertEquals(dll.getHead().getNext(), node3);
        assertEquals(dll.getTail().getBefore(), node3);
        assertEquals(3, dll.getLength());

        dll.Insert(node4, 4);
        assertEquals(4, dll.getLength());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertEquals(node2, dll.getHead().getNext().getNext());
        assertEquals(node4, dll.getTail());
        assertEquals(dll.getTail().getBefore(), node2);
        assertEquals(4, dll.getLength());
    }

    @Test
    public void testSortedInsert() {
        dll.SortedInsert(node2);
        assertEquals(1, dll.getLength());
        assertEquals(node2, dll.DeleteHead());
        assertEquals(0, dll.getLength());

        dll.SortedInsert(node2);
        assertEquals(1, dll.getLength());
        dll.SortedInsert(node1);
        assertEquals(2, dll.getLength());
        dll.SortedInsert(node3);
        assertEquals(3, dll.getLength());
        assertEquals(node1, dll.getTail().getBefore().getBefore());
        assertEquals(node2, dll.getTail().getBefore());
        assertEquals(node1, dll.DeleteHead());
        assertEquals(node2, dll.DeleteHead());
        assertEquals(node3, dll.DeleteHead());
        
    }

    @Test
    public void testSearch() {

        assertNull(dll.Search(node1));

        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);
        assertEquals(node1, dll.Search(node1));
        assertEquals(node2, dll.Search(node2));
        assertEquals(node3, dll.Search(node3));
    }

    @Test
    public void testDeleteHead() {
        assertNull(dll.DeleteHead());

        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);
        assertEquals(3, dll.getLength());

        assertEquals(node1, dll.DeleteHead());
        assertEquals(node2, dll.getTail().getBefore());
        assertEquals(2, dll.getLength());

        assertEquals(node2, dll.DeleteHead());
        assertNull(dll.getTail().getBefore());
        assertEquals(1, dll.getLength());

        assertEquals(node3, dll.DeleteHead());
        assertNull(dll.DeleteHead());
        assertEquals(0, dll.getLength());
    }

    @Test
    public void testDeleteTail() {
        assertNull(dll.DeleteTail());

        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);
        assertEquals(3, dll.getLength());

        assertEquals(node3, dll.DeleteTail());
        assertEquals(node1, dll.getTail().getBefore());
        assertEquals(2, dll.getLength());

        assertEquals(node2, dll.DeleteTail());
        assertNull(dll.getTail().getBefore());
        assertEquals(1, dll.getLength());

        assertEquals(node1, dll.DeleteTail());
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }

    @Test
    public void testDelete() {
        assertNull(dll.Delete(node1));

        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);
        assertEquals(3, dll.getLength());

        assertEquals(node3, dll.Delete(node3));
        assertEquals(node1, dll.getTail().getBefore());
        assertEquals(2, dll.getLength());


        assertEquals(node2, dll.Delete(node2));
        assertNull(dll.getTail().getBefore());
        assertEquals(1, dll.getLength());

        assertEquals(node1, dll.Delete(node1));
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }

    @Test
    public void testSort() {
        dll.InsertHead(node4);
        dll.InsertTail(node1);
        dll.InsertHead(node2);
        dll.InsertTail(node5);
        dll.InsertTail(node3);

        dll.Sort();

        assertEquals(dll.getHead(), node1);
        assertEquals(dll.getHead().getNext(), node2);
        assertEquals(dll.getHead().getNext().getNext(), node3);
        assertEquals(dll.getHead().getNext().getNext().getNext(), node4);
        assertEquals(dll.getTail(), node5);
        assertNull(node5.getNext());

        assertEquals(node1, dll.getTail().getBefore().getBefore().getBefore().getBefore());
        assertEquals(node2, dll.getTail().getBefore().getBefore().getBefore());
        assertEquals(node3, dll.getTail().getBefore().getBefore());
        assertEquals(node4, dll.getTail().getBefore());
    }

    @Test
    public void testClear() {
        dll.Clear();
        assertNull(dll.getHead());

        dll.InsertHead(node1);
        dll.Clear();
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());

        dll.InsertHead(node1);
        dll.InsertTail(node2);
        dll.InsertTail(node3);
        dll.Clear();
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }
}
