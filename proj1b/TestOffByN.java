import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testEqualChars() {
        CharacterComparator offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));

        CharacterComparator offBy25 = new OffByN(25);
        assertTrue(offBy25.equalChars('a', 'z'));
        assertFalse(offBy25.equalChars('a', 'x'));

        CharacterComparator offBy0 = new OffByN(0);
        assertTrue(offBy0.equalChars('a', 'a'));
        assertFalse(offBy0.equalChars('f', 'h'));

        CharacterComparator offBy1 = new OffByN(1);
        assertTrue(offBy1.equalChars('c', 'b'));
        assertFalse(offBy1.equalChars('f', 'o'));
    }
}
