/**
 * Problem:
 * Find and return the largest element present in an integer array.
 *
 * <p>The method scans the array once and keeps track of the maximum
 * value encountered so far.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The simplest and most efficient way to find the largest element is:</p>
 *
 * <ul>
 *   <li>Assume the first element is the largest.</li>
 *   <li>Traverse the remaining elements one by one.</li>
 *   <li>If a larger element is found, update the current maximum.</li>
 * </ul>
 *
 * <p>This approach ensures all elements are considered exactly once.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [3, 7, 2, 9, 4]
 *
 * Start → max = 3
 * Compare 7 → max = 7
 * Compare 2 → max remains 7
 * Compare 9 → max = 9
 * Compare 4 → max remains 9
 *
 * Output: 9
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array with one element → that element is the largest.</li>
 *   <li>Array with all negative numbers → works correctly.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the array.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LargestElement {

    public static void main(String[] args) {

        int[] nums = {3, 7, 2, 9, 4};

        int largest = largestElement(nums);

        System.out.println("Largest element: " + largest);
    }

    /**
     * Returns the largest element in the given integer array.
     *
     * @param nums input array
     * @return maximum element in the array
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int largestElement(int[] nums) {
        // Assume first element is the largest
        int max = nums[0];

        // Traverse array and update maximum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}