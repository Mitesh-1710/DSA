/**
 * Problem:
 * Sort an integer array in ascending order using the <b>Merge Sort</b> algorithm.
 *
 * <p>Merge Sort is a <b>divide-and-conquer</b> sorting algorithm that works by:</p>
 * <ul>
 *   <li>Dividing the array into two halves</li>
 *   <li>Recursively sorting each half</li>
 *   <li>Merging the sorted halves into a single sorted array</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Merge Sort:</b>
 *
 * <p>The core idea is to break a large problem into smaller, manageable subproblems:</p>
 *
 * <ul>
 *   <li>Keep dividing the array until each subarray has one element.</li>
 *   <li>A single-element array is already sorted.</li>
 *   <li>Merge sorted subarrays step by step.</li>
 * </ul>
 *
 * <p><b>Why Merge Sort is powerful:</b></p>
 * <ul>
 *   <li>Guaranteed O(n log n) time complexity.</li>
 *   <li>Stable sorting algorithm.</li>
 *   <li>Performance does not degrade with input order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimization Used:</b>
 *
 * <p>Before merging, we check:</p>
 * <pre>
 * if (nums[mid] <= nums[mid + 1]) return;
 * </pre>
 *
 * <ul>
 *   <li>If the largest element of the left half is already smaller than or
 *       equal to the smallest element of the right half, merging is skipped.</li>
 *   <li>This improves performance for nearly sorted arrays.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>When is Merge Sort a Good Choice?</b>
 *
 * <ul>
 *   <li>Large datasets where consistent performance is required.</li>
 *   <li>When stability (preserving relative order of equal elements) matters.</li>
 *   <li>When worst-case performance guarantees are important.</li>
 * </ul>
 *
 * <p><b>When NOT to use Merge Sort:</b></p>
 * <ul>
 *   <li>Memory-constrained environments (requires extra space).</li>
 *   <li>Small arrays (Insertion Sort is often faster).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Step-by-Step Example:</b>
 *
 * <pre>
 * Input: [5, 3, 8, 4]
 *
 * Split:
 * [5, 3] | [8, 4]
 *
 * Sort:
 * [3, 5] | [4, 8]
 *
 * Merge:
 * [3, 4, 5, 8]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Best Case: O(n log n)</li>
 *   <li>Average Case: O(n log n)</li>
 *   <li>Worst Case: O(n log n)</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(n) — additional temporary array for merging.
 * -----------------------------------------------------------------------
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {5, 3, 8, 4, 2, 7, 1};

        mergeSort(nums);

        System.out.print("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Public entry method to perform merge sort on the array.
     *
     * @param nums input integer array
     * @return sorted array in ascending order
     */
    public static int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * Recursively divides the array into halves and sorts them.
     *
     * @param nums array to be sorted
     * @param low  starting index
     * @param high ending index
     */
    private static void mergeSort(int[] nums, int low, int high) {

        // Base case: single element
        if (low >= high) return;

        // Calculate middle index safely
        int mid = low + ((high - low) >>> 1);

        // Recursively sort left and right halves
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        // Optimization: skip merge if already sorted
        if (nums[mid] <= nums[mid + 1]) return;

        // Merge the two sorted halves
        merge(nums, low, mid, high);
    }

    /**
     * Merges two sorted subarrays into a single sorted segment.
     *
     * <p>Left subarray:  nums[low..mid]</p>
     * <p>Right subarray: nums[mid+1..high]</p>
     *
     * @param nums array containing subarrays
     * @param low  start index
     * @param mid  middle index
     * @param high end index
     */
    private static void merge(int[] nums, int low, int mid, int high) {

        // Temporary array to store merged result
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        // Merge elements from both halves in sorted order
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        // Copy remaining elements from left half
        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        // Copy remaining elements from right half
        while (right <= high) {
            temp[index++] = nums[right++];
        }

        // Copy merged result back to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}