package myLib.datastructures.Linear;
import myLib.datastructures.nodes.DNode;

/**
 * QueueLL is a class that represents a Queue data structure implemented using a Singly Linked List.
 * It extends the SLL (Singly Linked List) class and overrides certain methods to implement Queue-specific behavior.
 * QueueLL allows for enqueueing (adding) elements to the end of the queue, dequeuing (removing) elements from the front of the queue,
 * peeking at the element at the front of the queue without removing it, checking if the queue is empty, getting the length of the queue,
 * and printing the contents of the queue.
 * @author Nathan Ante
 * @version 1.0
 */
public class QueueLL extends SLL{

    /**
     * Default constructor for QueueLL.
     */
    public QueueLL() {
        super();
    }

    /**
     * Parametized constructor for QueueLL that takes a node as an argument.
     */
    public QueueLL(DNode node) {
        super(node);
    }
    /**
     * Parametized constructor for QueueLL that takes an int as an argument.
     * Creates a node from the int.
     */
    public QueueLL(int num) {
        super(num);
    }

    @Override
    public void InsertHead(DNode node) {}

    @Override
    public void InsertTail(DNode node) {}

    @Override
    public void Insert(DNode node, int position) {}

    @Override
    public void SortedInsert(DNode node) {}

    /**
     * Searches for node in queue.
     * @param node  The node to be searched.
     * @return The node if it exists in queue, else return null.
     */
    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public DNode getHead() {return null;}

    @Override
    public DNode getTail() { return null;}

    /**
     * Returns the length of the queue.
     * @return Length of queue as an int.
     */
    @Override
    public int getLength() {return super.getLength();}

    @Override
    public DNode DeleteHead() {return null;}

    @Override
    public DNode DeleteTail() {return null;}

    @Override
    public DNode Delete(DNode node) {return null;}

    @Override
    public void Sort() {}
    
    /**
     * Empties the queue, dequeue every node;
     */
    @Override
    public void Clear() {
        while (super.getHead() != null) {
            super.DeleteHead();
        }
    }

    /**
     * Enqueues node and places it at tail of list
     * @param node  The node to be enqueued
     */
    public void Enqueue(DNode node) {
        super.InsertTail(node);
    }

    /**
     * Enqueues int after making a new node and places it at tail of list
     * @param node  The int to be enqueued
     */
    public void Enqueue(int num) {
        DNode node = new DNode(num);
        super.InsertTail(node);
    }

    /**
     * Denqueues node by removing the head of the list.
     * @return The data value of the head node as an int.
     */
    public int Dequeue() {
        if (super.getLength() == 0) {
            return 0;
        }
        
        return super.DeleteHead().getData();
    }
    
    /**
     * Peeks the head node of the queue
     * @return The head node of queue.
     */
    public DNode Peek() {
        return super.getHead();
    }

    /**
     * Seeks the given node.
     * @return The position of node in queue from head as an int. If node does not exists it returns -1.
     */
    public int Seek(DNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        DNode current = super.getHead();
        int i = 1;
        while (current != null) {
            if (current == node) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Checks if queue is empty
     * @return Returns true if empty, false if not.
     */
    public boolean Empty() {
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints contents of queue.
     */
    @Override
    public void Print() {
        System.out.println("Queue length: " + super.getLength());
        DNode current = super.getHead();
        if (Empty() == true) {
            System.out.println("Empty Queue");
        } else {
            int i = 1;
            System.out.println("Queue Content...");
            System.out.println("------------------------------");
            while (current != null) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("------------------------------");
        }
    }
}