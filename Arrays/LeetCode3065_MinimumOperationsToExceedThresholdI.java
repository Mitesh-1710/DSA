/**
 * Problem:
 * You are given an integer array {@code nums} and an integer {@code k}.
 *
 * <p>In one operation, you can remove any element from the array.</p>
 *
 * <p>Return the minimum number of operations required so that all
 * remaining elements are greater than or equal to {@code k}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3065:
 * Minimum Operations to Exceed Threshold Value I</b></p>
 * <p>🔗 https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We want:
 *
 * <pre>
 * all remaining elements ≥ k
 * </pre>
 *
 * So:
 *
 * <ul>
 *   <li>Any element < k must be removed.</li>
 *   <li>Each removal = 1 operation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Key Observation (IMPORTANT):</b>
 *
 * There is no benefit in keeping elements < k.
 *
 * So the problem reduces to:
 *
 * <pre>
 * count how many elements are < k
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Thinking Trap:</b>
 *
 * You might think:
 *
 * <ul>
 *   <li>Sorting needed ❌</li>
 *   <li>Greedy combining ❌</li>
 *   <li>Priority queue ❌</li>
 * </ul>
 *
 * But actually:
 *
 * ```text
 * Just count elements < k
 * ```
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Filtering / Threshold Pattern</b>
 *
 * We apply a filter:
 *
 * <pre>
 * if (n < k) → remove → count++
 * </pre>
 *
 * This is equivalent to:
 *
 * <pre>
 * number of invalid elements
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize count = 0.</li>
 *   <li>Traverse array:</li>
 *   <ul>
 *     <li>If n < k → increment count.</li>
 *   </ul>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [2, 11, 10, 1, 3]
 * k = 10
 *
 * Elements < 10:
 * 2, 1, 3 → count = 3
 *
 * Output:
 * 3
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No sorting required.</li>
 *   <li>No extra data structures.</li>
 *   <li>Direct logical mapping.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3065_MinimumOperationsToExceedThresholdI {

    public static void main(String[] args) {

        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;

        int result = minOperations(nums, k);

        System.out.println("Minimum Operations: " + result);
    }

    /**
     * Counts elements below threshold.
     */
    public static int minOperations(int[] nums, int k) {

        int count = 0;

        for (int n : nums) {

            if (n < k) {
                count++;
            }
        }

        return count;
    }
}