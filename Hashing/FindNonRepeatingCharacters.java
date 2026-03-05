import java.lang.StringBuilder;

/**
 * Problem:
 * Given a string {@code s} consisting of lowercase English letters,
 * return all <b>non-repeating characters</b> in the string.
 *
 * <p>The result should preserve the original order of characters
 * and characters should be separated by commas.</p>
 *
 * Example:
 * <pre>
 * Input:  "programming"
 * Output: "p,o,a,i,n"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires identifying characters that appear
 * exactly once in the string.
 *
 * Naive Approach:
 * <ul>
 *   <li>For every character, scan the entire string to count its occurrences.</li>
 * </ul>
 *
 * This results in:
 *
 * <pre>
 * O(n²)
 * </pre>
 *
 * because for each character we perform another full scan.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use a frequency array to count occurrences of each character.</li>
 *   <li>Then traverse the string again to collect characters with frequency = 1.</li>
 * </ul>
 *
 * This reduces the complexity to linear time.
 *
 * -----------------------------------------------------------------------
 * <b>Frequency Counting Concept (Detailed Explanation):</b>
 *
 * Since the string contains only lowercase letters:
 *
 * <pre>
 * 'a' → index 0
 * 'b' → index 1
 * ...
 * 'z' → index 25
 * </pre>
 *
 * We use an array:
 *
 * <pre>
 * int[] freq = new int[26];
 * </pre>
 *
 * To update frequency:
 *
 * <pre>
 * freq[s.charAt(i) - 'a']++
 * </pre>
 *
 * This allows constant-time updates and lookups.
 *
 * After computing frequencies,
 * we traverse the string again and select characters
 * whose frequency equals 1.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a frequency array of size 26.</li>
 *   <li>Traverse the string and count occurrences.</li>
 *   <li>Create a StringBuilder to store results.</li>
 *   <li>Traverse the string again:</li>
 *   <ul>
 *     <li>If frequency == 1 → append character.</li>
 *   </ul>
 *   <li>Remove trailing comma if present.</li>
 *   <li>Return the resulting string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "programming"
 *
 * Frequencies:
 * p → 1
 * r → 2
 * o → 1
 * g → 2
 * a → 1
 * m → 2
 * i → 1
 * n → 1
 *
 * Non-repeating characters:
 * p,o,a,i,n
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Two linear passes over the string.</li>
 *   <li>Constant-time frequency lookup.</li>
 *   <li>Maintains original order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — fixed array of size 26.
 * -----------------------------------------------------------------------
 */
public class FindNonRepeatingCharacters {

    public static void main(String[] args) {

        String s = "programming";

        String result = findNonRepeatingCharacters(s);

        System.out.println("Non-repeating characters: " + result);
    }

    /**
     * Returns non-repeating characters separated by commas.
     *
     * @param s input string
     * @return string containing non-repeating characters
     */
    public static String findNonRepeatingCharacters(String s) {

        int n = s.length();
        int[] freq = new int[26];

        // Step 1: Count character frequencies
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // Step 2: Collect characters with frequency = 1
        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (freq[c - 'a'] == 1) {
                sb.append(c).append(',');
            }
        }

        // Step 3: Remove trailing comma if present
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}