import java.util.HashSet;

/**
 * Problem:
 * Determine whether an integer array contains <b>consecutive elements</b>
 * with <b>no duplicates</b>.
 *
 * <p>An array is considered consecutive if:</p>
 * <ul>
 *   <li>All elements are unique.</li>
 *   <li>The difference between the maximum and minimum values is exactly
 *       <code>(length - 1)</code>.</li>
 * </ul>
 *
 * <p>The order of elements in the array does not matter.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>For a set of numbers to be consecutive:</p>
 *
 * <ul>
 *   <li>The count of unique numbers must equal the array length.</li>
 *   <li>If the numbers are consecutive, then:
 *       <pre>max - min + 1 == array length</pre>
 *   </li>
 * </ul>
 *
 * <p>Approach:</p>
 * <ul>
 *   <li>Traverse the array once.</li>
 *   <li>Track the minimum and maximum values.</li>
 *   <li>Use a {@link HashSet} to detect duplicates.</li>
 * </ul>
 *
 * <p>If a duplicate is found, the array cannot be consecutive.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [4, 2, 3, 5, 6]
 *
 * min = 2
 * max = 6
 * length = 5
 *
 * Check:
 *   max - min + 1 = 6 - 2 + 1 = 5 → valid
 *
 * Output: true
 * </pre>
 *
 * <pre>
 * Input:  [1, 2, 4, 5]
 *
 * min = 1
 * max = 5
 * length = 4
 *
 * Check:
 *   max - min + 1 = 5 → not equal to length
 *
 * Output: false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Single-element array → always consecutive.</li>
 *   <li>Array with duplicates → not consecutive.</li>
 *   <li>Array with gaps between numbers → not consecutive.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal with constant-time set operations.<br>
 * <b>Space Complexity:</b> O(n) — additional space for the HashSet.
 * -----------------------------------------------------------------------
 */
public class IsConsecutive {

    public static void main(String[] args) {

        int[] nums1 = {4, 2, 3, 5, 6};
        int[] nums2 = {1, 2, 4, 5};

        System.out.println("Is consecutive (nums1): " + isConsecutive(nums1));
        System.out.println("Is consecutive (nums2): " + isConsecutive(nums2));
    }

    /**
     * Checks whether the given array contains consecutive integers
     * with no duplicates.
     *
     * @param nums input integer array
     * @return {@code true} if array elements are consecutive, otherwise {@code false}
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static boolean isConsecutive(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> seen = new HashSet<>();

        // Traverse array to find min, max, and detect duplicates
        for (int num : nums) {

            // Duplicate found
            if (seen.contains(num)) {
                return false;
            }

            seen.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Check if range matches the number of elements
        return max - min + 1 == nums.length;
    }
}