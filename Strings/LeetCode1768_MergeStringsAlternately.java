/**
 * Problem:
 * You are given two strings {@code word1} and {@code word2}.
 *
 * <p>Merge the strings by adding letters in alternating order,
 * starting with {@code word1}.</p>
 *
 * <p>If one string is longer, append the remaining characters
 * at the end.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1768:
 * Merge Strings Alternately</b></p>
 * <p>🔗 https://leetcode.com/problems/merge-strings-alternately/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to:
 *
 * <ul>
 *   <li>Pick characters alternately from both strings.</li>
 *   <li>Continue until one string ends.</li>
 *   <li>Append remaining characters from the longer string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Use String concatenation repeatedly.</li>
 * </ul>
 *
 * This leads to:
 *
 * <pre>
 * O(n²) due to string immutability
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Use a character array of size (n1 + n2).</li>
 *   <li>Fill it using pointers.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Two-Pointer Merge Pattern</b>
 *
 * Maintain:
 *
 * <pre>
 * i → pointer for word1
 * j → pointer for word2
 * k → pointer for result array
 * </pre>
 *
 * Process:
 *
 * <ul>
 *   <li>Alternate picks from both strings.</li>
 *   <li>When one finishes, append remaining.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create result array of size n1 + n2.</li>
 *   <li>Initialize pointers i, j, k.</li>
 *   <li>While both strings have characters:</li>
 *   <ul>
 *     <li>Add from word1, then word2.</li>
 *   </ul>
 *   <li>Append remaining characters from either string.</li>
 *   <li>Return new string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * word1 = "abc"
 * word2 = "pqr"
 *
 * Process:
 * a p b q c r
 *
 * Output:
 * "apbqcr"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * word1 = "ab"
 * word2 = "pqrs"
 *
 * Output:
 * "apbqrs"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through both strings.</li>
 *   <li>No extra string concatenation overhead.</li>
 *   <li>Efficient memory usage.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n1 + n2)
 *
 * <b>Space Complexity:</b>
 * O(n1 + n2)
 * -----------------------------------------------------------------------
 */
public class LeetCode1768_MergeStringsAlternately {

    public static void main(String[] args) {

        String word1 = "abc";
        String word2 = "pqr";

        String result = mergeAlternately(word1, word2);

        System.out.println("Result: " + result);
    }

    /**
     * Merges two strings alternately.
     */
    public static String mergeAlternately(String word1, String word2) {

        int n1 = word1.length(), n2 = word2.length();

        char[] res = new char[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Alternate merge
        while (i < n1 && j < n2) {

            res[k++] = word1.charAt(i++);
            res[k++] = word2.charAt(j++);
        }

        // Append remaining characters
        while (i < n1) res[k++] = word1.charAt(i++);
        while (j < n2) res[k++] = word2.charAt(j++);

        return new String(res);
    }
}