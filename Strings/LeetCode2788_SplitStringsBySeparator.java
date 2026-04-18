import java.util.List;
import java.util.ArrayList;

/**
 * Problem:
 * You are given a list of strings {@code words} and a character {@code separator}.
 *
 * <p>Split each string in {@code words} by the separator and return all
 * resulting substrings, excluding empty strings.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2788:
 * Split Strings by Separator</b></p>
 * <p>🔗 https://leetcode.com/problems/split-strings-by-separator/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * For each word:
 *
 * <ul>
 *   <li>Identify segments separated by {@code separator}</li>
 *   <li>Ignore empty substrings</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Use {@code String.split()}</li>
 * </ul>
 *
 * Issues:
 *
 * <ul>
 *   <li>Uses regex → slower</li>
 *   <li>Creates unnecessary intermediate arrays</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use manual parsing with two pointers:
 *
 * <pre>
 * start → beginning of current substring
 * i     → current index
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Sliding Window Parsing</b>
 *
 * We maintain a window:
 *
 * <pre>
 * [start, i)
 * </pre>
 *
 * When we hit:
 *
 * <ul>
 *   <li>separator OR end of string</li>
 * </ul>
 *
 * we extract substring:
 *
 * <pre>
 * word.substring(start, i)
 * </pre>
 *
 * Only if:
 *
 * <pre>
 * start < i  (to avoid empty strings)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize result list.</li>
 *   <li>For each word:</li>
 *   <ul>
 *     <li>Set start = 0</li>
 *     <li>Traverse characters</li>
 *     <li>If separator or end reached:</li>
 *     <ul>
 *       <li>Add substring if non-empty</li>
 *       <li>Move start to next position</li>
 *     </ul>
 *   </ul>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * words = ["one.two", "three"]
 * separator = '.'
 *
 * Process:
 * "one.two" → ["one", "two"]
 * "three"   → ["three"]
 *
 * Output:
 * ["one", "two", "three"]
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * words = ["a..b"]
 *
 * Output:
 * ["a", "b"]   (empty skipped)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids regex overhead.</li>
 *   <li>No unnecessary intermediate arrays.</li>
 *   <li>Precise control over empty substrings.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(total characters across all words)
 *
 * <b>Space Complexity:</b>
 * O(output size)
 * -----------------------------------------------------------------------
 */
public class LeetCode2788_SplitStringsBySeparator {

    public static void main(String[] args) {

        List<String> words = List.of("one.two", "three");

        List<String> result = splitWordsBySeparator(words, '.');

        System.out.println("Result: " + result);
    }

    /**
     * Splits words manually using two-pointer parsing.
     */
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            int start = 0;

            for (int i = 0; i <= word.length(); i++) {

                // If separator OR end of string
                if (i == word.length() || word.charAt(i) == separator) {

                    // Avoid empty substrings
                    if (start < i) {
                        result.add(word.substring(start, i));
                    }

                    start = i + 1;
                }
            }
        }

        return result;
    }
}