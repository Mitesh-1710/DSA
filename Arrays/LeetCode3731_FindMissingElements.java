import java.util.List;
import java.util.ArrayList;

/**
 * Problem:
 * Given an integer array {@code nums}, return all integers
 * that are missing between the minimum and maximum values
 * present in the array.
 *
 * <p>That is, for every integer in the range [min(nums), max(nums)],
 * include those numbers that do not appear in {@code nums}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3731:
 * Find Missing Elements</b></p>
 * <p>🔗 https://leetcode.com/problems/find-missing-elements/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires:
 *
 * <ul>
 *   <li>Identifying the full range → from min to max</li>
 *   <li>Checking which numbers in this range are missing</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>For each number from min → max, check if it exists in array.</li>
 *   <li>This leads to O(n²).</li>
 * </ul>
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use a boolean array to mark seen elements.</li>
 *   <li>Track min and max in one pass.</li>
 *   <li>Traverse range and collect missing elements.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Presence Tracking</b>
 *
 * We use:
 *
 * <pre>
 * boolean[] seen
 * </pre>
 *
 * where:
 *
 * <pre>
 * seen[x] = true → x exists in array
 * </pre>
 *
 * This allows O(1) lookup for presence.
 *
 * Steps:
 *
 * <ul>
 *   <li>Mark all numbers present in the array.</li>
 *   <li>Track minimum and maximum values.</li>
 *   <li>Iterate from min to max and collect missing ones.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a boolean array for tracking presence.</li>
 *   <li>Initialize min and max using first element.</li>
 *   <li>Traverse nums:</li>
 *   <ul>
 *     <li>Mark seen[num] = true</li>
 *     <li>Update min and max</li>
 *   </ul>
 *   <li>Traverse range [min, max]:</li>
 *   <ul>
 *     <li>If seen[i] == false → add to result</li>
 *   </ul>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [3, 7, 1, 2, 8]
 *
 * min = 1, max = 8
 *
 * Missing:
 * 4, 5, 6
 *
 * Output:
 * [4, 5, 6]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass to mark elements.</li>
 *   <li>Constant-time lookup using array.</li>
 *   <li>Avoids nested loops.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + range), where range = max - min
 *
 * <b>Space Complexity:</b>
 * O(1) — since range is bounded (0–100)
 * -----------------------------------------------------------------------
 */
public class LeetCode3731_FindMissingElements {

    public static void main(String[] args) {

        int[] nums = {3, 7, 1, 2, 8};

        List<Integer> result = findMissingElements(nums);

        System.out.println("Missing elements: " + result);
    }

    /**
     * Returns all missing elements between min and max.
     */
    public static List<Integer> findMissingElements(int[] nums) {

        List<Integer> result = new ArrayList<>();

        boolean[] seen = new boolean[101]; // constraint-based optimization

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {

            seen[num] = true;

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {

            if (!seen[i]) {
                result.add(i);
            }
        }

        return result;
    }
}