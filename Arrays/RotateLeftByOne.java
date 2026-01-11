/**
 * Problem:
 * Rotate an integer array to the <b>left by one position</b>.
 *
 * <p>A left rotation by one means:</p>
 * <ul>
 *   <li>The first element moves to the last position.</li>
 *   <li>All other elements shift one position to the left.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The rotation can be done efficiently in-place by:</p>
 *
 * <ul>
 *   <li>Temporarily storing the first element.</li>
 *   <li>Shifting all remaining elements one position to the left.</li>
 *   <li>Placing the stored element at the end.</li>
 * </ul>
 *
 * <p>This avoids using extra arrays and maintains constant space usage.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [1, 2, 3, 4, 5]
 *
 * Step 1: Store first element → temp = 1
 * Step 2: Shift elements left → [2, 3, 4, 5, _]
 * Step 3: Place temp at end → [2, 3, 4, 5, 1]
 *
 * Output: [2, 3, 4, 5, 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array with one element → remains unchanged.</li>
 *   <li>Empty array → no operation performed.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal for shifting.<br>
 * <b>Space Complexity:</b> O(1) — in-place rotation.
 * -----------------------------------------------------------------------
 */
public class RotateLeftByOne {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        rotateArrayByOne(nums);

        System.out.print("Array after left rotation by one: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Rotates the given array to the left by one position.
     *
     * @param nums input integer array
     * @throws IllegalArgumentException if the array is null
     */
    public static void rotateArrayByOne(int[] nums) {
        if (nums.length <= 1) {
            return; // No rotation needed
        }

        // Store the first element
        int firstElement = nums[0];

        // Shift all elements one position to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place the first element at the end
        nums[nums.length - 1] = firstElement;
    }
}
