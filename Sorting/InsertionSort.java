/**
 * Problem:
 * Sort an integer array in ascending order using the <b>Insertion Sort</b> algorithm.
 *
 * <p>Insertion Sort works the same way we sort playing cards in our hands:
 * one element at a time is inserted into its correct position among the
 * already sorted elements.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Insertion Sort:</b>
 *
 * <p>The array is conceptually divided into two parts:</p>
 *
 * <ul>
 *   <li><b>Sorted part</b> — starts with the first element.</li>
 *   <li><b>Unsorted part</b> — remaining elements to be inserted.</li>
 * </ul>
 *
 * <p>At each step:</p>
 * <ul>
 *   <li>Select the current element (called <code>key</code>).</li>
 *   <li>Shift all larger elements in the sorted part one position to the right.</li>
 *   <li>Insert the key at its correct position.</li>
 * </ul>
 *
 * <p>This guarantees that the left portion of the array remains sorted after
 * every iteration.</p>
 *
 * -----------------------------------------------------------------------
 * <b>When is Insertion Sort a Good Choice?</b>
 *
 * <ul>
 *   <li><b>Nearly sorted arrays</b>
 *     <ul>
 *       <li>Insertion Sort runs in O(n) time when the array is almost sorted.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Small datasets</b>
 *     <ul>
 *       <li>Low overhead and simple logic.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Online sorting</b>
 *     <ul>
 *       <li>Can sort elements as they arrive.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Stable sorting requirement</b>
 *     <ul>
 *       <li>Insertion Sort preserves the relative order of equal elements.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>When NOT to use Insertion Sort:</b></p>
 * <ul>
 *   <li>Large datasets with random order → O(n²) is too slow.</li>
 *   <li>Performance-critical systems with large inputs.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Step-by-Step Example:</b>
 *
 * <pre>
 * Input: [8, 3, 5, 2]
 *
 * Pass 1: key = 3
 *   Shift 8 → [8, 8, 5, 2]
 *   Insert 3 → [3, 8, 5, 2]
 *
 * Pass 2: key = 5
 *   Shift 8 → [3, 8, 8, 2]
 *   Insert 5 → [3, 5, 8, 2]
 *
 * Pass 3: key = 2
 *   Shift 8, 5, 3 → [3, 5, 8, 8]
 *   Insert 2 → [2, 3, 5, 8]
 *
 * Output: [2, 3, 5, 8]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Best Case: O(n) — already or nearly sorted array.</li>
 *   <li>Average Case: O(n²).</li>
 *   <li>Worst Case: O(n²) — reverse sorted array.</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(1) — in-place sorting.
 * -----------------------------------------------------------------------
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = {8, 3, 5, 2};

        insertionSort(nums);

        System.out.print("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Sorts the given array using Insertion Sort.
     *
     * @param nums input integer array
     * @return sorted array in ascending order (same reference)
     */
    public static int[] insertionSort(int[] nums) {

        // Start from the second element (first is already considered sorted)
        for (int i = 1; i < nums.length; i++) {

            // Current element to be inserted
            int key = nums[i];

            // Index of the last element in the sorted portion
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Insert key at its correct position
            nums[j + 1] = key;
        }

        return nums;
    }
}