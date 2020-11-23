package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] list;

    public ImmutableArrayList(Object[] startValues) {
        this.list = startValues.clone();
    }

    public ImmutableArrayList add(Object e) {
        return add(size(), e);
    }

    public ImmutableArrayList add(int index, Object e) {
        Object[] newList = new Object[size() + 1];
        System.arraycopy(this.list, 0, newList, 0, index);
        newList[index] = e;
        System.arraycopy(this.list, index, newList, index + 1, size() - index);
        return new ImmutableArrayList(newList);
    }

    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size(), c);
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        Object[] newList = new Object[size() + c.length];
        System.arraycopy(this.list, 0, newList, 0, index);
        System.arraycopy(c, 0, newList, index, c.length);
        System.arraycopy(this.list, index, newList, index + c.length,
                size() - index);
        return new ImmutableArrayList(newList);
    }

    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.list[index];
    }

    public ImmutableArrayList remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[size() - 1];
        System.arraycopy(this.list, 0, newList, 0, index);
        System.arraycopy(this.list, index + 1, newList, index,
                size() - index - 1);
        return new ImmutableArrayList(newList);
    }

    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("heh");
        }
        Object[] newArr = this.list.clone();
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    public int indexOf(Object e) {
        int n = size();
        for (int i = 0; i < n; i++) {
            if (this.list[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.list.length;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object[] toArray() {
        return this.list;
    }

    public String toString() {
        int n = size();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = this.list[i].toString();
        }
        return String.join(",", s);
    }
}
