/**
 * Problem:
 * Given a non-negative integer {@code n}, compute the {@code n}th Fibonacci number
 * using recursion.
 *
 * <p>The Fibonacci sequence is defined as:</p>
 * <pre>
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)   for n >= 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Recursive Fibonacci Solution:</b>
 *
 * <p>The Fibonacci sequence naturally fits a <b>recursive definition</b>,
 * because each value depends on the sum of the two preceding values.</p>
 *
 * <ul>
 *   <li><b>Base Cases:</b>
 *     <ul>
 *       <li>If {@code n == 0}, return 0.</li>
 *       <li>If {@code n == 1}, return 1.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Recursive Case:</b>
 *     <ul>
 *       <li>For {@code n >= 2}, compute:
 *         <pre>fib(n) = fib(n - 1) + fib(n - 2)</pre>
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This directly mirrors the mathematical definition of Fibonacci.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Call Tree (Example for n = 4):</b>
 *
 * <pre>
 * fib(4)
 * ├── fib(3)
 * │   ├── fib(2)
 * │   │   ├── fib(1) → 1
 * │   │   └── fib(0) → 0
 * │   └── fib(1) → 1
 * └── fib(2)
 *     ├── fib(1) → 1
 *     └── fib(0) → 0
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Important Observation:</b>
 *
 * <ul>
 *   <li>This approach recalculates the same values multiple times.</li>
 *   <li>It is excellent for understanding recursion, but not optimal.</li>
 *   <li>Optimized versions use:
 *     <ul>
 *       <li>Memoization (Top-down DP)</li>
 *       <li>Tabulation (Bottom-up DP)</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output:</b>
 * <pre>
 * fib(0) = 0
 * fib(1) = 1
 * fib(5) = 5
 * fib(7) = 13
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(2ⁿ) — exponential due to overlapping subproblems.<br>
 * <b>Space Complexity:</b> O(n) — recursion stack depth.
 * -----------------------------------------------------------------------
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println("fib(0): " + fibonacci(0));
        System.out.println("fib(1): " + fibonacci(1));
        System.out.println("fib(5): " + fibonacci(5));
        System.out.println("fib(7): " + fibonacci(7));
    }

    /**
     * Returns the {@code n}th Fibonacci number using recursion.
     *
     * @param n index in Fibonacci sequence (n >= 0)
     * @return nth Fibonacci number
     */
    public static int fibonacci(int n) {

        // Base case 1: fib(0) = 0
        if (n == 0) return 0;

        // Base case 2: fib(1) = 1
        if (n == 1) return 1;

        // Recursive case:
        // fib(n) = fib(n - 1) + fib(n - 2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
