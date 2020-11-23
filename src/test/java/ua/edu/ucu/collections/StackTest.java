package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    Stack stack;

    @Before
    public void init() {
        stack = new Stack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testPeek() {
        Object expected = 5;
        Object actual = stack.peek();
        assertEquals(expected, actual);
    }

    // I would test peek after push here but it is already tested in testPeek()

    @Test
    public void testPop() {
        Object expected = 5;


        Object actual = stack.pop();
        assertEquals(expected, actual);
    }

    @Test
    public void testPeekAfterPop() {
        Object expected = 4;

        stack.pop();
        Object actual = stack.peek();
        assertEquals(expected, actual);
    }
}
