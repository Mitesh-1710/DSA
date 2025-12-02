/**
 * Problem:
 * Given two positive integers {@code n1} and {@code n2}, return their
 * Greatest Common Divisor (GCD), also known as the Highest Common Factor (HCF).
 *
 * <p>The GCD of two numbers is the largest integer that divides both numbers exactly.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Approaches to Solve the GCD Problem:</b>
 *
 * <p><b>1. Brute-Force Approach (Simple but Slow)</b></p>
 * <ul>
 *   <li>Start from {@code min(n1, n2)} and loop downward to 1.</li>
 *   <li>The first number that divides both is the GCD.</li>
 * </ul>
 *
 * <pre>
 * Example: n1 = 10, n2 = 20
 * Check: 10? No. 9? No. ... 5? Yes → GCD = 5
 * </pre>
 *
 * <p><b>Drawback:</b> O(min(n1, n2)) — too slow for large numbers.</p>
 *
 * -----------------------------------------------------------------------
 * <b>2. Optimized Approach — Euclidean Algorithm (Subtraction Method)</b>
 *
 * <p>The Euclidean algorithm is based on a key mathematical fact:</p>
 *
 * <pre>
 * gcd(a, b) = gcd(a - b, b)  if a > b
 * gcd(a, b) = gcd(a, b - a)  if b > a
 * </pre>
 *
 * <p>This repeatedly reduces the larger number until one becomes zero.</p>
 *
 * <ul>
 *   <li>If one number becomes 0, the other contains the GCD.</li>
 * </ul>
 *
 * <p><b>Why this works:</b></p>
 * <ul>
 *   <li>Subtracting a smaller factor from a larger one does NOT change the common divisors.</li>
 *   <li>The numbers get smaller quickly → far better than brute force.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * n1 = 10, n2 = 20
 *
 * 20 - 10 = 10 → (10, 10)
 * 10 - 10 = 0  → GCD = 10
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Using This Idea for More Problems:</b>
 *
 * <ul>
 *   <li>This exact logic forms the base of:
 *     <ul>
 *       <li>Euclidean Algorithm (subtraction version)</li>
 *       <li>Modulus-based Euclidean method (even faster)</li>
 *       <li>LCM calculation using GCD</li>
 *       <li>Checking if two numbers are co-prime</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(max(n1, n2)) in worst case  
 * <b>Space Complexity:</b> O(1)  
 * -----------------------------------------------------------------------
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int n1 = 10, n2 = 20;
        int gcd = GCD(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " = " + gcd);
    }

    /**
     * Computes the Greatest Common Divisor (GCD) of two positive integers
     * using the subtraction-based Euclidean Algorithm.
     *
     * <p>Logic:</p>
     * <ul>
     *   <li>Repeatedly subtract the smaller number from the larger one.</li>
     *   <li>When one of the numbers becomes 0, the other is the GCD.</li>
     * </ul>
     *
     * <p>Note:</p>
     * <ul>
     *   <li>This is more efficient than the brute-force approach, which tries
     *       all possible divisors from min(n1, n2) down to 1.</li>
     * </ul>
     *
     * @param n1 first number
     * @param n2 second number
     * @return the Greatest Common Divisor of n1 and n2
     */
    public static int GCD(int n1, int n2) {

        // Continue until one number becomes zero
        while (n1 != 0 && n2 != 0) {

            // If n1 is smaller, subtract it from n2
            if (n1 < n2) {
                n2 = n2 - n1;

                // Else subtract n2 from n1
            } else {
                n1 = n1 - n2;
            }
        }

        // When one becomes zero, return the other one
        return n1 < n2 ? n2 : n1;
    }
}