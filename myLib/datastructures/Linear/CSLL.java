package myLib.datastructures.Linear;
import myLib.datastructures.nodes.DNode;

/**
 * A Circly Singly Linked List (CSLL) implementation that stores nodes of type DNode and a singly linked list (SLL).
 * Nodes can be inserted at the head, tail, or at a specific position in the CSLL.
 * Nodes can also be sorted in ascending order based on their data.
 * Nodes can be searched, deleted from the CSLL, and the CSLL can be sorted.
 * Methods used are the same as SLL and are just called from SLL using super but with modifications that account for the circly functionality.
 * 
 * @author Nathan Ante
 * @version 1.0
 */

public class CSLL extends SLL{

    /**
     * Default constructor that creates a new SLL object by calling the SLL constructor
     */
    public CSLL() {
        super();
    }

    /**
     * Parametized constructor that creates a new SLL object by calling the SLL constructor with the node.
     * It then sets the next node of the tail to be the head.
     * @param node The initial node of the list.
     */
    public CSLL(DNode node) {
        super(node);
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void InsertHead(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertHead(node);
        super.getTail().setNext(super.getHead());

        
    }

    @Override
    public void InsertTail(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertTail(node);
        super.getTail().setNext(super.getHead());

    }

    @Override
    public void Insert(DNode node, int position) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.Insert(node, position);
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void SortedInsert(DNode node) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.SortedInsert(node);
        super.getTail().setNext(super.getHead());
    }

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public DNode DeleteHead() {
        if (super.getHead() == null) {
            return null;
        }

        super.getTail().setNext(null);

        if (super.getLength() == 1) {
            return super.DeleteHead();
        }

        DNode returnNode = super.DeleteHead();
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode DeleteTail() {
        if (super.getHead() == null) {
            return null;
        }

        super.getTail().setNext(null);

        if (super.getLength() == 1) {
            return super.DeleteTail();
        }

        DNode returnNode = super.DeleteTail();
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode Delete(DNode node) {
        DNode deleteNode = super.Search(node);
        if (deleteNode == null) {
            return null;
        }

        if (node == super.getHead() ) {
            return DeleteHead();
        }

        if (node == super.getTail()) {
            return DeleteTail();
        }
        
        super.getTail().setNext(null);
        DNode returnNode = super.Delete(node); 
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public void Sort() {
        super.getTail().setNext(null);
        super.Sort();
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void Print() {
        super.Print();
    }

    @Override
    public DNode getHead() {
        return super.getHead();
    }

    @Override
    public DNode getTail() {
        return super.getTail();
    }

    @Override
    public int getLength() {
        return super.getLength();
    }
}
