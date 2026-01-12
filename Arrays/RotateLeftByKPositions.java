/**
 * Problem:
 * Rotate an integer array to the <b>left by k positions</b>.
 *
 * <p>A left rotation by k means:</p>
 * <ul>
 *   <li>The first k elements move to the end of the array.</li>
 *   <li>The relative order of elements is preserved.</li>
 * </ul>
 *
 * <p>This implementation uses the <b>Reversal Algorithm</b>
 * to perform the rotation efficiently in-place.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The key idea is that a rotation can be achieved by reversing
 * specific parts of the array:</p>
 *
 * <ol>
 *   <li>Reverse the first k elements.</li>
 *   <li>Reverse the remaining (n − k) elements.</li>
 *   <li>Reverse the entire array.</li>
 * </ol>
 *
 * <p>This transforms the array into its rotated form without using
 * any extra memory.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 *
 * Step 1: Reverse first k elements
 *   [3, 2, 1, 4, 5, 6, 7]
 *
 * Step 2: Reverse remaining elements
 *   [3, 2, 1, 7, 6, 5, 4]
 *
 * Step 3: Reverse entire array
 *   [4, 5, 6, 7, 1, 2, 3]
 *
 * Output: [4, 5, 6, 7, 1, 2, 3]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>k = 0 → array remains unchanged.</li>
 *   <li>k ≥ array length → rotation count reduced using modulo.</li>
 *   <li>Array with size 0 or 1 → no change.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — three linear reversals.<br>
 * <b>Space Complexity:</b> O(1) — in-place rotation.
 * -----------------------------------------------------------------------
 */
public class RotateLeftByKPositions {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateArray(nums, k);

        System.out.print("Array after left rotation by " + k + ": ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Rotates the array to the left by k positions using the reversal algorithm.
     *
     * @param nums input integer array
     * @param k    number of positions to rotate
     */
    public static void rotateArray(int[] nums, int k) {
        int length = nums.length;

        if (length <= 1) return;

        // Normalize rotation count
        k %= length;
        if (k == 0) return;

        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Reverse remaining elements
        reverse(nums, k, length - 1);

        // Reverse entire array
        reverse(nums, 0, length - 1);
    }

    /**
     * Reverses elements in the array between two indices.
     *
     * @param nums  array
     * @param left  starting index
     * @param right ending index
     */
    private static void reverse(int[] nums, int left, int right) {

        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param nums array
     * @param i    first index
     * @param j    second index
     */
    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
