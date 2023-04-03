package myLib.datastructures.Linear;

import myLib.datastructures.nodes.SNode;

// extends SLL
public class StackLL extends SLL{

    public StackLL() {
        super();
    }

    public StackLL(SNode node) {
        super(node);
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
        return super.Search(node);
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
        while (super.getHead() != null) {
            super.DeleteHead();
        }
    }

    public void Push(SNode node) {
        super.InsertTail(node);
    }

    public void Pop() {
        super.DeleteTail();
    }

    public SNode Peek() {
        return super.getTail();
    }

    public int Seek(SNode node) {
        if (super.getHead() == null) {
            return -1;
        }
        SNode current = super.getHead();
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
        if (super.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Print() {
        System.out.println("Stack length: " + super.getLength());
        SNode current = super.getHead();
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
