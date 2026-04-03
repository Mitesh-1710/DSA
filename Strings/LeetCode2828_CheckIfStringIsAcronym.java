import java.util.List;

/**
 * Problem:
 * Given a list of strings {@code words} and a string {@code s},
 * determine if {@code s} is an acronym of the given words.
 *
 * <p>An acronym is formed by taking the first character of each word
 * and concatenating them in order.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2828:
 * Check if a String Is an Acronym of Words</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * To form the acronym:
 *
 * <pre>
 * s[i] = first character of words[i]
 * </pre>
 *
 * So we need:
 *
 * <ul>
 *   <li>Same length → words.size() == s.length()</li>
 *   <li>Each character must match corresponding word's first letter</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Build a new string using first characters.</li>
 *   <li>Compare with {@code s}.</li>
 * </ul>
 *
 * This creates extra string → unnecessary.
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Compare characters directly during traversal.</li>
 *   <li>Early exit on mismatch.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Index Mapping</b>
 *
 * We map:
 *
 * <pre>
 * words[i].charAt(0) ↔ s.charAt(i)
 * </pre>
 *
 * If any mismatch occurs:
 *
 * <pre>
 * return false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Check if sizes match.</li>
 *   <li>Traverse both structures.</li>
 *   <li>Compare first character of each word with s[i].</li>
 *   <li>If mismatch → return false.</li>
 *   <li>Return true if all match.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * words = ["alice", "bob", "charlie"]
 * s = "abc"
 *
 * Process:
 * a == a
 * b == b
 * c == c
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * words = ["alice", "bob"]
 * s = "abx"
 *
 * length mismatch → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No extra space used.</li>
 *   <li>Early termination on mismatch.</li>
 *   <li>Simple and efficient.</li>
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
public class LeetCode2828_CheckIfStringIsAcronym {

    public static void main(String[] args) {

        List<String> words = List.of("alice", "bob", "charlie");
        String s = "abc";

        boolean result = isAcronym(words, s);

        System.out.println("Is Acronym: " + result);
    }

    /**
     * Checks if s is an acronym of words.
     */
    public static boolean isAcronym(List<String> words, String s) {

        // Length must match
        if (words.size() != s.length()) return false;

        for (int i = 0; i < words.size(); i++) {

            // Compare first character
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}