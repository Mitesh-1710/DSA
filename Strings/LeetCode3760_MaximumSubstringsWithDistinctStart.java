/**
 * Problem:
 * Given a string {@code s} consisting of lowercase English letters,
 * return the maximum number of substrings such that each substring
 * starts with a <b>distinct character</b>.
 *
 * <p>Effectively, this reduces to counting how many unique starting
 * characters we can have — i.e., the number of distinct characters
 * in the string (bounded by 26).</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3760:
 * Maximum Substrings With Distinct Start</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-substrings-with-distinct-start/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The key observation:
 *
 * <ul>
 *   <li>Each substring must start with a distinct character.</li>
 *   <li>Therefore, we only need to count unique characters in the string.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>Use a Set<Character> to store unique characters.</li>
 *   <li>Return the size of the set.</li>
 * </ul>
 *
 * This works but involves hashing overhead.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use a <b>bitmask</b> to track seen characters.</li>
 *   <li>Each bit represents one character.</li>
 *   <li>Count unique characters efficiently.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Bitmask Concept (Detailed Explanation):</b>
 *
 * Since only lowercase letters are involved, we can use 26 bits:
 *
 * <pre>
 * bit 0  → 'a'
 * bit 1  → 'b'
 * ...
 * bit 25 → 'z'
 * </pre>
 *
 * For a character {@code c}:
 *
 * <pre>
 * int bit = 1 << (c - 'a');
 * </pre>
 *
 * Check if already seen:
 *
 * <pre>
 * (mask & bit) != 0
 * </pre>
 *
 * Mark as seen:
 *
 * <pre>
 * mask |= bit
 * </pre>
 *
 * This allows constant-time operations using a single integer.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize mask = 0 and count = 0.</li>
 *   <li>Traverse each character in the string.</li>
 *   <li>Compute its bit representation.</li>
 *   <li>If not already seen:</li>
 *   <ul>
 *     <li>Set the bit in mask.</li>
 *     <li>Increment count.</li>
 *   </ul>
 *   <li>If count reaches 26, return immediately (maximum possible).</li>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "abac"
 *
 * Process:
 *
 * a → new → count = 1
 * b → new → count = 2
 * a → already seen
 * c → new → count = 3
 *
 * Output:
 * 3
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * "abcdefghijklmnopqrstuvwxyz"
 *
 * Output:
 * 26
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through the string.</li>
 *   <li>Constant-time character tracking.</li>
 *   <li>Uses only one integer instead of extra data structures.</li>
 *   <li>Early exit when all characters are found.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — only a single integer is used.
 * -----------------------------------------------------------------------
 */
public class LeetCode3760_MaximumSubstringsWithDistinctStart {

    public static void main(String[] args) {

        String s = "abac";

        int result = maxDistinct(s);

        System.out.println("Result: " + result);
    }

    /**
     * Returns the number of distinct starting characters.
     *
     * @param s input string
     * @return count of distinct characters (max 26)
     */
    public static int maxDistinct(String s) {

        int mask = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            int bit = 1 << (s.charAt(i) - 'a');

            // If character not seen before
            if ((mask & bit) == 0) {

                mask |= bit;
                count++;
            }

            // Early exit if all 26 characters are found
            if (count == 26) {
                return 26;
            }
        }

        return count;
    }
}