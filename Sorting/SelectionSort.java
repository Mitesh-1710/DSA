/**
 * Problem:
 * Sort an integer array in ascending order using the <b>Selection Sort</b> algorithm.
 *
 * <p>Selection Sort is a simple comparison-based sorting technique where the array
 * is divided into two parts:</p>
 *
 * <ul>
 *   <li><b>Sorted part</b> — built from left to right.</li>
 *   <li><b>Unsorted part</b> — remaining elements yet to be arranged.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Selection Sort:</b>
 *
 * <p>The key idea is to repeatedly select the <b>minimum element</b> from the
 * unsorted portion of the array and move it to its correct position.</p>
 *
 * <ul>
 *   <li>At each index <code>i</code>, assume the element at <code>i</code> is the smallest.</li>
 *   <li>Scan the remaining array to find the actual minimum element.</li>
 *   <li>Swap the minimum element with the element at index <code>i</code>.</li>
 * </ul>
 *
 * <p>This guarantees that after each iteration, the left portion of the array
 * is sorted.</p>
 * -----------------------------------------------------------------------
 * <b>When is Selection Sort a Good Choice?</b>
 *
 * <p>Selection Sort is generally <b>not</b> the fastest sorting algorithm,
 * but it has specific scenarios where it is useful:</p>
 *
 * <ul>
 *   <li><b>1. When the array size is very small</b>
 *     <ul>
 *       <li>Overhead of complex algorithms (Quick Sort, Merge Sort) is unnecessary.</li>
 *       <li>Simple logic makes Selection Sort acceptable.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. When minimizing the number of swaps is important</b>
 *     <ul>
 *       <li>Selection Sort performs at most <b>(n − 1) swaps</b>.</li>
 *       <li>Useful when swaps are expensive (e.g., large objects, disk writes).</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. When memory usage must be minimal</b>
 *     <ul>
 *       <li>In-place algorithm.</li>
 *       <li>No extra memory required.</li>
 *     </ul>
 *   </li>
 *
 * </ul>
 *
 * <p><b>When NOT to use Selection Sort:</b></p>
 * <ul>
 *   <li>Large datasets → use Quick Sort / Merge Sort.</li>
 *   <li>Performance-critical systems → O(n²) is too slow.</li>
 *   <li>Nearly sorted arrays → Insertion Sort performs better.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Step-by-Step Example:</b>
 *
 * <pre>
 * Input: [64, 25, 12, 22, 11]
 *
 * Pass 1:
 *   Minimum from index 0 → 11
 *   Swap 64 and 11 → [11, 25, 12, 22, 64]
 *
 * Pass 2:
 *   Minimum from index 1 → 12
 *   Swap 25 and 12 → [11, 12, 25, 22, 64]
 *
 * Pass 3:
 *   Minimum from index 2 → 22
 *   Swap 25 and 22 → [11, 12, 22, 25, 64]
 *
 * Pass 4:
 *   Minimum from index 3 → 25
 *   Already in correct position
 *
 * Final Sorted Array:
 * [11, 12, 22, 25, 64]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Important Characteristics:</b>
 *
 * <ul>
 *   <li>Selection Sort always performs O(n²) comparisons.</li>
 *   <li>The number of swaps is minimal (at most n-1 swaps).</li>
 *   <li>Not stable by default.</li>
 *   <li>Best suited for small datasets or learning purposes.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²) — nested loops.<br>
 * <b>Space Complexity:</b> O(1) — in-place sorting.
 * -----------------------------------------------------------------------
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {64, 25, 12, 22, 11};

        System.out.print("Original Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        selectionSort(nums);

        System.out.print("\nSorted Array:   ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Sorts the given array in ascending order using Selection Sort.
     *
     * <p>Algorithm:</p>
     * <ul>
     *   <li>Fix the current index <code>i</code>.</li>
     *   <li>Find the minimum element in the unsorted part.</li>
     *   <li>Swap it with the element at index <code>i</code>.</li>
     * </ul>
     *
     * @param nums input array to be sorted
     * @return sorted array (same reference, sorted in-place)
     */
    public static int[] selectionSort(int[] nums) {

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {

            // 1. Assume the current index holds the minimum element
            int minIndex = i;

            // 2. Find the actual minimum element in the remaining array
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 3. Swap the found minimum element with the current index
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }

}
