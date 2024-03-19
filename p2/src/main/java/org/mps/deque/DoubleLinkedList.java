package org.mps.deque;

import org.w3c.dom.Node;

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
        // TODO
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
        // TODO
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
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return this.size;
    }
}
