package myLib.datastructures.Linear;
// extends SLL

import myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL{
    private SLL queue;

    public QueueLL() {
        this.queue = new SLL();
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
        this.queue.Clear();
    }

    public void Enqueue(SNode node) {
        this.queue.InsertTail(node);
    }

    public void Dequeue() {
        this.queue.DeleteHead();
    }
}
