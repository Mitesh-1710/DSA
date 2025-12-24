/**
 * Problem:
 * Reverse the elements of an integer array **in-place**.
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Reversal Logic:</b>
 *
 * <p>To reverse an array efficiently, we avoid creating a new array and instead swap elements
 * directly within the same array (in-place reversal).</p>
 *
 * <ul>
 *   <li><b>Two-Pointer Technique:</b>
 *     <ul>
 *       <li>One pointer starts at the beginning → <code>p1 = 0</code></li>
 *       <li>Another pointer starts at the end → <code>p2 = n - 1</code></li>
 *       <li>Swap the values at these positions.</li>
 *       <li>Move pointers inward:
 *         <pre>p1++,   p2--</pre>
 *       </li>
 *     </ul>
 *   </li>
 *
 *   <li><b>When to Stop?</b>
 *     <ul>
 *       <li>Stop when <code>p1 >= p2</code> — all elements have been reversed or pointers meet.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Characteristics of This Approach:</b>
 *     <ul>
 *       <li>No extra space required → true in-place O(1) memory usage.</li>
 *       <li>Each element is swapped at most once.</li>
 *       <li>Optimal for single reversal tasks.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 * <pre>
 * Input:  [1, 2, 3, 4, 5]
 *
 * p1=0, p2=4 → swap(1,5) → [5,2,3,4,1]
 * p1=1, p2=3 → swap(2,4) → [5,4,3,2,1]
 * p1=2, p2=2 → stop (center reached)
 *
 * Output: [5, 4, 3, 2, 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Related Techniques:</b>
 * <ul>
 *   <li><b>String reversal</b> — exact same two-pointer logic.</li>
 *   <li><b>Palindrome checking</b> — compare arr[p1] and arr[p2] instead of swapping.</li>
 *   <li><b>Array rotation</b> — often uses reversal as an internal step.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — each element visited at most once.<br>
 * <b>Space Complexity:</b> O(1) — in-place swaps only.
 * -----------------------------------------------------------------------
 */
public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        reverse(arr, n);

        System.out.println("\nReversed Array:");
        printArray(arr);
    }

    /**
     * Reverses the given integer array in-place using the two-pointer technique.
     *
     * @param arr the array to reverse
     * @param n   length of the array
     */
    public static void reverse(int[] arr, int n) {

        int p1 = 0;       // Pointer 1 starts at the beginning
        int p2 = n - 1;   // Pointer 2 starts at the end

        // Continue until pointers cross or meet
        while (p1 < p2) {

            // Swap arr[p1] and arr[p2]
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;

            // Move both pointers inward
            p1++;
            p2--;
        }
    }

    /** Utility method to print the contents of an array. */
    private static void printArray(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
}
