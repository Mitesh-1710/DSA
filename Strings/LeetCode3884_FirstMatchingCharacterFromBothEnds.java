/**
 * Problem:
 * Given a string {@code s}, return the first index {@code i}
 * such that:
 *
 * <pre>
 * s[i] == s[n - 1 - i]
 * </pre>
 *
 * where {@code n} is the length of the string.
 *
 * <p>If no such index exists, return -1.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3884:
 * First Matching Character From Both Ends</b></p>
 * <p>🔗 https://leetcode.com/problems/first-matching-character-from-both-ends/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We are comparing characters from:
 *
 * <pre>
 * left  → index i
 * right → index (n - 1 - i)
 * </pre>
 *
 * This is symmetric comparison from both ends.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>For each index i, compute matching index j.</li>
 *   <li>Compare s[i] with s[j].</li>
 * </ul>
 *
 * This works but recomputes indices repeatedly.
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (Two Pointers):</b>
 *
 * <ul>
 *   <li>Initialize two pointers:</li>
 *   <ul>
 *     <li>i → start (0)</li>
 *     <li>j → end (n-1)</li>
 *   </ul>
 *   <li>Move both inward simultaneously.</li>
 *   <li>Return first matching index.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Two-Pointer Symmetry</b>
 *
 * Instead of calculating:
 *
 * <pre>
 * j = n - 1 - i
 * </pre>
 *
 * we directly maintain:
 *
 * <pre>
 * i++, j--
 * </pre>
 *
 * This avoids recomputation and simplifies logic.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize i = 0 and j = n-1.</li>
 *   <li>While i ≤ j:</li>
 *   <ul>
 *     <li>If s[i] == s[j] → return i.</li>
 *     <li>Move i++, j--.</li>
 *   </ul>
 *   <li>If no match found → return -1.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "abca"
 *
 * i=0, j=3 → a == a → return 0
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * s = "abcd"
 *
 * a != d
 * b != c
 *
 * Output:
 * -1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass from both ends.</li>
 *   <li>Early exit on first match.</li>
 *   <li>No extra space required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n/2) → O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3884_FirstMatchingCharacterFromBothEnds {

    public static void main(String[] args) {

        String s = "abca";

        int result = firstMatchingIndex(s);

        System.out.println("Result: " + result);
    }

    /**
     * Finds first matching index from both ends.
     */
    public static int firstMatchingIndex(String s) {

        int i = 0, j = s.length() - 1;

        while (i <= j) {

            // Check symmetric characters
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }

            i++;
            j--;
        }

        return -1;
    }
}