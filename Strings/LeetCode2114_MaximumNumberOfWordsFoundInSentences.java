/**
 * Problem:
 * You are given an array of strings {@code sentences}, where each string
 * represents a sentence consisting of words separated by <b>single spaces</b>.
 *
 * <p>Return the <b>maximum number of words</b> that appear in any single
 * sentence.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2114: Maximum Number of Words Found in Sentences</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task is to determine how many words exist in each sentence
 * and track the maximum across all sentences.</p>
 *
 * <p>Key observation:</p>
 * <ul>
 *   <li>Words in a sentence are separated by single spaces.</li>
 *   <li>If a sentence has {@code k} spaces, it contains {@code k + 1} words.</li>
 * </ul>
 *
 * <p>A straightforward approach is sufficient here:</p>
 * <ul>
 *   <li>Iterate through each sentence.</li>
 *   <li>Count the number of spaces.</li>
 *   <li>Add one to get the word count.</li>
 * </ul>
 *
 * <p>This avoids unnecessary string splitting and keeps the solution simple
 * and efficient.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Counting Words Without Splitting:</b>
 *
 * <p>Instead of using {@code split()}, we count spaces directly:</p>
 *
 * <ul>
 *   <li>Initialize the word count to {@code 1} for each sentence.</li>
 *   <li>Increment the count whenever a space character is encountered.</li>
 * </ul>
 *
 * <p>This works because the problem guarantees valid formatting
 * (no leading, trailing, or multiple spaces).</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize {@code maxWords = 0}.</li>
 *   <li>For each sentence:</li>
 *   <ul>
 *     <li>Set {@code words = 1}.</li>
 *     <li>Traverse the sentence character-by-character.</li>
 *     <li>Increment {@code words} on every space.</li>
 *     <li>Update {@code maxWords} if needed.</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * sentences = [
 *   "alice and bob love leetcode",
 *   "i think so too",
 *   "this is great thanks very much"
 * ]
 *
 * Word counts:
 * "alice and bob love leetcode"        → 5
 * "i think so too"                     → 4
 * "this is great thanks very much"     → 6
 *
 * Output:
 *   6
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No extra memory allocation.</li>
 *   <li>A single pass through each sentence.</li>
 *   <li>Clear and easy to reason about.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(total characters across all sentences).<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode2114_MaximumNumberOfWordsFoundInSentences {

    public static void main(String[] args) {

        String[] sentences = {
                "alice and bob love leetcode",
                "i think so too",
                "this is great thanks very much"
        };

        int result = mostWordsFound(sentences);

        System.out.println("Maximum number of words: " + result);
    }

    /**
     * Returns the maximum number of words found in any sentence.
     *
     * @param sentences array of sentences
     * @return maximum word count
     */
    public static int mostWordsFound(String[] sentences) {

        int max = 0;

        for (String s : sentences) {
            int words = 1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    words++;
                }
            }

            max = Math.max(max, words);
        }

        return max;
    }
}