/**
 * Problem:
 * You are given a binary string {@code s}.
 *
 * <p>Return the <b>maximum odd binary number</b> that can be formed
 * by rearranging the bits of {@code s}.</p>
 *
 * <p>A binary number is odd if its last bit is '1'.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2864:
 * Maximum Odd Binary Number</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-odd-binary-number/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * To form the <b>maximum</b> binary number:
 *
 * <ul>
 *   <li>We want as many '1's as possible at the left (higher significance).</li>
 * </ul>
 *
 * To ensure the number is <b>odd</b>:
 *
 * <ul>
 *   <li>The last bit must be '1'.</li>
 * </ul>
 *
 * So the strategy becomes:
 *
 * <ul>
 *   <li>Reserve one '1' for the last position.</li>
 *   <li>Place remaining '1's at the beginning.</li>
 *   <li>Fill the rest with '0's.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Greedy Placement</b>
 *
 * Key Observations:
 *
 * <ul>
 *   <li>Binary number value depends on leftmost bits.</li>
 *   <li>More leading '1's → larger number.</li>
 *   <li>Last bit must be '1' to ensure odd.</li>
 * </ul>
 *
 * So optimal arrangement:
 *
 * <pre>
 * [all remaining '1's][all '0's]['1']
 * </pre>
 *
 * Example:
 *
 * <pre>
 * s = "0101"
 *
 * count(1) = 2
 *
 * Result:
 * "10" + "0" + "1" → "1001"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Count number of '1's in the string.</li>
 *   <li>Place one '1' at the last index.</li>
 *   <li>Fill from left with remaining '1's.</li>
 *   <li>Fill remaining positions with '0's.</li>
 *   <li>Return the constructed string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "0101"
 *
 * count = 2
 *
 * Last position → '1'
 * Remaining ones = 1
 *
 * Result:
 * "1001"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * s = "1110"
 *
 * Output:
 * "1101"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Greedy placement ensures maximum value.</li>
 *   <li>Single pass counting.</li>
 *   <li>Linear construction.</li>
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
public class LeetCode2864_MaximumOddBinaryNumber {

    public static void main(String[] args) {

        String s = "0101";

        String result = maximumOddBinaryNumber(s);

        System.out.println("Result: " + result);
    }

    /**
     * Constructs maximum odd binary number.
     */
    public static String maximumOddBinaryNumber(String s) {

        char[] arr = new char[s.length()];
        int count = 0;

        // Count number of '1's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        // Place one '1' at the last position (to make number odd)
        arr[arr.length - 1] = '1';
        count--;

        // Fill remaining positions
        for (int i = 0; i < arr.length - 1; i++) {

            // Place '1's first, then '0's
            arr[i] = count-- > 0 ? '1' : '0';
        }

        return new String(arr);
    }
}