/**
 * Problem:
 * Given a positive integer {@code n}, remove all zero digits
 * from its decimal representation and return the resulting number.
 *
 * <p>The relative order of non-zero digits must be preserved.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3726:
 * Remove Zeros in Decimal Representation</b></p>
 * <p>🔗 https://leetcode.com/problems/remove-zeros-in-decimal-representation/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The task is to remove all zero digits while keeping
 * the order of the remaining digits intact.
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert the number to a string.</li>
 *   <li>Remove all '0' characters.</li>
 *   <li>Convert back to a number.</li>
 * </ul>
 *
 * This works but involves unnecessary string conversion.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Process digits using arithmetic operations.</li>
 *   <li>Skip zero digits.</li>
 *   <li>Rebuild the number.</li>
 * </ul>
 *
 * However, direct rebuilding reverses the order of digits,
 * so we need an additional reversal step.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Digit Filtering + Reverse Pattern</b>
 *
 * Step 1: Extract digits
 *
 * <pre>
 * digit = n % 10
 * n = n / 10
 * </pre>
 *
 * Step 2: Skip zeros and build number
 *
 * <pre>
 * reversed = reversed * 10 + digit
 * </pre>
 *
 * But this builds the number in reverse order.
 *
 * Step 3: Reverse again to restore original order.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize reversed = 0.</li>
 *   <li>Traverse digits of n:</li>
 *   <ul>
 *     <li>If digit ≠ 0 → append to reversed.</li>
 *   </ul>
 *   <li>Reverse the intermediate number to restore order.</li>
 *   <li>Return final result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 102030
 *
 * Step 1 (filter + reverse build):
 * digits → 0 skip
 * 3 → reversed = 3
 * 0 skip
 * 2 → reversed = 32
 * 0 skip
 * 1 → reversed = 321
 *
 * Step 2 (reverse again):
 * 321 → 123
 *
 * Output:
 * 123
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids string conversion.</li>
 *   <li>Efficient digit-level processing.</li>
 *   <li>Maintains order using double-reversal.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is number of digits.
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3726_RemoveZerosInDecimalRepresentation {

    public static void main(String[] args) {

        long n = 102030;

        long result = removeZeros(n);

        System.out.println("Result: " + result);
    }

    /**
     * Removes zero digits from the number.
     */
    public static long removeZeros(long n) {

        long reversed = 0;

        // Step 1: Remove zeros and build reversed number
        while (n > 0) {

            long digit = n % 10;

            if (digit != 0) {
                reversed = reversed * 10 + digit;
            }

            n /= 10;
        }

        // Step 2: Reverse again to restore original order
        long result = 0;

        while (reversed > 0) {

            result = result * 10 + (reversed % 10);
            reversed /= 10;
        }

        return result;
    }
}