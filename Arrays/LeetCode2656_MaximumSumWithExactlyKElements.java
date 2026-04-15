/**
 * Problem:
 * You are given an integer array {@code nums} and an integer {@code k}.
 *
 * <p>You can perform the following operation exactly {@code k} times:</p>
 *
 * <ul>
 *   <li>Choose the maximum element from the array.</li>
 *   <li>Add it to your score.</li>
 *   <li>Increase that element by 1.</li>
 * </ul>
 *
 * <p>Return the maximum possible score.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2656:
 * Maximum Sum With Exactly K Elements</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * At every step:
 *
 * <ul>
 *   <li>You always pick the current maximum element.</li>
 *   <li>After picking, it increases by 1 → remains the maximum.</li>
 * </ul>
 *
 * So effectively:
 *
 * <pre>
 * sequence = max, max+1, max+2, ..., max+(k-1)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Repeat k times:</li>
 *   <li>Find max → O(n)</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n * k)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Recognize pattern:
 *
 * <pre>
 * sum = max + (max+1) + (max+2) + ... + (max+k-1)
 * </pre>
 *
 * This is an Arithmetic Progression (AP).
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Arithmetic Progression</b>
 *
 * General AP formula:
 *
 * <pre>
 * Sum = n/2 * (2a + (n-1)d)
 * </pre>
 *
 * Here:
 *
 * <ul>
 *   <li>a = max</li>
 *   <li>d = 1</li>
 *   <li>n = k</li>
 * </ul>
 *
 * So:
 *
 * <pre>
 * Sum = k * max + k*(k-1)/2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Find maximum element in array.</li>
 *   <li>Apply AP formula.</li>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 3, 4, 5]
 * k = 3
 *
 * max = 5
 *
 * sequence:
 * 5 + 6 + 7 = 18
 *
 * Formula:
 * 3*5 + 3*(3-1)/2 = 15 + 3 = 18
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids simulation.</li>
 *   <li>Uses direct math formula.</li>
 *   <li>Constant-time calculation after finding max.</li>
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
public class LeetCode2656_MaximumSumWithExactlyKElements {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        int result = maximizeSum(nums, k);

        System.out.println("Result: " + result);
    }

    /**
     * Computes maximum sum using AP formula.
     */
    public static int maximizeSum(int[] nums, int k) {

        int max = nums[0];

        // Find maximum element
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }

        // Apply AP formula
        return k * max + k * (k - 1) / 2;
    }
}