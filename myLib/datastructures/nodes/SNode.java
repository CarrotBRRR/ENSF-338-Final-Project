package myLib.datastructures.nodes;
//optional
public class SNode {
    private int data;
    private SNode next;

    public SNode() {
        this.data = 0;
        this.next = null;
    }

    public SNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public SNode getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}
