/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Return the sum of all elements that appear exactly once in the array.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1748:
 * Sum of Unique Elements</b></p>
 * <p>🔗 https://leetcode.com/problems/sum-of-unique-elements/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need:
 *
 * <pre>
 * sum of elements with frequency == 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Build frequency map.</li>
 *   <li>Iterate again and sum elements with freq == 1.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n + n) = O(n)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (Single Pass):</b>
 *
 * Instead of two passes, we update sum dynamically:
 *
 * <ul>
 *   <li>First occurrence → add to sum</li>
 *   <li>Second occurrence → remove from sum</li>
 *   <li>Further occurrences → ignore</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Frequency State Transition</b>
 *
 * Each number goes through states:
 *
 * <pre>
 * freq = 0 → not seen
 * freq = 1 → unique → include in sum
 * freq = 2 → duplicate → remove from sum
 * freq > 2 → ignore
 * </pre>
 *
 * So:
 *
 * <pre>
 * if freq becomes 1 → add
 * if freq becomes 2 → subtract
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create frequency array (bounded constraint).</li>
 *   <li>Initialize sum = 0.</li>
 *   <li>Traverse nums:</li>
 *   <ul>
 *     <li>Increment frequency.</li>
 *     <li>If freq == 1 → add number.</li>
 *     <li>If freq == 2 → subtract number.</li>
 *   </ul>
 *   <li>Return sum.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 3, 2]
 *
 * Step-by-step:
 *
 * 1 → freq=1 → sum=1
 * 2 → freq=1 → sum=3
 * 3 → freq=1 → sum=6
 * 2 → freq=2 → sum=4 (remove duplicate)
 *
 * Output:
 * 4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>Avoids second iteration.</li>
 *   <li>Efficient state-based updates.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1) (bounded array size)
 * -----------------------------------------------------------------------
 */
public class LeetCode1748_SumOfUniqueElements {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2};

        int result = sumOfUnique(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Returns sum of unique elements using incremental updates.
     */
    public static int sumOfUnique(int[] nums) {

        int[] freq = new int[101]; // constraint-based optimization
        int sum = 0;

        for (int num : nums) {

            freq[num]++;

            if (freq[num] == 1) {
                sum += num;         // first occurrence
            } else if (freq[num] == 2) {
                sum -= num;         // became duplicate
            }
        }

        return sum;
    }
}