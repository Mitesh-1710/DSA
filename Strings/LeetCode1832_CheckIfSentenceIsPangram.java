/**
 * Problem:
 * A sentence is called a <b>Pangram</b> if it contains every letter
 * of the English alphabet at least once.
 *
 * <p>Given a string {@code sentence} consisting of lowercase English letters,
 * return {@code true} if the sentence is a pangram, otherwise return {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1832:
 * Check if the Sentence Is Pangram</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-the-sentence-is-pangram/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The goal is to determine whether all 26 alphabet letters appear
 * in the sentence.
 *
 * Naive Approach:
 * <ul>
 *   <li>For every letter from 'a' to 'z', check if it exists
 *       in the string.</li>
 * </ul>
 *
 * Although acceptable, it repeatedly scans the string.
 *
 * Optimized Boolean Array Approach:
 * <ul>
 *   <li>Use a boolean array of size 26.</li>
 *   <li>Mark characters as they appear.</li>
 * </ul>
 *
 * Further Optimized Bitmask Approach:
 * <ul>
 *   <li>Use a single integer where each bit represents a letter.</li>
 *   <li>Set the corresponding bit when a letter appears.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Bitmask Concept (Detailed Explanation):</b>
 *
 * Since there are 26 lowercase letters, we can represent them
 * using 26 bits of an integer.
 *
 * Mapping:
 *
 * <pre>
 * bit 0  → 'a'
 * bit 1  → 'b'
 * ...
 * bit 25 → 'z'
 * </pre>
 *
 * To mark a letter as seen:
 *
 * <pre>
 * mask |= 1 << (c - 'a')
 * </pre>
 *
 * Explanation:
 * <ul>
 *   <li>{@code (c - 'a')} gives position of letter.</li>
 *   <li>{@code 1 << position} creates a bitmask for that letter.</li>
 *   <li>Bitwise OR stores it in the mask.</li>
 * </ul>
 *
 * When all 26 bits are set:
 *
 * <pre>
 * mask == (1 << 26) - 1
 * </pre>
 *
 * Because:
 *
 * <pre>
 * (1 << 26) - 1
 * =
 * 11111111111111111111111111  (26 ones)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize mask = 0.</li>
 *   <li>Traverse each character in the sentence.</li>
 *   <li>Set the corresponding bit.</li>
 *   <li>After traversal, check if mask equals
 *       (1 << 26) - 1.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "thequickbrownfoxjumpsoverthelazydog"
 *
 * As letters appear, bits are set in mask.
 *
 * Final mask:
 * 11111111111111111111111111
 *
 * Since all bits are set → Pangram.
 *
 * Output:
 * true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses a single integer instead of an array.</li>
 *   <li>Very memory efficient.</li>
 *   <li>Bit operations are extremely fast.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where n is the sentence length.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — only one integer used.
 * -----------------------------------------------------------------------
 */
public class LeetCode1832_CheckIfSentenceIsPangram_Bitmask {

    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        boolean result = checkIfPangram(sentence);

        System.out.println("Is pangram: " + result);
    }

    /**
     * Checks if the sentence is a pangram using bitmasking.
     */
    public static boolean checkIfPangram(String sentence) {

        int mask = 0;

        for (char c : sentence.toCharArray()) {

            // Set the bit corresponding to the character
            mask |= 1 << (c - 'a');
        }

        // Check if all 26 bits are set
        return mask == (1 << 26) - 1;
    }
}