import java.util.PriorityQueue;

/**
 * Problem:
 * You are given an integer array {@code nums}, an integer {@code k},
 * and an integer {@code multiplier}.
 *
 * <p>Perform the following operation exactly {@code k} times:</p>
 * <ul>
 *   <li>Find the minimum element in {@code nums}.</li>
 *   <li>Multiply it by {@code multiplier}.</li>
 *   <li>Replace it in the array.</li>
 * </ul>
 *
 * <p>Return the final state of the array after {@code k} operations.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3264:
 * Final Array State After K Multiplication Operations I</b></p>
 * <p>🔗 https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The operation requires repeatedly selecting the minimum element
 * and updating it. A naive approach would be:</p>
 *
 * <ul>
 *   <li>For each of the {@code k} operations:</li>
 *   <ul>
 *     <li>Scan the entire array to find the minimum.</li>
 *   </ul>
 * </ul>
 *
 * <p>This results in:</p>
 * <pre>
 * Time Complexity: O(k * n)
 * </pre>
 *
 * <p>For small constraints, this nested-loop approach is perfectly fine
 * and may even be faster due to lower overhead.</p>
 *
 * <p>However, for larger inputs (large {@code n} and {@code k}),
 * repeatedly scanning the array becomes inefficient.</p>
 *
 * <p>To optimize, we use a <b>Min-Heap (PriorityQueue)</b>.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Min-Heap Concept:</b>
 *
 * <ul>
 *   <li>A min-heap allows retrieving the smallest element in O(log n).</li>
 *   <li>Insertion also takes O(log n).</li>
 *   <li>Thus each operation becomes efficient.</li>
 * </ul>
 *
 * <p>To preserve array positions:</p>
 * <ul>
 *   <li>Store both value and index in the heap.</li>
 *   <li>When values are equal, compare by index to maintain stability.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Insert all elements into a min-heap as (value, index) pairs.</li>
 *   <li>Repeat {@code k} times:</li>
 *   <ul>
 *     <li>Extract the minimum element.</li>
 *     <li>Multiply it by {@code multiplier}.</li>
 *     <li>Update the array.</li>
 *     <li>Reinsert the updated value into the heap.</li>
 *   </ul>
 *   <li>Return the modified array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [1, 2, 3]
 * k = 2
 * multiplier = 2
 *
 * Operation 1:
 *   min = 1 → 1 * 2 = 2
 *   nums = [2, 2, 3]
 *
 * Operation 2:
 *   min = 2 → 2 * 2 = 4
 *   nums = [4, 2, 3]
 *
 * Final Output:
 *   [4, 2, 3]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Efficient retrieval of minimum element.</li>
 *   <li>Scales well for larger constraints.</li>
 *   <li>Maintains correct index updates.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + k log n)<br>
 * (Heap build + k extract/insert operations)
 *
 * <b>Space Complexity:</b>
 * O(n) — space used by the priority queue.
 * -----------------------------------------------------------------------
 */
public class LeetCode3264_FinalArrayStateAfterKMultiplicationOperationsI {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int k = 2;
        int multiplier = 2;

        int[] result = getFinalState(nums, k, multiplier);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    /**
     * Returns the final array after performing k multiplication operations.
     *
     * @param nums        input array
     * @param k           number of operations
     * @param multiplier  multiplier value
     * @return modified array after k operations
     */
    public static int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                }
        );

        // Build heap
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // Perform k operations
        while (k-- > 0) {

            int[] curr = pq.poll();
            int value = curr[0];
            int index = curr[1];

            int newValue = value * multiplier;
            nums[index] = newValue;

            pq.offer(new int[]{newValue, index});
        }

        return nums;
    }
}