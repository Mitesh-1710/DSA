/**
 * Problem:
 * Given a string {@code word} and a character {@code ch}, reverse the
 * <b>prefix</b> of {@code word} that ends at the <b>first occurrence</b>
 * of {@code ch}.
 *
 * <p>The prefix includes the character {@code ch} itself.</p>
 *
 * <p>If {@code ch} does not exist in {@code word}, return the original
 * string unchanged.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2000: Reverse Prefix of Word</b></p>
 * <p>🔗 https://leetcode.com/problems/reverse-prefix-of-word/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task only requires reversing a portion of the string, not the
 * entire string.</p>
 *
 * <p>Key observations:</p>
 * <ul>
 *   <li>Only the prefix up to the <b>first occurrence</b> of {@code ch}
 *       needs to be reversed.</li>
 *   <li>If {@code ch} is not present, no operation is needed.</li>
 * </ul>
 *
 * <p>A straightforward approach would be:</p>
 * <ul>
 *   <li>Find the index of {@code ch}.</li>
 *   <li>Reverse characters from index {@code 0} to that index.</li>
 * </ul>
 *
 * <p>This can be done efficiently using a two-pointer technique.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Two-Pointer Reversal Concept:</b>
 *
 * <p>Once the index of {@code ch} is known:</p>
 *
 * <ul>
 *   <li>Initialize one pointer at the start of the string.</li>
 *   <li>Initialize another pointer at the index of {@code ch}.</li>
 *   <li>Swap characters while moving both pointers toward the center.</li>
 * </ul>
 *
 * <p>This reverses the prefix in-place with constant extra space.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Find the first index {@code j} of {@code ch} using
 *       {@code indexOf}.</li>
 *   <li>If {@code j == -1}, return {@code word} as-is.</li>
 *   <li>Convert the string to a character array.</li>
 *   <li>Reverse characters from index {@code 0} to {@code j}
 *       using two pointers.</li>
 *   <li>Convert the array back to a string and return it.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * word = "abcdefd"
 * ch   = 'd'
 *
 * First occurrence of 'd' → index 3
 *
 * Prefix to reverse: "abcd"
 * Reversed prefix:   "dcba"
 *
 * Result:
 *   "dcbaefd"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Only a single pass over the prefix.</li>
 *   <li>No unnecessary string slicing.</li>
 *   <li>In-place reversal using constant extra space.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of {@code word}.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — character array used for in-place reversal.
 * -----------------------------------------------------------------------
 */
public class LeetCode2000_ReversePrefixOfWord {

    public static void main(String[] args) {

        String word = "abcdefd";
        char ch = 'd';

        String result = reversePrefix(word, ch);

        System.out.println("Result: " + result);
    }

    /**
     * Reverses the prefix of {@code word} ending at the first
     * occurrence of {@code ch}.
     *
     * @param word input string
     * @param ch   target character
     * @return string with reversed prefix
     */
    public static String reversePrefix(String word, char ch) {

        int j = word.indexOf(ch);
        if (j < 0) {
            return word;
        }

        char[] a = word.toCharArray();

        for (int i = 0; i < j; i++, j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        return new String(a);
    }
}