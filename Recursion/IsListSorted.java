import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem:
 * Check whether a given list of integers is sorted in non-decreasing order
 * using recursion.
 *
 * <p>A list is considered sorted if every element is less than or equal to
 * the element that comes after it.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>Instead of checking all elements using loops, we solve the problem
 * recursively by comparing adjacent elements.</p>
 *
 * <ul>
 *   <li>At each step, compare <code>nums[index]</code> with
 *       <code>nums[index + 1]</code>.</li>
 *   <li>If the current pair is ordered correctly, recursively check the rest.</li>
 *   <li>If any pair violates the order, return <code>false</code>.</li>
 * </ul>
 *
 * <p>This approach mirrors how we would check sortedness manually, step by step.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Breakdown:</b>
 *
 * <p><b>Base Case:</b></p>
 * <ul>
 *   <li>If <code>index == nums.size() - 1</code>, we have reached the end.</li>
 *   <li>No violations found so far → the list is sorted.</li>
 * </ul>
 *
 * <p><b>Recursive Case:</b></p>
 * <ul>
 *   <li>If <code>nums[index] > nums[index + 1]</code>, return <code>false</code>.</li>
 *   <li>Otherwise, recursively check the next index.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * nums = [1, 2, 3, 4]
 *
 * Compare 1 <= 2 → OK
 * Compare 2 <= 3 → OK
 * Compare 3 <= 4 → OK
 * Reached end → return true
 * </pre>
 *
 * <pre>
 * nums = [1, 3, 2]
 *
 * Compare 1 <= 3 → OK
 * Compare 3 > 2  → violation → return false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — each element is visited once.<br>
 * <b>Space Complexity:</b> O(n) — recursion stack in the worst case.
 * -----------------------------------------------------------------------
 */
public class IsListSorted {

    public static void main(String[] args) {

        ArrayList<Integer> list1 =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        ArrayList<Integer> list2 =
                new ArrayList<>(Arrays.asList(1, 3, 2, 4));

        System.out.println("List 1 sorted? " + isSorted(list1));
        System.out.println("List 2 sorted? " + isSorted(list2));
    }

    /**
     * Public method to check if the list is sorted.
     *
     * @param nums input list of integers
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(ArrayList<Integer> nums) {
        if (nums == null || nums.size() <= 1) return true;
        return sorted(nums, 0);
    }

    /**
     * Recursive helper method that checks sortedness starting from a given index.
     *
     * @param nums  input list
     * @param index current index being checked
     * @return true if remaining list is sorted
     */
    private static boolean sorted(ArrayList<Integer> nums, int index) {

        // Base Case: reached the last element
        if (index == nums.size() - 1) {
            return true;
        }

        // If current element is greater than next, list is not sorted
        if (nums.get(index) > nums.get(index + 1)) {
            return false;
        }

        // Recursive call for next index
        return sorted(nums, index + 1);
    }
}
