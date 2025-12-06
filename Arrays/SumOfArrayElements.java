/**
 * Problem:
 * Compute the sum of all elements in an integer array and also count
 * how many elements are odd and how many are even.
 *
 * <p>This class provides:</p>
 * <ul>
 *   <li>A method to compute the total sum of an array</li>
 *   <li>A method to count odd & even numbers</li>
 *   <li>Edge-case handling and variations for safe usage</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process</b>
 *
 * <p><b>1. Summing Elements:</b></p>
 * <ul>
 *   <li>Use a single loop and keep adding elements to a running total.</li>
 *   <li>This is optimal at O(n) time and O(1) space.</li>
 *   <li>For large integer ranges, a long accumulator prevents overflow.</li>
 * </ul>
 *
 * <p><b>2. Counting Odd & Even Elements:</b></p>
 * <ul>
 *   <li>Each number is checked via <code>num % 2 == 0</code>.</li>
 *   <li>Even → divisible by 2; Odd → remainder 1 or -1.</li>
 *   <li>Only one scan is needed to count both → O(n).</li>
 * </ul>
 *
 * <p><b>Edge Cases:</b></p>
 * <ul>
 *   <li>Empty or null array → sum = 0 and odd/even counts = 0.</li>
 *   <li>Negative numbers work the same (mod logic unchanged).</li>
 *   <li>All even or all odd arrays also handled automatically.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output:</b>
 * <pre>
 * Input:  [1, 2, 3, 4, 5]
 * → Sum = 15
 * → Odds = 3, Evens = 2
 *
 * Input:  []
 * → Sum = 0
 * → Odds = 0, Evens = 0
 *
 * Input:  [-1, 2, -3, 4]
 * → Sum = 2
 * → Odds = 2, Evens = 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Sum Calculation → O(n)</li>
 *   <li>Odd/Even Counting → O(n)</li>
 * </ul>
 * <b>Space Complexity:</b> O(1) — Only counters/accumulator used.
 * -----------------------------------------------------------------------
 */
public class SumOfArrayElements {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {};
        int[] a3 = {-1, 2, -3, 4};

        System.out.println("1. Sum of [1,2,3,4,5]: " + sumArray(a1));
        System.out.println("   Odd/Even Count: " + countOddEven(a1) + "\n");

        System.out.println("2. Sum of []: " + sumArray(a2));
        System.out.println("   Odd/Even Count: " + countOddEven(a2) + "\n");

        System.out.println("3. Sum of [-1,2,-3,4]: " + sumArray(a3));
        System.out.println("   Odd/Even Count: " + countOddEven(a3));
    }

    /**
     * Returns the sum of all elements in the provided integer array.
     *
     * <p><b>Notes:</b></p>
     * <ul>
     *   <li>If the array is empty or null, this method returns 0.</li>
     *   <li>Use a long accumulator if values can exceed int range.</li>
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
            // Add current element to running total
            sum += arr[i];
        }

        return sum;
    }

    /**
     * Counts how many numbers are odd and how many are even in the array.
     *
     * <p><b>Core Idea:</b>
     * Use modulus check:</p>
     * <ul>
     *   <li><code>num % 2 == 0</code> → Even</li>
     *   <li>Otherwise → Odd</li>
     * </ul>
     *
     * @param arr input array of integers
     * @return formatted string showing odd & even counts
     */
    public static String countOddEven(int[] arr) {
        if (arr == null || arr.length == 0)
            return "Odds = 0, Evens = 0";

        int odd = 0;
        int even = 0;

        // Single-pass classification
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            // Check parity
            if (val % 2 == 0) {
                even++;  // Even number
            } else {
                odd++;   // Odd number
            }
        }

        return "Odds = " + odd + ", Evens = " + even;
    }
}