package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

// extends DLL
public class CDLL extends DLL {
    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {
        if (super.getHead() != null) {
            super.getHead().setBefore(null);
            super.getTail().setNext(null);
            super.InsertHead(node);
            super.getHead().setBefore(super.getTail());
            super.getTail().setNext(super.getHead());

        } else {
            super.InsertHead(node);
        }
    }

    @Override
    public void InsertTail(DNode node) {
        if (super.getHead() != null) {
            super.getHead().setBefore(null);
            super.getTail().setNext(null);
            super.InsertTail(node);
            super.getHead().setBefore(super.getTail());
            super.getTail().setNext(super.getHead());

        } else {
            super.InsertTail(node);
        }
    }

    @Override
    public void Insert(DNode node, int position) {
        if (super.getHead() != null) {
            super.getHead().setBefore(null);
            super.getTail().setNext(null);
            super.Insert(node, position);
            super.getHead().setBefore(super.getTail());
            super.getTail().setNext(super.getHead());

        } else {
            super.Insert(node, position);
        }
    }

    @Override
    public void SortedInsert(DNode node) {
        if (super.getHead() != null) {
            super.getHead().setBefore(null);
            super.getTail().setNext(null);
            super.SortedInsert(node);
            super.getHead().setBefore(super.getTail());
            super.getTail().setNext(super.getHead());

        } else {
            super.SortedInsert(node);
        }
    }

    @Override
    public DNode Search(DNode node) {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        DNode returnNode = super.Search(node);
        super.getHead().setBefore(super.getTail());
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode DeleteHead() {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        DNode returnNode = super.DeleteHead();
        super.getHead().setBefore(super.getTail());
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode DeleteTail() {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        DNode returnNode = super.DeleteTail();
        super.getHead().setBefore(super.getTail());
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public DNode Delete(DNode node) {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        DNode returnNode = super.Delete(node);
        super.getHead().setBefore(super.getTail());
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public void Sort() {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        super.Sort();
        super.getHead().setBefore(super.getTail());
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

    @Override
    public boolean isSorted() {
        super.getHead().setBefore(null);
        super.getTail().setNext(null);
        boolean returnBool = super.isSorted();
        super.getHead().setBefore(super.getTail());
        super.getTail().setNext(super.getHead());
        return returnBool;
    }
}
