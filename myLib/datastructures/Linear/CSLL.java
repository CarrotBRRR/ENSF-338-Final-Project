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
        if(super.getHead() != null) {
            super.getTail().setNext(null);
            super.InsertHead(node);
            super.getTail().setNext(super.getHead());
        } else {
            super.InsertHead(node);
        }
        
    }

    @Override
    public void InsertTail(DNode node) {
        if (super.getHead() != null) {
            super.getTail().setNext(null);
            super.InsertTail(node);
            super.getTail().setNext(super.getHead());
        } else {
            super.InsertTail(node);
        }
    }

    @Override
    public void Insert(DNode node, int position) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
            super.Insert(node, position);
            super.getTail().setNext(super.getHead());
        } else {
            super.Insert(node, position);
        }
    }

    @Override
    public void SortedInsert(DNode node) {
        if(super.getHead() != null) {
            super.getTail().setNext(null);
            super.SortedInsert(node);
            super.getTail().setNext(super.getHead());
        } else {
            super.SortedInsert(node);
        }
    }

    @Override
    public DNode Search(DNode node) {
        super.getTail().setNext(null);
        DNode returnNode = super.Search(node);
        super.getTail().setNext(super.getHead());
        return returnNode;
    }

    @Override
    public void DeleteHead() {
        super.getTail().setNext(null);
        super.DeleteHead();
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void DeleteTail() {
        super.getTail().setNext(null);
        super.DeleteTail();
        super.getTail().setNext(super.getHead());
    }

    @Override
    public void Delete(DNode node) {
        super.getTail().setNext(null);
        super.Delete(node);
        super.getTail().setNext(super.getHead());
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

    @Override
    public void setTail(DNode node) {
    }

    @Override
    public void setHead(DNode node) {
    }


}
