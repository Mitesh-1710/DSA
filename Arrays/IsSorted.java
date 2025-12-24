/**
 * Problem:
 * Determine whether a given integer array is sorted in non-decreasing (ascending) order.
 *
 * <p>This class provides a simple linear-time approach to verify array ordering.
 * The check ensures that every element is less than or equal to the next element.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process</b>
 *
 * <p>The ordering rule for an ascending array is:</p>
 * <pre>
 * arr[i] ≤ arr[i + 1] for all valid i
 * </pre>
 *
 * <p>Thus, the simplest and most optimal approach is:</p>
 * <ul>
 *   <li>Iterate through the array once.</li>
 *   <li>Compare each element with its next neighbor.</li>
 *   <li>If any violation is found → array is NOT sorted.</li>
 * </ul>
 *
 * <p>This makes the check extremely efficient and suitable for real-time validations.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Brute-Force Thought (For Understanding)</b>
 *
 * <p>A naïve brute-force way would be:</p>
 * <ul>
 *   <li>For each element arr[i], compare it with all elements arr[j] where j > i.</li>
 *   <li>If <code>arr[i] > arr[j]</code> for any j, the array is unsorted.</li>
 * </ul>
 *
 * <p>This results in O(n²) comparisons — unnecessary when a simple O(n) solution exists.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Outputs</b>
 * <pre>
 * Input: [1, 2, 3, 4, 5]     → true   (sorted)
 * Input: [3, 3, 5, 7]        → true   (duplicates allowed)
 * Input: [5, 4, 3, 2]        → false  (descending)
 * Input: [1, 5, 2, 7]        → false  (unsorted in middle)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through array.<br>
 * <b>Space Complexity:</b> O(1) — no extra space used.
 * -----------------------------------------------------------------------
 */
public class IsSorted {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {3, 3, 5, 7};
        int[] a3 = {5, 4, 3, 2};
        int[] a4 = {1, 5, 2, 7};

        System.out.println("1. [1,2,3,4,5] → " + arraySortedOrNot(a1));
        System.out.println("2. [3,3,5,7] → " + arraySortedOrNot(a2));
        System.out.println("3. [5,4,3,2] → " + arraySortedOrNot(a3));
        System.out.println("4. [1,5,2,7] → " + arraySortedOrNot(a4));
    }

    /**
     * Checks whether an integer array is sorted in non-decreasing order.
     *
     * <p><b>Logic:</b></p>
     * <ul>
     *   <li>Loop through the array from index 0 to n-2.</li>
     *   <li>If any <code>arr[i] > arr[i+1]</code> occurs, the order is violated.</li>
     * </ul>
     *
     * <p>This is the optimal way to check sortedness.</p>
     *
     * @param arr input array
     * @return {@code true} if sorted, otherwise {@code false}
     */
    public static boolean arraySortedOrNot(int[] arr) {
        if (arr == null || arr.length <= 1) return true; // Empty or single element → sorted by definition

        // Linear scan to detect any violation
        for (int i = 0; i < arr.length - 1; i++) {
            // If current element is greater than next → unsorted
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}