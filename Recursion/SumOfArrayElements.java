/**
 * Problem:
 * Given an integer array {@code nums}, compute the sum of all its elements
 * using <b>recursion</b>.
 *
 * <p>This class demonstrates how a repetitive accumulation problem
 * (array summation) can be solved by breaking it into smaller subproblems.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Using Recursion:</b>
 *
 * <p>The idea is to reduce the problem size step by step:</p>
 * <ul>
 *   <li>At each step, add the current element to the sum of the remaining array.</li>
 *   <li>Delegate the responsibility of summing the rest to the recursive call.</li>
 * </ul>
 *
 * <p><b>Key Observation:</b></p>
 * <ul>
 *   <li>Sum of array from index {@code i} =
 *       {@code nums[i] + sum(nums, i + 1)}</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Structure:</b>
 *
 * <ul>
 *   <li><b>Base Case:</b>
 *     <ul>
 *       <li>If index reaches the array length → return 0.</li>
 *     </ul>
 *   </li>
 *   <li><b>Recursive Case:</b>
 *     <ul>
 *       <li>Add current element and recurse for the next index.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * nums = [1, 2, 3, 4]
 *
 * sum(0) = 1 + sum(1)
 * sum(1) = 2 + sum(2)
 * sum(2) = 3 + sum(3)
 * sum(3) = 4 + sum(4)
 * sum(4) = 0   ← base case
 *
 * Final Sum = 1 + 2 + 3 + 4 = 10
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Comparison with Iterative Approach:</b>
 *
 * <ul>
 *   <li><b>Iterative:</b> Uses loops, more space-efficient.</li>
 *   <li><b>Recursive:</b> Cleaner logic, but uses call stack space.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — each element processed once.<br>
 * <b>Space Complexity:</b> O(n) — recursion call stack.
 * -----------------------------------------------------------------------
 */
public class SumOfArrayElements {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {};
        int[] a3 = {-1, 2, -3, 4};

        System.out.println("1. Sum of [1,2,3,4]: " + sumArray(a1));
        System.out.println("\n2. Sum of []: " + sumArray(a2));
        System.out.println("\n3. Sum of [-1,2,-3,4]: " + sumArray(a3));
    }

    /**
     * Public helper method to compute array sum using recursion.
     *
     * @param nums input array
     * @return sum of elements
     */
    public static int sumArray(int[] nums) {

        // Defensive check
        if (nums == null || nums.length == 0) return 0;

        return sumArrayRecursive(nums, 0);
    }

    /**
     * Recursive method that computes sum starting from a given index.
     *
     * <p>Logic:</p>
     * <ul>
     *   <li>If index reaches array length → return 0.</li>
     *   <li>Otherwise, return current value + recursive result.</li>
     * </ul>
     *
     * @param nums  input array
     * @param index current position
     * @return sum from index to end
     */
    private static int sumArrayRecursive(int[] nums, int index) {

        // Base Case: no elements left
        if (index == nums.length) {
            return 0;
        }

        // Recursive Case:
        // current element + sum of remaining elements
        return nums[index] + sumArrayRecursive(nums, index + 1);
    }
}