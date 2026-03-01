/**
 * Problem:
 * You are given:
 * <ul>
 *   <li>An array of strings {@code words}.</li>
 *   <li>An integer array {@code weights} of size 26,
 *       where weights[i] represents the weight of character
 *       ('a' + i).</li>
 * </ul>
 *
 * <p>For each word:</p>
 * <ul>
 *   <li>Compute the total weight of the word by summing
 *       the weights of its characters.</li>
 *   <li>Let {@code mappedChar = (char) ('z' - (sum % 26))}.</li>
 * </ul>
 *
 * <p>Return the string formed by concatenating all mapped characters.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3838:
 * Weighted Word Mapping</b></p>
 * <p>🔗 https://leetcode.com/problems/weighted-word-mapping/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * For each word, we must:
 * <ul>
 *   <li>Calculate a cumulative weight.</li>
 *   <li>Transform that weight into a character using modulo arithmetic.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>For each word, for each character, search for its weight
 *       by scanning an array or map.</li>
 * </ul>
 *
 * This would add unnecessary overhead.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Since weights correspond directly to letters 'a' to 'z',
 *       we can access weight in O(1) using:
 *       weights[char - 'a']</li>
 *   <li>Compute sum efficiently.</li>
 *   <li>Use modulo operation to map into 0–25 range.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Character Weight Mapping Concept (Detailed Explanation):</b>
 *
 * Each character:
 *
 * <pre>
 * 'a' → index 0
 * 'b' → index 1
 * ...
 * 'z' → index 25
 * </pre>
 *
 * So weight retrieval is:
 *
 * <pre>
 * weights[word.charAt(i) - 'a']
 * </pre>
 *
 * After computing sum:
 *
 * <pre>
 * sum % 26
 * </pre>
 *
 * ensures the result fits within alphabet size.
 *
 * The final mapping:
 *
 * <pre>
 * 'z' - (sum % 26)
 * </pre>
 *
 * reverses the alphabet direction.
 *
 * Example:
 *
 * If sum % 26 = 0 → result = 'z'
 * If sum % 26 = 1 → result = 'y'
 *
 * This effectively mirrors the alphabet.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a result character array of size words.length.</li>
 *   <li>For each word:</li>
 *   <ul>
 *     <li>Initialize sum = 0.</li>
 *     <li>Accumulate weights of each character.</li>
 *     <li>Compute mapped character using ('z' - (sum % 26)).</li>
 *   </ul>
 *   <li>Return new string from result array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * words = ["abc", "a"]
 * weights = [1,2,3,...]
 *
 * For "abc":
 * sum = weight[a] + weight[b] + weight[c]
 *     = 1 + 2 + 3 = 6
 * sum % 26 = 6
 * mapped = 'z' - 6 = 't'
 *
 * For "a":
 * sum = 1
 * sum % 26 = 1
 * mapped = 'z' - 1 = 'y'
 *
 * Output: "ty"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Constant-time weight lookup.</li>
 *   <li>Single traversal per word.</li>
 *   <li>Efficient modulo arithmetic for mapping.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(total characters in all words).<br>
 *
 * <b>Space Complexity:</b>
 * O(w), where {@code w} is number of words (for result array).
 * -----------------------------------------------------------------------
 */
public class LeetCode3838_WeightedWordMapping {

    public static void main(String[] args) {

        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};

        String result = mapWordWeights(words, weights);

        System.out.println("Mapped string: " + result);
    }

    /**
     * Maps each word to a character based on cumulative weights.
     *
     * @param words   array of words
     * @param weights weight mapping for characters a-z
     * @return resulting mapped string
     */
    public static String mapWordWeights(String[] words, int[] weights) {

        char[] result = new char[words.length];
        int idx = 0;

        for (String word : words) {

            int sum = 0;

            // Calculate cumulative weight of the word
            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }

            // Map sum to reversed alphabet character
            result[idx++] = (char) ('z' - (sum % 26));
        }

        return new String(result);
    }
}