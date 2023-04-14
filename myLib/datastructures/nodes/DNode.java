package myLib.datastructures.nodes;

/**
 * The double node class.
 * <p>
 * This node class is used by all data stuctures.
 * </p>
 * <p>
 * This class creates objects that contains a data variable as an int, a before DNode object as well as a next DNode object.
 * </p>
 * @author Nathan Ante
 * @version 1.0.0
 */

public class DNode {
    private int data;       // Data stored in the node
    private DNode next;     // Reference to the next node
    private DNode before;   // Reference to the previous node

    /**
     * Constructs a new DNode with null next and before references.
     */
    public DNode() {
        this.next = null;
        this.before = null;
    }
    
    /**
     * Constructs a new DNode with the specified data and null next and before references.
     *
     * @param data the data to be stored in the node
     */
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.before = null;
    }

    /**
     * Sets the data of the node.
     *
     * @param data the data to be set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Sets the next node reference.
     *
     * @param next the next node to be set
     */
    public void setNext(DNode next) {
        this.next = next;
    }

    /**
     * Sets the previous node reference.
     *
     * @param before the previous node to be set
     */
    public void setBefore(DNode before) {
        this.before = before;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node
     */
    public int getData() {
        return data;
    }

    /**
     * Returns the reference to the next node.
     *
     * @return the reference to the next node
     */
    public DNode getNext() {
        return next;
    }

    /**
     * Returns the reference to the previous node.
     *
     * @return the reference to the previous node
     */
    public DNode getBefore() {
        return before;
    }
}
