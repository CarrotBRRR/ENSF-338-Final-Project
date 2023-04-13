package Tests.LinearTests;
import myLib.datastructures.Linear.CDLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class CDLLTest {
    private CDLL cdll;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;

    @Before
    public void setUp() {
        cdll = new CDLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

    @Test
    public void testInsertHead() {
        cdll.InsertHead(node1);
        assertEquals(1, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node1, node1.getNext());
        assertEquals(node1, node1.getBefore());

        cdll.InsertHead(node2);
        assertEquals(2, cdll.getLength());
        assertEquals(node2, cdll.getHead());
        assertEquals(node1, cdll.getHead().getNext());
        assertEquals(node2, node1.getNext());
        assertEquals(node1, cdll.getHead().getBefore());
        assertEquals(node2, cdll.getTail().getBefore());
        
        cdll.InsertHead(node3);
        assertEquals(3, cdll.getLength());
        assertEquals(node3, cdll.getHead());
        assertEquals(node2, cdll.getHead().getNext());
        assertEquals(node1, cdll.getHead().getNext().getNext());
        assertEquals(node3, node1.getNext());
        assertEquals(node1, node3.getBefore());
    }

    @Test
    public void testInsertTail() {
        cdll.InsertTail(node1);
        assertEquals(1, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node1, cdll.getTail());
        assertEquals(node1, node1.getNext());
        assertEquals(node1, cdll.getTail().getBefore());
        assertEquals(node1, cdll.getHead().getBefore());


        cdll.InsertTail(node2);
        assertEquals(2, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node2, cdll.getTail());
        assertEquals(node1, node2.getNext());
        assertEquals(node2, cdll.getHead().getBefore());


        cdll.InsertTail(node3);
        assertEquals(3, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getTail());
        assertEquals(node1, node3.getNext());
        assertEquals(node3, cdll.getHead().getBefore());
    }

    @Test
    public void testInsert() {
        cdll.Insert(node1, 1);
        assertEquals(1, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node1, cdll.getTail());
        assertEquals(node1, node1.getNext());
        assertEquals(node1, cdll.getTail().getBefore());
        assertEquals(node1, cdll.getHead().getBefore());


        cdll.Insert(node2, 2);
        assertEquals(2, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node2, cdll.getTail());
        assertEquals(node1, node2.getNext());
        assertEquals(node2, node1.getBefore());

        cdll.Insert(node3, 2);
        assertEquals(3, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getHead().getNext());
        assertEquals(node2, cdll.getTail());
        assertEquals(node1, node2.getNext());
        assertEquals(node1, cdll.getTail().getNext());
        assertEquals(node3, cdll.getTail().getBefore());
        assertEquals(node3, node2.getBefore());

        cdll.Insert(node4, 4);
        assertEquals(4, cdll.getLength());
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getHead().getNext());
        assertEquals(node2, cdll.getHead().getNext().getNext());
        assertEquals(node4, cdll.getTail());
        assertEquals(node1, node4.getNext());
        assertEquals(node4, node1.getBefore());
        assertEquals(node1, node4.getNext());
    }

    @Test
    public void testSortedInsert() {
        cdll.SortedInsert(node2);
        assertEquals(node2, cdll.getHead().getBefore());
        assertEquals(node2, cdll.getTail().getBefore());
        assertEquals(node2, cdll.getHead().getNext());
        assertEquals(node2, cdll.getTail().getNext());
        assertEquals(node2, node2.getNext());
        assertEquals(node2, cdll.DeleteHead());
        

        cdll.SortedInsert(node2);
        assertEquals(1, cdll.getLength());
        assertEquals(node2, node2.getNext());
        assertEquals(node2, cdll.getHead());
        assertEquals(node2, cdll.getTail());

        cdll.SortedInsert(node1);
        assertEquals(2, cdll.getLength());
        assertEquals(node1, node2.getNext());
        assertEquals(node1, cdll.getHead());
        assertEquals(node2, cdll.getTail());
        assertEquals(node1, cdll.getTail().getBefore());
        assertEquals(node1, cdll.getTail().getNext());

        cdll.SortedInsert(node3);
        assertEquals(3, cdll.getLength());
        assertEquals(node1, node3.getNext());
        assertEquals(node1, cdll.getHead());
        assertEquals(node3, cdll.getTail());
        assertEquals(node2, cdll.getTail().getBefore());
        assertEquals(node1, cdll.getTail().getNext());

        assertEquals(node1, cdll.DeleteHead());
        assertEquals(node2, cdll.DeleteHead());
        assertEquals(node3, cdll.DeleteHead());
    }

    @Test
    public void testSearch() {

        assertNull(cdll.Search(node1));
        cdll.InsertHead(node1);
        cdll.InsertTail(node2);
        cdll.InsertTail(node3);

        assertEquals(node1, cdll.Search(node1));
        assertEquals(node2, cdll.Search(node2));
        assertEquals(node3, cdll.Search(node3));
        assertEquals(node1, cdll.Search(node3).getNext());
        assertEquals(node2, cdll.Search(node3).getBefore());
    }

    @Test
    public void testDeleteHead() {
        assertNull(cdll.DeleteHead());
        cdll.InsertHead(node1);
        cdll.InsertTail(node2);
        cdll.InsertTail(node3);

        assertEquals(node1, cdll.DeleteHead());
        assertEquals(node2, node3.getNext());
        assertEquals(node2, cdll.getHead());
        assertEquals(2, cdll.getLength());
        assertEquals(cdll.getHead(), cdll.getTail().getNext());
        assertEquals(node2, cdll.getTail().getNext());
        assertEquals(node2, cdll.getTail().getBefore());
        assertEquals(node3, cdll.getHead().getBefore());

        assertEquals(node2, cdll.DeleteHead());
        assertEquals(node3, node3.getNext());
        assertEquals(1, cdll.getLength());
        assertEquals(node3, node3.getNext());
        assertEquals(node3, cdll.getHead().getBefore());
        assertEquals(node3, cdll.getHead().getNext());

        assertEquals(node3, cdll.DeleteHead());
        assertEquals(0, cdll.getLength());
        assertNull(cdll.DeleteHead());
    }

    @Test
    public void testDeleteTail() { 
        assertNull(cdll.DeleteTail());

        cdll.InsertHead(node1);
        cdll.InsertTail(node2);
        cdll.InsertTail(node3);

        assertEquals(node3, cdll.DeleteTail());
        assertEquals(node1, node2.getNext());
        assertEquals(2, cdll.getLength());
        assertEquals(node2, cdll.getTail());
        assertEquals(node1, cdll.getTail().getNext());
        assertEquals(node1, cdll.getTail().getBefore());
        assertEquals(node2, cdll.getHead().getBefore());

        assertEquals(node2, cdll.DeleteTail());
        assertEquals(node1, node1.getNext());
        assertEquals(1, cdll.getLength());
        assertEquals(node1, cdll.getTail());
        assertEquals(node1, node1.getNext());
        assertEquals(node1, cdll.getHead().getBefore());
        assertEquals(node1, cdll.getTail().getBefore());
        assertEquals(node1, node1.getBefore());

        assertEquals(node1, cdll.DeleteTail());
        assertEquals(0, cdll.getLength());
        assertNull(cdll.getTail());
        assertNull(cdll.getHead());
    }

    @Test
    public void testDelete() { 
        assertNull(cdll.Delete(node1));

        cdll.InsertHead(node1);
        cdll.InsertTail(node2);
        cdll.InsertTail(node3);
        cdll.InsertTail(node4);
        cdll.InsertTail(node5);

        assertEquals(node3, cdll.Delete(node3));
        assertEquals(4, cdll.getLength());
        assertEquals(node2, node4.getBefore());

        assertEquals(node5, cdll.Delete(node5));
        assertEquals(3, cdll.getLength());
        assertEquals(node1, node4.getNext());
        assertEquals(node1, node4.getNext());
        assertEquals(node4, node1.getBefore());

        assertEquals(node1, cdll.Delete(node1));
        assertEquals(2, cdll.getLength());
        assertEquals(node2, node4.getNext());
        assertEquals(node2, node4.getBefore());
        assertEquals(node4, node2.getBefore());
        assertEquals(node2, node4.getNext());

        assertEquals(node2, cdll.Delete(node2));
        assertEquals(node4, node4.getNext());
        assertEquals(node4, node4.getBefore());
        assertEquals(node4, node4.getNext());

        assertEquals(node4, cdll.Delete(node4));
        assertNull(cdll.getHead());
    }

    @Test
    public void testSort() {
        cdll.InsertHead(node4);
        cdll.InsertTail(node1);
        cdll.InsertHead(node2);
        cdll.InsertTail(node5);
        cdll.InsertTail(node3);

        cdll.Sort();

        assertEquals(cdll.getHead(), node1);
        assertEquals(cdll.getHead().getNext(), node2);
        assertEquals(cdll.getHead().getNext().getNext(), node3);
        assertEquals(cdll.getHead().getNext().getNext().getNext(), node4);
        assertEquals(cdll.getTail(), node5);
        assertEquals(node1, node5.getNext());
        assertEquals(cdll.getHead(), cdll.getTail().getNext());
    }

    @Test
    public void testClear() {
        cdll.Clear();
        assertNull(cdll.getHead());

        cdll.InsertHead(node1);
        cdll.Clear();
        assertNull(cdll.getHead());
        assertEquals(0, cdll.getLength());

        cdll.InsertHead(node1);
        cdll.InsertTail(node2);
        cdll.InsertTail(node3);
        cdll.Clear();
        assertNull(cdll.getHead());
        assertEquals(0, cdll.getLength());
    } 
}
