/**
 * Problem:
 * Given a binary integer array, find the maximum number of
 * <b>consecutive 1s</b> present in the array.
 *
 * <p>The array contains only 0s and 1s.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The idea is to track the length of the current sequence of consecutive 1s
 * while iterating through the array:</p>
 *
 * <ul>
 *   <li>Use a variable to count the current streak of 1s.</li>
 *   <li>Use another variable to store the maximum streak found so far.</li>
 *   <li>Reset the current count whenever a 0 is encountered.</li>
 * </ul>
 *
 * <p>At the end of traversal, ensure the last streak is also considered.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [1, 1, 0, 1, 1, 1]
 *
 * Traversal:
 *   1 → current = 1, max = 1
 *   1 → current = 2, max = 2
 *   0 → reset current to 0
 *   1 → current = 1
 *   1 → current = 2
 *   1 → current = 3, max = 3
 *
 * Output: 3
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array contains no 1s → result is 0.</li>
 *   <li>Array contains all 1s → result is array length.</li>
 *   <li>Single element array → works correctly.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass over the array.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Maximum consecutive 1s: " + result);
    }

    /**
     * Returns the maximum number of consecutive 1s in the given binary array.
     *
     * @param nums input binary array
     * @return maximum count of consecutive 1s
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxStreak = 0;
        int currentStreak = 0;

        // Traverse the array
        for (int value : nums) {

            if (value == 1) {
                // Extend current streak
                currentStreak++;
            } else {
                // Reset on zero and update maximum
                maxStreak = Math.max(maxStreak, currentStreak);
                currentStreak = 0;
            }
        }

        // Handle case where array ends with 1s
        return Math.max(maxStreak, currentStreak);
    }
}
