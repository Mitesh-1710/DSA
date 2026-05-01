import java.util.*;

/**
 * Problem:
 * Given a string {@code s} of even length, split it into two equal halves.
 *
 * <pre>
 * first half  = s[0 ... n/2 - 1]
 * second half = s[n/2 ... n-1]
 * </pre>
 *
 * Return {@code true} if both halves contain the same number of vowels.
 *
 * <p>Vowels are:
 * <pre>
 * a, e, i, o, u (case-insensitive)
 * </pre>
 *
 * <p>This is the solution to <b>LeetCode Problem 1704:
 * Determine if String Halves Are Alike</b></p>
 * <p>🔗 https://leetcode.com/problems/determine-if-string-halves-are-alike/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to verify:
 *
 * <pre>
 * vowels(first half) == vowels(second half)
 * </pre>
 *
 * Instead of counting separately, we can track the difference.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Split string into two halves.</li>
 *   <li>Count vowels in both halves separately.</li>
 *   <li>Compare counts.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n)
 * </pre>
 *
 * Space:
 *
 * <pre>
 * O(n) (due to substring creation)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Avoid splitting and use a single traversal.
 *
 * <ul>
 *   <li>Traverse first half → increment count for vowels.</li>
 *   <li>Traverse second half → decrement count for vowels.</li>
 *   <li>If final count == 0 → both halves are alike.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Difference Counting + Symmetric Traversal</b>
 *
 * Instead of maintaining two counters:
 *
 * <pre>
 * count1 == count2
 * </pre>
 *
 * We track:
 *
 * <pre>
 * count1 - count2 == 0
 * </pre>
 *
 * -----------------------------------------------------
 * <b>1. Difference Counting Pattern</b>
 *
 * <ul>
 *   <li>Vowel in first half → +1</li>
 *   <li>Vowel in second half → -1</li>
 * </ul>
 *
 * Final condition:
 *
 * <pre>
 * count == 0
 * </pre>
 *
 * This pattern is useful in:
 *
 * <ul>
 *   <li>Balanced comparisons</li>
 *   <li>Prefix difference problems</li>
 *   <li>Two-group equality checks</li>
 * </ul>
 *
 * -----------------------------------------------------
 * <b>2. Symmetric Two-Pointer Traversal</b>
 *
 * <pre>
 * i           → start
 * n - 1 - i   → end
 * </pre>
 *
 * This allows:
 *
 * <ul>
 *   <li>Single loop instead of two passes</li>
 *   <li>Better locality and fewer iterations</li>
 * </ul>
 *
 * -----------------------------------------------------
 * <b>3. ASCII Lookup Optimization</b>
 *
 * We use:
 *
 * <pre>
 * boolean[128]
 * </pre>
 *
 * to mark vowels for constant-time lookup.
 *
 * Advantage:
 *
 * <ul>
 *   <li>No hashing overhead</li>
 *   <li>Faster than Set</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create boolean array to mark vowels.</li>
 *   <li>Initialize count = 0.</li>
 *   <li>Traverse from both ends till midpoint:</li>
 *   <ul>
 *     <li>If left char is vowel → count++</li>
 *     <li>If right char is vowel → count--</li>
 *   </ul>
 *   <li>Return count == 0.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "book"
 *
 * First half  = "bo"
 * Second half = "ok"
 *
 * Iteration:
 *
 * i = 0:
 * b → not vowel → count = 0
 * k → not vowel → count = 0
 *
 * i = 1:
 * o → vowel → count = +1
 * o → vowel → count = -1 → net = 0
 *
 * Output:
 * true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>No extra space for substrings.</li>
 *   <li>Constant-time vowel lookup.</li>
 *   <li>Uses difference tracking instead of two counters.</li>
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
public class LeetCode1704_DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {

        String s = "book";

        boolean result = halvesAreAlike(s);

        System.out.println("Result: " + result);
    }

    /**
     * Checks if both halves of the string have equal number of vowels.
     */
    public static boolean halvesAreAlike(String s) {

        boolean[] vowel = new boolean[128];

        // Mark vowels
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowel[c] = true;
        }

        int count = 0;
        int n = s.length();

        // Traverse both halves simultaneously
        for (int i = 0; i < n / 2; i++) {

            if (vowel[s.charAt(i)]) {
                count++;
            }

            if (vowel[s.charAt(n - 1 - i)]) {
                count--;
            }
        }

        return count == 0;
    }
}