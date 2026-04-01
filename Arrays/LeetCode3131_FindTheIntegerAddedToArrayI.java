/**
 * Problem:
 * You are given two integer arrays {@code nums1} and {@code nums2}.
 *
 * <p>Array {@code nums2} is formed by adding a fixed integer {@code x}
 * to every element of {@code nums1} and then shuffling.</p>
 *
 * <p>Your task is to find the integer {@code x}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3131:
 * Find the Integer Added to Array I</b></p>
 * <p>🔗 https://leetcode.com/problems/find-the-integer-added-to-array-i/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We are told:
 *
 * <pre>
 * nums2[i] = nums1[i] + x  (after rearrangement)
 * </pre>
 *
 * So:
 *
 * <pre>
 * x = nums2[i] - nums1[i]
 * </pre>
 *
 * However, arrays are shuffled → indices do not match.
 *
 * -----------------------------------------------------------------------
 * <b>Key Observation (IMPORTANT):</b>
 *
 * The smallest element in {@code nums1} will map to the smallest element
 * in {@code nums2} after adding {@code x}.
 *
 * Why?
 *
 * <ul>
 *   <li>Adding a constant preserves relative order.</li>
 *   <li>Sorting order remains unchanged.</li>
 * </ul>
 *
 * So:
 *
 * <pre>
 * min(nums2) = min(nums1) + x
 * </pre>
 *
 * Therefore:
 *
 * <pre>
 * x = min(nums2) - min(nums1)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Order Preservation</b>
 *
 * When a constant is added to all elements:
 *
 * <ul>
 *   <li>Relative ordering does not change.</li>
 *   <li>Minimum stays minimum.</li>
 *   <li>Maximum stays maximum.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * nums1 = [3, 5, 7]
 * x = 4
 *
 * nums2 = [7, 9, 11]
 * </pre>
 *
 * min1 = 3
 * min2 = 7
 *
 * x = 7 - 3 = 4
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Find minimum value in nums1.</li>
 *   <li>Find minimum value in nums2.</li>
 *   <li>Return difference (min2 - min1).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums1 = [1, 2, 3]
 * nums2 = [4, 5, 6]
 *
 * min1 = 1
 * min2 = 4
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
 *   <li>Single pass through arrays.</li>
 *   <li>Constant-time computation.</li>
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
public class LeetCode3131_FindTheIntegerAddedToArrayI {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};

        int result = addedInteger(nums1, nums2);

        System.out.println("Added integer: " + result);
    }

    /**
     * Finds the integer added to all elements.
     */
    public static int addedInteger(int[] nums1, int[] nums2) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {

            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }

        return min2 - min1;
    }
}