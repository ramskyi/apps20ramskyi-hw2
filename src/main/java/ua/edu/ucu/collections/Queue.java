package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList list;

    public Queue() {
        list = new ImmutableLinkedList(new Object[0]);
    }

    public Object peek() {
        return list.getFirst();
    }

    public Object dequeue() {
        Object first = list.getFirst();
        list = list.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }
}
