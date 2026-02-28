import java.util.Arrays;

/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Repeatedly perform the following operation:</p>
 * <ul>
 *   <li>Select the smallest and largest elements.</li>
 *   <li>Compute their average.</li>
 *   <li>Track the minimum average obtained across all such pairs.</li>
 * </ul>
 *
 * <p>Return the minimum average value.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3194:
 * Minimum Average of Smallest and Largest Elements</b></p>
 * <p>🔗 https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * At first glance, the problem appears to require repeatedly finding
 * minimum and maximum elements dynamically.
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>In each iteration, scan the array to find min and max.</li>
 *   <li>Remove them and compute average.</li>
 *   <li>Repeat until all elements are paired.</li>
 * </ul>
 *
 * This would result in O(n²) time complexity.
 *
 * <p>Optimized Observation:</p>
 * <ul>
 *   <li>If we sort the array first, smallest elements appear at the beginning,
 *       and largest elements at the end.</li>
 *   <li>Then we can use two pointers to pair them efficiently.</li>
 * </ul>
 *
 * This reduces complexity significantly.
 *
 * -----------------------------------------------------------------------
 * <b>Sorting + Two-Pointer Pairing Concept (Detailed Explanation):</b>
 *
 * After sorting:
 *
 * <pre>
 * nums = [a1, a2, a3, ..., an]
 * </pre>
 *
 * The smallest element is at index 0,
 * and the largest element is at index n-1.
 *
 * <p>We pair:</p>
 *
 * <pre>
 * (a1, an)
 * (a2, an-1)
 * (a3, an-2)
 * ...
 * </pre>
 *
 * Using two pointers:
 * <ul>
 *   <li>{@code left = 0}</li>
 *   <li>{@code right = n - 1}</li>
 * </ul>
 *
 * After computing each average, we move:
 *
 * <pre>
 * left++
 * right--
 * </pre>
 *
 * This ensures all smallest-largest combinations are evaluated exactly once.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Sort the array.</li>
 *   <li>Initialize left pointer at 0 and right pointer at n-1.</li>
 *   <li>Initialize minimum average as Double.MAX_VALUE.</li>
 *   <li>While left < right:</li>
 *   <ul>
 *     <li>Compute average of nums[left] and nums[right].</li>
 *     <li>Update minimum if needed.</li>
 *     <li>Move both pointers inward.</li>
 *   </ul>
 *   <li>Return minimum average.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [7, 8, 3, 4, 15, 13]
 *
 * After sorting:
 * [3, 4, 7, 8, 13, 15]
 *
 * Pairings:
 * (3, 15) → avg = 9.0
 * (4, 13) → avg = 8.5
 * (7, 8)  → avg = 7.5
 *
 * Minimum average = 7.5
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Sorting enables structured pairing.</li>
 *   <li>Two-pointer technique ensures linear pairing after sort.</li>
 *   <li>Avoids repeated scanning for min/max.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n log n) — due to sorting.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — in-place sorting (excluding recursion stack).
 * -----------------------------------------------------------------------
 */
public class LeetCode3194_MinimumAverageOfSmallestAndLargestElements {

    public static void main(String[] args) {

        int[] nums = {7, 8, 3, 4, 15, 13};

        double result = minimumAverage(nums);

        System.out.println("Minimum average: " + result);
    }

    /**
     * Returns the minimum average of smallest-largest pairs.
     *
     * @param nums input array
     * @return minimum average value
     */
    public static double minimumAverage(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        double minAvg = Double.MAX_VALUE;

        // Step 2: Pair smallest with largest
        while (left < right) {

            double avg = (nums[left] + nums[right]) / 2.0;

            if (avg < minAvg) {
                minAvg = avg;
            }

            left++;
            right--;
        }

        return minAvg;
    }
}