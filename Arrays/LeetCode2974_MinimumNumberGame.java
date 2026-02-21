import java.util.Arrays;

/**
 * Problem:
 * You are given an integer array {@code nums} of even length.
 *
 * <p>You repeatedly perform the following operation:</p>
 * <ul>
 *   <li>Select the two smallest elements from {@code nums}.</li>
 *   <li>Alice removes the smallest element.</li>
 *   <li>Bob removes the next smallest element.</li>
 *   <li>Append Bob's element first, then Alice's element to the result.</li>
 * </ul>
 *
 * <p>Return the resulting array after all elements are processed.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2974: Minimum Number Game</b></p>
 * <p>🔗 https://leetcode.com/problems/minimum-number-game/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The game always selects the two smallest remaining numbers.</p>
 *
 * <p>Naive Simulation:</p>
 * <ul>
 *   <li>Repeatedly find two minimum elements.</li>
 *   <li>Remove them and append in reversed order.</li>
 * </ul>
 *
 * <p>This would require repeated minimum searches and removals,
 * leading to inefficient performance.</p>
 *
 * <p>Optimized Observation:</p>
 * <ul>
 *   <li>If we sort the array first, the smallest elements naturally
 *       appear in adjacent positions.</li>
 *   <li>After sorting, every consecutive pair represents
 *       the two smallest available elements at that stage.</li>
 * </ul>
 *
 * <p>Thus, we simply swap every adjacent pair after sorting.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Sorting + Pair Swapping Concept (Detailed Explanation):</b>
 *
 * <p>After sorting:</p>
 * <pre>
 * nums = [a1, a2, a3, a4, a5, a6, ...]
 * </pre>
 *
 * <p>Game logic dictates:</p>
 * <ul>
 *   <li>Take a1, a2 → append a2, a1</li>
 *   <li>Take a3, a4 → append a4, a3</li>
 *   <li>Take a5, a6 → append a6, a5</li>
 * </ul>
 *
 * <p>This is equivalent to swapping each adjacent pair.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Sort the array.</li>
 *   <li>Traverse the array in steps of 2.</li>
 *   <li>Swap {@code nums[i]} and {@code nums[i + 1]}.</li>
 *   <li>Return the modified array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [5, 4, 2, 3]
 *
 * After sorting:
 * [2, 3, 4, 5]
 *
 * Swap pairs:
 * [3, 2, 5, 4]
 *
 * Output:
 * [3, 2, 5, 4]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Sorting ensures smallest elements are grouped.</li>
 *   <li>Swapping adjacent pairs directly simulates the game.</li>
 *   <li>Simple and efficient implementation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n log n) — due to sorting.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — in-place modification (excluding sort stack space).
 * -----------------------------------------------------------------------
 */
public class LeetCode2974_MinimumNumberGame {

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 3};

        int[] result = numberGame(nums);

        System.out.println(Arrays.toString(result));
    }

    /**
     * Simulates the minimum number game.
     *
     * @param nums input array
     * @return modified array after game simulation
     */
    public static int[] numberGame(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Swap every adjacent pair
        for (int i = 0; i < nums.length - 1; i += 2) {

            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }
}