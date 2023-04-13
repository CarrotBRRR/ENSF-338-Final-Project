package myLib.datastructures.Linear;
import myLib.datastructures.nodes.DNode;

// extends SLL
public class CSLL extends SLL{

    public CSLL() {
        super();
    }

    public CSLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertHead(node);
        super.getTail().setNext(super.getHead());

        
    }

    @Override
    public void InsertTail(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.InsertTail(node);
        super.getTail().setNext(super.getHead());

    }

    @Override
    public void Insert(DNode node, int position) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.Insert(node, position);
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void SortedInsert(DNode node) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
        }
        super.SortedInsert(node);
        super.getTail().setNext(super.getHead());
    }

    @Override
    public DNode Search(DNode node) {
        return super.Search(node);
    }

    @Override
    public DNode DeleteHead() {
        if (super.getHead() == null) {
            return null;
        }

        super.getTail().setNext(null);

        if (super.getLength() == 1) {
            return super.DeleteHead();
        }

        DNode returnNode = super.DeleteHead();
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode DeleteTail() {
        if (super.getHead() == null) {
            return null;
        }

        super.getTail().setNext(null);

        if (super.getLength() == 1) {
            return super.DeleteTail();
        }

        DNode returnNode = super.DeleteTail();
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode Delete(DNode node) {
        DNode deleteNode = super.Search(node);
        if (deleteNode == null) {
            return null;
        }

        if (node == super.getHead() ) {
            return DeleteHead();
        }

        if (node == super.getTail()) {
            return DeleteTail();
        }
        
        super.getTail().setNext(null);
        DNode returnNode = super.Delete(node); 
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public void Sort() {
        super.getTail().setNext(null);
        super.Sort();
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void Print() {
        super.Print();
    }

    @Override
    public DNode getHead() {
        return super.getHead();
    }

    @Override
    public DNode getTail() {
        return super.getTail();
    }

    @Override
    public int getLength() {
        return super.getLength();
    }
}
