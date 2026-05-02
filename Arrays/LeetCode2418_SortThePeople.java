import java.util.Arrays;

/**
 * Problem:
 * You are given two arrays:
 *
 * <pre>
 * names[i]   → name of the i-th person
 * heights[i] → height of the i-th person
 * </pre>
 *
 * Return the array of names sorted in descending order of heights.
 *
 * <p>This is the solution to <b>LeetCode Problem 2418:
 * Sort the People</b></p>
 * <p>🔗 https://leetcode.com/problems/sort-the-people/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to sort people based on heights, but:
 *
 * <pre>
 * names and heights are in separate arrays
 * </pre>
 *
 * So we must maintain the mapping between them while sorting.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Create a list of (name, height) pairs.</li>
 *   <li>Sort the list by height in descending order.</li>
 *   <li>Extract names.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n log n)
 * </pre>
 *
 * Space:
 *
 * <pre>
 * O(n) (for storing pairs)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Instead of creating pairs, sort indices based on heights.
 *
 * <ul>
 *   <li>Create an index array: [0, 1, 2, ..., n-1]</li>
 *   <li>Sort indices using heights as reference.</li>
 *   <li>Rebuild result using sorted indices.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Indirect Sorting (Index-Based Sorting)</b>
 *
 * Instead of rearranging original arrays, we:
 *
 * <pre>
 * sort indices based on values in another array
 * </pre>
 *
 * -----------------------------------------------------
 * <b>1. Index Mapping</b>
 *
 * <pre>
 * indices[i] = i
 * </pre>
 *
 * This preserves original positions.
 *
 * -----------------------------------------------------
 * <b>2. Custom Comparator</b>
 *
 * We sort indices using:
 *
 * <pre>
 * heights[b] - heights[a]
 * </pre>
 *
 * This ensures:
 *
 * <ul>
 *   <li>Descending order</li>
 *   <li>No modification to original arrays</li>
 * </ul>
 *
 * -----------------------------------------------------
 * <b>3. Reconstruction Step</b>
 *
 * After sorting indices:
 *
 * <pre>
 * result[i] = names[indices[i]]
 * </pre>
 *
 * This maps sorted order back to names.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create Integer[] indices of size n.</li>
 *   <li>Initialize indices with 0...n-1.</li>
 *   <li>Sort indices based on heights in descending order.</li>
 *   <li>Create result array.</li>
 *   <li>Fill result using sorted indices.</li>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * names   = ["Mary","John","Emma"]
 * heights = [180,165,170]
 *
 * indices = [0,1,2]
 *
 * After sorting (by heights desc):
 * indices = [0,2,1]
 *
 * Result:
 * ["Mary","Emma","John"]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids creating extra pair objects.</li>
 *   <li>Keeps original arrays intact.</li>
 *   <li>Flexible and reusable pattern.</li>
 *   <li>Efficient comparator-based sorting.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n log n)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode2418_SortThePeople {

    public static void main(String[] args) {

        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        String[] result = sortPeople(names, heights);

        System.out.println(Arrays.toString(result));
    }

    /**
     * Sorts people based on heights using index-based sorting.
     */
    public static String[] sortPeople(String[] names, int[] heights) {

        Integer[] indices = new Integer[heights.length];

        // Initialize indices
        for (int i = 0; i < heights.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on heights (descending)
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        String[] result = new String[heights.length];

        // Reconstruct result using sorted indices
        for (int i = 0; i < indices.length; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}