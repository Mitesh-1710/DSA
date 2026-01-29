/**
 * Problem:
 * Given an integer array {@code nums}, find the element that appears more than
 * ⌊n / 2⌋ times. You may assume that the majority element always exists.
 *
 * <p>This is the solution to <b>LeetCode Problem 169: Majority Element</b></p>
 * <p>🔗 https://leetcode.com/problems/majority-element/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key observation is that the majority element appears more than half
 * of the time. This allows us to use the <b>Boyer–Moore Voting Algorithm</b>,
 * which works in linear time and constant space.</p>
 *
 * <p>The idea is based on pair cancellation:</p>
 * <ul>
 *   <li>Different elements cancel each other out.</li>
 *   <li>The majority element survives because it appears more than all others combined.</li>
 * </ul>
 *
 * <p><b>Algorithm Intuition:</b></p>
 * <ul>
 *   <li>Maintain a <b>candidate</b> and a <b>count</b>.</li>
 *   <li>If {@code count == 0}, choose the current element as the new candidate.</li>
 *   <li>If the current element equals the candidate, increment the count.</li>
 *   <li>Otherwise, decrement the count.</li>
 * </ul>
 *
 * <p>By the end of the iteration, the remaining candidate is guaranteed
 * to be the majority element.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input: nums = [2,2,1,1,1,2,2]
 *
 * Step-by-step:
 * i=0 → candidate=2, count=1
 * i=1 → same as candidate → count=2
 * i=2 → different → count=1
 * i=3 → different → count=0
 * i=4 → count=0 → new candidate=1, count=1
 * i=5 → different → count=0
 * i=6 → count=0 → new candidate=2, count=1
 *
 * Output: 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the array.<br>
 * <b>Space Complexity:</b> O(1) — no extra data structures used.
 * -----------------------------------------------------------------------
 */
public class LeetCode169_MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int majority = majorityElement(nums);
        System.out.println("Majority Element: " + majority);
    }

    /**
     * Returns the majority element using Boyer–Moore Voting Algorithm.
     *
     * <p><b>Core rules:</b></p>
     * <ul>
     *   <li>If {@code count == 0}, select the current element as candidate.</li>
     *   <li>If current element equals candidate → increment count.</li>
     *   <li>Otherwise → decrement count.</li>
     * </ul>
     *
     * @param nums input array (majority element always exists)
     * @return the majority element
     */
    public static int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        // Single-pass voting process
        for (int i = 0; i < nums.length; i++) {

            // If no active candidate, choose current element
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            // Same element reinforces the candidate
            else if (nums[i] == candidate) {
                count++;
            }
            // Different element cancels one vote
            else {
                count--;
            }
        }

        return candidate;
    }
}