/**
 * Problem:
 * You are given a string {@code num} representing a non-negative integer.
 *
 * <p>Remove all trailing zeros from the string and return the result.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2710:
 * Remove Trailing Zeros From a String</b></p>
 * <p>🔗 https://leetcode.com/problems/remove-trailing-zeros-from-a-string/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to:
 *
 * <ul>
 *   <li>Remove zeros ONLY from the end.</li>
 *   <li>Keep all other characters intact.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Repeatedly remove last character if it's '0'.</li>
 * </ul>
 *
 * This can lead to:
 *
 * <pre>
 * O(n²) (due to repeated string creation)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Traverse from right → find first non-zero character.
 *
 * Then:
 *
 * <pre>
 * return substring(0, index + 1)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Reverse Scan / Right Pointer</b>
 *
 * Use pointer:
 *
 * <pre>
 * i = last index
 * </pre>
 *
 * Move left while:
 *
 * <pre>
 * num[i] == '0'
 * </pre>
 *
 * Stop at first non-zero.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize i = n - 1.</li>
 *   <li>While i ≥ 0 and num[i] == '0':</li>
 *   <ul>
 *     <li>i--</li>
 *   </ul>
 *   <li>Return substring(0, i + 1).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * num = "51230100"
 *
 * Process:
 * remove trailing zeros → "512301"
 *
 * Output:
 * "512301"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * num = "123"
 *
 * No trailing zeros → unchanged
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass from end.</li>
 *   <li>No repeated string creation.</li>
 *   <li>Efficient substring extraction.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(n) (substring result)
 * -----------------------------------------------------------------------
 */
public class LeetCode2710_RemoveTrailingZerosFromString {

    public static void main(String[] args) {

        String num = "51230100";

        String result = removeTrailingZeros(num);

        System.out.println("Result: " + result);
    }

    /**
     * Removes trailing zeros using reverse scan.
     */
    public static String removeTrailingZeros(String num) {

        int i = num.length() - 1;

        // Move left while zeros
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }

        return num.substring(0, i + 1);
    }
}