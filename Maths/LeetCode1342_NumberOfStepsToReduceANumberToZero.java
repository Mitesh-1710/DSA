/**
 * Problem:
 * Given an integer {@code num}, return the number of steps required
 * to reduce it to zero.
 *
 * <p>In one step:</p>
 * <ul>
 *   <li>If the current number is even → divide it by 2.</li>
 *   <li>If the current number is odd  → subtract 1 from it.</li>
 * </ul>
 *
 * <p>This is the solution to <b>LeetCode Problem 1342:
 * Number of Steps to Reduce a Number to Zero</b></p>
 * <p>🔗 https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem describes a repeated transformation process
 * based on whether the number is even or odd.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Check if {@code num % 2 == 0}.</li>
 *   <li>If even → divide by 2.</li>
 *   <li>If odd → subtract 1.</li>
 *   <li>Repeat until num becomes 0.</li>
 * </ul>
 *
 * <p>This works perfectly within constraints.</p>
 *
 * <p>Optimized Observation:</p>
 * <ul>
 *   <li>Instead of using modulo, we can check parity using bitwise operations.</li>
 *   <li>Even numbers have last bit = 0.</li>
 *   <li>Odd numbers have last bit = 1.</li>
 * </ul>
 *
 * <p>Using bitwise operators is slightly faster and more expressive
 * for binary-based logic.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Bitwise Parity Concept (Detailed Explanation):</b>
 *
 * <p>Binary properties:</p>
 * <ul>
 *   <li>{@code (num & 1)} extracts the least significant bit.</li>
 *   <li>If result == 0 → number is even.</li>
 *   <li>If result == 1 → number is odd.</li>
 * </ul>
 *
 * <p>Division by 2 can be performed efficiently using:</p>
 * <pre>
 * num >>= 1
 * </pre>
 *
 * <p>This right shift removes the last bit, effectively dividing by 2.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize {@code steps = 0}.</li>
 *   <li>While {@code num > 0}:</li>
 *   <ul>
 *     <li>If even → right shift by 1.</li>
 *     <li>If odd → subtract 1.</li>
 *     <li>Increment step counter.</li>
 *   </ul>
 *   <li>Return steps.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * num = 14
 *
 * 14 → even → 7   (1 step)
 * 7  → odd  → 6   (2 steps)
 * 6  → even → 3   (3 steps)
 * 3  → odd  → 2   (4 steps)
 * 2  → even → 1   (5 steps)
 * 1  → odd  → 0   (6 steps)
 *
 * Output:
 * 6
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Direct simulation of defined process.</li>
 *   <li>Efficient parity check using bitwise operation.</li>
 *   <li>No additional data structures.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(log n), since each division by 2 reduces the number of bits.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode1342_NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {

        int num = 14;

        int result = numberOfSteps(num);

        System.out.println("Number of steps: " + result);
    }

    /**
     * Returns the number of steps required to reduce num to zero.
     *
     * @param num input number
     * @return number of steps
     */
    public static int numberOfSteps(int num) {

        int steps = 0;

        while (num > 0) {

            // Check if number is even using bitwise AND
            if ((num & 1) == 0) {
                num >>= 1;  // Divide by 2 using right shift
            } else {
                num--;      // Subtract 1 if odd
            }

            steps++;
        }

        return steps;
    }
}