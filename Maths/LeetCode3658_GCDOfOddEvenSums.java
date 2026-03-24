/**
 * Problem:
 * Given an integer {@code n}, compute:
 *
 * <ul>
 *   <li>Sum of first n odd numbers</li>
 *   <li>Sum of first n even numbers</li>
 * </ul>
 *
 * Then return the GCD of these two sums.
 *
 * <p>This is the solution to <b>LeetCode Problem 3658:
 * GCD of Odd and Even Sums</b></p>
 * <p>🔗 https://leetcode.com/problems/gcd-of-odd-and-even-sums/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Instead of generating sequences:
 *
 * <pre>
 * Odd:  1 + 3 + 5 + ... (n terms)
 * Even: 2 + 4 + 6 + ... (n terms)
 * </pre>
 *
 * We derive mathematical formulas.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Mathematical Derivation</b>
 *
 * 1️. Sum of first n odd numbers:
 *
 * <pre>
 * 1 + 3 + 5 + ... + (2n-1)
 * </pre>
 *
 * Known identity:
 *
 * <pre>
 * Sum = n²
 * </pre>
 *
 * Example:
 * <pre>
 * n = 4 → 1 + 3 + 5 + 7 = 16 = 4²
 * </pre>
 *
 * ---------------------------------------------------------------
 * 2️. Sum of first n even numbers:
 *
 * <pre>
 * 2 + 4 + 6 + ... + 2n
 * </pre>
 *
 * Factor out 2:
 *
 * <pre>
 * = 2(1 + 2 + 3 + ... + n)
 * </pre>
 *
 * Using formula:
 *
 * <pre>
 * n(n+1)/2
 * </pre>
 *
 * Final:
 *
 * <pre>
 * = 2 * n(n+1)/2 = n(n+1)
 * </pre>
 *
 * ---------------------------------------------------------------
 * So:
 *
 * <pre>
 * oddSum  = n²
 * evenSum = n(n+1)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Key Mathematical Insight:</b>
 *
 * We need:
 *
 * <pre>
 * gcd(n², n(n+1))
 * </pre>
 *
 * Factor out n:
 *
 * <pre>
 * = n * gcd(n, n+1)
 * </pre>
 *
 * Since consecutive numbers are always coprime:
 *
 * <pre>
 * gcd(n, n+1) = 1
 * </pre>
 *
 * Therefore:
 *
 * <pre>
 * gcd = n
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Insight (Important):</b>
 *
 * Instead of computing GCD, we can directly return:
 *
 * <pre>
 * result = n
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * Approach 1 (Your Approach):
 * <ul>
 *   <li>Compute oddSum = n * n</li>
 *   <li>Compute evenSum = n * (n + 1)</li>
 *   <li>Compute gcd using Euclidean Algorithm</li>
 * </ul>
 *
 * Approach 2 (Optimal):
 * <ul>
 *   <li>Return n directly</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 3
 *
 * oddSum  = 9
 * evenSum = 12
 *
 * gcd(9, 12) = 3
 *
 * Output:
 * 3
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Transforms sequence problem into formula.</li>
 *   <li>Uses mathematical properties of GCD.</li>
 *   <li>Avoids unnecessary iteration.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(log n) for GCD (your approach)<br>
 * O(1) for optimized solution
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3658_GCDOfOddEvenSums {

    public static void main(String[] args) {

        int n = 3;

        int result = gcdOfOddEvenSums(n);

        System.out.println("Result: " + result);
    }

    /**
     * Computes GCD of odd sum and even sum.
     */
    public static int gcdOfOddEvenSums(int n) {

        int odd = n * n;
        int even = n * (n + 1);

        return gcd(odd, even);
    }

    /**
     * Euclidean Algorithm for GCD.
     */
    private static int gcd(int n1, int n2) {

        while (n2 != 0) {

            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
}