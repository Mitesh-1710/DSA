import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers {@code nums} and an integer {@code target},
 * return the indices of the two numbers such that they add up to {@code target}.
 *
 * <p>This is the solution to <b>LeetCode Problem 1: Two Sum</b></p>
 * <p>🔗 https://leetcode.com/problems/two-sum/</p>
 *
 * <p>Each input has exactly one solution, and the same element
 * cannot be used twice.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The brute-force approach would check every possible pair,
 * resulting in O(n²) time complexity.</p>
 *
 * <p>To optimize this, we use a <b>HashMap</b> to store previously
 * seen numbers along with their indices.</p>
 *
 * <p>For each element {@code nums[i]}:</p>
 * <ul>
 *   <li>Compute the required complement: <code>needed = target - nums[i]</code></li>
 *   <li>If {@code needed} already exists in the map, we have found the solution.</li>
 *   <li>Otherwise, store the current number and its index in the map.</li>
 * </ul>
 *
 * <p>This ensures we find the answer in a single pass.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   nums = [2, 7, 11, 15]
 *   target = 9
 *
 * Iteration:
 *   i=0 → num=2 → needed=7 → not found → store (2 → 0)
 *   i=1 → num=7 → needed=2 → found at index 0
 *
 * Output:
 *   [0, 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the array.<br>
 * <b>Space Complexity:</b> O(n) — hash map stores up to n elements.
 * -----------------------------------------------------------------------
 */
public class LeetCode1_TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    /**
     * Returns the indices of the two numbers that add up to the target.
     *
     * @param nums   input array of integers
     * @param target target sum
     * @return indices of the two numbers, or {-1, -1} if not found
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            // If complement already exists, return indices
            if (indexMap.containsKey(needed)) {
                return new int[]{indexMap.get(needed), i};
            }

            // Store current value with its index
            indexMap.put(nums[i], i);
        }

        // No valid pair found (for completeness)
        return new int[]{-1, -1};
    }
}