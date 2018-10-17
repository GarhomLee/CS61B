import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testRemoveLast() {
        /* removeLast() in StudentArrayDeque is the method with bug */
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        OperationSequence opSeq = new OperationSequence();
        ArrayDequeOperation ado;
        for (int i = 0; i < 10; i += 1) {
            sad.addLast(i);
            ads.addLast(i);
            ado = new ArrayDequeOperation("addLast", i);
            opSeq.addLast(ado);
        }

        for (int i = 0; i < 5; i += 1) {
            Integer expected = ads.removeLast();
            Integer actual = sad.removeLast();
            ado = new ArrayDequeOperation("removeLast");
            opSeq.addLast(ado);
            //assertEquals(expected, actual);
            String opSeqOutput = opSeq.stringPrintDeque(); //something goes wrong when use .toString()
            assertEquals("\n" + opSeqOutput, expected, actual);
        }

    }

    @Test
    public void testSize() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        assertEquals(0, sad1.size());
        for (int i = 0; i < 100; i += 1) {
            sad1.addFirst(i);
        }
        assertEquals(100, sad1.size());
    }
}
