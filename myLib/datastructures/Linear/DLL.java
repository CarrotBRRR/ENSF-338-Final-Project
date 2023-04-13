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
        if (node == null || Search(node) == node) {
            return;
        }

        if(this.length == 0) {
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
        if (node == null || Search(node) == node) {
            return;
        }

        if (this.length == 0) {
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
        if (node == null || Search(node) == node) {
            return;
        }

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
        if (node == null || Search(node) == node) {
            return;
        }

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
        int i = 0;
        while (i < this.length) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
            i++;
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
            length--;
            return returnHead;
        }

        // temp is new head
        DNode temp = this.head.getNext();
        this.head.setNext(null);
        this.head = temp;
        this.head.setBefore(null);
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
        this.tail.setBefore(null);;
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

        // current is the node before the to-be-deleted node
        current.setNext(node.getNext());
        node.getNext().setBefore(current);
        this.length--;

        deleteNode.setNext(null);
        deleteNode.setBefore(null);
        return deleteNode;
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


    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: " + isSorted());
        DNode current = this.head;
        if (current == null) {
            System.out.println("Empty List");
        } else {
            int i = 1;
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

    private boolean isSorted() {
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

    /* getters */
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
