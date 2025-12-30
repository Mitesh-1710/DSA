/**
 * Problem:
 * Given an integer {@code num}, repeatedly add all its digits until the result
 * contains only a single digit, and return that digit.
 *
 * <p>This process is also known as finding the <b>digital root</b>,
 * but here it is solved explicitly using <b>recursion</b>.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The idea is to break the problem into two repeating steps:</p>
 * <ul>
 *   <li>Extract digits of the number one by one using <code>% 10</code>.</li>
 *   <li>Accumulate them until the number reduces to a single digit.</li>
 * </ul>
 *
 * <p>Instead of using loops, recursion is used to:</p>
 * <ul>
 *   <li>Process each digit</li>
 *   <li>Rebuild intermediate sums</li>
 *   <li>Restart the process until a single digit remains</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Strategy:</b>
 *
 * <ul>
 *   <li><b>Base Case:</b>
 *     <ul>
 *       <li>If {@code num <= 9}, it is already a single digit → return it.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Recursive Case:</b>
 *     <ul>
 *       <li>Extract the last digit using <code>num % 10</code>.</li>
 *       <li>Accumulate it into {@code total}.</li>
 *       <li>Reduce the number using <code>num / 10</code>.</li>
 *       <li>When all digits are consumed, restart recursion with the new sum.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * num = 987
 *
 * Step 1: 9 + 8 + 7 = 24
 * Step 2: 2 + 4     = 6
 *
 * Output: 6
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d) — where d is the total number of digits processed across recursive calls.
 *
 * <b>Space Complexity:</b>
 * O(d) — recursion call stack.
 * -----------------------------------------------------------------------
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println("Result for 0: " + addDigits(0));
        System.out.println("Result for 5: " + addDigits(5));
        System.out.println("Result for 38: " + addDigits(38));
        System.out.println("Result for 987: " + addDigits(987));
    }

    /**
     * Public method to start recursive digit addition.
     *
     * @param num input number
     * @return single-digit result after repeated digit summation
     */
    public static int addDigits(int num) {
        return recursiveSum(num, 0);
    }

    /**
     * Recursively processes digits and accumulates their sum.
     *
     * @param num   remaining number to process
     * @param total accumulated digit sum
     * @return final single-digit result
     */
    private static int recursiveSum(int num, int total) {

        // Base case: if already a single digit
        if (num <= 9) {
            return num;
        }

        // 1. Add last digit to total
        total = (total * 10) + (num % 10);

        // 2. Remove last digit
        num = num / 10;

        // 3. If all digits consumed, restart with summed value
        if (num <= 9) {
            num += total;
            total = 0;
        }

        // 4. Recursive call
        return recursiveSum(num, total);
    }
}