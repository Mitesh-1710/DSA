/**
 * Problem:
 * Given a string {@code s} consisting of multiple words separated
 * by single spaces, return the largest word (i.e., the word with
 * the maximum number of characters).
 *
 * <p>If multiple words have the same maximum length,
 * return the first such word.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task requires identifying word boundaries and tracking
 * the longest word encountered so far.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Split the string using {@code s.split(" ")}.</li>
 *   <li>Traverse the resulting array to find the longest word.</li>
 * </ul>
 *
 * <p>This works but creates an additional array of substrings,
 * increasing memory usage.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Traverse the string manually.</li>
 *   <li>Detect word boundaries using spaces.</li>
 *   <li>Track start index and length of each word.</li>
 * </ul>
 *
 * <p>This avoids extra memory allocation and keeps the solution linear.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Word Boundary Detection Concept (Detailed Explanation):</b>
 *
 * <p>A word ends when:</p>
 * <ul>
 *   <li>We encounter a space character, OR</li>
 *   <li>We reach the end of the string.</li>
 * </ul>
 *
 * <p>To handle the last word uniformly, we iterate until
 * {@code i <= s.length()} and treat {@code i == s.length()}
 * as a word boundary.</p>
 *
 * <p>For each word:</p>
 * <pre>
 * length = i - start
 * </pre>
 *
 * <p>If length > maxLength:</p>
 * <ul>
 *   <li>Update maxLength</li>
 *   <li>Update maxStart</li>
 * </ul>
 *
 * <p>This guarantees we return the first longest word,
 * since we only update when strictly greater.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize variables to track maximum word start and length.</li>
 *   <li>Traverse string from index 0 to n (inclusive).</li>
 *   <li>When a word boundary is detected:</li>
 *   <ul>
 *     <li>Compute word length.</li>
 *     <li>If greater than current maximum, update tracking variables.</li>
 *     <li>Move start to next position.</li>
 *   </ul>
 *   <li>Return substring using recorded start and length.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   "Java is powerful and fast"
 *
 * Words:
 *   "Java"      → length 4
 *   "is"        → length 2
 *   "powerful"  → length 8
 *   "and"       → length 3
 *   "fast"      → length 4
 *
 * Largest word:
 *   "powerful"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 *   "cat dog pig"
 *
 * All words length 3.
 * Return first: "cat"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through string.</li>
 *   <li>No additional data structures required.</li>
 *   <li>Correctly handles tie-breaking by returning first occurrence.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space (excluding substring result).
 * -----------------------------------------------------------------------
 */
public class LargestWordInString {

    public static void main(String[] args) {

        String s = "Java is powerful and fast";

        String result = largestWord(s);

        System.out.println("Largest word: " + result);
    }

    /**
     * Returns the largest word in the given string.
     *
     * @param s input string
     * @return word with maximum length
     */
    public static String largestWord(String s) {

        int maxStart = 0;
        int maxLength = 0;

        int start = 0;

        for (int i = 0; i <= s.length(); i++) {

            // Word boundary detected
            if (i == s.length() || s.charAt(i) == ' ') {

                int length = i - start;

                if (length > maxLength) {
                    maxLength = length;
                    maxStart = start;
                }

                start = i + 1;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }
}