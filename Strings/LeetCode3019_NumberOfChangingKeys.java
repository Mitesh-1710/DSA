/**
 * Problem:
 * You are given a string {@code s} representing key presses.
 *
 * <p>A key change occurs when two consecutive characters are different
 * (case-insensitive).</p>
 *
 * <p>Return the number of key changes.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3019:
 * Number of Changing Keys</b></p>
 * <p>🔗 https://leetcode.com/problems/number-of-changing-keys/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to count how many times:
 *
 * <pre>
 * s[i] != s[i-1] (case-insensitive)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Convert entire string to lowercase.</li>
 *   <li>Compare adjacent characters.</li>
 * </ul>
 *
 * This creates extra string → unnecessary.
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Normalize characters on-the-fly using bit manipulation:
 *
 * <pre>
 * c | 32 → converts uppercase to lowercase
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): ASCII Bit Trick</b>
 *
 * ASCII values:
 *
 * <pre>
 * 'A' = 65 → 01000001
 * 'a' = 97 → 01100001
 * </pre>
 *
 * Difference:
 *
 * <pre>
 * 32 → 00100000
 * </pre>
 *
 * So:
 *
 * <pre>
 * 'A' | 32 = 'a'
 * 'B' | 32 = 'b'
 * </pre>
 *
 * Lowercase remains unchanged:
 *
 * <pre>
 * 'a' | 32 = 'a'
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Key Idea:</b>
 *
 * <pre>
 * (c | 32) → lowercase conversion without extra space
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize count = 0.</li>
 *   <li>Traverse string from index 1.</li>
 *   <li>Convert both characters to lowercase using bit trick.</li>
 *   <li>If different → increment count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "aAbBc"
 *
 * Normalized:
 * a a b b c
 *
 * Changes:
 * a → b → c → total = 2
 *
 * Output:
 * 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No extra string creation.</li>
 *   <li>Constant-time normalization.</li>
 *   <li>Single pass solution.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3019_NumberOfChangingKeys {

    public static void main(String[] args) {

        String s = "aAbBc";

        int result = countKeyChanges(s);

        System.out.println("Key Changes: " + result);
    }

    /**
     * Counts number of key changes using bit trick.
     */
    public static int countKeyChanges(String s) {

        int count = 0;

        for (int i = 1; i < s.length(); i++) {

            // Normalize both characters to lowercase using bit trick
            if ((s.charAt(i - 1) | 32) != (s.charAt(i) | 32)) {
                count++;
            }
        }

        return count;
    }
}