package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue queue;

    @Before
    public void init() {
        queue = new Queue();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void testPeek() {
        Object expected = 1;
        Object actual = queue.peek();
        assertEquals(expected, actual);
    }

    // I would test peek after enqueue here but it is already tested in testPeek()


    @Test
    public void testDequeue() {
        Object expected = 1;


        Object actual = queue.dequeue();
        assertEquals(expected, actual);
    }

    @Test
    public void testPeekAfterDequeue() {
        Object expected = 2;

        queue.dequeue();
        Object actual = queue.peek();
        assertEquals(expected, actual);
    }
}
