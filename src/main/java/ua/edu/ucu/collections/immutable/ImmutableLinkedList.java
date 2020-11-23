package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {
    private static class Node {
        private final Object value;
        private Node next;

        public Node(Object c) {
            this.value = c;
            this.next = null;
        }

        public Object getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private final Node first;
    private final Node last;
    private final int size;


    public ImmutableLinkedList(Object[] startValues) {
        this.size = startValues.length;

        if (this.size > 0) {
            this.first = new Node(startValues[0]);

            Node prevNode = this.first;
            for (int i = 1; i < startValues.length; i++) {
                prevNode.setNext(new Node(startValues[i]));
                prevNode = prevNode.getNext();
            }
            this.last = prevNode;
        } else {
            this.first = null;
            this.last = null;
        }
    }

    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }

    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        int n = size();
        if (index < 0 || index > n)
            throw new IndexOutOfBoundsException();

        Object[] newArr = new Object[size() + c.length];
        Node currNode = first;
        for (int i = 0; i < index; i++, currNode = currNode.getNext()) {
            newArr[i] = currNode.value;
        }
        System.arraycopy(c, 0, newArr, index, c.length);
        for (int i = index; i < n; i++, currNode = currNode.getNext()) {
            newArr[c.length + i] = currNode.value;
        }
        return new ImmutableLinkedList(newArr);
    }

    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
            Node currNode = first;
        for (int i = 0; i < index; i++, currNode = currNode.getNext()) ;

        return currNode.getValue();
    }

    public ImmutableLinkedList remove(int index) {
        int n = size();
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[n - 1];
        Node currNode = first;
        int skipped = 0;
        for (int i = 0; i < n; i++, currNode = currNode.getNext()) {
            if (i == index) {
                skipped = 1;
                continue;
            }
//            if one element is skipped newArr indices still mustnt be skipped
            newArr[i - skipped] = currNode.getValue();
        }
        return new ImmutableLinkedList(newArr);
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = toArray();
        newArr[index] = e;
        return new ImmutableLinkedList(newArr);
    }

    public int indexOf(Object e) {
        int n = size();
        Node currNode = first;
        for (int i = 0; i < n; i++, currNode = currNode.getNext()) {
            if (currNode.getValue().equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList(new Object[0]);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object[] toArray() {
        int n = size();
        Object[] newArr = new Object[n];
        Node currNode = first;
        for (int i = 0; i < n; i++, currNode = currNode.getNext()) {
            newArr[i] = currNode.getValue();
        }
        return newArr;
    }

    public String toString() {
        int n = size();
        Object[] o = toArray();
        String[] s = new String[size()];
        for (int i = 0; i < n; i++) {
            s[i] = o[i].toString();
        }
        return String.join(",", s);
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }
    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }
    public Object getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return first.getValue();
    }
    public Object getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return last.getValue();
    }
    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }
    public ImmutableLinkedList removeLast() {
        return remove(size() - 1);
    }
}
