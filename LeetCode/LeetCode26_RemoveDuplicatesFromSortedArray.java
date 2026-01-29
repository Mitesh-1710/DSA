/**
 * Problem:
 * Remove duplicates from a sorted integer array in-place and return the number of unique elements.
 *
 * <p>This is the solution to <b>LeetCode Problem 26: Remove Duplicates From Sorted Array</b></p>
 * <p>🔗 https://leetcode.com/problems/remove-duplicates-from-sorted-array/</p>
 *
 * <p>The array is sorted in non-decreasing order.
 * After removing duplicates, the first <b>k</b> elements of the array
 * must contain the unique values in the original order.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>Since the array is already sorted, all duplicate values appear
 * consecutively. This allows the use of a <b>two-pointer technique</b>
 * to overwrite duplicates in-place.</p>
 *
 * <ul>
 *   <li><b>Pointer x</b> — tracks the index of the last unique element.</li>
 *   <li><b>Pointer i</b> — scans the array from left to right.</li>
 * </ul>
 *
 * <p><b>Key Observation:</b></p>
 * <ul>
 *   <li>If <code>nums[i] == nums[x]</code>, the element is a duplicate and is skipped.</li>
 *   <li>If <code>nums[i] != nums[x]</code>, a new unique value is found.</li>
 *   <li>The new value is written to position <code>x + 1</code>, and <code>x</code> is incremented.</li>
 * </ul>
 *
 * <p>This guarantees that all unique elements are compacted at the beginning
 * of the array without using extra memory.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  nums = [0,0,1,1,1,2,2,3,3,4]
 *
 * Iteration:
 * i=0 → first element (always unique)
 * i=1 → duplicate of 0 → ignore
 * i=2 → new element 1 → place at index 1
 * i=5 → new element 2 → place at index 2
 * i=7 → new element 3 → place at index 3
 * i=9 → new element 4 → place at index 4
 *
 * Result:
 * nums = [0,1,2,3,4,_,_,_,_,_]
 * k = 5
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the array.<br>
 * <b>Space Complexity:</b> O(1) — in-place modification, no extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = removeDuplicates(nums);

        System.out.println("Unique count (k): " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * Removes duplicates from a sorted array in-place.
     * The first {@code k} positions of the array will contain the unique values.
     *
     * <p><b>Two-pointer approach:</b></p>
     * <ul>
     *   <li><b>x</b> — index of the last unique element.</li>
     *   <li><b>i</b> — scans each element in the array.</li>
     * </ul>
     *
     * @param nums sorted integer array
     * @return number of unique elements (k)
     */
    public static int removeDuplicates(int[] nums) {

        // Pointer to the last unique element
        int x = 0;

        // Scan the array
        for (int i = 0; i < nums.length; i++) {

            // When a new unique element is found
            if (nums[i] != nums[x]) {
                nums[x + 1] = nums[i]; // place it after the last unique
                x++;                  // advance unique pointer
            }
        }

        // Total number of unique elements
        return x + 1;
    }
}
