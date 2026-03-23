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
 * The goal is to remove all zero digits while preserving
 * the order of remaining digits.
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert number to string.</li>
 *   <li>Remove '0' characters.</li>
 *   <li>Convert back to number.</li>
 * </ul>
 *
 * This introduces unnecessary overhead.
 *
 * Initial Optimized Approach:
 * <ul>
 *   <li>Extract digits using modulo.</li>
 *   <li>Build number while skipping zeros.</li>
 *   <li>Reverse again to restore order.</li>
 * </ul>
 *
 * Better Optimized Approach (Final):
 * <ul>
 *   <li>Use <b>place-value construction</b> to build the number
 *       directly in correct order.</li>
 *   <li>Avoid double reversal completely.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Place-Value Construction</b>
 *
 * Normally:
 *
 * <pre>
 * digit = n % 10
 * n = n / 10
 * </pre>
 *
 * builds digits from right to left.
 *
 * Instead of reversing later, we maintain a multiplier:
 *
 * <pre>
 * place = 1, 10, 100, ...
 * </pre>
 *
 * When we encounter a non-zero digit:
 *
 * <pre>
 * result += digit * place
 * place *= 10
 * </pre>
 *
 * This directly builds the number in correct order.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize result = 0 and place = 1.</li>
 *   <li>Traverse digits using modulo and division.</li>
 *   <li>If digit ≠ 0:</li>
 *   <ul>
 *     <li>Add digit * place to result.</li>
 *     <li>Update place *= 10.</li>
 *   </ul>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 102030
 *
 * Process:
 *
 * digit = 0 → skip
 * digit = 3 → result = 3
 * digit = 0 → skip
 * digit = 2 → result = 23
 * digit = 0 → skip
 * digit = 1 → result = 123
 *
 * Output:
 * 123
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>No reversal required.</li>
 *   <li>Efficient digit reconstruction.</li>
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
     * Removes zero digits using place-value technique.
     */
    public static long removeZeros(long n) {

        long result = 0;
        long place = 1;

        while (n > 0) {

            long digit = n % 10;

            // Only process non-zero digits
            if (digit != 0) {

                result += digit * place;
                place *= 10;
            }

            n /= 10;
        }

        return result;
    }
}