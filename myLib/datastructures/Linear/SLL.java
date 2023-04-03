package myLib.datastructures.Linear;
import myLib.datastructures.nodes.SNode;

public class SLL {
    private int length;
    private SNode head;
    private SNode tail;

    public SLL() {
        this.head = null;
        this.tail = null;
    }

    public SLL(SNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void InsertHead(SNode node) {
        node.setNext(this.head);
        this.head = node;
        length++;
    }

    public void InsertTail(SNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            length = 1;
            return;
        } else {
            SNode current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            this.tail = node;
            length++;
        }
    }

    public void Insert(SNode node, int position) {
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
        SNode current = this.head;
        for (int i = 2; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        node.setNext(current.getNext());
        current.setNext(node);
        length++;
    }

    public void SortedInsert(SNode node) {
        if (this.head == null) {
            InsertHead(node);
            return;
        }
        
        // goes through entire linked list, if not sorted then break while loop and call sort
        if (isSorted() ==  false) {
            Sort();
        }

        SNode current;
        current = this.head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        
        node.setNext(current.getNext());
        current.setNext(node);
        length++;
    }

    public SNode Search(SNode node) {
        SNode current = this.head;
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
            this.length--;
            return;
        }
        SNode temp = this.head.getNext();
        this.head = null;
        this.head = temp;
        this.length--;
    }

    public void DeleteTail() {
        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return;
        }
        SNode current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        this.tail = null;
        current.setNext(null);
        this.tail = current;
        this.length--;
    }

    public void Delete(SNode node) {
        SNode deletedNode = Search(node);
        if (deletedNode == null) {
            return;
        }

        if (node == this.head) {
            DeleteHead();
            return;
        }

        if (node == this.head) {
            DeleteTail();
            return;
        }

        SNode current = this.head;
        while (current.getNext() != node) {
            current = current.getNext();
        }
        // current is the node before the to be deleted node
        current.setNext(node.getNext());
        length--;
    }

    public void Sort() {
        if (this.head == null) {
            return;
        }

        SNode sortedList = null;
        SNode current = this.head;

        while(current != null) {
            SNode next = current.getNext();

            if (sortedList == null || current.getData() < sortedList.getData()) {
                current.setNext(sortedList);
                sortedList = current;
            }
            else {
                SNode search = sortedList;
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
    }

    public void Clear() {
        while (this.head != null) {
            DeleteHead();
        }
    }

    public boolean isSorted() {
        SNode current = this.head;
        if (current == null || length == 1) {
            return true;
        }

        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: "+ isSorted());
        SNode current = this.head;
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

    public SNode getHead() {
        return this.head;
    }

    public SNode getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

}
