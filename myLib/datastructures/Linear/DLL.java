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
        this.length = 0;
    }
    
    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    
    public void InsertHead(DNode node) {
        if(this.head == null) {
            this.head = node;
            this.tail = node;
            this.length = 1;
            return;
        }
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
        current.getNext().setBefore(node);
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
        current.getNext().setBefore(node);
        current.setNext(node);
        node.setBefore(current);
        length++;
    }

    public DNode Search(DNode node) {
        DNode current = this.head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        }
        return null;
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
        // temp is new head
        DNode temp = this.head.getNext();
        this.head = null;
        this.head = temp;
        this.head.setBefore(null);
        this.length--;
    }

    public void DeleteTail() {
        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return;
        }
        DNode current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        this.tail = null;
        current.setNext(null);
        this.tail = current;
        this.length--;
    }

    public void Delete(DNode node) {
        DNode deleteDNode = Search(node);
        if (deleteDNode == null) {
            return;
        }

        if (node == this.head) {
            DeleteHead();
            return;
        }

        if (node == this.tail) {
            DeleteTail();
            return;
        }

        DNode current = this.head;
        while (current.getNext() != node) {
            current = current.getNext();
        }
        // current is the node before the to-be-deleted node
        current.setNext(node.getNext());
        node.getNext().setBefore(current);
        this.length--;
    }

    public void Sort() {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }


        DNode current = this.head.getNext();
        while(current != null) {
            DNode prev = current.getBefore();
            DNode next = current.getNext();
            //while prev.data > current.data, then make prev into current
            while(prev != null && prev.getData() > current.getData()){
                DNode temp = prev.getBefore();

                // set prev.next to current.next
                prev.setNext(current.getNext());

                // set prev.before to current
                prev.setBefore(current);

                //set current.next to prev
                current.setNext(prev);

                //set current.before to prev.befor
                current.setBefore(temp);

                current = prev;
            }
            if (current.getBefore() == null) {
                this.head = current;
            } else {
                current.setNext(next);
                next.setBefore(current);
            }
            current = next;
        }
        // used to find tail
        current = this.head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        this.tail = current;
    }

    public void Clear() {
        while (this.head != null) {
            DeleteHead();
        }
    }

    public boolean isSorted() {
        if (length == 0 || length == 1) {
            return true;
        }
        DNode current = this.head.getNext();
        while (current.getNext() != null) {
            if (current.getBefore().getData() > current.getData() ) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: "+ isSorted());
        DNode current = this.head;
        if (current == null) {
            System.out.println("Empty List");
        } else {
            int i = 1;
            while (current != null) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                current = current.getNext();
                i++;
            }
        }
    }

    public DNode getTail() {
        return this.tail;
    }

    public DNode getHead() {
        return this.head;
    }

    public int getLength() {
        return this.length;
    }
}
