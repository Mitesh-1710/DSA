import java.util.*;

/**
 * Problem:
 * Given an array {@code nums} of integers, return how many numbers
 * contain an even number of digits.
 *
 * <p>This is the solution to <b>LeetCode Problem 1295:
 * Find Numbers with Even Number of Digits</b></p>
 * <p>🔗 https://leetcode.com/problems/find-numbers-with-even-number-of-digits/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to determine:
 *
 * <pre>
 * digit count of each number
 * </pre>
 *
 * and check whether it is even.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Convert each number to string.</li>
 *   <li>Check string length.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * String.valueOf(num).length()
 * </pre>
 *
 * Drawback:
 *
 * <ul>
 *   <li>Extra string creation.</li>
 *   <li>Unnecessary conversion overhead.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use direct range checks instead of counting digits dynamically.
 *
 * Observation:
 *
 * <pre>
 * Constraints:
 * 1 ≤ nums[i] ≤ 100000
 * </pre>
 *
 * Numbers with even digits are only:
 *
 * <pre>
 * 10 - 99       → 2 digits
 * 1000 - 9999   → 4 digits
 * 100000        → 6 digits
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Digit Range Mapping</b>
 *
 * -----------------------------------------------------
 * <b>1. Digit Count via Numeric Ranges</b>
 *
 * Instead of repeatedly dividing numbers:
 *
 * <pre>
 * digits(1234) = 4
 * </pre>
 *
 * we use fixed ranges:
 *
 * <pre>
 * 1 digit  → 0 - 9
 * 2 digits → 10 - 99
 * 3 digits → 100 - 999
 * </pre>
 *
 * etc.
 *
 * -----------------------------------------------------
 * <b>2. Constraint-Based Optimization</b>
 *
 * Since constraints are small and bounded:
 *
 * <pre>
 * max = 100000
 * </pre>
 *
 * we only need to check:
 *
 * <ul>
 *   <li>2-digit numbers</li>
 *   <li>4-digit numbers</li>
 *   <li>6-digit number (100000)</li>
 * </ul>
 *
 * This eliminates:
 *
 * <ul>
 *   <li>Loops</li>
 *   <li>Logarithms</li>
 *   <li>String conversion</li>
 * </ul>
 *
 * -----------------------------------------------------
 * <b>3. Branch-Based Constant-Time Check</b>
 *
 * Each number is validated using:
 *
 * <pre>
 * range comparisons
 * </pre>
 *
 * which are extremely fast CPU operations.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize count = 0.</li>
 *   <li>Traverse each number in array.</li>
 *   <li>Check if number belongs to even-digit ranges:</li>
 *   <ul>
 *     <li>10 - 99</li>
 *     <li>1000 - 9999</li>
 *     <li>100000</li>
 *   </ul>
 *   <li>If valid → increment count.</li>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [12,345,2,6,7896]
 *
 * Check:
 * 12   → 2 digits → even ✅
 * 345  → 3 digits → odd ❌
 * 2    → 1 digit  → odd ❌
 * 6    → 1 digit  → odd ❌
 * 7896 → 4 digits → even ✅
 *
 * Output:
 * 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No string conversion.</li>
 *   <li>No repeated division operations.</li>
 *   <li>Pure constant-time numeric checks.</li>
 *   <li>Takes advantage of bounded constraints.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1295_FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, 7896};

        int result = findNumbers(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Counts numbers having even number of digits.
     */
    public static int findNumbers(int[] nums) {

        int count = 0;

        for (int n : nums) {

            // 2-digit OR 4-digit OR 6-digit number
            if ((n >= 10 && n < 100) ||
                    (n >= 1000 && n < 10000) ||
                    n == 100000) {

                count++;
            }
        }

        return count;
    }
}