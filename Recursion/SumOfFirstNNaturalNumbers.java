/**
 * Problem:
 * Compute the sum of the first {@code n} natural numbers using recursion.
 *
 * <p>The natural numbers are defined as:</p>
 * <pre>
 * 1, 2, 3, 4, ..., n
 * </pre>
 *
 * <p>The goal is to calculate:</p>
 * <pre>
 * 1 + 2 + 3 + ... + n
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Recursive Approach:</b>
 *
 * <p>Recursion works best when a problem can be broken into:</p>
 * <ul>
 *   <li>A <b>base case</b> — where the recursion stops</li>
 *   <li>A <b>recursive case</b> — where the problem reduces in size</li>
 * </ul>
 *
 * <p><b>1. Base Case</b></p>
 * <ul>
 *   <li>If {@code n == 1}, the sum is simply 1.</li>
 *   <li>This prevents infinite recursion.</li>
 * </ul>
 *
 * <p><b>2. Recursive Relation</b></p>
 * <ul>
 *   <li>The sum of first {@code n} numbers can be expressed as:</li>
 * </ul>
 * <pre>
 * sum(n) = n + sum(n - 1)
 * </pre>
 *
 * <p>This means:</p>
 * <ul>
 *   <li>Take the current number {@code n}</li>
 *   <li>Add it to the sum of the remaining numbers {@code (n - 1)}</li>
 * </ul>
 *
 * <p><b>3. Recursive Call Stack Insight</b></p>
 * <pre>
 * sum(4)
 * = 4 + sum(3)
 * = 4 + (3 + sum(2))
 * = 4 + (3 + (2 + sum(1)))
 * = 4 + (3 + (2 + 1))
 * = 10
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output:</b>
 *
 * <pre>
 * Input:  n = 1  → Output: 1
 * Input:  n = 5  → Output: 15
 * Input:  n = 10 → Output: 55
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — one recursive call per number.<br>
 * <b>Space Complexity:</b> O(n) — recursion call stack.
 * -----------------------------------------------------------------------
 */
public class SumOfFirstNNaturalNumbers {

    public static void main(String[] args) {

        System.out.println("Sum of first 1 number: " + NnumbersSum(1));
        System.out.println("Sum of first 5 numbers: " + NnumbersSum(5));
        System.out.println("Sum of first 10 numbers: " + NnumbersSum(10));
    }

    /**
     * Returns the sum of the first {@code n} natural numbers using recursion.
     *
     * @param n the number up to which sum is calculated
     * @return sum of first {@code n} natural numbers
     */
    public static int NnumbersSum(int n) {

        // Base case: smallest valid natural number
        if (n == 1) return 1;

        // Recursive case:
        // Add current number to sum of remaining (n - 1) numbers
        return n + NnumbersSum(n - 1);
    }
}