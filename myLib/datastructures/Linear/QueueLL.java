package myLib.datastructures.Linear;
// extends SLL
import myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL{
    private int length;
    private SNode head;
    private SNode tail;

    public QueueLL() {
        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    public QueueLL(SNode node) {
        this.head = node;
        this.tail = node;
        length = 1;
    }

    @Override
    public void InsertHead(SNode node) {}

    @Override
    public void InsertTail(SNode node) {}

    @Override
    public void Insert(SNode node, int position) {}

    @Override
    public void SortedInsert(SNode node) {}

    @Override
    public SNode Search(SNode node) {
        return null;
    }

    @Override
    public void DeleteHead() {}

    @Override
    public void DeleteTail() {}

    @Override
    public void Delete(SNode node) {}

    @Override
    public void Sort() {}
    
    @Override
    public void Clear() {
        super.Clear();
    }

    public void Enqueue(SNode node) {
        super.InsertTail(node);
        this.head = super.head;
        this.tail = super.tail;
        this.length = super.length;
    }

    public void Dequeue() {
        super.DeleteHead();
        this.head = super.head;
        this.tail = super.tail;
        this.length = super.length;
    }
    
    public SNode Peek() {
        return this.head;
    }

    public int Seek(SNode node) {
        if (this.head == null) {
            return -1;
        }
        SNode current = this.head;
        int i = 1;
        while (current != null) {
            if (current == node) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public boolean Empty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Print() {
        System.out.println("Queue length: " + this.length);
        SNode current = this.head;
        if (Empty() == true) {
            System.out.println("Empty Queue");
        } else {
            int i = 1;
            System.out.println("Queue Content...");
            System.out.println("------------------------------");
            while (current != null) {
                System.out.println("Index : " + i + " | Data : " + current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("------------------------------");
        }
    }
}