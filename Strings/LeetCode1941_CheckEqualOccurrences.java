/**
 * Problem:
 * Given a string {@code s}, return {@code true} if all characters
 * in the string have the same number of occurrences.
 *
 * <p>This is the solution to <b>LeetCode Problem 1941:
 * Check if All Characters Have Equal Number of Occurrences</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to verify:
 *
 * <pre>
 * frequency of all characters is equal
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Count frequency.</li>
 *   <li>Store frequencies in a set.</li>
 *   <li>If set size == 1 → valid.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use an invariant:
 *
 * <pre>
 * all non-zero frequencies must match a reference value
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Invariant Tracking</b>
 *
 * We maintain:
 *
 * <pre>
 * expected = first non-zero frequency
 * </pre>
 *
 * Then:
 *
 * <ul>
 *   <li>Ignore zero frequencies.</li>
 *   <li>Compare each frequency with expected.</li>
 * </ul>
 *
 * If mismatch → return false.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Count frequency of each character.</li>
 *   <li>Initialize expected = 0.</li>
 *   <li>Traverse frequency array:</li>
 *   <ul>
 *     <li>Skip zero frequencies.</li>
 *     <li>If expected not set → set it.</li>
 *     <li>If mismatch → return false.</li>
 *   </ul>
 *   <li>Return true.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "abacbc"
 *
 * Frequencies:
 * a → 2
 * b → 2
 * c → 2
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * s = "aaabb"
 *
 * a → 3
 * b → 2
 *
 * Output:
 * false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No extra data structures.</li>
 *   <li>Single pass over frequency array.</li>
 *   <li>Simple invariant check.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + 26) → O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1941_CheckEqualOccurrences {

    public static void main(String[] args) {

        String s = "abacbc";

        boolean result = areOccurrencesEqual(s);

        System.out.println("Result: " + result);
    }

    /**
     * Checks if all character frequencies are equal.
     */
    public static boolean areOccurrencesEqual(String s) {

        int[] freq = new int[26];

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int expected = 0;

        for (int f : freq) {

            if (f == 0) continue;

            if (expected == 0) {

                expected = f;

            } else if (f != expected) {

                return false;
            }
        }

        return true;
    }
}