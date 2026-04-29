/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>An element {@code nums[i]} is called <b>special</b> if:</p>
 *
 * <pre>
 * (i + 1) divides n
 * </pre>
 *
 * where {@code n = nums.length}.
 *
 * <p>Return the sum of squares of all special elements.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2778:
 * Sum of Squares of Special Elements</b></p>
 * <p>🔗 https://leetcode.com/problems/sum-of-squares-of-special-elements/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to:
 *
 * <ul>
 *   <li>Check if index (1-based) divides n</li>
 *   <li>If yes → include square of element</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Key Observation:</b>
 *
 * We use 1-based indexing:
 *
 * <pre>
 * i → 1 to n
 * element → nums[i - 1]
 * </pre>
 *
 * Condition:
 *
 * <pre>
 * n % i == 0
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Divisors Pattern</b>
 *
 * We are effectively iterating over:
 *
 * <pre>
 * all divisors of n
 * </pre>
 *
 * If:
 *
 * <pre>
 * i divides n → include nums[i-1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize total = 0.</li>
 *   <li>Loop i from 1 to n:</li>
 *   <ul>
 *     <li>If n % i == 0:</li>
 *     <ul>
 *       <li>val = nums[i-1]</li>
 *       <li>Add val² to total</li>
 *     </ul>
 *   </ul>
 *   <li>Return total.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 3, 4]
 *
 * n = 4
 *
 * Divisors of 4:
 * 1, 2, 4
 *
 * Values:
 * nums[0] = 1 → 1² = 1
 * nums[1] = 2 → 2² = 4
 * nums[3] = 4 → 4² = 16
 *
 * Output:
 * 1 + 4 + 16 = 21
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Direct mapping from math to code.</li>
 *   <li>Simple iteration.</li>
 *   <li>No extra data structures.</li>
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
public class LeetCode2778_SumOfSquaresOfSpecialElements {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int result = sumOfSquares(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Computes sum of squares of special elements.
     */
    public static int sumOfSquares(int[] nums) {

        int n = nums.length;
        int total = 0;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {

                int val = nums[i - 1];
                total += val * val;
            }
        }

        return total;
    }
}