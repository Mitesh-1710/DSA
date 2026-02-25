/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Define:</p>
 * <ul>
 *   <li><b>Element Sum</b> → Sum of all elements in the array.</li>
 *   <li><b>Digit Sum</b> → Sum of all digits of every element.</li>
 * </ul>
 *
 * <p>Return the absolute difference between the element sum
 * and the digit sum.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2535:
 * Difference Between Element Sum and Digit Sum of an Array</b></p>
 * <p>🔗 https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task requires computing two quantities:</p>
 *
 * <ul>
 *   <li>Sum of array elements.</li>
 *   <li>Sum of digits of each element.</li>
 * </ul>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Compute element sum in one loop.</li>
 *   <li>Compute digit sum in another loop.</li>
 * </ul>
 *
 * <p>This works but requires two passes.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Compute both sums in a single traversal.</li>
 *   <li>For each number, accumulate element sum and extract digits immediately.</li>
 * </ul>
 *
 * <p>This keeps the solution concise and efficient.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Digit Extraction Concept (Detailed Explanation):</b>
 *
 * <p>To extract digits from a number:</p>
 *
 * <ul>
 *   <li>{@code x % 10} → gives last digit.</li>
 *   <li>{@code x /= 10} → removes last digit.</li>
 * </ul>
 *
 * <p>We repeatedly apply this until the number becomes zero.</p>
 *
 * <p>This ensures every digit of every element
 * contributes to the digit sum.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize {@code elementSum = 0} and {@code digitSum = 0}.</li>
 *   <li>Traverse each number in array:</li>
 *   <ul>
 *     <li>Add number to elementSum.</li>
 *     <li>Extract its digits and add to digitSum.</li>
 *   </ul>
 *   <li>Return absolute difference between the two sums.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [1, 15, 6, 3]
 *
 * Element Sum:
 * 1 + 15 + 6 + 3 = 25
 *
 * Digit Sum:
 * 1
 * 1 + 5
 * 6
 * 3
 * → Total = 16
 *
 * Difference:
 * |25 - 16| = 9
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over the array.</li>
 *   <li>No extra data structures required.</li>
 *   <li>Efficient digit extraction using arithmetic.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n * d), where:
 * <ul>
 *   <li>{@code n} = number of elements</li>
 *   <li>{@code d} = number of digits per element</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode2535_DifferenceBetweenElementSumAndDigitSumOfArray {

    public static void main(String[] args) {

        int[] nums = {1, 15, 6, 3};

        int result = differenceOfSum(nums);

        System.out.println("Difference: " + result);
    }

    /**
     * Returns absolute difference between element sum and digit sum.
     *
     * @param nums input array
     * @return absolute difference
     */
    public static int differenceOfSum(int[] nums) {

        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {

            // Add to element sum
            elementSum += num;

            // Extract digits and add to digit sum
            for (int x = num; x > 0; x /= 10) {
                digitSum += x % 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}