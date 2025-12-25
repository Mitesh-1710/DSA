/**
 * Problem:
 * Given two integer arrays {@code nums1} and {@code nums2},
 * return an array of their intersection.
 *
 * <p>Each element in the result must be <b>unique</b> and
 * the order of elements in the result does not matter.</p>
 *
 * <p>This is the solution to LeetCode Problem 349:
 * <br>https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key requirement is to:</p>
 * <ul>
 *   <li>Return only elements present in <b>both arrays</b></li>
 *   <li>Avoid duplicates in the output</li>
 * </ul>
 *
 * <p><b>Approach Used: Frequency Presence Mapping</b></p>
 *
 * <ul>
 *   <li>Create two boolean arrays to track the presence of numbers
 *       in {@code nums1} and {@code nums2}</li>
 *   <li>Index represents the number, value represents whether it exists</li>
 *   <li>Since constraints limit values to {@code 0 ≤ value ≤ 1000},
 *       fixed-size arrays can be used</li>
 * </ul>
 *
 * <p><b>Steps:</b></p>
 * <ol>
 *   <li>Mark all values from {@code nums1} as present</li>
 *   <li>Mark all values from {@code nums2} as present</li>
 *   <li>Count values present in both maps</li>
 *   <li>Build the result array using those common values</li>
 * </ol>
 *
 * <p>This guarantees uniqueness because each number is added only once.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * Presence Map:
 * nums1 → {1,2}
 * nums2 → {2}
 *
 * Output:
 * [2]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n + m + k)
 * <ul>
 *   <li>n = length of nums1</li>
 *   <li>m = length of nums2</li>
 *   <li>k = fixed range (0 to 1000)</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(1)
 * <p>Constant space due to fixed-size boolean arrays.</p>
 * -----------------------------------------------------------------------
 */
public class LeetCode349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.print("Intersection: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /**
     * Returns an array containing the unique intersection of two integer arrays.
     *
     * <p>This method uses presence-mapping to efficiently track
     * which numbers appear in both arrays.</p>
     *
     * @param nums1 first input array
     * @param nums2 second input array
     * @return array of unique common elements
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        // Presence maps for numbers 0 to 1000
        boolean[] presentInNums1 = new boolean[1001];
        boolean[] presentInNums2 = new boolean[1001];

        // Mark presence for nums1
        for (int value : nums1) {
            presentInNums1[value] = true;
        }

        // Mark presence for nums2
        for (int value : nums2) {
            presentInNums2[value] = true;
        }

        // Count common elements
        int commonCount = 0;
        for (int i = 0; i <= 1000; i++) {
            if (presentInNums1[i] && presentInNums2[i]) {
                commonCount++;
            }
        }

        // Build result array
        int[] result = new int[commonCount];
        int index = 0;

        for (int i = 0; i <= 1000; i++) {
            if (presentInNums1[i] && presentInNums2[i]) {
                result[index++] = i;
            }
        }

        return result;
    }
}