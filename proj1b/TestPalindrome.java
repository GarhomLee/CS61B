import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator obo = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("dog"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("r"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("madam"));
        assertFalse(palindrome.isPalindrome("palindrome"));

        assertFalse(palindrome.isPalindrome("palindrome", obo));
        assertFalse(palindrome.isPalindrome("madam", obo));
        assertFalse(palindrome.isPalindrome("mazan", obo));
        assertTrue(palindrome.isPalindrome("r", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("cab", obo));
    }
}
