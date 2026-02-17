/**
 * Problem:
 * Given an integer {@code num}, return the number of digits in {@code num}
 * that divide {@code num} evenly.
 *
 * <p>A digit {@code d} divides {@code num} if:</p>
 * <pre>
 * num % d == 0
 * </pre>
 *
 * <p>Digits are considered individually, and zero digits are ignored
 * since division by zero is undefined.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2520:
 * Count the Digits That Divide a Number</b></p>
 * <p>🔗 https://leetcode.com/problems/count-the-digits-that-divide-a-number/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task requires checking each digit of the number to determine
 * whether it divides the original number evenly.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Convert the number to a string.</li>
 *   <li>Iterate through each character, convert to digit, and check divisibility.</li>
 * </ul>
 *
 * <p>This works but involves unnecessary string conversion.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Extract digits mathematically using modulo and division.</li>
 *   <li>Keep a copy of the original number for digit extraction.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Digit Extraction Concept (Detailed Explanation):</b>
 *
 * <p>To process digits from right to left:</p>
 * <ul>
 *   <li>{@code copy % 10} gives the last digit.</li>
 *   <li>{@code copy /= 10} removes the last digit.</li>
 * </ul>
 *
 * <p>For each extracted digit:</p>
 * <ul>
 *   <li>Check if it is non-zero.</li>
 *   <li>Verify {@code num % digit == 0}.</li>
 * </ul>
 *
 * <p>If both conditions hold, increment the counter.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Store original number in a variable {@code num}.</li>
 *   <li>Create a copy for digit traversal.</li>
 *   <li>While copy is not zero:</li>
 *   <ul>
 *     <li>Extract last digit.</li>
 *     <li>If digit ≠ 0 and divides {@code num}, increment count.</li>
 *     <li>Remove last digit from copy.</li>
 *   </ul>
 *   <li>Return the count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * num = 1248
 *
 * Digits:
 * 8 → 1248 % 8 == 0 ✓
 * 4 → 1248 % 4 == 0 ✓
 * 2 → 1248 % 2 == 0 ✓
 * 1 → 1248 % 1 == 0 ✓
 *
 * Output:
 * 4
 * </pre>
 *
 * Another example:
 *
 * num = 121
 *
 * Digits:
 * 1 → divides ✓
 * 2 → 121 % 2 != 0 ✗
 * 1 → divides ✓
 *
 * Output:
 * 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No string conversion required.</li>
 *   <li>Single pass through digits.</li>
 *   <li>Constant extra space.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is the number of digits in {@code num}.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode2520_CountTheDigitsThatDivideANumber {

    public static void main(String[] args) {

        int num = 1248;

        int result = countDigits(num);

        System.out.println("Count of dividing digits: " + result);
    }

    /**
     * Returns the count of digits that divide the number evenly.
     *
     * @param num input number
     * @return number of digits dividing num
     */
    public static int countDigits(int num) {

        int copy = num;
        int count = 0;

        while (copy != 0) {

            int digit = copy % 10; // Extract last digit

            // Ensure digit is non-zero and divides num
            if (digit != 0 && num % digit == 0) {
                count++;
            }

            copy /= 10; // Remove last digit
        }

        return count;
    }
}