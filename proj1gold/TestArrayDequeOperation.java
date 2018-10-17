import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeOperation {
    @Test
    public void testGetOperation() {
        ArrayDequeOperation<String> ado1 = new ArrayDequeOperation("addFirst", 9);
        assertEquals("addFirst(9)", ado1.getOperation());
        assertNotEquals("addFirst(0)", ado1.getOperation());

        ArrayDequeOperation<String> ado2 = new ArrayDequeOperation("removeLast");
        assertEquals("removeLast()", ado2.getOperation());
        assertNotEquals("addFirst(0)", ado2.getOperation());
        assertNotEquals("removeFirst(0)", ado2.getOperation());
        assertNotEquals("removeLast(0)", ado2.getOperation());
    }
}
