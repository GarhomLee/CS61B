public class Palindrome {
    /* given a word, turn it into a ArrayDeque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> characterDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            char c = word.charAt(i);
            characterDeque.addLast(c);
        }
        return characterDeque;
    }

    /* a helper method for isPalindrome(String word) */
    private boolean isPalindrome(Deque<Character> characterDeque) {
        // base case
        if (characterDeque.size() == 0 | characterDeque.size() == 1) {
            return true;
        }
        // recursion
        char firstChar = characterDeque.removeFirst();
        char lastChar = characterDeque.removeLast();
        // characterDeque has been changed after "remove" method
        if (firstChar == lastChar) {
            return isPalindrome(characterDeque);
        } else {
            return false;
        }
    }

    /* see if a given word is palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque);
    }

    /* a helper method for isPalindrome(String word, CharacterComparator cc) */
    private boolean isPalindrome(Deque<Character> characterDeque, CharacterComparator cc) {
        // base case
        if (characterDeque.size() == 0 | characterDeque.size() == 1) {
            return true;
        }
        // recursion
        char firstChar = characterDeque.removeFirst();
        char lastChar = characterDeque.removeLast();
        // characterDeque has been changed after "remove" method
        if (cc.equalChars(firstChar, lastChar)) {
            return isPalindrome(characterDeque, cc);
        } else {
            return false;
        }
    }

    /* overload */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque, cc);
    }
}
