/**
 * Problem:
 * Calculate the factorial of a given positive integer {@code n} using recursion.
 *
 * <p>The factorial of a number is defined as:</p>
 * <pre>
 * n! = n × (n-1) × (n-2) × ... × 1
 * </pre>
 *
 * <p>By definition:</p>
 * <ul>
 *   <li>0! = 1</li>
 *   <li>1! = 1</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Recursive Approach:</b>
 *
 * <p>Factorial is a classic example of a problem that naturally fits recursion.</p>
 *
 * <ul>
 *   <li>The problem can be broken down into smaller subproblems.</li>
 *   <li>To compute {@code n!}, we only need {@code (n-1)!}.</li>
 *   <li>This creates a chain of recursive calls until a base condition is reached.</li>
 * </ul>
 *
 * <p><b>Recursive Relation:</b></p>
 * <pre>
 * factorial(n) = n × factorial(n - 1)
 * </pre>
 *
 * <p><b>Base Case:</b></p>
 * <ul>
 *   <li>If {@code n == 0 || n == 1}, return {@code 1}.</li>
 *   <li>This stops further recursive calls.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough (n = 5):</b>
 *
 * <pre>
 * factorial(5)
 * = 5 × factorial(4)
 * = 5 × (4 × factorial(3))
 * = 5 × (4 × (3 × factorial(2)))
 * = 5 × (4 × (3 × (2 × factorial(1))))
 * = 5 × 4 × 3 × 2 × 1
 * = 120
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Important Notes:</b>
 *
 * <ul>
 *   <li>This implementation assumes {@code n >= 0}.</li>
 *   <li>For large values of {@code n}, recursion depth may cause stack overflow.</li>
 *   <li>An iterative approach is safer for very large inputs.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — one recursive call per value of n.<br>
 * <b>Space Complexity:</b> O(n) — due to recursive call stack.
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
     * Computes the factorial of a non-negative integer {@code n} using recursion.
     *
     * <p>Base Case:</p>
     * <ul>
     *   <li>If {@code n == 0 || n == 1}, return {@code 1}.</li>
     * </ul>
     *
     * <p>Recursive Case:</p>
     * <ul>
     *   <li>Multiply {@code n} with the factorial of {@code (n - 1)}.</li>
     * </ul>
     *
     * @param n the number whose factorial is to be computed
     * @return factorial of {@code n}
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public static int factorial(int n) {

        // Base case: 0! and 1! are both 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n! = n × (n-1)!
        return n * factorial(n - 1);
    }
}
