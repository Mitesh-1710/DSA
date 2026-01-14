/**
 * Problem:
 * Given an integer array containing <b>n</b> distinct numbers taken from the
 * range <code>[0, n]</code>, find the one number that is missing from the array.
 *
 * <p>The array contains exactly one missing number.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The numbers are expected to form a complete sequence from <code>0</code>
 * to <code>n</code>, except for one missing value.</p>
 *
 * <ul>
 *   <li>The sum of numbers from <code>0</code> to <code>n</code> is:
 *       <pre>n * (n + 1) / 2</pre>
 *   </li>
 *   <li>If we subtract the sum of elements present in the array from this
 *       expected sum, the result is the missing number.</li>
 * </ul>
 *
 * <p>This avoids sorting and works in a single pass.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  nums = [3, 0, 1]
 * n = 3
 *
 * Expected sum (0..3) = 3 * 4 / 2 = 6
 * Actual sum = 3 + 0 + 1 = 4
 *
 * Missing number = 6 - 4 = 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Missing number is 0.</li>
 *   <li>Missing number is n.</li>
 *   <li>Single-element array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal to compute sum.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        int missing = missingNumber(nums);

        System.out.println("Missing number: " + missing);
    }

    /**
     * Returns the missing number from the array.
     *
     * @param nums input array containing numbers from 0 to n with one missing
     * @return the missing number
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Calculate sum of elements in the array
        for (int value : nums) {
            sum += value;
        }

        // Expected sum of numbers from 0 to n
        int expectedSum = (n * (n + 1)) / 2;

        // Missing number is the difference
        return expectedSum - sum;
    }
}