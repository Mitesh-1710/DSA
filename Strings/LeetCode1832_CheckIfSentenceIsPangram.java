/**
 * Problem:
 * A sentence is called a <b>Pangram</b> if it contains every letter
 * of the English alphabet at least once.
 *
 * <p>Given a string {@code sentence} consisting of lowercase English letters,
 * return {@code true} if the sentence is a pangram, otherwise return {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1832:
 * Check if the Sentence Is Pangram</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-the-sentence-is-pangram/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The goal is to determine whether all 26 letters of the English alphabet
 * appear at least once in the given sentence.
 *
 * Naive Approach:
 * <ul>
 *   <li>For each letter from 'a' to 'z', scan the entire string
 *       to check if it exists.</li>
 * </ul>
 *
 * This results in:
 *
 * <pre>
 * O(26 * n) ≈ O(n)
 * </pre>
 *
 * Although acceptable, it repeatedly scans the string.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Track letters seen using a boolean array of size 26.</li>
 *   <li>Mark characters as they appear.</li>
 *   <li>Stop early once all 26 letters are discovered.</li>
 * </ul>
 *
 * This ensures only a single pass through the sentence.
 *
 * -----------------------------------------------------------------------
 * <b>Alphabet Index Mapping Concept (Detailed Explanation):</b>
 *
 * Each lowercase letter can be mapped to an index:
 *
 * <pre>
 * 'a' → 0
 * 'b' → 1
 * ...
 * 'z' → 25
 * </pre>
 *
 * Using:
 *
 * <pre>
 * index = c - 'a'
 * </pre>
 *
 * We store whether a character has appeared using:
 *
 * <pre>
 * boolean[] seen = new boolean[26];
 * </pre>
 *
 * When a new character is encountered:
 * <ul>
 *   <li>Mark it as seen.</li>
 *   <li>Increase the count of unique letters found.</li>
 * </ul>
 *
 * If the count reaches 26, the sentence is a pangram.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a boolean array of size 26.</li>
 *   <li>Initialize a counter for unique characters.</li>
 *   <li>Traverse each character in the sentence.</li>
 *   <ul>
 *     <li>Map character to index.</li>
 *     <li>If not seen before, mark it and increment counter.</li>
 *     <li>If counter reaches 26, return true immediately.</li>
 *   </ul>
 *   <li>If traversal finishes and count < 26, return false.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "thequickbrownfoxjumpsoverthelazydog"
 *
 * All letters from 'a' to 'z' appear at least once.
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * "leetcode"
 *
 * Missing several letters.
 *
 * Output:
 * false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single traversal of the sentence.</li>
 *   <li>Constant-time character lookup.</li>
 *   <li>Early termination when all letters are found.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the sentence.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — fixed array of size 26.
 * -----------------------------------------------------------------------
 */
public class LeetCode1832_CheckIfSentenceIsPangram {

    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        boolean result = checkIfPangram(sentence);

        System.out.println("Is pangram: " + result);
    }

    /**
     * Returns true if the sentence contains every letter
     * of the English alphabet at least once.
     *
     * @param sentence input string
     * @return true if pangram, otherwise false
     */
    public static boolean checkIfPangram(String sentence) {

        boolean[] seen = new boolean[26];
        int count = 0;

        for (char c : sentence.toCharArray()) {

            int index = c - 'a';

            // If this letter hasn't been seen before
            if (!seen[index]) {

                seen[index] = true;
                count++;

                // Early exit when all 26 letters are found
                if (count == 26) {
                    return true;
                }
            }
        }

        return false;
    }
}