/**
 * Problem:
 * Given an integer {@code n}, determine whether it is an
 * <b>Abundant Number</b>.
 *
 * <p>A number is called <b>abundant</b> if the sum of its
 * <b>proper divisors</b> (excluding the number itself)
 * is greater than {@code n}.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The task is to efficiently compute the sum of all proper divisors
 * of {@code n} without iterating up to {@code n - 1}.</p>
 *
 * <p>Key observations:</p>
 * <ul>
 *   <li>Divisors come in pairs: if {@code i} divides {@code n},
 *       then {@code n / i} is also a divisor.</li>
 *   <li>We only need to iterate up to {@code sqrt(n)}.</li>
 *   <li>The number {@code 1} is always a proper divisor for {@code n > 1}.</li>
 * </ul>
 *
 * <p>To avoid unnecessary computation:</p>
 * <ul>
 *   <li>Start the sum with {@code 1}.</li>
 *   <li>For each divisor {@code i}, add both {@code i} and {@code n / i}.</li>
 *   <li>Avoid double-counting when {@code i * i == n}.</li>
 * </ul>
 *
 * <p>This allows us to compute the divisor sum in O(√n) time.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 12
 *
 * Proper divisors:
 * 1, 2, 3, 4, 6
 *
 * Sum = 1 + 2 + 3 + 4 + 6 = 16
 *
 * Since 16 > 12 → Abundant Number → true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>{@code n <= 1} (no proper divisors).</li>
 *   <li>Prime numbers (sum of proper divisors = 1).</li>
 *   <li>Perfect squares (avoid double-counting the square root).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(√n) — iterating only up to the square root of {@code n}.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class IsAbundant {

    public static void main(String[] args) {

        int n = 12;

        boolean result = isAbundant(n);

        System.out.println("Is Abundant: " + result);
    }

    /**
     * Checks whether the given number is an Abundant Number.
     *
     * @param n input number
     * @return {@code true} if {@code n} is abundant, otherwise {@code false}
     */
    public static boolean isAbundant(int n) {

        if (n <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;

                // Add the paired divisor if it is different
                if (n / i != i) {
                    sum += (n / i);
                }
            }
        }

        return sum > n;
    }
}