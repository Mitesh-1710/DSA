/**
 * Problem:
 * Given an integer {@code n}, compute its factorial value (n!).
 *
 * <p>The factorial of a number represents the product of all positive integers
 * from 1 up to {@code n}.</p>
 *
 * <p>Mathematically:</p>
 * <pre>
 * n! = n × (n-1) × (n-2) × ... × 2 × 1
 * </pre>
 *
 * <p><b>Examples:</b></p>
 * <ul>
 *   <li>0! = 1   (by definition)</li>
 *   <li>1! = 1</li>
 *   <li>4! = 24</li>
 *   <li>5! = 120</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Factorial Computation:</b>
 *
 * <p>The factorial function is built on a simple repetitive multiplication pattern:</p>
 *
 * <ul>
 *   <li><b>1. Multiplication Loop:</b>
 *     <ul>
 *       <li>Start with result = 1</li>
 *       <li>Multiply result by each number from 1 to n</li>
 *       <li>Result keeps accumulating the product</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Special Case: n = 0</b>
 *     <ul>
 *       <li>By definition, <code>0! = 1</code></li>
 *       <li>This matches combinatorics and recursive base cases</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. Overflow Consideration:</b>
 *     <ul>
 *       <li>Factorials grow extremely fast.</li>
 *       <li>Even 20! exceeds integer range; for very large factorials, BigInteger should be used or a string to store each digit one by one.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <p>Compute 5!</p>
 *
 * <pre>
 * i = 1 → result = 1
 * i = 2 → result = 2
 * i = 3 → result = 6
 * i = 4 → result = 24
 * i = 5 → result = 120
 *
 * Final Answer = 120
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — simple loop from 1 to n<br>
 * <b>Space Complexity:</b> O(1) — only one variable used for accumulation
 * -----------------------------------------------------------------------
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of 1: " + factorial(1));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 7: " + factorial(7));
    }

    /**
     * Computes the factorial of {@code n} using iterative multiplication.
     *
     * <p><b>Special Case:</b> If n = 0, return 1.</p>
     *
     * @param n the number whose factorial is to be computed
     * @return the factorial value n!
     */
    public static long factorial(int n) {

        // 0! = 1 (by definition)
        if (n == 0) return 1;

        long result = 1;

        // Multiply numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            result *= i;  // Accumulate product
        }

        return result;
    }
}
