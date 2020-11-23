package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList arrList;

    @Before
    public void init() {
        arrList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAdd() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {1, 2, 3, 4, 5, 6});
        ImmutableArrayList actual = arrList.add(6);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testAddWithIndex() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {1, 2, 3, 6, 4, 5});
        ImmutableArrayList actual = arrList.add(3, 6);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddWithIndexOutOfBound() {
        arrList.add(-1, 6);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        ImmutableArrayList actual = arrList.addAll(new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {6, 7, 8, 9, 1, 2, 3, 4, 5});
        ImmutableArrayList actual = arrList.addAll(0, new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testMultiAddWithIndexOutOfBound() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {6, 7, 8, 9, 1, 2, 3, 4, 5});
        ImmutableArrayList actual = arrList.add(6, new Object[] {6, 7, 8, 9});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testGet() {
        Object expected = 4;
        Object actual = arrList.get(3);
        assertEquals(expected, actual);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetOutOfBound() {
        arrList.get(5);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {1, 2, 3, 4});
        ImmutableArrayList actual = arrList.remove(4);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveOutOfBound() {
        arrList.remove(50);
    }

    @Test
    public void testSet() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {1, 2, -1, 4, 5});
        ImmutableArrayList actual = arrList.set(2, -1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetOutOfBound() {
        arrList.set(-6, "vshystko yedno");
    }

    @Test
    public void testIndexOf() {
        Object expected = 4;
        Object actual = arrList.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOfNotFound() {
        Object expected = -1;
        Object actual = arrList.indexOf(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        Object expected = 5;
        Object actual = arrList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableArrayList expected = new ImmutableArrayList(new Object[] {});
        ImmutableArrayList actual = arrList.clear();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        ImmutableArrayList emptyOne = new ImmutableArrayList(new Object[0]);
        boolean actual = emptyOne.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        boolean actual = arrList.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void testToArray() {
        Object[] expected = new Object[] {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arrList.toArray());
    }

    @Test
    public void testToString() {
        String expected = "1,2,3,4,5";
        String actual = arrList.toString();
        assertEquals(expected, actual);
    }
}
