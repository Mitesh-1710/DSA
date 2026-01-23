import java.util.List;

/**
 * Problem:
 * Given a list of integers, repeatedly <b>transform the array</b> until it
 * reaches a stable state.
 *
 * <p>The transformation rules for each element (except the first and last) are:</p>
 *
 * <ul>
 *   <li>If an element is strictly greater than both its neighbors,
 *       decrement it by 1.</li>
 *   <li>If an element is strictly smaller than both its neighbors,
 *       increment it by 1.</li>
 *   <li>Otherwise, leave it unchanged.</li>
 * </ul>
 *
 * <p>The process continues until <b>no element changes</b> in an iteration.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>This problem requires simulating changes over multiple iterations
 * until a stable configuration is reached.</p>
 *
 * <p>Key observations:</p>
 * <ul>
 *   <li>The first and last elements never change.</li>
 *   <li>Each iteration depends only on the values from the previous iteration.</li>
 *   <li>We must avoid modifying the array while reading from it.</li>
 * </ul>
 *
 * <p>Approach:</p>
 * <ul>
 *   <li>Maintain two arrays:
 *     <ul>
 *       <li><code>current</code> → represents the current state</li>
 *       <li><code>next</code> → stores the updated state</li>
 *     </ul>
 *   </li>
 *   <li>Apply transformation rules to generate the next state.</li>
 *   <li>Repeat until no changes occur.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [1, 6, 3, 4, 3, 5]
 *
 * Iteration 1:
 *   6 > 1 and 6 > 3 → 5
 *   3 < 6 and 3 < 4 → 4
 *   4 unchanged
 *   3 < 4 and 3 < 5 → 4
 *
 * Result: [1, 5, 4, 4, 4, 5]
 *
 * Iteration 2:
 *   No element satisfies transformation rules
 *
 * Final Output:
 *   [1, 5, 4, 4, 4, 5]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Array size ≤ 2 → already stable.</li>
 *   <li>Array already stable → no changes applied.</li>
 *   <li>Large values → safe due to incremental updates.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(k × n), where:
 * <ul>
 *   <li>n = number of elements</li>
 *   <li>k = number of iterations until stabilization</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(n) — two auxiliary arrays used.
 * -----------------------------------------------------------------------
 */
public class TransformArrayUntilStable {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 6, 3, 4, 3, 5);

        // Convert to mutable list for transformation
        nums = new java.util.ArrayList<>(nums);

        List<Integer> result = transformArray(nums);

        System.out.println("Transformed array: " + result);
    }

    /**
     * Transforms the array repeatedly until no changes occur.
     *
     * @param arr input list of integers
     * @return transformed list in its stable state
     */
    public static List<Integer> transformArray(List<Integer> arr) {

        int n = arr.size();
        if (n <= 2) return arr;

        // Current and next state arrays
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = arr.get(i);
        }

        int[] next = new int[n];

        // First and last elements never change
        next[0] = current[0];
        next[n - 1] = current[n - 1];

        boolean changed;

        // Repeat until array stabilizes
        do {
            changed = false;

            // Apply transformation rules
            for (int i = 1; i < n - 1; i++) {
                int value = current[i];

                if (current[i - 1] < value && value > current[i + 1]) {
                    next[i] = value - 1;
                    changed = true;
                } else if (current[i - 1] > value && value < current[i + 1]) {
                    next[i] = value + 1;
                    changed = true;
                } else {
                    next[i] = value;
                }
            }

            // Swap current and next arrays
            int[] temp = current;
            current = next;
            next = temp;

        } while (changed);

        // Copy final stable values back to the list
        for (int i = 1; i < n - 1; i++) {
            arr.set(i, current[i]);
        }

        return arr;
    }
}