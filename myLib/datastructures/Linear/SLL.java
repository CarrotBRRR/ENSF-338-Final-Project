package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

/**
 * A Singly Linked List (SLL) implementation that stores nodes of type DNode.
 * Nodes can be inserted at the head, tail, or at a specific position in the SLL.
 * Nodes can also be sorted in ascending order based on their data.
 * Nodes can be searched, deleted from the SLL, and the SLL can be sorted.
 * 
 * @author Nathan Ante
 * @version 1.0
 */

public class SLL {
    private int length;         // The length of the SLL
    private DNode head;         // The head (first node) of the SLL
    private DNode tail;         // The tail (last node) of the SLL


    /**
     * Constructs an empty SLL with a null head, tail, and length of 0.
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructs a SLL with the given node as both the head and the tail, and a length of 1.
     *
     * @param node The node to be set as both the head and the tail of the SLL.
     */
    public SLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    /**
     * Constructs a SLL with the given int after it creates a new node and sets it to both the head and the tail, and a sets a length of 1.
     *
     * @param node The node to be set as both the head and the tail of the SLL.
     */
    public SLL(int num) {
        DNode node = new DNode(num);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    /**
     * Inserts the given node at the head of the SLL.
     *
     * @param node The node to be inserted at the head of the SLL.
     */
    public void InsertHead(DNode node) {
        if (node == null || this.Search(node) == node) {
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

    /**
     * Inserts the given node at the tail of the SLL.
     *
     * @param node The node to be inserted at the tail of the SLL.
     */
    public void InsertTail(DNode node) {
        if (node == null || this.Search(node) == node) {
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

    /**
     * Inserts the given node at the specified position in the SLL.
     *
     * @param node     The node to be inserted in the SLL.
     * @param position The position at which the node should be inserted.
     */
    public void Insert(DNode node, int position) {
        if (node == null || this.Search(node) == node) {
            return;
        }

        if (position > length+1) {
            System.out.println("Position out of bounds");
            return;
            // position out of list bounds
        }
        if (position == 1) {
            // essentially setting a new head
            this.InsertHead(node);
            return;
        }
        if (position == (length + 1)) {
            // essentially setting a new tail
            this.InsertTail(node);
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

    /**
     * Inserts the given node at the sorted position in ascending order in the SLL.
     * Sorts the list first if it wasnt already.
     *
     * @param node     The node to be inserted in the SLL.
     * 
     */
    public void SortedInsert(DNode node) {
        if (node == null || this.Search(node) == node) {
            return;
        }
        
        if (this.head == null) {
            this.InsertHead(node);
            return;
        }
        
        // goes through entire linked list, if not sorted then break while loop and call sort
        if (this.isSorted() ==  false) {
            this.Sort();
        }

        if (this.head.getData() > node.getData()) {
            this.InsertHead(node);
            return;
        }

        if (this.tail.getData() < node.getData()) {
            this.InsertTail(node);
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
            this.length--;
            return returnHead;
        }

        DNode temp = this.head.getNext();
        this.head.setNext(null);
        this.head = temp;
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
        this.tail = null;
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
            return this.DeleteHead();
        }

        if (node == this.tail) {
            return this.DeleteTail();
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
    
    /**
     * Sorts the list in ascending order based on the data value of the node.
     */
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

    /**
     * Clears the list, deletes every node.
     */
    public void Clear() {
        while (this.head != null) {
            this.DeleteHead();
        }
    }

    /**
     * Prints the contents of the list.
     */
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

    /* Getters */

    /**
     * Returns head node of list
     * @return The head node
     */
    public DNode getHead() {
        return this.head;
    }

    /**
     * Returns tail node of list
     * @return The tail node
     */
    public DNode getTail() {
        return this.tail;
    }

    /**
     * Returns length of list
     * @return The list length
     */
    public int getLength() {
        return this.length;
    }

}
