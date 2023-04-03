package myLib.datastructures.Linear;

import java.sql.SQLXML;

import myLib.datastructures.nodes.DNode;

public class DLL{
    private int length;
    private DNode head;
    private DNode tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    
    public void InsertHead(DNode node) {
        node.setNext(this.head);
        this.head.setBefore(node);
        this.head = node;
        length++;
    }

    public void InsertTail(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        } else {
            DNode current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setBefore(current);
            this.tail = node;
            length++;
        }
    }

    public void Insert(DNode node, int position) {
        if (position > length+1) {
            System.out.println("Position out of bounds");
            return;
            // position out of list bounds
        }
        if (position == 1) {
            // essentially setting a new head
            InsertHead(node);
            return;
        }
        if (position == (length + 1)) {
            // essentially setting a new tail
            InsertTail(node);
            return;
        }
        DNode current = this.head;
        for (int i = 2; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        node.setNext(current.getNext());
        current.getNext().setBefore(node.getNext());
        current.setNext(node);
        node.setBefore(current);
        length++;
    }

    public void SortedInsert(DNode node) {
        if (this.head == null) {
            InsertHead(node);
            return;
        }
        
        // goes through entire linked list, if not sorted then break while loop and call sort
        if (isSorted() ==  false) {
            Sort();
        }

        DNode current;
        current = this.head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        
        node.setNext(current.getNext());
        current.getNext().setBefore(node.getNext());
        current.setNext(node);
        node.setBefore(current);
        length++;
    }

    public void DeleteHead() {
        if (this.head == null) {
            return;
        }
        if (length == 1) {
            this.head = null;
            this.tail = null;
            length--;
            return;
        }
        SNode temp = this.head.getNext();
        this.head = null;
        this.head = temp;
        length--;
    }
}
