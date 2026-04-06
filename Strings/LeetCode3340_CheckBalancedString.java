/**
 * Problem:
 * A string {@code num} is called <b>balanced</b> if the sum of digits at
 * even indices is equal to the sum of digits at odd indices.
 *
 * <p>Return {@code true} if the string is balanced, otherwise {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3340:
 * Check Balanced String</b></p>
 * <p>🔗 https://leetcode.com/problems/check-balanced-string/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need:
 *
 * <pre>
 * sum(even indices) == sum(odd indices)
 * </pre>
 *
 * Naive Approach:
 * <ul>
 *   <li>Maintain two variables: evenSum and oddSum.</li>
 *   <li>Compare at the end.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Instead of maintaining two variables, we use a single variable:
 *
 * <pre>
 * balance = evenSum - oddSum
 * </pre>
 *
 * If:
 *
 * <pre>
 * balance == 0 → balanced
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Alternating Sum Pattern</b>
 *
 * We convert:
 *
 * <pre>
 * even index → +digit
 * odd index  → -digit
 * </pre>
 *
 * So:
 *
 * <pre>
 * balance += (i % 2 == 0) ? digit : -digit
 * </pre>
 *
 * This is equivalent to:
 *
 * <pre>
 * (sum of even positions) - (sum of odd positions)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize balance = 0.</li>
 *   <li>Traverse string:</li>
 *   <ul>
 *     <li>Convert character to digit.</li>
 *     <li>Add or subtract based on index parity.</li>
 *   </ul>
 *   <li>Check if balance == 0.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * num = "1210"
 *
 * even indices → 1 + 1 = 2
 * odd indices  → 2 + 0 = 2
 *
 * balance = 2 - 2 = 0
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * num = "1234"
 *
 * even → 1 + 3 = 4
 * odd  → 2 + 4 = 6
 *
 * balance = -2 → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single variable instead of two.</li>
 *   <li>Cleaner and more mathematical.</li>
 *   <li>Single pass solution.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3340_CheckBalancedString {

    public static void main(String[] args) {

        String num = "1210";

        boolean result = isBalanced(num);

        System.out.println("Is Balanced: " + result);
    }

    /**
     * Checks if string is balanced using alternating sum.
     */
    public static boolean isBalanced(String num) {

        int balance = 0;

        for (int i = 0; i < num.length(); i++) {

            int digit = num.charAt(i) - '0';

            // Add for even index, subtract for odd index
            balance += (i % 2 == 0) ? digit : -digit;
        }

        return balance == 0;
    }
}