/**
 * Problem:
 * Move all zero elements in an integer array to the <b>end</b> of the array
 * while maintaining the <b>relative order</b> of the non-zero elements.
 *
 * <p>The operation must be performed <b>in-place</b> without creating
 * an additional array.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The idea is to compact all non-zero elements to the front of the array
 * and then fill the remaining positions with zeroes:</p>
 *
 * <ul>
 *   <li>Maintain an index (<code>insertIndex</code>) where the next non-zero
 *       element should be placed.</li>
 *   <li>Traverse the array and copy only non-zero values forward.</li>
 *   <li>After traversal, fill the remaining positions with zeroes.</li>
 * </ul>
 *
 * <p>This approach ensures order preservation and constant space usage.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [0, 1, 0, 3, 12]
 *
 * Step 1: Move non-zero elements forward
 *   [1, 3, 12, _, _]
 *
 * Step 2: Fill remaining positions with zeroes
 *   [1, 3, 12, 0, 0]
 *
 * Output: [1, 3, 12, 0, 0]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>No zeroes in array → array remains unchanged.</li>
 *   <li>All elements are zero → array remains unchanged.</li>
 *   <li>Single-element or empty array → no operation performed.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass to move elements and one pass to fill zeroes.<br>
 * <b>Space Complexity:</b> O(1) — in-place operation.
 * -----------------------------------------------------------------------
 */
public class MoveZeroesToEnd {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        System.out.print("Array after moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Moves all zero elements to the end of the array while
     * maintaining the order of non-zero elements.
     *
     * @param nums input integer array
     */
    public static void moveZeroes(int[] nums) {

        int insertIndex = 0;

        // Move non-zero elements to the front
        for (int value : nums) {
            if (value != 0) {
                nums[insertIndex++] = value;
            }
        }

        // Fill remaining positions with zeroes
        while (insertIndex < nums.length) {
            nums[insertIndex++] = 0;
        }
    }
}
