package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

/**
 * StackLL is a stack implementation that extends a singly linked list (SLL).
 * It allows operations like push, pop, peek, check if empty, and print the stack.
 * @author Nathan Ante
 * @version 1.0
 */
public class StackLL extends SLL{

    /**
     * Default constructor that creates an empty stack.
     */
    public StackLL() {
        super();
    }

    /**
     * Constructor that creates a stack with the given node as the head.
     * 
     * @param node The initial node to set as the head of the stack.
     */
    public StackLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {}

    @Override
    public void InsertTail(DNode node) {}

    @Override
    public void Insert(DNode node, int position) {}

    @Override
    public void SortedInsert(DNode node) {}

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public DNode DeleteHead() {return null;}

    @Override
    public DNode DeleteTail() {return null;}

    @Override
    public DNode Delete(DNode node) {return null;}

    @Override
    public void Sort() {}
    
    /**
     * Clears the stack by repeatedly deleting the tail until the stack is empty.
     */
    @Override
    public void Clear() {
        while (super.getHead() != null) {
            super.DeleteTail();
        }
    }

    /**
     * Pushes a node onto the top of the stack by inserting it at the tail.
     * 
     * @param node The node to be pushed onto the stack.
     */
    public void Push(DNode node) {
        super.InsertTail(node);
    }

    /**
     * Pops the node from the top of the stack by deleting it from the tail.
     * 
     * @return The data of the popped node, or 0 if the stack is empty.
     */
    public int Pop() {
        if (super.getLength() == 0) {
            return 0;
        }
        return super.DeleteTail().getData();
    }

    /**
     * Peeks at the node from the top of the stack without removing it.
     * 
     * @return The node at the top of the stack, or null if the stack is empty.
     */
    public DNode Peek() {
        return super.getTail();
    }

    /**
     * Searches for the position of a node in the stack from top to bottom.
     * 
     * @param node The node to search for in the stack.
     * @return The position of the node in the stack, or -1 if the node is not found.
     */
    public int Seek(DNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        DNode current = super.getHead();
        int i = 1;
        while (current != null) {
            if (current == node) {
                return super.getLength() - i + 1;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Checks if stack is empty
     * 
     * @return true if the stack is empty, otherwise false.
     */
    public boolean Empty() {
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints the cotents of the stack
     */
    @Override
    public void Print() {
        System.out.println("Stack length: " + super.getLength());
        DNode current = super.getHead();
        if (Empty() == true) {
            System.out.println("Empty Queue");
        } else {
            int i = 1;
            System.out.println("Stack Content...");
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
