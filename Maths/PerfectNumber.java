/**
 * Problem:
 * Determine whether a given integer {@code n} is a <b>Perfect Number</b>.
 *
 * <p>A number is considered perfect if the sum of all its <b>proper positive divisors</b>
 * (excluding the number itself) equals the number.</p>
 *
 * <p><b>Examples:</b></p>
 * <ul>
 *   <li>6  → divisors = 1, 2, 3 → sum = 6   → Perfect ✔</li>
 *   <li>28 → divisors = 1, 2, 4, 7, 14 → sum = 28 → Perfect ✔</li>
 *   <li>12 → divisors = 1, 2, 3, 4, 6   → sum = 16 → Not Perfect ✘</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Perfect Number Detection:</b>
 *
 * <p>We only need to check divisors up to <b>√n</b> because divisors come in pairs.</p>
 *
 * <p>For example, for n = 28:</p>
 * <pre>
 * 1 × 28
 * 2 × 14
 * 4 × 7
 * </pre>
 *
 * That means:
 * <ul>
 *   <li>If <code>i</code> divides <code>n</code>, then <code>n / i</code> also divides <code>n</code>.</li>
 *   <li>We must add <code>i</code> and <code>n/i</code> to the sum (unless they are the same).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Core Logic:</b>
 *
 * <ul>
 *   <li>1 is always a divisor (except when n = 1, which is not perfect).</li>
 *   <li>Check all numbers from 2 → √n.</li>
 *   <li>If <code>i</code> divides <code>n</code>, add both:
 *     <ul>
 *       <li><code>i</code></li>
 *       <li><code>n / i</code> (paired divisor)</li>
 *     </ul>
 *   </li>
 *   <li>Avoid double-counting when <code>i == n/i</code> (like √36 = 6).</li>
 *   <li>At the end, compare <code>sum == n</code>.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough (n = 28):</b>
 *
 * <pre>
 * Start sum = 1  (since 1 is a divisor)
 *
 * i = 2 → divides → add 2 + 14 → sum = 17
 * i = 3 → no
 * i = 4 → divides → add 4 + 7  → sum = 28
 * i = 5 → no
 *
 * sum = 28 → equal to n → Perfect Number ✔
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(√n)<br>
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println("Is 6 perfect?  " + isPerfectNumber(6));
        System.out.println("Is 28 perfect? " + isPerfectNumber(28));
        System.out.println("Is 12 perfect? " + isPerfectNumber(12));
        System.out.println("Is 1 perfect?  " + isPerfectNumber(1));
    }

    /**
     * Checks whether the given integer {@code n} is a perfect number.
     *
     * <p><b>Special Case:</b></p>
     * <ul>
     *   <li>If {@code n == 1}, return false (1 is not a perfect number).</li>
     * </ul>
     *
     * @param n the number to evaluate
     * @return {@code true} if {@code n} is a perfect number, otherwise {@code false}
     */
    public static boolean isPerfectNumber(int n) {

        // 1 is not considered a perfect number
        if (n == 1) return false;

        int sum = 1; // 1 is always a divisor of n

        // Loop from 2 to √n to find divisor pairs
        for (int i = 2; i * i <= n; i++) {

            // If i divides n, it contributes two divisors: i and n/i
            if (n % i == 0) {

                sum += i; // add divisor

                // Add paired divisor only if it's different (avoid double-counting squares)
                if (i != (n / i)) {
                    sum += (n / i);
                }
            }
        }

        return n == sum; // Perfect number check
    }
}
