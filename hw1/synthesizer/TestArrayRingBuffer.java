package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testFillCount() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        assertEquals(0, arb.fillCount());
        arb.enqueue(9);
        arb.enqueue(8);
        assertEquals(2, arb.fillCount());
    }

    @Test
    public void testCapacity() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        assertEquals(4, arb.capacity());
        assertNotEquals(0, arb.capacity());
    }

    @Test
    public void testIsEmpty() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        assertTrue(arb.isEmpty());
    }

    @Test
    public void testEnqueue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(9);
        arb.enqueue(8);
        arb.enqueue(6);
        assertFalse(arb.isEmpty());
        assertEquals(3, arb.fillCount());
    }

    @Test
    public void testIsFull() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(2);
        assertTrue(arb.isEmpty());
        arb.enqueue(9);
        arb.enqueue(6);
        //arb.enqueue(6); // throw runtime exception
        assertFalse(arb.isEmpty());
        assertTrue(arb.isFull());
    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        //arb.dequeue(); // throw runtime exception
        arb.enqueue(9);
        arb.enqueue(8);
        arb.enqueue(6);
        Integer item1 = arb.dequeue();
        Integer item2 = arb.dequeue();
        assertEquals((Integer)9, item1);
        assertEquals((Integer)8, item2);
        assertEquals(1, arb.fillCount());
        Integer item3 = arb.dequeue();
        assertEquals((Integer)6, item3);
        assertEquals(0, arb.fillCount());
        assertTrue(arb.isEmpty());
    }

    @Test
    public void testPeek() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        arb.enqueue(9);
        arb.enqueue(8);
        assertEquals((Integer)9, arb.peek());
        arb.dequeue();
        assertEquals((Integer)8, arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
