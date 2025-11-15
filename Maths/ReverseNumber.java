/**
 * Problem:
 * Given an integer {@code n}, return the number obtained by reversing its digits.
 *
 * <p>The sign of the number should be preserved. Only the digits are reversed.
 *
 * <p>Examples:
 * <ul>
 *   <li>n = 0       → Output: 0</li>
 *   <li>n = 5       → Output: 5</li>
 *   <li>n = 123     → Output: 321</li>
 *   <li>n = -987    → Output: -789</li>
 *   <li>n = 1002    → Output: 2001</li>
 * </ul>
 *
 * <p><b>Core Logic:</b></p>
 * <ul>
 *   <li>Use {@code n % 10} to extract the last digit.</li>
 *   <li>Build the reversed number by multiplying the current result by 10 and adding the extracted digit.</li>
 *   <li>Use {@code n / 10} to remove the last digit from the original number.</li>
 *   <li>If the number is negative, process its absolute value and reapply the sign at the end.</li>
 * </ul>
 *
 * <p><b>Example Walkthrough:</b></p>
 * <pre>
 * n = 245
 *
 * Iteration 1: digit = 245 % 10 = 5
 *              reversed = 0 * 10 + 5 = 5
 *              n = 245 / 10 = 24
 *
 * Iteration 2: digit = 24 % 10 = 4
 *              reversed = 5 * 10 + 4 = 54
 *              n = 24 / 10 = 2
 *
 * Iteration 3: digit = 2 % 10 = 2
 *              reversed = 54 * 10 + 2 = 542
 *              n = 2 / 10 = 0
 *
 * Final answer = 542
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(log₁₀(n)) — proportional to the number of digits.<br>
 * <b>Space Complexity:</b> O(1) — uses constant space.</p>
 */
public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println("Reverse of 0: " + reverse(0));
        System.out.println("Reverse of 7: " + reverse(7));
        System.out.println("Reverse of 1234: " + reverse(1234));
        System.out.println("Reverse of -987: " + reverse(-987));
        System.out.println("Reverse of 1002: " + reverse(1002));
    }

    /**
     * Returns the reverse of the given integer {@code n}.
     *
     * <p>The sign of the number is preserved. Only digits are reversed.</p>
     *
     * @param n the integer to be reversed
     * @return the reversed number
     */
    public static int reverse(int n) {

        // Track the sign and convert to positive for processing
        boolean isNegative = n < 0;
        n = Math.abs(n);

        int reversed = 0;

        // Extract digits and build reversed number
        while (n > 0) {
            int digit = n % 10;             // Extract last digit
            reversed = reversed * 10 + digit;  // Append digit to reversed number
            n = n / 10;                     // Remove last digit
        }

        // Restore sign if original number was negative
        return isNegative ? -reversed : reversed;
    }
}