package myLib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode next;
    private DNode before;

    public DNode() {
        this.next = null;
        this.before = null;
    }

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.before = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setBefore(DNode before) {
        this.before = before;
    }

    public int getData() {
        return data;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getBefore() {
        return before;
    }


}
