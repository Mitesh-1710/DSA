/**
 * Problem:
 * Sort an integer array using the <b>Bubble Sort</b> algorithm.
 *
 * <p>Bubble Sort is a simple comparison-based sorting algorithm that repeatedly
 * steps through the list, compares adjacent elements, and swaps them if they
 * are in the wrong order.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Bubble Sort:</b>
 *
 * <p>The key idea is to <b>push the largest elements toward the end</b> of the array
 * in each pass, similar to bubbles rising to the surface.</p>
 *
 * <ul>
 *   <li>In each outer iteration, the largest unsorted element settles at its correct position.</li>
 *   <li>The inner loop compares adjacent elements and swaps them if needed.</li>
 * </ul>
 *
 * <p><b>Optimization Insight (Early Exit):</b></p>
 * <ul>
 *   <li>If no swaps occur during a full pass, the array is already sorted.</li>
 *   <li>We can stop early to avoid unnecessary iterations.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>When is Bubble Sort a Good Choice?</b>
 *
 * <ul>
 *   <li>When the input size is very small.</li>
 *   <li>When the array is already nearly sorted.</li>
 *   <li>When simplicity and readability are more important than performance.</li>
 *   <li>Useful for teaching sorting fundamentals and algorithmic thinking.</li>
 * </ul>
 *
 * <p><b>When NOT to use Bubble Sort?</b></p>
 * <ul>
 *   <li>Large datasets (very slow compared to Quick Sort, Merge Sort, etc.).</li>
 *   <li>Performance-critical systems.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [5, 1, 4, 2, 8]
 *
 * Pass 1: [1, 4, 2, 5, 8]
 * Pass 2: [1, 2, 4, 5, 8]
 * Pass 3: No swaps → Stop early
 *
 * Output: [1, 2, 4, 5, 8]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Best Case: O(n) — already sorted (early exit).</li>
 *   <li>Average Case: O(n²).</li>
 *   <li>Worst Case: O(n²).</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(1) — in-place sorting.
 * -----------------------------------------------------------------------
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 4, 2, 8};

        bubbleSort(nums);

        System.out.print("Sorted Array: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * Sorts the given array using Bubble Sort with early-exit optimization.
     *
     * <p><b>Approach:</b></p>
     * <ul>
     *   <li>Compare adjacent elements.</li>
     *   <li>Swap if they are in the wrong order.</li>
     *   <li>Repeat until no swaps occur.</li>
     * </ul>
     *
     * @param nums input array to be sorted
     * @return the same array sorted in ascending order
     */
    public static int[] bubbleSort(int[] nums) {

        // Traverse array from end to start
        for (int i = nums.length - 1; i >= 0; i--) {

            boolean didSwap = false;

            // Compare adjacent elements
            for (int j = 0; j <= i - 1; j++) {

                // Swap if elements are in wrong order
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    didSwap = true;
                }
            }

            // Optimization: if no swaps happened, array is already sorted
            if (!didSwap) {
                break;
            }
        }

        return nums;
    }
}