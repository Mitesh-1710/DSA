import java.util.Arrays;

/**
 * Problem:
 * Find the <b>union of two sorted integer arrays</b>.
 *
 * <p>The union contains all distinct elements that appear in either
 * of the two arrays, arranged in sorted order.</p>
 *
 * <p>Both input arrays are assumed to be sorted in non-decreasing order.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>This problem is solved efficiently using a <b>two-pointer merge approach</b>,
 * similar to the merge step of Merge Sort:</p>
 *
 * <ul>
 *   <li>Traverse both arrays simultaneously using two pointers.</li>
 *   <li>At each step, select the smaller (or equal) element.</li>
 *   <li>Add the element to the result only if it is not already present.</li>
 * </ul>
 *
 * <p>This guarantees sorted order and avoids duplicates without extra data structures.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   firstArray  = [1, 2, 2, 3, 4]
 *   secondArray = [2, 3, 5]
 *
 * Traversal:
 *   Result = [1, 2, 3, 4, 5]
 *
 * Output:
 *   [1, 2, 3, 4, 5]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>One or both arrays empty.</li>
 *   <li>Arrays with no overlapping elements.</li>
 *   <li>Arrays with all elements common.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n + m) — single traversal of both arrays.<br>
 * <b>Space Complexity:</b> O(n + m) — temporary array for storing result.
 * -----------------------------------------------------------------------
 */
public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] firstArray = {1, 2, 2, 3, 4};
        int[] secondArray = {2, 3, 5};

        int[] union = unionArray(firstArray, secondArray);

        System.out.print("Union of arrays: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
    }

    /**
     * Returns the union of two sorted arrays without duplicates.
     *
     * @param firstArray  first sorted integer array
     * @param secondArray second sorted integer array
     * @return sorted array containing union of both arrays
     */
    public static int[] unionArray(int[] firstArray, int[] secondArray) {
        int i = 0, j = 0, resultIndex = 0;
        int[] temp = new int[firstArray.length + secondArray.length];

        // Merge both arrays while avoiding duplicates
        while (i < firstArray.length && j < secondArray.length) {

            int value;

            if (firstArray[i] <= secondArray[j]) {
                value = firstArray[i++];
            } else {
                value = secondArray[j++];
            }

            // Add only if different from last inserted value
            if (resultIndex == 0 || temp[resultIndex - 1] != value) {
                temp[resultIndex++] = value;
            }
        }

        // Process remaining elements in first array
        while (i < firstArray.length) {
            int value = firstArray[i++];
            if (resultIndex == 0 || temp[resultIndex - 1] != value) {
                temp[resultIndex++] = value;
            }
        }

        // Process remaining elements in second array
        while (j < secondArray.length) {
            int value = secondArray[j++];
            if (resultIndex == 0 || temp[resultIndex - 1] != value) {
                temp[resultIndex++] = value;
            }
        }

        // Return array trimmed to actual size
        return Arrays.copyOf(temp, resultIndex);
    }
}