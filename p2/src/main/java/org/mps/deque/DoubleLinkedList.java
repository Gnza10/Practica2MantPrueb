package org.mps.deque;

<<<<<<< Updated upstream
import java.util.Comparator;
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
>>>>>>> Stashed changes

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
        return this.size;
    }

<<<<<<< Updated upstream
    @Override
    public boolean contains(T value){
        boolean found = false;
        LinkedNode node = this.first;

        while(!found && node!=null){
            found = node.getItem() == value;
            node = node.getNext();
        }
        
        return found;
    }

    @Override
    public void remove(T value){
        if(first() == value)deleteFirst();

        else if(last() == value) deleteLast();

        else{
            boolean removed = false;
            LinkedNode node = this.first.getNext();

                while(!removed && node!=this.last){
                    if(node.getItem() == value){
                        node.getPrevious().setNext(node.getNext());
                        node.getNext().setPrevious(node.getPrevious());
                        removed = true;
                        size--;
                    }
                    node = node.getNext();
                }
        }
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
=======

    //Second part
    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new DoubleLinkedQueueException("Index out of bounds");
        }
        LinkedNode<T> current = first;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getItem();  
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public void remove(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    //Second part
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size > 1) {
            List<T> list = new ArrayList<>();
            LinkedNode<T> current = first;
            while (current != null) {
                list.add(current.getItem());
                current = current.getNext();
            }

            Collections.sort(list, comparator);

            LinkedNode<T> currentNew = first;
            for (T t : list) {
                currentNew.setItem(t);
                currentNew = currentNew.getNext();
            }
        }
>>>>>>> Stashed changes
    }
}
