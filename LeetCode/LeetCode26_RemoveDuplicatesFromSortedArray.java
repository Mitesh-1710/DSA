/**
 * Problem:
 * Remove duplicates from a sorted integer array in-place and return the number of unique elements.
 *
 * <p>This is the solution to LeetCode Problem 26:
 * <br>🔗 https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * <p>The array is guaranteed to be sorted in non-decreasing order.
 * After processing, the first <b>k</b> elements of the array must contain the unique elements.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>Since the array is sorted, all duplicates appear consecutively.
 * This allows us to use a <b>two-pointer technique</b>:</p>
 *
 * <ul>
 *   <li><b>Pointer x</b> → tracks the position of the last unique element found.</li>
 *   <li><b>Pointer i</b> → scans through the array from left to right.</li>
 * </ul>
 *
 * <p><b>When nums[i] ≠ nums[x]:</b></p>
 * <ul>
 *   <li>We found a new unique element.</li>
 *   <li>We write it at position <code>x + 1</code>.</li>
 *   <li>Then move <code>x++</code>.</li>
 * </ul>
 *
 * <p>This ensures that the array is overwritten only when a new distinct value is detected.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  nums = [0,0,1,1,1,2,2,3,3,4]
 *
 * Step-by-step:
 * i=0 → nums[0]=0 (first element, always unique)
 * i=1 → same as nums[x], ignore
 * i=2 → new element '1' → place at nums[1]
 * i=5 → new element '2' → place at nums[2]
 * i=7 → new element '3' → place at nums[3]
 * i=9 → new element '4' → place at nums[4]
 *
 * Final array: [0,1,2,3,4, _, _, _, _, _]
 * Output k = 5
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — we scan the array once.<br>
 * <b>Space Complexity:</b> O(1) — no extra data structure used.
 * -----------------------------------------------------------------------
 */
public class LeetCode26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);

        System.out.println("Unique count (k): " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * Removes duplicates from a sorted array in-place.
     * The first returned <code>k</code> elements will be the unique values.
     *
     * <p><b>Two-pointer strategy:</b></p>
     * <ul>
     *   <li><b>x</b> = last unique index</li>
     *   <li><b>i</b> = current scanning index</li>
     *   <li>Only when nums[i] != nums[x], the unique pointer advances.</li>
     * </ul>
     *
     * @param nums sorted array of integers
     * @return the number of unique elements (k)
     */
    public static int removeDuplicates(int[] nums) {

        int x = 0; // last unique element position

        // Scan entire array
        for (int i = 0; i < nums.length; i++) {
            // When a new value is found
            if (nums[x] != nums[i]) {
                nums[x + 1] = nums[i]; // place unique value forward
                x++;                  // move unique pointer
            }
        }

        return x + 1; // total unique count
    }
}
