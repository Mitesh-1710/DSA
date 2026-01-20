/**
 * Problem:
 * Rearrange an integer array so that <b>positive and negative numbers
 * appear alternately</b>.
 *
 * <p>The relative order of positive numbers among themselves and
 * negative numbers among themselves is preserved.</p>
 *
 * <p>It is assumed that the array contains an equal number of
 * positive and negative elements, or that positives can start first.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The idea is to place:</p>
 * <ul>
 *   <li>Positive numbers at <b>even indices</b> (0, 2, 4, ...)</li>
 *   <li>Negative numbers at <b>odd indices</b> (1, 3, 5, ...)</li>
 * </ul>
 *
 * <p>To achieve this efficiently:</p>
 *
 * <ul>
 *   <li>Maintain two pointers:
 *     <ul>
 *       <li><code>positiveIndex</code> → next even index</li>
 *       <li><code>negativeIndex</code> → next odd index</li>
 *     </ul>
 *   </li>
 *   <li>Traverse the original array once.</li>
 *   <li>Place each number directly at its correct position.</li>
 * </ul>
 *
 * <p>This avoids sorting and keeps the solution simple and predictable.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [3, -2, 1, -5, -1, 2]
 *
 * Placement:
 *   3  → arr[0]
 *  -2  → arr[1]
 *   1  → arr[2]
 *  -5  → arr[3]
 *  -1  → arr[5]
 *   2  → arr[4]
 *
 * Output:
 *   [3, -2, 1, -5, 2, -1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array with length 0 → returns empty array.</li>
 *   <li>Array with length 1 → unchanged.</li>
 *   <li>All positives or all negatives → positions may overflow assumptions.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal of the array.<br>
 * <b>Space Complexity:</b> O(n) — auxiliary array for rearranged result.
 * -----------------------------------------------------------------------
 */
public class RearrangeArrayBySign {

    public static void main(String[] args) {

        int[] nums = {3, -2, 1, -5, -1, 2};

        int[] rearranged = rearrangeArray(nums);

        System.out.print("Rearranged array: ");
        for (int num : rearranged) {
            System.out.print(num + " ");
        }
    }

    /**
     * Rearranges the array so that positive and negative numbers
     * appear alternately.
     *
     * @param nums input integer array
     * @return new array with alternating positive and negative values
     */
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int positiveIndex = 0; // even indices
        int negativeIndex = 1; // odd indices

        // Traverse original array
        for (int value : nums) {

            if (value >= 0) {
                result[positiveIndex] = value;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = value;
                negativeIndex += 2;
            }
        }

        return result;
    }
}