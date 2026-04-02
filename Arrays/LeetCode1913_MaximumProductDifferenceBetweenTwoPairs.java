/**
 * Problem:
 * Given an integer array {@code nums}, choose four distinct indices
 * {@code a, b, c, d} such that:
 *
 * <pre>
 * (nums[a] * nums[b]) - (nums[c] * nums[d])
 * </pre>
 *
 * is maximized.
 *
 * <p>Return the maximum value of this expression.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1913:
 * Maximum Product Difference Between Two Pairs</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-product-difference-between-two-pairs/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to maximize:
 *
 * <pre>
 * (largest product) - (smallest product)
 * </pre>
 *
 * So:
 *
 * <ul>
 *   <li>Pick two largest numbers → maximize product</li>
 *   <li>Pick two smallest numbers → minimize product</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Sort the array.</li>
 *   <li>Pick last two and first two elements.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n log n)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Traverse array once.</li>
 *   <li>Track:</li>
 *   <ul>
 *     <li>max1, max2 → two largest</li>
 *     <li>min1, min2 → two smallest</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Greedy + Top/Bottom Tracking</b>
 *
 * During traversal:
 *
 * <pre>
 * max1 ≥ max2
 * min1 ≤ min2
 * </pre>
 *
 * For each element:
 *
 * 1. Update largest values:
 *
 * <ul>
 *   <li>If n ≥ max1 → shift max1 → max2</li>
 *   <li>Else if n > max2 → update max2</li>
 * </ul>
 *
 * 2️. Update smallest values:
 *
 * <ul>
 *   <li>If n ≤ min1 → shift min1 → min2</li>
 *   <li>Else if n < min2 → update min2</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize max1, max2 and min1, min2.</li>
 *   <li>Traverse array once.</li>
 *   <li>Update four variables accordingly.</li>
 *   <li>Return (max1 * max2) - (min1 * min2).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [5, 6, 2, 7, 4]
 *
 * max1 = 7, max2 = 6
 * min1 = 2, min2 = 4
 *
 * Result:
 * (7 * 6) - (2 * 4) = 42 - 8 = 34
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>No sorting required.</li>
 *   <li>Greedy selection ensures optimal result.</li>
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
public class LeetCode1913_MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {

        int[] nums = {5, 6, 2, 7, 4};

        int result = maxProductDifference(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Returns maximum product difference.
     */
    public static int maxProductDifference(int[] nums) {

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int n : nums) {

            // Update largest values
            if (n >= max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }

            // Update smallest values
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }
}