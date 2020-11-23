package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList list;

    public Stack() {
        list = new ImmutableLinkedList(new Object[0]);
    }

    public Object peek() {
        return list.getLast();
    }

    public Object pop() {
        Object last = list.getLast();
        list = list.removeLast();
        return last;
    }
    void push(Object e) {
        list = list.addLast(e);
    }
}
