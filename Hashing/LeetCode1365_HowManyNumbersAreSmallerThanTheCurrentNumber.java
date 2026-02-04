/**
 * Problem:
 * Given an integer array {@code nums}, for each element {@code nums[i]},
 * determine how many numbers in the array are <b>strictly smaller</b>
 * than {@code nums[i]}.
 *
 * <p>The result should be returned as an array where each index
 * corresponds to the count for that element.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1365: How Many Numbers Are Smaller Than the Current Number</b></p>
 * <p>🔗 https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>A straightforward (naive) approach would be:</p>
 * <ul>
 *   <li>For each element, compare it with every other element.</li>
 * </ul>
 *
 * <p>This results in O(n²) time complexity, which is inefficient.</p>
 *
 * <p>Observations that help optimize:</p>
 * <ul>
 *   <li>All values in {@code nums} lie in the range {@code 0 ≤ nums[i] ≤ 100}.</li>
 *   <li>This small fixed range allows us to use a counting technique.</li>
 * </ul>
 *
 * <p>Using a frequency array and prefix sums, we can answer each query
 * in constant time.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Frequency Counting Concept:</b>
 *
 * <p>We create an array {@code freq} of size 101 where:</p>
 * <ul>
 *   <li>{@code freq[x]} stores how many times number {@code x} appears.</li>
 * </ul>
 *
 * <p>Example:</p>
 * <pre>
 * nums = [8, 1, 2, 2, 3]
 *
 * freq after counting:
 * freq[1] = 1
 * freq[2] = 2
 * freq[3] = 1
 * freq[8] = 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Prefix Sum Optimization:</b>
 *
 * <p>By converting {@code freq} into a prefix sum array:</p>
 *
 * <pre>
 * freq[i] = freq[i] + freq[i - 1]
 * </pre>
 *
 * <p>After this transformation:</p>
 * <ul>
 *   <li>{@code freq[x]} represents how many numbers are ≤ {@code x}.</li>
 * </ul>
 *
 * <p>Therefore, the count of numbers strictly smaller than {@code x} is:</p>
 * <pre>
 * freq[x - 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Building the Result:</b>
 *
 * <p>For each element {@code nums[i]}:</p>
 * <ul>
 *   <li>If {@code nums[i] == 0}, the answer is {@code 0}.</li>
 *   <li>Otherwise, use {@code freq[nums[i] - 1]}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   nums = [8, 1, 2, 2, 3]
 *
 * Prefix freq:
 *   freq[0] = 0
 *   freq[1] = 1
 *   freq[2] = 3
 *   freq[3] = 4
 *   freq[8] = 5
 *
 * Result:
 *   [4, 0, 1, 1, 3]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids nested loops.</li>
 *   <li>Leverages small value constraints.</li>
 *   <li>Each element is processed in constant time.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + k), where {@code n} is the length of {@code nums} and
 * {@code k = 101} (constant).<br>
 *
 * <b>Space Complexity:</b>
 * O(k) — fixed-size frequency array.
 * -----------------------------------------------------------------------
 */
public class LeetCode1365_HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};

        int[] result = smallerNumbersThanCurrent(nums);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    /**
     * Returns an array where each element represents the count of numbers
     * smaller than the current number.
     *
     * @param nums input array
     * @return array of counts
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];
        int[] freq = new int[101];

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Build prefix sum
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        // Build result
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] > 0 ? freq[nums[i] - 1] : 0;
        }

        return result;
    }
}