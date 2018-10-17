import static org.junit.Assert.*;
import org.junit.Test;

public class TestOperationSequence {
    @Test
    public void testArrayPrintDeque() {
        OperationSequence opSeq = new OperationSequence();
        ArrayDequeOperation ado1 = new ArrayDequeOperation("addFirst", 9);
        opSeq.addLast(ado1);
        ArrayDequeOperation ado2 = new ArrayDequeOperation("removeLast");
        opSeq.addLast(ado2);
        ArrayDequeOperation ado3 = new ArrayDequeOperation("addLast", 70);
        opSeq.addLast(ado3);
        ArrayDequeOperation ado4 = new ArrayDequeOperation("removeFirst");
        opSeq.addLast(ado4);

        String expected = "addFirst(9)\nremoveLast()\naddLast(70)\nremoveFirst()\n";
        assertEquals(expected, opSeq.stringPrintDeque());
    }
}
