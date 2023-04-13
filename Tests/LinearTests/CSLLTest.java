package Tests.LinearTests;
import myLib.datastructures.Linear.CSLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class CSLLTest {
    private CSLL csll;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;

    @Before
    public void setUp() {
        csll = new CSLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

    @Test
    public void testInsertHead() {
        csll.InsertHead(node1);
        assertEquals(1, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node1, node1.getNext());

        csll.InsertHead(node2);
        assertEquals(2, csll.getLength());
        assertEquals(node2, csll.getHead());
        assertEquals(node1, csll.getHead().getNext());
        assertEquals(node2, node1.getNext());
        
        csll.InsertHead(node3);
        assertEquals(3, csll.getLength());
        assertEquals(node3, csll.getHead());
        assertEquals(node2, csll.getHead().getNext());
        assertEquals(node1, csll.getHead().getNext().getNext());
        assertEquals(node3, node1.getNext());
    }

    @Test
    public void testInsertTail() {
        csll.InsertTail(node1);
        assertEquals(1, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getTail());
        assertEquals(node1, node1.getNext());


        csll.InsertTail(node2);
        assertEquals(2, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getTail());
        assertEquals(node1, node2.getNext());

        csll.InsertTail(node3);
        assertEquals(3, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node3, csll.getTail());
        assertEquals(node1, node3.getNext());
    }

    @Test
    public void testInsert() {
        csll.Insert(node1, 1);
        assertEquals(1, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getTail());
        assertEquals(node1, node1.getNext());

        csll.Insert(node2, 2);
        assertEquals(2, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getTail());
        assertEquals(node1, node2.getNext());

        csll.Insert(node3, 2);
        assertEquals(3, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node3, csll.getHead().getNext());
        assertEquals(node2, csll.getTail());
        assertEquals(node1, node2.getNext());
        assertEquals(node1, csll.getTail().getNext());

        csll.Insert(node4, 4);
        assertEquals(4, csll.getLength());
        assertEquals(node1, csll.getHead());
        assertEquals(node3, csll.getHead().getNext());
        assertEquals(node2, csll.getHead().getNext().getNext());
        assertEquals(node4, csll.getTail());
        assertEquals(node1, node4.getNext());
    }

    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        csll.SortedInsert(node2);
        assertEquals(node2, node2.getNext());
        assertEquals(node2, csll.DeleteHead());
        
        csll.SortedInsert(node2);
        assertEquals(1, csll.getLength());
        assertEquals(node2, node2.getNext());
        assertEquals(node2, csll.getHead());
        assertEquals(node2, csll.getTail());

        csll.SortedInsert(node1);
        assertEquals(2, csll.getLength());
        assertEquals(node1, node2.getNext());
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getTail());

        csll.SortedInsert(node3);
        assertEquals(3, csll.getLength());
        assertEquals(node1, node3.getNext());
        assertEquals(node1, csll.getHead());
        assertEquals(node3, csll.getTail());

        assertEquals(node1, csll.DeleteHead());
        assertEquals(node2, csll.DeleteHead());
        assertEquals(node3, csll.DeleteHead());
    }

    @Test
    public void testSearch() {
        assertNull(csll.Search(node1));
        csll.InsertHead(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);
        assertEquals(node1, csll.Search(node1));
        assertEquals(node2, csll.Search(node2));
        assertEquals(node3, csll.Search(node3));
        assertEquals(node1, csll.Search(node3).getNext());
    }

    @Test
    public void testDeleteHead() {
        assertNull(csll.DeleteHead());
        csll.InsertHead(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);

        assertEquals(node1, csll.DeleteHead());
        assertEquals(node2, node3.getNext());
        assertEquals(node2, csll.getHead());
        assertEquals(2, csll.getLength());
        assertEquals(csll.getHead(), csll.getTail().getNext());
        assertEquals(node2, csll.getTail().getNext());

        assertEquals(node2, csll.DeleteHead());
        assertEquals(node3, node3.getNext());
        assertEquals(1, csll.getLength());
        assertEquals(node3, node3.getNext());

        assertEquals(node3, csll.DeleteHead());
        assertEquals(0, csll.getLength());
        assertNull(csll.DeleteHead());
    }

    @Test
    public void testDeleteTail() {
        assertNull(csll.DeleteTail());

        csll.InsertHead(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);

        assertEquals(node3, csll.DeleteTail());
        assertEquals(node1, node2.getNext());
        assertEquals(2, csll.getLength());
        assertEquals(node2, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());

        assertEquals(node2, csll.DeleteTail());
        assertEquals(node1, node1.getNext());
        assertEquals(1, csll.getLength());
        assertEquals(node1, csll.getTail());
        assertEquals(node1, node1.getNext());

        assertEquals(node1, csll.DeleteTail());
        assertEquals(0, csll.getLength());
        assertNull(csll.getTail());
        assertNull(csll.getHead());
    }

    @Test
    public void testDelete() {
        assertNull(csll.Delete(node1));

        csll.InsertHead(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);
        csll.InsertTail(node4);
        csll.InsertTail(node5);


        assertEquals(node3, csll.Delete(node3));
        assertEquals(4, csll.getLength());

        assertEquals(node5, csll.Delete(node5));
        assertEquals(3, csll.getLength());
        assertEquals(node1, node4.getNext());

        assertEquals(node1, csll.Delete(node1));
        assertEquals(2, csll.getLength());
        assertEquals(node2, node4.getNext());

        assertEquals(node2, csll.Delete(node2));
        assertEquals(node4, node4.getNext());

        assertEquals(node4, csll.Delete(node4));
        assertNull(csll.getHead());
    }

    @Test
    public void testSort() {
        csll.InsertHead(node4);
        csll.InsertTail(node1);
        csll.InsertHead(node2);
        csll.InsertTail(node5);
        csll.InsertTail(node3);

        csll.Sort();

        assertEquals(csll.getHead(), node1);
        assertEquals(csll.getHead().getNext(), node2);
        assertEquals(csll.getHead().getNext().getNext(), node3);
        assertEquals(csll.getHead().getNext().getNext().getNext(), node4);
        assertEquals(csll.getTail(), node5);
        assertEquals(node1, node5.getNext());
        assertEquals(csll.getHead(), csll.getTail().getNext());
    }

    @Test
    public void testClear() {
        csll.Clear();
        assertNull(csll.getHead());

        csll.InsertHead(node1);
        csll.Clear();
        assertNull(csll.getHead());
        assertEquals(0, csll.getLength());

        csll.InsertHead(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);
        csll.Clear();
        assertNull(csll.getHead());
        assertEquals(0, csll.getLength());
    } 
}
