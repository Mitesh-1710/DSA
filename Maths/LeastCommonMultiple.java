/**
 * Problem:
 * Compute the Least Common Multiple (LCM) of two integers using the efficient
 * GCD-based formula.
 *
 * <p>The LCM of two numbers is the smallest positive integer that is divisible
 * by both numbers.</p>
 *
 * <ul>
 *   <li>Example: LCM(4, 6) = 12</li>
 *   <li>Example: LCM(3, 7) = 21</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Core Logic (Efficient Approach):</b>
 *
 * <p>The relationship between GCD and LCM is:</p>
 *
 * <pre>
 * LCM(a, b) = (a * b) / GCD(a, b)
 * </pre>
 *
 * <p>This works because:</p>
 * <ul>
 *   <li>GCD extracts the shared factor between the two numbers.</li>
 *   <li>Multiplying a × b gives the product containing all factors of both numbers.</li>
 *   <li>Dividing by GCD removes duplicated shared factors, giving the smallest common multiple.</li>
 * </ul>
 *
 * <p>This approach is extremely efficient and runs in <b>O(log(min(a, b)))</b> time
 * because GCD using the Euclidean method is logarithmic.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Brute-Force Approach (For Understanding Only):</b>
 *
 * <p>The simplest way to find LCM is:</p>
 *
 * <pre>
 * Start from max(a, b)
 * Keep incrementing the number
 * The first number divisible by both a and b is the LCM
 * </pre>
 *
 * <p>But this is very slow:</p>
 * <ul>
 *   <li>Worst-case time: O(a × b)</li>
 *   <li>Example: LCM(987, 991) requires scanning thousands of numbers</li>
 * </ul>
 *
 * <p>Thus, the GCD-based solution is always preferred.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * a = 12, b = 18
 *
 * Step 1: GCD(12, 18) = 6
 *
 * Step 2: LCM = (12 × 18) / 6
 *            = 216 / 6
 *            = 36
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Using GCD → O(log(min(a, b)))</li>
 *   <li>Brute Force → O(a × b) (Impractical)</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class LeastCommonMultiple {

    public static void main(String[] args) {
        int a = 12, b = 18;

        System.out.println("LCM of " + a + " and " + b + " = " + LCM(a, b));
    }

    /**
     * Computes LCM using the GCD relationship:
     *
     * <pre>
     * LCM(a, b) = (a * b) / GCD(a, b)
     * </pre>
     */
    public static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    /**
     * Computes GCD using the subtraction-based Euclidean algorithm.
     *
     * <p>Also note: A brute-force approach for GCD would loop from
     * min(a, b) → 1 and return the first divisor of both numbers.</p>
     */
    public static int GCD(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 < n2) {
                n2 = n2 - n1;
            } else {
                n1 = n1 - n2;
            }
        }
        return n1 < n2 ? n2 : n1;
    }
}
