import java.util.Arrays;

/**
 * Problem:
 * Find the <b>intersection of two sorted integer arrays</b>.
 *
 * <p>The intersection contains elements that appear in <b>both</b> arrays.
 * Each common element is included only once per matching occurrence
 * during traversal.</p>
 *
 * <p>Both input arrays are assumed to be sorted in non-decreasing order.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>This problem can be solved efficiently using a <b>two-pointer approach</b>:</p>
 *
 * <ul>
 *   <li>Use one pointer for each array.</li>
 *   <li>If elements at both pointers are equal, it is part of the intersection.</li>
 *   <li>If elements are not equal, advance the pointer pointing to the smaller value.</li>
 * </ul>
 *
 * <p>This works because the arrays are already sorted.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   nums1 = [1, 2, 3, 4, 5]
 *   nums2 = [2, 4, 6]
 *
 * Traversal:
 *   Match at 2 → add to result
 *   Match at 4 → add to result
 *
 * Output:
 *   [2, 4]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>No common elements → result is empty array.</li>
 *   <li>One or both arrays empty.</li>
 *   <li>All elements common.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n + m) — single traversal of both arrays.<br>
 * <b>Space Complexity:</b> O(min(n, m)) — temporary array for intersection.
 * -----------------------------------------------------------------------
 */
public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 4, 6};

        int[] intersection = intersectionArray(nums1, nums2);

        System.out.print("Intersection of arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }

    /**
     * Returns the intersection of two sorted arrays.
     *
     * @param nums1 first sorted integer array
     * @param nums2 second sorted integer array
     * @return array containing common elements
     */
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, resultIndex = 0;

        // Traverse both arrays
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                temp[resultIndex++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Trim result array to actual size
        return Arrays.copyOf(temp, resultIndex);
    }
}