/**
 * Problem:
 * Find and return the <b>second largest</b> element in an integer array.
 *
 * <p>The second largest element is the largest value that is strictly
 * smaller than the maximum element.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The most efficient approach is to find the result in a <b>single traversal</b>:</p>
 *
 * <ul>
 *   <li>Maintain two variables:
 *     <ul>
 *       <li><b>max</b> — stores the largest value found so far.</li>
 *       <li><b>secondMax</b> — stores the second largest value.</li>
 *     </ul>
 *   </li>
 *   <li>For each element:
 *     <ul>
 *       <li>If it is greater than <code>max</code>, update both values.</li>
 *       <li>If it lies strictly between <code>max</code> and <code>secondMax</code>,
 *           update <code>secondMax</code>.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This ensures optimal time complexity without sorting the array.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [5, 1, 9, 3, 7]
 *
 * Iteration:
 *   num = 5 → max = 5,  secondMax = MIN
 *   num = 1 → secondMax = 1
 *   num = 9 → max = 9,  secondMax = 5
 *   num = 3 → ignored
 *   num = 7 → secondMax = 7
 *
 * Output: 7
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array with fewer than two distinct elements → return -1.</li>
 *   <li>Array with all elements equal → return -1.</li>
 *   <li>Works correctly with negative numbers.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class SecondLargestElement {

    public static void main(String[] args) {

        int[] nums = {5, 1, 9, 3, 7};

        int result = secondLargestElement(nums);

        if (result != -1) {
            System.out.println("Second largest element: " + result);
        } else {
            System.out.println("Second largest element does not exist");
        }
    }

    /**
     * Returns the second largest distinct element in the array.
     *
     * @param nums input integer array
     * @return second largest element, or -1 if it does not exist
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int secondLargestElement(int[] nums) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Single-pass traversal
        for (int num : nums) {

            if (num > max) {
                // New maximum found
                secondMax = max;
                max = num;

            } else if (num > secondMax && num < max) {
                // Candidate for second largest
                secondMax = num;
            }
        }

        // If secondMax was never updated, no second largest exists
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
