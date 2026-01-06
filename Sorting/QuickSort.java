/**
 * Problem:
 * Sort an integer array in ascending order using the <b>Quick Sort</b> algorithm.
 *
 * <p>Quick Sort is a highly efficient <b>divide-and-conquer</b> sorting algorithm
 * that works by selecting a pivot element and partitioning the array around it.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Quick Sort:</b>
 *
 * <p>The algorithm follows three fundamental steps:</p>
 *
 * <ol>
 *   <li>Select a pivot element.</li>
 *   <li>Partition the array such that:
 *     <ul>
 *       <li>Elements ≤ pivot are placed on the left.</li>
 *       <li>Elements > pivot are placed on the right.</li>
 *     </ul>
 *   </li>
 *   <li>Recursively apply the same process to left and right partitions.</li>
 * </ol>
 *
 * <p>Once partitioned, the pivot is guaranteed to be in its final sorted position.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Pivot Selection Optimization (Median of Three):</b>
 *
 * <p>Instead of choosing the first or last element as the pivot, this
 * implementation uses the <b>median-of-three</b> strategy:</p>
 *
 * <ul>
 *   <li>Choose the median of:
 *     <ul>
 *       <li>First element</li>
 *       <li>Middle element</li>
 *       <li>Last element</li>
 *     </ul>
 *   </li>
 *   <li>This reduces the chance of worst-case behavior on sorted or
 *       nearly sorted arrays.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Partitioning Strategy Used:</b>
 *
 * <p>This implementation uses a two-pointer partitioning approach:</p>
 *
 * <ul>
 *   <li>Pivot is placed at the beginning.</li>
 *   <li>Left pointer scans for elements greater than pivot.</li>
 *   <li>Right pointer scans for elements less than or equal to pivot.</li>
 *   <li>Elements are swapped until pointers cross.</li>
 *   <li>Pivot is finally placed in its correct position.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>When is Quick Sort a Good Choice?</b>
 *
 * <ul>
 *   <li>Large datasets where average-case performance matters.</li>
 *   <li>In-memory sorting with limited extra space.</li>
 *   <li>When stability is not required.</li>
 * </ul>
 *
 * <p><b>When NOT to use Quick Sort:</b></p>
 * <ul>
 *   <li>Worst-case guarantees are required (use Merge Sort).</li>
 *   <li>Stable sorting is mandatory.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input: [8, 3, 1, 7, 0, 10, 2]
 *
 * Pivot (median-of-three): 3
 *
 * Partition:
 * [1, 0, 2] | 3 | [8, 7, 10]
 *
 * Recursively sort both sides:
 * [0, 1, 2] | 3 | [7, 8, 10]
 *
 * Output: [0, 1, 2, 3, 7, 8, 10]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Best Case: O(n log n)</li>
 *   <li>Average Case: O(n log n)</li>
 *   <li>Worst Case: O(n²) — mitigated by median-of-three pivot selection</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(log n) — recursion stack (average case).
 * -----------------------------------------------------------------------
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] nums = {8, 3, 1, 7, 0, 10, 2};

        quickSort(nums);

        System.out.print("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Public entry method to perform Quick Sort on the array.
     *
     * @param nums input integer array
     * @return sorted array in ascending order
     */
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * Recursively applies Quick Sort on subarrays.
     *
     * @param nums array to be sorted
     * @param low  starting index
     * @param high ending index
     */
    private static void quickSort(int[] nums, int low, int high) {

        // Base case: zero or one element
        if (low >= high) return;

        // Partition the array and get pivot index
        int pivotIndex = partition(nums, low, high);

        // Recursively sort left and right partitions
        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);
    }

    /**
     * Partitions the array around a pivot element and places the pivot
     * in its correct sorted position.
     *
     * @param nums array to partition
     * @param low  starting index
     * @param high ending index
     * @return final index of the pivot
     */
    private static int partition(int[] nums, int low, int high) {

        // Choose pivot using median-of-three strategy
        int mid = low + ((high - low) >>> 1);
        int pivotIndex = medianOfThreeIndex(nums, low, mid, high);

        // Move pivot to the beginning
        swap(nums, low, pivotIndex);

        int pivot = nums[low];
        int left = low + 1;
        int right = high;

        // Partitioning using two pointers
        while (left <= right) {

            while (left <= high && nums[left] <= pivot) left++;
            while (right >= low + 1 && nums[right] > pivot) right--;

            if (left > right) break;

            swap(nums, left, right);
            left++;
            right--;
        }

        // Place pivot in its correct position
        swap(nums, low, right);
        return right;
    }

    /**
     * Returns the index of the median value among three indices.
     */
    private static int medianOfThreeIndex(int[] nums, int a, int b, int c) {

        int x = nums[a], y = nums[b], z = nums[c];

        if (x < y) {
            if (y < z) return b;
            return (x < z) ? c : a;
        } else {
            if (x < z) return a;
            return (y < z) ? c : b;
        }
    }

    /**
     * Utility method to swap two elements in an array.
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}