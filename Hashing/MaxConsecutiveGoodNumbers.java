import java.util.HashSet;
import java.util.Set;
/**
 * Problem:
 * Given an integer array {@code nums} and another integer array
 * {@code goodNumbers}, find the length of the <b>maximum number of
 * consecutive elements</b> in {@code nums} that belong to {@code goodNumbers}.
 *
 * <p>An element in {@code nums} is considered <b>good</b> if it exists
 * in the {@code goodNumbers} array.</p>
 *
 * <p>The order of elements in {@code nums} must be preserved.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The goal is to detect the longest continuous sequence of valid
 * ("good") numbers in the array.</p>
 *
 * <p>A naive approach would be:</p>
 * <ul>
 *   <li>For each element in {@code nums}, search {@code goodNumbers}
 *       linearly to check if it is good.</li>
 * </ul>
 *
 * <p>This results in poor performance. To optimize:</p>
 *
 * <ul>
 *   <li>Convert {@code goodNumbers} into a {@link java.util.Set} for
 *       constant-time lookups.</li>
 *   <li>Traverse {@code nums} once while maintaining:</li>
 *   <ul>
 *     <li>A counter for the current consecutive good sequence.</li>
 *     <li>A variable to track the maximum sequence length seen so far.</li>
 *   </ul>
 * </ul>
 *
 * <p>If a number is good, increment the current count.</p>
 * <p>If a number is not good, reset the current count to zero.</p>
 *
 * <p>This sliding-window style traversal ensures efficiency.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums        = [1, 2, 3, 2, 2, 5, 2, 2, 2]
 * goodNumbers = [2, 3]
 *
 * Traversal:
 * 1 → not good → current = 0
 * 2 → good     → current = 1
 * 3 → good     → current = 2
 * 2 → good     → current = 3
 * 2 → good     → current = 4
 * 5 → not good → current = 0
 * 2 → good     → current = 1
 * 2 → good     → current = 2
 * 2 → good     → current = 3
 *
 * Output:
 *   4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>{@code nums} is empty.</li>
 *   <li>{@code goodNumbers} is empty.</li>
 *   <li>No elements in {@code nums} are good.</li>
 *   <li>All elements in {@code nums} are good.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + m), where {@code n} is the length of {@code nums} and
 * {@code m} is the length of {@code goodNumbers}.<br>
 *
 * <b>Space Complexity:</b>
 * O(m) — additional space used for the set of good numbers.
 * -----------------------------------------------------------------------
 */
public class MaxConsecutiveGoodNumbers {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 2, 5, 2, 2, 2};
        int[] goodNumbers = {2, 3};

        int result = maxConsecutiveGoodNums(nums, goodNumbers);

        System.out.println("Maximum consecutive good numbers: " + result);
    }

    /**
     * Returns the maximum number of consecutive elements in {@code nums}
     * that are present in {@code goodNumbers}.
     *
     * @param nums        input array to scan
     * @param goodNumbers array containing valid (good) numbers
     * @return maximum length of consecutive good numbers
     */
    public static int maxConsecutiveGoodNums(int[] nums, int[] goodNumbers) {

        Set<Integer> goodSet = new HashSet<>(goodNumbers.length);
        for (int num : goodNumbers) {
            goodSet.add(num);
        }

        int max = 0;
        int current = 0;

        for (int num : nums) {
            if (goodSet.contains(num)) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }

        return max;
    }
}