/**
 * Problem:
 * Given an integer {@code n}, return the total number of digits in the number.
 *
 * <p>The number will not contain leading zeroes, except when the number itself is {@code 0}.
 * Examples:
 * <ul>
 *   <li>n = 0      → Output: 1</li>
 *   <li>n = 5      → Output: 1</li>
 *   <li>n = 123    → Output: 3</li>
 *   <li>n = 9901   → Output: 4</li>
 * </ul>
 *
 * <p><b>Core Logic:</b></p>
 * <ul>
 *   <li>Every division by 10 removes the last digit of a number.</li>
 *   <li>The count of such divisions before the number becomes 0 equals the number of digits.</li>
 *   <li>Special case: {@code n = 0} should return 1.</li>
 * </ul>
 *
 * <p><b>Example Walkthrough:</b></p>
 * <pre>
 * n = 245
 *
 * Iteration 1: 245 / 10 → 24   (count = 1)
 * Iteration 2:  24 / 10 →  2   (count = 2)
 * Iteration 3:   2 / 10 →  0   (count = 3)
 *
 * Final answer = 3 digits
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(log₁₀(n)) — proportional to the number of digits.<br>
 * <b>Space Complexity:</b> O(1) — no additional space used.</p>
 */
public class CountDigitsOfNumber {

    public static void main(String[] args) {
        System.out.println("Digits in 0: " + countDigit(0));
        System.out.println("Digits in 7: " + countDigit(7));
        System.out.println("Digits in 1234: " + countDigit(1234));
        System.out.println("Digits in 987654: " + countDigit(987654));
    }

    /**
     * Returns the total number of digits in the given integer {@code n}.
     *
     * <p>Special Case:</p>
     * <ul>
     *   <li>If {@code n == 0}, return 1 (since zero has exactly one digit).</li>
     * </ul>
     *
     * @param n the number whose digits are to be counted
     * @return total count of digits in the number
     */
    public static int countDigit(int n) {

        // Zero has exactly one digit
        if (n == 0) return 1;

        int count = 0;

        // NOTE:
        // Using this same loop logic (extracting digits one by one),
        // we can solve several related problems:
        //   - Find the largest digit in the number by comparing each digit and taking a variable for storing current maximum
        //   - Find the smallest digit in the number by comparing each digit and taking a variable for storing current minimum
        //   - Count even/odd digits
        //   - Check if the number is a palindrome
        //
        // All of these rely on repeatedly removing digits using n = n / 10.

        // Repeatedly divide by 10 to remove digits
        while (n > 0) {
            n = n / 10;  // Remove last digit
            count++;     // Increase digit count
        }

        return count;
    }
}
