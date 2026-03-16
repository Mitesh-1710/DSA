/**
 * Problem:
 * A number {@code x} is called a <b>Harshad Number</b> (or Niven number)
 * if it is divisible by the sum of its digits.
 *
 * <p>Given an integer {@code x}, compute the sum of its digits and
 * check whether {@code x} is divisible by this sum.</p>
 *
 * <p>If {@code x} is a Harshad number, return the sum of its digits;
 * otherwise return {@code -1}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3099:
 * Harshad Number</b></p>
 * <p>🔗 https://leetcode.com/problems/harshad-number/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The definition of a Harshad number directly suggests two steps:
 *
 * <ul>
 *   <li>Compute the sum of the digits of the number.</li>
 *   <li>Check if the original number is divisible by this sum.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert the number into a string.</li>
 *   <li>Extract each character and convert it back to an integer.</li>
 *   <li>Sum the digits and perform the divisibility check.</li>
 * </ul>
 *
 * Although correct, converting the number to a string is unnecessary.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Extract digits using arithmetic operations.</li>
 *   <li>Use modulo (%) to obtain the last digit.</li>
 *   <li>Use division (/) to remove the last digit.</li>
 * </ul>
 *
 * This avoids extra memory allocation and processes digits directly.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Digit Extraction Pattern</b>
 *
 * Digits of a number can be extracted using:
 *
 * <pre>
 * digit = n % 10
 * </pre>
 *
 * which gives the last digit.
 *
 * To remove the last digit:
 *
 * <pre>
 * n = n / 10
 * </pre>
 *
 * Repeating this process allows us to process all digits.
 *
 * Example:
 *
 * <pre>
 * x = 18
 *
 * digit = 18 % 10 = 8
 * remaining = 1
 *
 * digit = 1 % 10 = 1
 *
 * sum = 8 + 1 = 9
 * </pre>
 *
 * Since:
 *
 * <pre>
 * 18 % 9 = 0
 * </pre>
 *
 * 18 is a Harshad number.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize digit sum to 0.</li>
 *   <li>Traverse digits using modulo and division.</li>
 *   <li>Add each digit to the running sum.</li>
 *   <li>After computing the sum, check if {@code x % sum == 0}.</li>
 *   <li>If divisible → return the sum.</li>
 *   <li>Otherwise → return -1.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * x = 18
 *
 * Digit sum:
 * 1 + 8 = 9
 *
 * Check:
 * 18 % 9 = 0
 *
 * Output:
 * 9
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * x = 19
 *
 * Digit sum:
 * 1 + 9 = 10
 *
 * Check:
 * 19 % 10 ≠ 0
 *
 * Output:
 * -1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Processes digits directly using arithmetic operations.</li>
 *   <li>Single traversal of the number.</li>
 *   <li>No extra memory allocations.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is the number of digits in {@code x}.
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode3099_HarshadNumber {

    public static void main(String[] args) {

        int x = 18;

        int result = sumOfTheDigitsOfHarshadNumber(x);

        System.out.println("Result: " + result);
    }

    /**
     * Returns the digit sum if the number is a Harshad number,
     * otherwise returns -1.
     */
    public static int sumOfTheDigitsOfHarshadNumber(int x) {

        int sum = 0;

        // Extract digits and compute their sum
        for (int n = x; n > 0; n /= 10) {
            sum += n % 10;
        }

        // Check Harshad condition
        return (sum != 0 && x % sum == 0) ? sum : -1;
    }
}