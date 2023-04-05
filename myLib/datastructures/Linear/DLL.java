package myLib.datastructures.Linear;
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
            this.length++;
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
            // next is to specify which node to try and sort next
            DNode next = current.getNext();
            //while prev.data > current.data, then make prev into current
            while(current.getBefore() != null && current.getBefore().getData() > current.getData()){
                // swapNodes is just to swap two nodes with each other
                swapNodes(current.getBefore(), current);
            }
            current = next;
        }
    }

    public void Clear() {
        while (this.head != null) {
            DeleteHead();
        }
    }

    public boolean isSorted() {
        if (this.head == null || this.head.getNext() == null) {
            return true;
        }
        DNode current = this.head.getNext();
        while (current != null) {
            if (current.getBefore().getData() > current.getData() ) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: " + isSorted());
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

    private void swapNodes(DNode node1, DNode node2) {
        DNode tempPrev = node1.getBefore();
        DNode tempNext = node2.getNext();

        if (tempPrev != null) {
            tempPrev.setNext(node2);
        } else {
            head = node2;
        }

        if (tempNext != null) {
            tempNext.setBefore(node1);
        } else {
            tail = node1;
        }

        node1.setNext(tempNext);
        node2.setBefore(tempPrev);

        node2.setNext(node1);
        node1.setBefore(node2);
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
