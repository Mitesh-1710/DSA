/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Replace every element in the array with the sum of its digits.
 * Return the minimum value among the replaced elements.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3300:
 * Minimum Element After Replacement With Digit Sum</b></p>
 * <p>🔗 https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires:
 * <ul>
 *   <li>Replacing each number with its digit sum.</li>
 *   <li>Finding the minimum among those values.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>Create a new array storing digit sums.</li>
 *   <li>Traverse that array to find minimum.</li>
 * </ul>
 *
 * This works but uses unnecessary extra space.
 *
 * Optimized Approach:
 * <ul>
 *   <li>For each number, compute digit sum.</li>
 *   <li>Track minimum immediately.</li>
 * </ul>
 *
 * This avoids storing intermediate results.
 *
 * -----------------------------------------------------------------------
 * <b>Digit Sum Concept (Detailed Explanation):</b>
 *
 * To compute the digit sum of a number:
 *
 * <ul>
 *   <li>{@code n % 10} gives the last digit.</li>
 *   <li>{@code n /= 10} removes the last digit.</li>
 * </ul>
 *
 * Repeat until the number becomes zero.
 *
 * This extracts every digit exactly once.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize {@code min = Integer.MAX_VALUE}.</li>
 *   <li>For each number in {@code nums}:</li>
 *   <ul>
 *     <li>Compute digit sum.</li>
 *     <li>Update minimum if needed.</li>
 *   </ul>
 *   <li>Return minimum.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [10, 12, 13, 14]
 *
 * Digit sums:
 * 10 → 1
 * 12 → 3
 * 13 → 4
 * 14 → 5
 *
 * Minimum = 1
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * nums = [99, 18]
 *
 * Digit sums:
 * 99 → 18
 * 18 → 9
 *
 * Minimum = 9
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over array.</li>
 *   <li>Constant extra space.</li>
 *   <li>Efficient digit extraction using arithmetic.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n * d), where:
 * <ul>
 *   <li>{@code n} = number of elements</li>
 *   <li>{@code d} = number of digits per number</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode3300_MinimumElementAfterReplacementWithDigitSum {

    public static void main(String[] args) {

        int[] nums = {10, 12, 13, 14};

        int result = minElement(nums);

        System.out.println("Minimum digit sum: " + result);
    }

    /**
     * Returns the minimum value after replacing each element
     * with its digit sum.
     *
     * @param nums input array
     * @return minimum digit sum
     */
    public static int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int n : nums) {

            int sum = 0;

            // Compute digit sum
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            // Update minimum
            if (min > sum) {
                min = sum;
            }
        }

        return min;
    }
}