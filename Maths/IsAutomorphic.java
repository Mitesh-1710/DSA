/**
 * Problem:
 * Given a positive integer {@code n}, determine whether it is an
 * <b>Automorphic Number</b>.
 *
 * <p>A number is called Automorphic if the square of the number
 * ends with the number itself.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The definition directly suggests comparing:</p>
 * <pre>
 * n  with  n²
 * </pre>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Convert both {@code n} and {@code n²} to strings.</li>
 *   <li>Check whether {@code n²} ends with {@code n} using string comparison.</li>
 * </ul>
 *
 * <p>This works but introduces unnecessary string conversion.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Compare digits mathematically from right to left.</li>
 *   <li>Use modulo (%) to extract last digits.</li>
 *   <li>Divide by 10 to shift digits.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Digit Comparison Concept (Detailed Explanation):</b>
 *
 * <p>If a number is automorphic:</p>
 * <pre>
 * The last digit of n must equal the last digit of n².
 * The second last digit must also match.
 * And so on...
 * </pre>
 *
 * <p>To compare digits:</p>
 * <ul>
 *   <li>{@code n % 10} gives last digit of n.</li>
 *   <li>{@code square % 10} gives last digit of n².</li>
 *   <li>If digits mismatch → return false.</li>
 *   <li>Divide both numbers by 10 and repeat.</li>
 * </ul>
 *
 * <p>If all digits of {@code n} are matched successfully,
 * the number is automorphic.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Compute {@code square = n * n}.</li>
 *   <li>While {@code n > 0}:</li>
 *   <ul>
 *     <li>Compare last digits of {@code n} and {@code square}.</li>
 *     <li>If mismatch → return false.</li>
 *     <li>Remove last digit from both.</li>
 *   </ul>
 *   <li>If loop completes → return true.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 25
 *
 * square = 625
 *
 * Compare digits:
 * 25 → last digit 5
 * 625 → last digit 5 ✓
 *
 * 2 → last digit 2
 * 62 → last digit 2 ✓
 *
 * All digits matched → true
 * </pre>
 *
 * Another example:
 *
 * n = 6
 * square = 36
 *
 * Last digit matches (6) → true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No string conversion.</li>
 *   <li>Pure mathematical digit comparison.</li>
 *   <li>Stops early if mismatch occurs.</li>
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
public class IsAutomorphic {

    public static void main(String[] args) {

        int n = 25;

        boolean result = isAutomorphic(n);

        System.out.println("Is Automorphic: " + result);
    }

    /**
     * Checks whether the given number is an Automorphic Number.
     *
     * @param n input number
     * @return true if n is automorphic, otherwise false
     */
    public static boolean isAutomorphic(int n) {

        long square = (long) n * n; // Use long to prevent overflow

        while (n > 0) {

            // Compare last digits
            if (n % 10 != square % 10) {
                return false;
            }

            // Remove last digit from both numbers
            n /= 10;
            square /= 10;
        }

        return true;
    }
}