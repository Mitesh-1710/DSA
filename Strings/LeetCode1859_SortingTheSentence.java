/**
 * Problem:
 * You are given a string {@code s} containing words where each word
 * has a trailing digit indicating its position in the sentence.
 *
 * <p>Reconstruct and return the correct sentence.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1859:
 * Sorting the Sentence</b></p>
 * <p>🔗 https://leetcode.com/problems/sorting-the-sentence/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Each word ends with a digit:
 *
 * <pre>
 * "is2 sentence4 This1 a3"
 * </pre>
 *
 * Meaning:
 *
 * <pre>
 * position = digit - '1'
 * </pre>
 *
 * So we:
 *
 * <ul>
 *   <li>Extract word (without digit)</li>
 *   <li>Place it at correct index</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Split string into words.</li>
 *   <li>Sort using comparator on last digit.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n log n)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use direct indexing:
 *
 * <ul>
 *   <li>No sorting needed.</li>
 *   <li>Place words directly into result array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Indexed Placement</b>
 *
 * Instead of sorting:
 *
 * <pre>
 * Use digit as index → O(1) placement
 * </pre>
 *
 * This is similar to:
 *
 * <pre>
 * bucket sort / counting sort idea
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create array to store words.</li>
 *   <li>Traverse string character by character.</li>
 *   <li>Build word using StringBuilder.</li>
 *   <li>When digit encountered:</li>
 *   <ul>
 *     <li>Place word at index (digit - '1')</li>
 *     <li>Reset builder</li>
 *   </ul>
 *   <li>Finally, join all words with spaces.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "is2 sentence4 This1 a3"
 *
 * Processing:
 * "is" → index 1
 * "sentence" → index 3
 * "This" → index 0
 * "a" → index 2
 *
 * Result:
 * ["This", "is", "a", "sentence"]
 *
 * Output:
 * "This is a sentence"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No sorting required.</li>
 *   <li>Single pass parsing.</li>
 *   <li>Direct placement → optimal.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode1859_SortingTheSentence {

    public static void main(String[] args) {

        String s = "is2 sentence4 This1 a3";

        String result = sortSentence(s);

        System.out.println("Result: " + result);
    }

    /**
     * Sorts sentence using index-based placement.
     */
    public static String sortSentence(String s) {

        String[] res = new String[10]; // max words ≤ 9
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == ' ') continue;

            if (c >= '1' && c <= '9') {

                int idx = c - '1';

                res[idx] = word.toString();
                word.setLength(0);

            } else {

                word.append(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String w : res) {

            if (w != null) {

                if (ans.length() > 0) ans.append(' ');
                ans.append(w);
            }
        }

        return ans.toString();
    }
}