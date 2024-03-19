package org.mps.deque;


public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if(first == null) {
            first = new LinkedNode<>(value, null, null);
            last = first;
            ++size;
        } else {
            LinkedNode<T> newNode = new LinkedNode<>(value, null, first);
            first.setPrevious(newNode);
            first = newNode;
            ++size;
        }
    }

    @Override
    public void append(T value) {
        if(last == null){
            last = new LinkedNode<T>(value, null, null);
            first = last;
        }
        else{
            LinkedNode<T> newlast = new LinkedNode<T>(value, last, null);
            last.setNext(newlast);
            last = newlast;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(first == null){
            throw new DoubleLinkedQueueException("The deque is empty");
        }
        if(first == last){
            first = null;
            last = null;
            size = 0;
        } else {
            first = first.getNext();
            first.setPrevious(null);
            --size;
        }
    }

    @Override
    public void deleteLast() {
        if(last == null){
            throw new DoubleLinkedQueueException("The queue is empty");
        }
        else if(last == first) {
            last = null;
            first = null;
        }
        else{
            LinkedNode<T> newLast = last.getPrevious();
            newLast.setNext(null);
            last = newLast;
        }
        size--;
    }

    @Override
    public T first() {
        // TODO
        if(first == null){
            throw new DoubleLinkedQueueException("The deque is empty");
        }
        return first.getItem();
    }

    @Override
    public T last() {
        if(last == null) throw new DoubleLinkedQueueException("The queue is empty");
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return this.size;
    }
}
