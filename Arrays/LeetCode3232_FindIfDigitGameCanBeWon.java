/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Alice and Bob play a game where numbers are divided into two groups:</p>
 *
 * <ul>
 *   <li>Single-digit numbers (n < 10)</li>
 *   <li>Double-digit numbers (n ≥ 10)</li>
 * </ul>
 *
 * <p>Alice wins if the sum of one group is different from the sum
 * of the other group.</p>
 *
 * <p>Return {@code true} if Alice can win, otherwise {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3232:
 * Find if Digit Game Can Be Won</b></p>
 * <p>🔗 https://leetcode.com/problems/find-if-digit-game-can-be-won/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to compare:
 *
 * <pre>
 * sum(single-digit numbers) vs sum(double-digit numbers)
 * </pre>
 *
 * If they are equal → Alice loses
 * If they are different → Alice wins
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Maintain two sums.</li>
 *   <li>Compare at the end.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use a single variable:
 *
 * <pre>
 * diff = sum(single-digit) - sum(double-digit)
 * </pre>
 *
 * If:
 *
 * <pre>
 * diff != 0 → Alice wins
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Difference / Invariant Pattern</b>
 *
 * Instead of tracking:
 *
 * <pre>
 * sumA and sumB
 * </pre>
 *
 * we collapse into:
 *
 * <pre>
 * diff += value (if single-digit)
 * diff -= value (if double-digit)
 * </pre>
 *
 * Final condition:
 *
 * <pre>
 * diff == 0 → balanced → Alice loses
 * diff != 0 → imbalance → Alice wins
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize diff = 0.</li>
 *   <li>Traverse array:</li>
 *   <ul>
 *     <li>If n < 10 → add to diff.</li>
 *     <li>Else → subtract from diff.</li>
 *   </ul>
 *   <li>Return diff != 0.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 12]
 *
 * single-digit sum = 1 + 2 = 3
 * double-digit sum = 12
 *
 * diff = 3 - 12 = -9
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * nums = [5, 5, 10]
 *
 * single = 10
 * double = 10
 *
 * diff = 0 → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>Uses one variable instead of two.</li>
 *   <li>Mathematical simplification.</li>
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
public class LeetCode3232_FindIfDigitGameCanBeWon {

    public static void main(String[] args) {

        int[] nums = {1, 2, 12};

        boolean result = canAliceWin(nums);

        System.out.println("Can Alice Win: " + result);
    }

    /**
     * Determines if Alice can win using difference tracking.
     */
    public static boolean canAliceWin(int[] nums) {

        int diff = 0;

        for (int n : nums) {

            // Add single-digit numbers, subtract double-digit numbers
            diff += (n < 10) ? n : -n;
        }

        return diff != 0;
    }
}