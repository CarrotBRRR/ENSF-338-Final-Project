package myLib.datastructures.Linear;
import myLib.datastructures.nodes.DNode;

/**
 * A Doubly Linked List (DLL) implementation that stores nodes of type DNode.
 * Nodes can be inserted at the head, tail, or at a specific position in the DLL.
 * Nodes can also be sorted in ascending order based on their data.
 * Nodes can be searched, deleted from the DLL, and the DLL can be sorted.
 * 
 * @author Nathan Ante
 * @version 1.0
 */

public class DLL{
    private int length;     // The length of the DLL
    private DNode head;     // The head (first node) of the DLL
    private DNode tail;     // The tail (last node) of the DLL

    /**
     * Constructs an empty DLL with a null head, tail, and length of 0.
     */
    public DLL() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructs a DLL with the given node as both the head and the tail, and a length of 1.
     *
     * @param node The node to be set as both the head and the tail of the DLL.
     */
    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    
    /**
     * Inserts the given node at the head of the DLL.
     *
     * @param node The node to be inserted at the head of the DLL.
     */
    public void InsertHead(DNode node) {
        // If the given node is null or already exists in the DLL, return
        if (node == null || Search(node) == node) {
            return;
        }

        // If the DLL is empty, set the head, tail, and length to the given node
        if(this.length == 0) {
            this.head = node;
            this.tail = node;
            this.length = 1;
            return;
        }

        // Set the next node of the given node to the current head
        // Set the before node of the current head to the given node
        // Set the head to the given node
        node.setNext(this.head);
        this.head.setBefore(node);
        this.head = node;
        length++;
    }

    /**
     * Inserts the given node at the tail of the DLL.
     *
     * @param node The node to be inserted at the tail of the DLL.
     */
    public void InsertTail(DNode node) {
        // If the given node is null or already exists in the DLL, return
        if (node == null || Search(node) == node) {
            return;
        }

        // If the DLL is empty, set the head, tail, and length to the given node
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        } else {
            // Find the current tail node and set its next node to the given node
            // Set the before node of the given node to the current tail
            // Set the tail to the given node
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

    /**
     * Inserts the given node at the specified position in the DLL.
     *
     * @param node     The node to be inserted in the DLL.
     * @param position The position at which the node should be inserted.
     */
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

    /**
     * Inserts the given node at the sorted position in ascending order in the DLL.
     * Sorts the list first if it wasnt already.
     *
     * @param node     The node to be inserted in the DLL.
     * 
     */
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

    /**
     * Searches the node within the list
     * @param node  The node to be searched
     * @return The node if it is within the list, else it returns null
     */
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

    /**
     * Deletes the head node of the list
     * 
     * @return The deleted node if the list is not empty, else it returns null
     */
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

    /**
     * Deletes the tail node of the list.
     * 
     * @return The deleted node if the list is not empty, else it returns null.
     */
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

    /**
     * Deletes the node that was specified.
     * @param node  The node to be deleted
     * @return The deleted node if it exists in the list, else it returns null.
     */
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


    /**
     * Sorts the list in ascending order based on the data value of the node.
     */
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


    /**
     * Clears the list, deletes every node.
     */
    public void Clear() {
        while (this.head != null) {
            DeleteHead();
        }
    }


    /**
     * Prints the contents of the list.
     */
    public void Print() {
        System.out.println("List length: " + this.length);
        System.out.println("Sort status: " + isSorted());
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

    /**
     * Swaps the position of two given nodes
     * @param node1     First node to be swapped
     * @param node2     Second node to be swapped
     */
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

    /**
     * Checks if list is sorted or not
     * @return Returns true if list is sorted by ascending order of data, else returns false
     */
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


    /**
     * Returns tail node of list
     * @return The tail node
     */
    public DNode getTail() {
        return this.tail;
    }

    /**
     * Returns head node of list
     * @return The head node
     */
    public DNode getHead() {
        return this.head;
    }

    /**
     * Returns length of list
     * @return The list length
     */
    public int getLength() {
        return this.length;
    }
}
