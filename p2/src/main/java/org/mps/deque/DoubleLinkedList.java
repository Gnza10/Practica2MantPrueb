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
        // TODO
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
        // TODO
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
        return null;
    }

    @Override
    public T last() {
        if(last == null) throw new DoubleLinkedQueueException("The queue is empty");
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
