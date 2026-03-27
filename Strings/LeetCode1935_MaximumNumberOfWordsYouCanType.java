/**
 * Problem:
 * You are given a string {@code text} consisting of words separated by spaces,
 * and a string {@code brokenLetters}.
 *
 * <p>A word is considered <b>typable</b> if it does not contain any
 * characters from {@code brokenLetters}.</p>
 *
 * <p>Return the number of typable words.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1935:
 * Maximum Number of Words You Can Type</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-number-of-words-you-can-type/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires:
 *
 * <ul>
 *   <li>Checking each word in the sentence.</li>
 *   <li>Verifying if it contains any broken letter.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>For each word, check each character against brokenLetters.</li>
 *   <li>This leads to repeated lookups.</li>
 * </ul>
 *
 * Optimized Approach:
 * <ul>
 *   <li>Convert brokenLetters into a <b>bitmask</b>.</li>
 *   <li>Use bit operations for constant-time checks.</li>
 *   <li>Traverse the string and validate words.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Bitmask + Word Parsing</b>
 *
 * 1️. Bitmask Representation:
 *
 * <pre>
 * bit 0 → 'a'
 * bit 1 → 'b'
 * ...
 * bit 25 → 'z'
 * </pre>
 *
 * Build mask:
 *
 * <pre>
 * mask |= 1 << (c - 'a')
 * </pre>
 *
 * Check if character is broken:
 *
 * <pre>
 * (mask & (1 << (c - 'a'))) != 0
 * </pre>
 *
 * ---------------------------------------------------------------
 *
 * 2️. Word Parsing:
 *
 * <ul>
 *   <li>Use a boolean {@code valid} to track current word.</li>
 *   <li>If broken letter appears → mark invalid.</li>
 *   <li>On space → finalize current word.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Build bitmask for brokenLetters.</li>
 *   <li>Initialize count = 0 and valid = true.</li>
 *   <li>Traverse each character:</li>
 *   <ul>
 *     <li>If space → check valid and reset.</li>
 *     <li>If broken letter → mark invalid.</li>
 *   </ul>
 *   <li>After loop, check last word.</li>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * text = "hello world"
 * brokenLetters = "ad"
 *
 * Process:
 *
 * hello → valid
 * world → contains 'd' → invalid
 *
 * Output:
 * 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through the string.</li>
 *   <li>Constant-time character checks.</li>
 *   <li>No extra string splitting required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + m), where:
 * <ul>
 *   <li>n = length of text</li>
 *   <li>m = length of brokenLetters</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(1) — single integer mask
 * -----------------------------------------------------------------------
 */
public class LeetCode1935_MaximumNumberOfWordsYouCanType {

    public static void main(String[] args) {

        String text = "hello world";
        String broken = "ad";

        int result = canBeTypedWords(text, broken);

        System.out.println("Result: " + result);
    }

    /**
     * Counts number of typable words.
     */
    public static int canBeTypedWords(String text, String brokenLetters) {

        int mask = 0;

        // Build bitmask for broken letters
        for (int i = 0; i < brokenLetters.length(); i++) {
            mask |= 1 << (brokenLetters.charAt(i) - 'a');
        }

        int count = 0;
        boolean valid = true;

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (c == ' ') {

                if (valid) count++;
                valid = true;

            } else if ((mask & (1 << (c - 'a'))) != 0) {

                // Broken character found
                valid = false;
            }
        }

        // Check last word
        return valid ? count + 1 : count;
    }
}