/**
 * Problem:
 * Given two strings {@code s} and {@code t}, both being permutations
 * of the same set of lowercase English letters, calculate the
 * <b>permutation difference</b>.
 *
 * <p>The permutation difference is defined as the sum of the absolute
 * differences between the indices of each character in {@code s}
 * and {@code t}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3146: Permutation Difference between Two Strings</b></p>
 * <p>🔗 https://leetcode.com/problems/permutation-difference-between-two-strings/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key observation is that:</p>
 * <ul>
 *   <li>Both strings are permutations of each other.</li>
 *   <li>Each lowercase character appears exactly once in both strings.</li>
 * </ul>
 *
 * <p>This allows us to map each character directly to its index in
 * both strings.</p>
 *
 * <p>A naive approach would be:</p>
 * <ul>
 *   <li>For each character in {@code s}, search for its index in {@code t}.</li>
 * </ul>
 *
 * <p>This leads to O(n²) time complexity.</p>
 *
 * <p>To optimize, we store the index positions of characters in
 * both strings using fixed-size arrays.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Index Mapping Concept:</b>
 *
 * <p>Since only lowercase English letters are used
 * (<code>'a'</code> to <code>'z'</code>), we can:</p>
 *
 * <ul>
 *   <li>Use an integer array of size 26.</li>
 *   <li>Map each character to its index using {@code char - 'a'}.</li>
 * </ul>
 *
 * <p>This provides:</p>
 * <ul>
 *   <li>O(1) index access.</li>
 *   <li>Minimal memory usage.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Building the Index Arrays:</b>
 *
 * <p>For each position {@code i}:</p>
 * <ul>
 *   <li>Store {@code i} as the index of {@code s.charAt(i)}.</li>
 *   <li>Store {@code i} as the index of {@code t.charAt(i)}.</li>
 * </ul>
 *
 * <p>After this step:</p>
 * <ul>
 *   <li>{@code sIndex[c]} holds the index of character {@code c} in {@code s}.</li>
 *   <li>{@code tIndex[c]} holds the index of character {@code c} in {@code t}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Calculating the Permutation Difference:</b>
 *
 * <p>For each character from {@code 'a'} to {@code 'z'}:</p>
 * <ul>
 *   <li>Compute the absolute difference between its indices.</li>
 *   <li>Add it to the running total.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * s = "abc"
 * t = "bac"
 *
 * Indices:
 * 'a' → s:0 , t:1 → |0 - 1| = 1
 * 'b' → s:1 , t:0 → |1 - 0| = 1
 * 'c' → s:2 , t:2 → |2 - 2| = 0
 *
 * Output:
 *   2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Each character is processed once.</li>
 *   <li>No nested loops.</li>
 *   <li>Constant extra space.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the strings.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — fixed-size arrays of length 26.
 * -----------------------------------------------------------------------
 */
public class LeetCode3146_PermutationDifferenceBetweenTwoStrings {

    public static void main(String[] args) {

        String s = "abc";
        String t = "bac";

        int result = findPermutationDifference(s, t);

        System.out.println("Permutation Difference: " + result);
    }

    /**
     * Computes the permutation difference between two strings.
     *
     * @param s first permutation string
     * @param t second permutation string
     * @return sum of absolute index differences for all characters
     */
    public static int findPermutationDifference(String s, String t) {

        int[] sIndex = new int[26];
        int[] tIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sIndex[s.charAt(i) - 'a'] = i;
            tIndex[t.charAt(i) - 'a'] = i;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(sIndex[i] - tIndex[i]);
        }

        return diff;
    }
}