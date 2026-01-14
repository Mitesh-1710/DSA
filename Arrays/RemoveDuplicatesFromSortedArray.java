/**
 * Problem:
 * Remove duplicate elements from a <b>sorted integer array</b> in-place
 * and return the count of unique elements.
 *
 * <p>After removal, the first <b>k</b> elements of the array will contain
 * the unique values in their original order.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>Since the array is already sorted:</p>
 *
 * <ul>
 *   <li>All duplicate values appear next to each other.</li>
 *   <li>This allows us to use a <b>two-pointer approach</b>.</li>
 * </ul>
 *
 * <p>Approach:</p>
 * <ul>
 *   <li>Maintain an <code>insertIndex</code> that tracks the position
 *       of the last unique element.</li>
 *   <li>Traverse the array using a scanning index.</li>
 *   <li>Whenever a new value is found, place it at <code>insertIndex + 1</code>.</li>
 * </ul>
 *
 * <p>This ensures duplicates are skipped without using extra memory.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [1, 1, 2, 2, 3]
 *
 * Traversal:
 *   insertIndex = 0 → [1, _, _, _, _]
 *   i = 1 → duplicate → ignore
 *   i = 2 → new value → place at index 1 → [1, 2, _, _, _]
 *   i = 3 → duplicate → ignore
 *   i = 4 → new value → place at index 2 → [1, 2, 3, _, _]
 *
 * Output:
 *   Unique count = 3
 *   Modified array = [1, 2, 3]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array with no duplicates → unchanged.</li>
 *   <li>Array with all elements same → unique count = 1.</li>
 *   <li>Single-element array → unique count = 1.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal of the array.<br>
 * <b>Space Complexity:</b> O(1) — in-place operation.
 * -----------------------------------------------------------------------
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 4, 7, 7, 10};

        int k = removeDuplicates(nums);

        System.out.print("Unique elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\nUnique count: " + k);
    }

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums sorted input array
     * @return number of unique elements
     */
    public static int removeDuplicates(int[] nums) {
        int insertIndex = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // When a new unique value is found
            if (nums[insertIndex] != nums[i]) {
                nums[++insertIndex] = nums[i];
            }
        }

        // Number of unique elements
        return insertIndex + 1;
    }
}