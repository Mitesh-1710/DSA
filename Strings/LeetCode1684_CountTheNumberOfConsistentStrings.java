/**
 * Problem:
 * Count the number of <b>consistent strings</b>.
 *
 * <p>You are given:</p>
 * <ul>
 *   <li>A string {@code allowed} containing distinct lowercase characters.</li>
 *   <li>An array of strings {@code words}.</li>
 * </ul>
 *
 * <p>A string is considered <b>consistent</b> if all its characters
 * appear in the {@code allowed} string.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1684: Count the Number of Consistent Strings</b></p>
 * <p>🔗 https://leetcode.com/problems/count-the-number-of-consistent-strings/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The naive approach would be:</p>
 * <ul>
 *   <li>For each word, check every character against {@code allowed}
 *       using a set or string lookup.</li>
 * </ul>
 *
 * <p>This works, but we can optimize character checks using
 * <b>bitmasking</b>, which provides constant-time lookups using bit operations.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Bitmasking Concept (Detailed Explanation):</b>
 *
 * <p>Since the problem involves only lowercase English letters
 * (<code>'a'</code> to <code>'z'</code>), we can represent the presence of
 * characters using a single 32-bit integer.</p>
 *
 * <p><b>Idea:</b></p>
 * <ul>
 *   <li>Each bit in an integer represents one character.</li>
 *   <li>Bit position <code>0</code> → 'a'</li>
 *   <li>Bit position <code>1</code> → 'b'</li>
 *   <li>...</li>
 *   <li>Bit position <code>25</code> → 'z'</li>
 * </ul>
 *
 * <p><b>Setting a bit:</b></p>
 * <pre>
 * mask |= 1 << (character - 'a')
 * </pre>
 *
 * <p><b>Checking a bit:</b></p>
 * <pre>
 * (mask & (1 << (character - 'a'))) != 0
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Building the Allowed Mask:</b>
 *
 * <p>For {@code allowed = "abc"}:</p>
 *
 * <pre>
 * 'a' → 1 << 0 → 000...001
 * 'b' → 1 << 1 → 000...010
 * 'c' → 1 << 2 → 000...100
 *
 * allowedMask = 000...111
 * </pre>
 *
 * <p>This mask now represents all allowed characters.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Checking Each Word:</b>
 *
 * <p>For every character in a word:</p>
 * <ul>
 *   <li>Generate its bit.</li>
 *   <li>Check if that bit exists in {@code allowedMask}.</li>
 *   <li>If any character is missing, the word is inconsistent.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * allowed = "ab"
 * words   = ["ad","bd","aaab","baa","badab"]
 *
 * allowedMask = bits for 'a' and 'b'
 *
 * "ad"   → 'd' not allowed → ❌
 * "bd"   → 'd' not allowed → ❌
 * "aaab" → all allowed     → ✅
 * "baa"  → all allowed     → ✅
 * "badab"→ 'd' not allowed → ❌
 *
 * Output: 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why Bitmasking Works Well Here:</b>
 *
 * <ul>
 *   <li>Only 26 possible characters → fits in one integer.</li>
 *   <li>Bitwise operations are extremely fast.</li>
 *   <li>No extra data structures required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(total characters in all words).<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — only a single integer mask is used.
 * -----------------------------------------------------------------------
 */
public class LeetCode1684_CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {

        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};

        int result = countConsistentStrings(allowed, words);

        System.out.println("Number of consistent strings: " + result);
    }

    /**
     * Counts how many strings in {@code words} are consistent
     * with the {@code allowed} characters.
     *
     * @param allowed string containing allowed lowercase characters
     * @param words   array of words to evaluate
     * @return count of consistent strings
     */
    public static int countConsistentStrings(String allowed, String[] words) {

        int allowedMask = 0;

        // Build bitmask for allowed characters
        for (int i = 0; i < allowed.length(); i++) {
            allowedMask |= 1 << (allowed.charAt(i) - 'a');
        }

        int count = 0;

        // Check each word
        for (String word : words) {

            boolean consistent = true;

            for (int i = 0; i < word.length(); i++) {
                int bit = 1 << (word.charAt(i) - 'a');

                // If character not present in allowed mask
                if ((allowedMask & bit) == 0) {
                    consistent = false;
                    break;
                }
            }

            if (consistent) {
                count++;
            }
        }

        return count;
    }
}