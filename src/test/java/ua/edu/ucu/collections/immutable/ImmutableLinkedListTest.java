package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList list;

    @Before
    public void init() {
        list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5, 6});
        ImmutableLinkedList actual = list.add(6);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testAddWithIndex() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, 3, 6, 4, 5});
        ImmutableLinkedList actual = list.add(3, 6);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddWithIndexOutOfBound() {
        list.add(-1, 6);
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        ImmutableLinkedList actual = list.addAll(new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {6, 7, 8, 9, 1, 2, 3, 4, 5});
        ImmutableLinkedList actual = list.addAll(0, new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testMultiAddWithIndexOutOfBound() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {6, 7, 8, 9, 1, 2, 3, 4, 5});
        ImmutableLinkedList actual = list.add(6, new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testGet() {
        Object expected = 4;
        Object actual = list.get(3);
        assertEquals(expected, actual);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetOutOfBound() {
        list.get(5);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 3, 4, 5});
        ImmutableLinkedList actual = list.remove(1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveOutOfBound() {
        list.remove(50);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, -1, 4, 5});
        ImmutableLinkedList actual = list.set(2, -1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetOutOfBound() {
        list.set(-6, "vshystko yedno");
    }

    @Test
    public void testIndexOf() {
        Object expected = 4;
        Object actual = list.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOfNotFound() {
        Object expected = -1;
        Object actual = list.indexOf(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        Object expected = 5;
        Object actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {});
        ImmutableLinkedList actual = list.clear();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        ImmutableLinkedList emptyOne = new ImmutableLinkedList(new Object[0]);
        boolean actual = emptyOne.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        boolean actual = list.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void testToArray() {
        Object[] expected = new Object[] {1, 2, 3, 4, 5};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testToString() {
        String expected = "1,2,3,4,5";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5});
        ImmutableLinkedList actual = list.addFirst(0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5, 6});
        ImmutableLinkedList actual = list.addLast(6);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testGetFirst() {
        Object expected = 1;
        Object actual = list.getFirst();
        assertEquals(expected, actual);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetFirstOutOfBound() {
        ImmutableLinkedList emptyOne = new ImmutableLinkedList(new Object[0]);
        emptyOne.getFirst();
    }

    @Test
    public void testGetLast() {
        Object expected = 5;
        Object actual = list.getLast();
        assertEquals(expected, actual);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetLastOutOfBound() {
        ImmutableLinkedList emptyOne = new ImmutableLinkedList(new Object[0]);
        emptyOne.getLast();
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {2, 3, 4, 5});
        ImmutableLinkedList actual = list.removeFirst();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveFirstOutOfBound() {
        ImmutableLinkedList emptyOne = new ImmutableLinkedList(new Object[0]);
        emptyOne.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[] {1, 2, 3, 4});
        ImmutableLinkedList actual = list.removeLast();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveLastOutOfBound() {
        ImmutableLinkedList emptyOne = new ImmutableLinkedList(new Object[0]);
        emptyOne.removeLast();
    }
}
