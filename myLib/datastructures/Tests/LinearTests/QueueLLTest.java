package myLib.datastructures.Tests.LinearTests;
import myLib.datastructures.Linear.QueueLL;
import myLib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class QueueLLTest {
    private QueueLL queue;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;
    private DNode node5;

    @Before
    public void setUp() {
        queue = new QueueLL();
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        node5 = new DNode(5);
    }

        @Test
        public void testEnqueue() {
            assertNull(queue.Peek());
            assertEquals(true, queue.Empty());
            assertEquals(-1, queue.Seek(node1));

            queue.Enqueue(node1);
            assertEquals(1, queue.getLength());
            assertEquals(node1, queue.Peek());
            assertEquals(1, queue.Seek(node1));

            queue.Enqueue(node2);
            assertEquals(2, queue.getLength());
            assertEquals(node1, queue.Peek());
            assertEquals(2, queue.Seek(node2));

            queue.Enqueue(node3);
            assertEquals(3, queue.getLength());
            assertEquals(node1, queue.Peek());
            assertEquals(3, queue.Seek(node3));            
        }

        @Test
        public void testDequeue() {
            assertNull(queue.Peek());
            queue.Enqueue(node1);
            queue.Enqueue(node2);
            queue.Enqueue(node3);
            queue.Enqueue(node4);
            queue.Enqueue(node5);

            assertEquals(5, queue.getLength());
            assertEquals(1, queue.Dequeue());
            assertEquals(node2, queue.Peek());

            assertEquals(4, queue.getLength());
            assertEquals(2, queue.Dequeue());
            assertEquals(node3, queue.Peek());

            assertEquals(3, queue.getLength());
            assertEquals(3, queue.Dequeue());
            assertEquals(node4, queue.Peek());

            assertEquals(2, queue.getLength());
            assertEquals(4, queue.Dequeue());
            assertEquals(node5, queue.Peek());

            assertEquals(1, queue.getLength());
            assertEquals(5, queue.Dequeue());

            assertEquals(0, queue.getLength());
            assertNull(queue.Peek());
            assertEquals(0, queue.Dequeue());
        }

        @Test
        public void testPeek() {
            assertNull(queue.Peek());

            queue.Enqueue(node1);
            queue.Enqueue(node2);
            queue.Enqueue(node3);
            queue.Enqueue(node4);
            queue.Enqueue(node5);

            assertEquals(node1, queue.Peek());
            queue.Dequeue();

            assertEquals(node2, queue.Peek());
            queue.Dequeue();
            
            assertEquals(node3, queue.Peek());
            queue.Dequeue();

            assertEquals(node4, queue.Peek());
            queue.Dequeue();

            assertEquals(node5, queue.Peek());
            queue.Dequeue();

            assertNull(queue.Peek());
        }

        @Test
        public void testSeek() {
            assertEquals(-1, queue.Seek(node1));

            queue.Enqueue(node1);
            queue.Enqueue(node2);
            queue.Enqueue(node3);
            queue.Enqueue(node4);
            queue.Enqueue(node5);

            assertEquals(1, queue.Seek(node1));
            assertEquals(2, queue.Seek(node2));
            assertEquals(3, queue.Seek(node3));
            assertEquals(4, queue.Seek(node4));
            assertEquals(5, queue.Seek(node5));
        }

        @Test 
        public void testEmpty() {
            assertEquals(true, queue.Empty());

            queue.Enqueue(node1);
            assertEquals(false, queue.Empty());

            queue.Dequeue();
            assertEquals(true, queue.Empty());
        }
}
