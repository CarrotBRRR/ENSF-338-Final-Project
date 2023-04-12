package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class SLL {
    private int length;
    private DNode head;
    private DNode tail;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public SLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public SLL(int num) {
        DNode node = new DNode(num);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void InsertHead(DNode node) {
        if (node == null) {
            return;
        }

        if (this.length == 0) {
            this.head = node;
            this.tail = node;
            length = 1;
            return;
        } else {
            node.setNext(this.head);
            this.head = node;
            length++;
        }
    }

    public void InsertTail(DNode node) {
        if (node == null) {
            return;
        }
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
            length = 1;
            return;
        } else {
            DNode current = this.head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
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
        for (int i = 2; i < position; i++) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
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

        if (this.head.getData() > node.getData()) {
            InsertHead(node);
            return;
        }

        if (this.tail.getData() < node.getData()) {
            InsertTail(node);
            return;
        }

        DNode current = this.head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
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

    public DNode DeleteHead() {
        if (this.head == null) {
            return null;
        }

        DNode returnHead = this.head;

        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return returnHead;
        }

        DNode temp = this.head.getNext();
        this.head.setNext(null);
        this.head = temp;
        this.length--;
        return returnHead;
    }


    public DNode DeleteTail() {
        if (this.head == null) {
            return null;
        }
        DNode returnTail = this.tail;

        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return returnTail;
        }

        DNode current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        this.tail = null;
        current.setNext(null);
        this.tail = current;
        this.length--;
        return returnTail;
    }


    public DNode Delete(DNode node) {
        DNode deleteNode = Search(node);
        if (deleteNode == null) {
            return null;
        }


        if (node == this.head) {
            return DeleteHead();
        }

        if (node == this.tail) {
            return DeleteTail();
        }

        DNode current = this.head;
        while (current.getNext() != node) {
            current = current.getNext();
        }
        // current is the node before the to be deleted node
        current.setNext(node.getNext());
        length--;
        deleteNode.setNext(null);
        return deleteNode;
    }

    public void Sort() {
        if (this.head == null) {
            return;
        }

        DNode sortedList = null;
        DNode current = this.head;

        while(current != null) {
            DNode next = current.getNext();

            if (sortedList == null || current.getData() < sortedList.getData()) {
                current.setNext(sortedList);
                sortedList = current;
            }
            else {
                DNode search = sortedList;
                while (search.getNext() != null && current.getData() > search.getNext().getData()) {
                    // while search.next != null and current data is greater than temporary search node data
                    search = search.getNext();
                }
                current.setNext(search.getNext());
                search.setNext(current);
            }
            current = next;
        }
        this.head = sortedList;
        DNode newTail = this.head;
        while(newTail.getNext() != null) {
            newTail = newTail.getNext();
        }
        this.tail = newTail;
    }


    public void Clear() {
        while (this.head != null) {
            DeleteHead();
        }
    }

    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: "+ isSorted());
        DNode current = this.head;
        if (current == null) {
            System.out.println("Empty List");
        } else {
            int i = 1;
            if (this.length == 1) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                return;
            }
            while (current != this.tail) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                current = current.getNext();
                i++;
            }
            if (this.length != 1) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
            }
        }
        System.out.println();
    }


    public boolean isSorted() {
        DNode current = this.head;
        if (current == null || length == 1) {
            return true;
        }

        while (current != this.tail) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /* Getters */
    public DNode getHead() {
        return this.head;
    }

    public DNode getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

}
