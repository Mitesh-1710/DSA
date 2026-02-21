import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Problem:
 * Given an integer array {@code nums}, return a list of all elements
 * that appear more than once in the array.
 *
 * <p>The order of elements in the result does not matter.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task requires identifying elements whose frequency
 * is greater than 1.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>For each element, count its occurrences by scanning the array.</li>
 *   <li>If count > 1, add it to result.</li>
 * </ul>
 *
 * <p>This results in O(n²) time complexity.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Use a HashMap to store frequencies.</li>
 *   <li>Traverse the array once to build frequency map.</li>
 *   <li>Traverse the map to collect elements with frequency > 1.</li>
 * </ul>
 *
 * <p>This reduces time complexity to linear time.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Frequency Counting Concept (Detailed Explanation):</b>
 *
 * <p>A {@link java.util.HashMap} allows us to store:</p>
 * <pre>
 * key   → element value
 * value → number of occurrences
 * </pre>
 *
 * <p>While traversing the array:</p>
 * <ul>
 *   <li>If element is seen for the first time → store with count 1.</li>
 *   <li>If already present → increment count.</li>
 * </ul>
 *
 * <p>After building the frequency map:</p>
 * <ul>
 *   <li>Any key with value > 1 is a repeating element.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create an empty HashMap for frequency counting.</li>
 *   <li>Traverse the array and update frequencies.</li>
 *   <li>Create a result list.</li>
 *   <li>Traverse the map and add elements with frequency > 1.</li>
 *   <li>Return the result list.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * nums = [1, 2, 3, 2, 4, 5, 1]
 *
 * Frequency map:
 * 1 → 2
 * 2 → 2
 * 3 → 1
 * 4 → 1
 * 5 → 1
 *
 * Repeating elements:
 * [1, 2]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass for counting.</li>
 *   <li>Efficient frequency lookup using HashMap.</li>
 *   <li>Scales well for large arrays.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n) — single traversal of array + map iteration.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — in worst case when all elements are unique.
 * -----------------------------------------------------------------------
 */
public class FindRepeatingElements {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 4, 5, 1};

        List<Integer> result = findRepeatingElements(nums);

        System.out.println("Repeating elements: " + result);
    }

    /**
     * Returns a list of elements that appear more than once.
     *
     * @param nums input array
     * @return list of repeating elements
     */
    public static List<Integer> findRepeatingElements(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Build frequency map
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        // Step 2: Collect elements with frequency > 1
        for (int key : freq.keySet()) {
            if (freq.get(key) > 1) {
                res.add(key);
            }
        }

        return res;
    }
}