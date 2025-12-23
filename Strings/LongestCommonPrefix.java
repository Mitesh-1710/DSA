import java.util.Arrays;

/**
 * Problem:
 * Given an array of strings, find the <b>longest common prefix</b> shared by all strings.
 * If there is no common prefix, return an empty string {@code ""}.
 *
 * <p>A prefix is a substring that appears at the beginning of each string.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key observation is based on <b>lexicographical ordering</b>:</p>
 *
 * <ul>
 *   <li>If all strings share a common prefix, then:</li>
 *   <li>The <b>first</b> and <b>last</b> strings after sorting will differ the most.</li>
 *   <li>Any mismatch between them immediately breaks the common prefix.</li>
 * </ul>
 *
 * <p><b>Core Strategy:</b></p>
 * <ul>
 *   <li>Sort the string array lexicographically.</li>
 *   <li>Compare characters of:
 *     <ul>
 *       <li>First string (smallest)</li>
 *       <li>Last string (largest)</li>
 *     </ul>
 *   </li>
 *   <li>Accumulate characters until a mismatch occurs.</li>
 * </ul>
 *
 * <p>This works because any prefix common to all strings must also be
 * common to the smallest and largest strings.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * Input: ["flower", "flow", "flight"]
 *
 * After sorting:
 * ["flight", "flow", "flower"]
 *
 * Compare:
 * f == f → prefix = "f"
 * l == l → prefix = "fl"
 * i != o → stop
 *
 * Output = "fl"
 * </pre>
 *
 * <p>Another example:</p>
 * <pre>
 * Input: ["dog", "racecar", "car"]
 * After sorting: ["car", "dog", "racecar"]
 * First char mismatch → Output = ""
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 * <ul>
 *   <li>Empty array → return empty string</li>
 *   <li>Single string → return that string</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Sorting: O(n log n)</li>
 *   <li>Prefix comparison: O(m)</li>
 * </ul>
 * Overall: O(n log n), where <b>n</b> = number of strings,
 * <b>m</b> = length of shortest string.
 *
 * <b>Space Complexity:</b> O(1) (ignoring sorting internals).
 * -----------------------------------------------------------------------
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] a1 = {"flower", "flow", "flight"};
        String[] a2 = {"dog", "racecar", "car"};
        String[] a3 = {"interview", "internet", "internal"};

        System.out.println("1. LCP: " + longestCommonPrefix(a1));
        System.out.println("\n2. LCP: " + longestCommonPrefix(a2));
        System.out.println("\n3. LCP: " + longestCommonPrefix(a3));
    }

    /**
     * Returns the longest common prefix among all strings in the array.
     *
     * @param s array of input strings
     * @return longest common prefix or empty string if none exists
     */
    public static String longestCommonPrefix(String[] s) {

        // Defensive checks
        if (s == null || s.length == 0) return "";
        if (s.length == 1) return s[0];

        // Sort strings lexicographically
        Arrays.sort(s);

        // Compare only the first and last strings
        String first = s[0];
        String last = s[s.length - 1];

        StringBuilder prefix = new StringBuilder();

        // Compare character by character
        for (int i = 0; i < first.length(); i++) {

            // Stop at first mismatch
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }

            // Append matching character
            prefix.append(first.charAt(i));
        }

        return prefix.toString();
    }
}