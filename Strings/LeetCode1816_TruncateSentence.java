/**
 * Problem:
 * Given a string {@code s} representing a sentence consisting of words
 * separated by single spaces, and an integer {@code k},
 * return the sentence truncated to its first {@code k} words.
 *
 * <p>The returned string should contain exactly the first {@code k} words,
 * separated by single spaces.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1816: Truncate Sentence</b></p>
 * <p>🔗 https://leetcode.com/problems/truncate-sentence/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem requires extracting the first {@code k} words
 * from a space-separated sentence.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Use {@code split(" ")} to split the string into words.</li>
 *   <li>Join the first {@code k} words.</li>
 * </ul>
 *
 * <p>This works but creates an additional array and uses extra memory.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Traverse the string once.</li>
 *   <li>Count spaces encountered.</li>
 *   <li>Stop when {@code k} words are completed.</li>
 * </ul>
 *
 * <p>Since each word is separated by a single space,
 * counting spaces gives us word boundaries.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Space Counting Concept (Detailed Explanation):</b>
 *
 * <p>If a sentence has:</p>
 * <pre>
 * k words → it contains (k - 1) spaces.
 * </pre>
 *
 * <p>Therefore:</p>
 * <ul>
 *   <li>We iterate through the string.</li>
 *   <li>Each time we encounter a space, we increment a counter.</li>
 *   <li>When the counter reaches {@code k}, we return the substring
 *       from index 0 up to the current position.</li>
 * </ul>
 *
 * <p>This avoids splitting and keeps memory usage minimal.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize a space counter.</li>
 *   <li>Traverse characters of the string.</li>
 *   <li>Increment counter when encountering a space.</li>
 *   <li>If space count equals {@code k}, return substring(0, currentIndex).</li>
 *   <li>If traversal finishes without reaching {@code k},
 *       return the original string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * s = "Hello how are you Contestant"
 * k = 4
 *
 * Words:
 * "Hello" (1)
 * "how"   (2)
 * "are"   (3)
 * "you"   (4)
 *
 * Output:
 * "Hello how are you"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over the string.</li>
 *   <li>No additional data structures.</li>
 *   <li>Efficient substring extraction.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of {@code s}.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — no extra space used (excluding output substring).
 * -----------------------------------------------------------------------
 */
public class LeetCode1816_TruncateSentence {

    public static void main(String[] args) {

        String s = "Hello how are you Contestant";
        int k = 4;

        String result = truncateSentence(s, k);

        System.out.println("Truncated sentence: " + result);
    }

    /**
     * Returns the sentence truncated to its first k words.
     *
     * @param s input sentence
     * @param k number of words to keep
     * @return truncated sentence
     */
    public static String truncateSentence(String s, int k) {

        int spaces = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                spaces++;

                // When k words are reached, return substring up to this index
                if (spaces == k) {
                    return s.substring(0, i);
                }
            }
        }

        // If sentence has fewer than k words, return original string
        return s;
    }
}