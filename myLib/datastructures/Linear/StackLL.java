package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

// extends SLL
public class StackLL extends SLL{

    public StackLL() {
        super();
    }

    public StackLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {}

    @Override
    public void InsertTail(DNode node) {}

    @Override
    public void Insert(DNode node, int position) {}

    @Override
    public void SortedInsert(DNode node) {}

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public DNode DeleteHead() {return null;}

    @Override
    public DNode DeleteTail() {return null;}

    @Override
    public DNode Delete(DNode node) {return null;}

    @Override
    public void Sort() {}
    
    @Override
    public void Clear() {
        while (super.getHead() != null) {
            super.DeleteTail();
        }
    }

    public void Push(DNode node) {
        super.InsertTail(node);
    }

    public int Pop() {
        if (super.getLength() == 0) {
            return 0;
        }
        return super.DeleteTail().getData();
    }

    public DNode Peek() {
        return super.getTail();
    }

    public int Seek(DNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        DNode current = super.getHead();
        int i = 1;
        while (current != null) {
            if (current == node) {
                return super.getLength() - i + 1;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public boolean Empty() {
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Print() {
        System.out.println("Stack length: " + super.getLength());
        DNode current = super.getHead();
        if (Empty() == true) {
            System.out.println("Empty Queue");
        } else {
            int i = 1;
            System.out.println("Stack Content...");
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
