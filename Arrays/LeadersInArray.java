import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Find all <b>leader elements</b> in an integer array.
 *
 * <p>An element is considered a <b>leader</b> if it is strictly greater
 * than all elements to its right.</p>
 *
 * <p>The rightmost element of the array is always a leader.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The key observation is that an element can only be a leader
 * if it is greater than the maximum element seen so far from the right.</p>
 *
 * <ul>
 *   <li>Start traversal from the rightmost element.</li>
 *   <li>Maintain a variable to track the maximum value seen so far.</li>
 *   <li>If the current element is greater than this maximum, it is a leader.</li>
 * </ul>
 *
 * <p>This avoids unnecessary nested loops and results in a linear solution.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [16, 17, 4, 3, 5, 2]
 *
 * Traversal from right:
 *   Start with 2 → leader
 *   5 > 2  → leader
 *   3 < 5  → ignore
 *   4 < 5  → ignore
 *   17 > 5 → leader
 *   16 < 17 → ignore
 *
 * Output:
 *   [17, 5, 2]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Single-element array → that element is a leader.</li>
 *   <li>Strictly increasing array → only the last element is a leader.</li>
 *   <li>Strictly decreasing array → all elements are leaders.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal from right to left.<br>
 * <b>Space Complexity:</b> O(k) — where k is the number of leaders.
 * -----------------------------------------------------------------------
 */
public class LeadersInArray {

    public static void main(String[] args) {

        int[] nums = {16, 17, 4, 3, 5, 2};

        List<Integer> leaders = findLeaders(nums);

        System.out.println("Leaders in array: " + leaders);
    }

    /**
     * Returns a list of leader elements in the array.
     *
     * @param nums input integer array
     * @return list of leaders in their original left-to-right order
     */
    public static List<Integer> findLeaders(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();

        // Rightmost element is always a leader
        int maxFromRight = nums[nums.length - 1];
        result.addFirst(maxFromRight);

        // Traverse from right to left
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] > maxFromRight) {
                maxFromRight = nums[i];
                result.addFirst(maxFromRight);
            }
        }

        return result;
    }
}
