/**
 * Problem:
 * Determine whether a given integer {@code n} is an Armstrong number.
 *
 * <p>An <b>Armstrong Number</b> (also called a Narcissistic Number) is a number that equals
 * the sum of its own digits each raised to the power of the total number of digits.</p>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Core Concept Behind Armstrong Numbers</b>
 *
 * <p>Given a number like {@code n = 153}:</p>
 * <ul>
 *   <li>It has 3 digits.</li>
 *   <li>We compute: <code>1³ + 5³ + 3³ = 153</code>.</li>
 *   <li>Since the result equals the original number, 153 is an Armstrong number.</li>
 * </ul>
 *
 * <p>General formula for any number with {@code d} digits:</p>
 * <pre>
 * Armstrong(n) = Σ (eachDigitʳ)   where r = number of digits
 * </pre>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Steps Used in the Logic:</b>
 *
 * <ul>
 *   <li><b>1. Count digits (d)</b>
 *     <ul>
 *       <li>Using:  <code>d = floor(log10(n)) + 1</code></li>
 *       <li>This gives the power to raise every digit.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Extract each digit</b>
 *     <ul>
 *       <li>Use modulo: <code>digit = n % 10</code></li>
 *       <li>Use division to shrink number: <code>n = n / 10</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. Compute powered sum</b>
 *     <ul>
 *       <li>Add: <code>digitᵈ</code> into a running total.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>4. Compare final sum to original number</b>
 *     <ul>
 *       <li>If equal → Armstrong number.</li>
 *       <li>Else → Not an Armstrong number.</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough</b>
 *
 * <p>Let {@code n = 9474}:</p>
 *
 * <pre>
 * Step 1: Count digits → d = 4
 *
 * Step 2: Breakdown digits:
 *     9474 % 10 = 4
 *     9474 / 10 = 947
 *     947 % 10  = 7
 *     947 / 10  = 94
 *     94 % 10   = 4
 *     94 / 10   = 9
 *     9 % 10    = 9
 *
 * Step 3: Sum powered digits:
 *     4⁴ + 7⁴ + 4⁴ + 9⁴
 *   = 256 + 2401 + 256 + 6561
 *   = 9474
 *
 * Step 4: Matches original → Armstrong number.
 * </pre>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(d) — proportional to the number of digits.<br>
 * <b>Space Complexity:</b> O(1) — constant space.
 * -----------------------------------------------------------------------
 */
public class IsArmstrong {

    public static void main(String[] args) {
        System.out.println("153 is Armstrong? " + isArmstrong(153));
        System.out.println("9474 is Armstrong? " + isArmstrong(9474));
        System.out.println("123 is Armstrong? " + isArmstrong(123));
        System.out.println("1634 is Armstrong? " + isArmstrong(1634));
    }

    /**
     * Checks whether the given integer {@code n} is an Armstrong number.
     *
     * <p>The method:</p>
     * <ul>
     *   <li>Determines the number of digits.</li>
     *   <li>Raises each digit to that power.</li>
     *   <li>Sums the values.</li>
     *   <li>Compares with the original number.</li>
     * </ul>
     *
     * @param n the number to check
     * @return true if {@code n} is an Armstrong number, false otherwise
     */
    public static boolean isArmstrong(int n) {

        // 1. Count digits using logarithmic trick
        int count = (int) Math.log10(Math.abs(n)) + 1;

        int armstrong = 0;
        int copy = n;

        // 2. Extract digits one by one
        while (copy > 0) {

            int digit = copy % 10;         // Get last digit
            armstrong += Math.pow(digit, count); // Add digit^count
            copy /= 10;                    // Remove last digit
        }

        // 3. Final comparison
        return n == armstrong;
    }
}
