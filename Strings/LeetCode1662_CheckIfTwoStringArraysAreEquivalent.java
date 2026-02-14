/**
 * Problem:
 * You are given two string arrays {@code word1} and {@code word2}.
 *
 * <p>Each array represents a string formed by concatenating
 * all its elements in order.</p>
 *
 * <p>Return {@code true} if the two resulting strings are equal,
 * otherwise return {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1662: Check If Two String Arrays are Equivalent</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem reduces to checking whether:</p>
 * <pre>
 * concat(word1) == concat(word2)
 * </pre>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Concatenate all strings in {@code word1}.</li>
 *   <li>Concatenate all strings in {@code word2}.</li>
 *   <li>Compare the final strings.</li>
 * </ul>
 *
 * <p>This works well within given constraints.</p>
 *
 * <p>Optimized Observation:</p>
 * <ul>
 *   <li>Instead of building full strings, we could compare characters
 *       on-the-fly using two pointers.</li>
 *   <li>This avoids building intermediate large strings.</li>
 * </ul>
 *
 * <p>However, given moderate constraints, StringBuilder approach
 * is simple, readable, and efficient enough.</p>
 *
 * -----------------------------------------------------------------------
 * <b>String Concatenation Concept (Detailed Explanation):</b>
 *
 * <p>Using {@link java.lang.StringBuilder} is preferable to
 * direct string concatenation because:</p>
 *
 * <ul>
 *   <li>Strings are immutable in Java.</li>
 *   <li>Repeated concatenation creates new string objects.</li>
 *   <li>StringBuilder provides amortized O(1) append operations.</li>
 * </ul>
 *
 * <p>Thus, building both final strings using StringBuilder
 * ensures linear time complexity.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create two StringBuilders.</li>
 *   <li>Append all elements of {@code word1} to first builder.</li>
 *   <li>Append all elements of {@code word2} to second builder.</li>
 *   <li>Compare the resulting strings using {@code equals()}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * word1 = ["ab", "c"]
 * word2 = ["a", "bc"]
 *
 * Concatenated:
 * word1 → "abc"
 * word2 → "abc"
 *
 * Output:
 * true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Clear and easy to implement.</li>
 *   <li>Efficient for moderate input sizes.</li>
 *   <li>Leverages optimized StringBuilder implementation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + m), where:
 * <ul>
 *   <li>{@code n} = total characters in {@code word1}</li>
 *   <li>{@code m} = total characters in {@code word2}</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(n + m) — for storing concatenated strings.
 * -----------------------------------------------------------------------
 */
public class LeetCode1662_CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        boolean result = arrayStringsAreEqual(word1, word2);

        System.out.println("Are equal: " + result);
    }

    /**
     * Returns true if concatenation of word1 equals concatenation of word2.
     *
     * @param word1 first string array
     * @param word2 second string array
     * @return true if equivalent, otherwise false
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();

        // Build first string
        for (String s : word1) {
            w1.append(s);
        }

        // Build second string
        for (String s : word2) {
            w2.append(s);
        }

        return w1.toString().equals(w2.toString());
    }
}
