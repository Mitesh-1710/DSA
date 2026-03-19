/**
 * Problem:
 * Given an integer array {@code nums}, choose two different indices
 * {@code i} and {@code j} such that:
 *
 * <pre>
 * (nums[i] - 1) * (nums[j] - 1)
 * </pre>
 *
 * is maximized.
 *
 * Return the maximum value of the above expression.
 *
 * <p>This is the solution to <b>LeetCode Problem 1464:
 * Maximum Product of Two Elements in an Array</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The expression:
 *
 * <pre>
 * (nums[i] - 1) * (nums[j] - 1)
 * </pre>
 *
 * is maximized when we choose the two largest numbers in the array.
 *
 * Why?
 *
 * Because subtracting 1 does not change the relative order of numbers.
 *
 * Naive Approach:
 * <ul>
 *   <li>Sort the array.</li>
 *   <li>Pick the last two elements.</li>
 * </ul>
 *
 * Time complexity:
 *
 * <pre>
 * O(n log n)
 * </pre>
 *
 * Optimized Approach:
 * <ul>
 *   <li>Traverse the array once.</li>
 *   <li>Keep track of the largest and second largest elements.</li>
 * </ul>
 *
 * This reduces complexity to linear time.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Top-2 Tracking Pattern</b>
 *
 * We maintain two variables:
 *
 * <pre>
 * max        → largest element
 * secondMax  → second largest element
 * </pre>
 *
 * For each number:
 *
 * <ul>
 *   <li>If {@code num >= max}:</li>
 *   <ul>
 *     <li>Update secondMax = max</li>
 *     <li>Update max = num</li>
 *   </ul>
 *
 *   <li>Else if {@code num > secondMax}:</li>
 *   <ul>
 *     <li>Update secondMax = num</li>
 *   </ul>
 * </ul>
 *
 * This ensures we always have the top two elements.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize max and secondMax.</li>
 *   <li>Traverse the array.</li>
 *   <li>Update max and secondMax accordingly.</li>
 *   <li>Return (max - 1) * (secondMax - 1).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [3, 4, 5, 2]
 *
 * Process:
 *
 * max = 5
 * secondMax = 4
 *
 * Result:
 * (5 - 1) * (4 - 1) = 4 * 3 = 12
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * nums = [1, 5, 4, 5]
 *
 * max = 5
 * secondMax = 5
 *
 * Result:
 * (5 - 1) * (5 - 1) = 16
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through the array.</li>
 *   <li>No sorting required.</li>
 *   <li>Constant extra space.</li>
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
public class LeetCode1464_MaximumProductOfTwoElements {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 2};

        int result = maxProduct(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Returns maximum product of (nums[i] - 1) * (nums[j] - 1)
     */
    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num >= max) {

                secondMax = max;
                max = num;

            } else if (num > secondMax) {

                secondMax = num;
            }
        }

        return (max - 1) * (secondMax - 1);
    }
}