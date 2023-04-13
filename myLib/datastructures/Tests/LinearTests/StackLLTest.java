package myLib.datastructures.Tests.LinearTests;
import myLib.datastructures.Linear.StackLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class StackLLTest {
    private StackLL stack;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;

    @Before
    public void setUp() {
        stack = new StackLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

    @Test
    public void testPush() {
        assertNull(stack.Peek());

        stack.Push(node1);
        assertEquals(node1, stack.Peek());
        assertEquals(1, stack.getLength());

        stack.Push(node2);
        assertEquals(node2, stack.Peek());
        assertEquals(2, stack.getLength());

        stack.Push(node3);
        assertEquals(node3, stack.Peek());
        assertEquals(3, stack.getLength());
    }

    @Test
    public void testPop() {
        assertNull(stack.Peek());

        stack.Push(node1);
        stack.Push(node2);
        stack.Push(node3);
        assertEquals(3, stack.getLength());

        assertEquals(3, stack.Pop());
        assertEquals(2, stack.getLength());
        assertEquals(node2, stack.Peek());
        
        assertEquals(2, stack.Pop());
        assertEquals(1, stack.getLength());
        assertEquals(node1, stack.Peek());

        assertEquals(1, stack.Pop());
        assertEquals(0, stack.getLength());

        assertNull(stack.Peek());
    }

    @Test
    public void testPeek() {
        assertNull(stack.Peek());

        stack.Push(node1);
        assertEquals(stack.Peek(), node1);

        stack.Push(node2);
        assertEquals(stack.Peek(), node2);

        stack.Push(node3);
        assertEquals(stack.Peek(), node3);

        stack.Pop();
        assertEquals(stack.Peek(), node2);

        stack.Pop();
        assertEquals(stack.Peek(), node1);

        stack.Pop();
        assertNull(stack.Peek());
    }

    @Test
    public void testSeek() {
        assertEquals(-1, stack.Seek(node1));

        stack.Push(node1);
        stack.Push(node2);
        stack.Push(node3);
        stack.Push(node4);
        stack.Push(node5);

        assertEquals(5, stack.getLength());

        assertEquals(5, stack.Seek(node1));
        assertEquals(4, stack.Seek(node2));
        assertEquals(3, stack.Seek(node3));
        assertEquals(2, stack.Seek(node4));
        assertEquals(1, stack.Seek(node5));
    }

    @Test 
    public void testEmpty() {
        assertEquals(true, stack.Empty());

        stack.Push(node1);
        assertEquals(false, stack.Empty());

        stack.Pop();
        assertEquals(true, stack.Empty());
    }
}
