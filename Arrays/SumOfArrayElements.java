/**
 * Problem:
 * Compute the sum of all elements in an integer array.
 *
 * <p>This class demonstrates a simple, robust approach to summing array elements
 * and provides a couple of variations and implementation notes.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process</b>
 *
 * <p>The core idea is straightforward:</p>
 * <ul>
 *   <li>Iterate through the array exactly once and accumulate the running total.</li>
 *   <li>This is an optimal O(n) approach for a single sum query.</li>
 * </ul>
 *
 * <p><b>Edge-cases:</b></p>
 * <ul>
 *   <li>Empty array → sum = 0.</li>
 *   <li>Integer overflow → if elements can be large, use {@code long} for accumulation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output:</b>
 * <pre>
 * Input:  [1, 2, 3, 4, 5]    → Sum = 15
 * Input:  []                 → Sum = 0
 * Input:  [-1, 2, -3, 4]     → Sum = 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass over the array.<br>
 * <b>Space Complexity:</b> O(1) — only a constant-sized accumulator used.
 * -----------------------------------------------------------------------
 */
public class SumOfArrayElements {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {};
        int[] a3 = {-1, 2, -3, 4};

        System.out.println("1. Sum of [1,2,3,4,5]: " + sumArray(a1));
        System.out.println("\n2. Sum of []: " + sumArray(a2));
        System.out.println("\n3. Sum of [-1,2,-3,4]: " + sumArray(a3));
    }

    /**
     * Returns the sum of all elements in the provided integer array.
     *
     * <p>Notes:</p>
     * <ul>
     *   <li>If the array is empty or null, this method returns 0.</li>
     *   <li>Use {@link #sumArrayLong(long[])} if values can overflow {@code int}.</li>
     * </ul>
     *
     * @param arr input integer array
     * @return sum of elements (int)
     */
    public static int sumArray(int[] arr) {
        // Defensive null/empty check
        if (arr == null || arr.length == 0) return 0;

        int sum = 0;

        // Single-pass accumulation: O(n)
        for (int i = 0; i < arr.length; i++) {
            // 1. Add current element to running total
            sum += arr[i];
        }

        return sum;
    }
}
