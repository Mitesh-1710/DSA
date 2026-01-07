/**
 * Problem:
 * Search for a target value in an integer array using the <b>Linear Search</b> algorithm.
 *
 * <p>Linear Search checks each element of the array sequentially
 * until the target is found or the array ends.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Linear Search:</b>
 *
 * <p>The simplest searching approach is to scan the array from
 * left to right and compare each element with the target.</p>
 *
 * <ul>
 *   <li>If the current element matches the target, return its index.</li>
 *   <li>If the end of the array is reached without a match, return -1.</li>
 * </ul>
 *
 * <p>This algorithm does not make any assumptions about the input array.</p>
 *
 * -----------------------------------------------------------------------
 * <b>When is Linear Search a Good Choice?</b>
 *
 * <ul>
 *   <li>When the array is <b>unsorted</b>.</li>
 *   <li>When the dataset size is small.</li>
 *   <li>When only a single search is required.</li>
 *   <li>When simplicity is preferred over performance.</li>
 * </ul>
 *
 * <p><b>When NOT to use Linear Search:</b></p>
 * <ul>
 *   <li>Large datasets with frequent searches.</li>
 *   <li>Sorted arrays where binary search is applicable.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Step-by-Step Example:</b>
 *
 * <pre>
 * Input Array: [4, 2, 7, 1, 9]
 * Target: 7
 *
 * Compare index 0 → 4 ≠ 7
 * Compare index 1 → 2 ≠ 7
 * Compare index 2 → 7 == 7 → return 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Best Case: O(1) — target found at first index.</li>
 *   <li>Average Case: O(n).</li>
 *   <li>Worst Case: O(n) — target not present.</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(1) — no extra space used.
 * -----------------------------------------------------------------------
 */
public class LinearSearch {

    public static void main(String[] args) {

        int[] nums = {4, 2, 7, 1, 9};
        int target = 7;

        int index = linearSearch(nums, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found");
        }
    }

    /**
     * Searches for the target element using Linear Search.
     *
     * @param nums   input integer array
     * @param target value to search for
     * @return index of target if found, otherwise -1
     */
    public static int linearSearch(int[] nums, int target) {

        // Traverse the array sequentially
        for (int i = 0; i < nums.length; i++) {

            // Check for match
            if (nums[i] == target) {
                return i;
            }
        }

        // Target not found
        return -1;
    }
}