/**
 * Problem:
 * Given an integer {@code n}, calculate the difference between the
 * <b>product of its digits</b> and the <b>sum of its digits</b>.
 *
 * <p>Return the value:</p>
 * <pre>
 * (product of digits) - (sum of digits)
 * </pre>
 *
 * <p>This is the solution to <b>LeetCode Problem 1281: Subtract the Product and Sum of Digits of an Integer</b></p>
 * <p>🔗 https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem requires extracting individual digits from a number
 * and performing two independent calculations:</p>
 *
 * <ul>
 *   <li>The sum of all digits.</li>
 *   <li>The product of all digits.</li>
 * </ul>
 *
 * <p>A naive approach might involve converting the number to a string,
 * but this is unnecessary.</p>
 *
 * <p>Instead, we can process the digits mathematically using
 * modulo and division operations.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Digit Extraction Concept:</b>
 *
 * <p>To process digits from right to left:</p>
 *
 * <ul>
 *   <li>{@code n % 10} gives the last digit.</li>
 *   <li>{@code n / 10} removes the last digit.</li>
 * </ul>
 *
 * <p>Repeating this until {@code n == 0} allows us to traverse
 * all digits of the number.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize {@code sum = 0} and {@code product = 1}.</li>
 *   <li>While {@code n} is not zero:</li>
 *   <ul>
 *     <li>Extract the last digit.</li>
 *     <li>Add the digit to {@code sum}.</li>
 *     <li>Multiply the digit with {@code product}.</li>
 *     <li>Remove the last digit from {@code n}.</li>
 *   </ul>
 *   <li>Return {@code product - sum}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 234
 *
 * Digits:
 * 2, 3, 4
 *
 * Sum     = 2 + 3 + 4 = 9
 * Product = 2 * 3 * 4 = 24
 *
 * Result:
 * 24 - 9 = 15
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No extra memory allocation.</li>
 *   <li>Pure mathematical digit processing.</li>
 *   <li>Linear time relative to number of digits.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is the number of digits in {@code n}.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode1281_SubtractProductAndSumOfDigits {

    public static void main(String[] args) {

        int n = 234;

        int result = subtractProductAndSum(n);

        System.out.println("Result: " + result);
    }

    /**
     * Returns the difference between the product of digits
     * and the sum of digits of the given integer.
     *
     * @param n input number
     * @return product of digits minus sum of digits
     */
    public static int subtractProductAndSum(int n) {

        int sum = 0;
        int prod = 1;

        while (n != 0) {
            int digit = n % 10;
            n /= 10;

            sum += digit;
            prod *= digit;
        }

        return prod - sum;
    }
}