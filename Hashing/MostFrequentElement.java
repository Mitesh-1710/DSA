import java.util.*;
/**
 * Problem:
 * Given an integer array {@code nums}, find the most frequent element in the array.
 *
 * <ul>
 *   <li>If multiple elements have the same highest frequency, return the <b>smallest</b> among them.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process</b>
 *
 * <p>The task requires tracking how many times each element appears.
 * A simple and powerful approach is to use a <b>frequency map</b>
 * (HashMap) where:</p>
 *
 * <ul>
 *   <li><b>Key</b> → element value</li>
 *   <li><b>Value</b> → occurrence count</li>
 * </ul>
 *
 * <p>As we iterate:</p>
 * <ul>
 *   <li>Update its frequency via {@code freqMap.merge(num, 1, Integer::sum)}.</li>
 *   <li>Track the current maximum frequency.</li>
 *   <li>If the new frequency is greater → update result.</li>
 *   <li>If same frequency but number is smaller → update result.</li>
 * </ul>
 *
 * <p>This ensures the smallest element with highest frequency is chosen.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Works:</b>
 *
 * <ul>
 *   <li>Every element is processed exactly once → O(n).</li>
 *   <li>HashMap gives O(1) average insert and lookup time.</li>
 *   <li>Simultaneous frequency and result tracking avoids extra passes.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * nums = [4, 9, 4, 9, 9, 3, 4]
 *
 * freqMap updates:
 *   4 → 1   → maxFreq = 1, result = 4
 *   9 → 1   → maxFreq = 1, result = 4 (4 < 9)
 *   4 → 2   → maxFreq = 2, result = 4
 *   9 → 2   → same freq, result remains 4 (4 < 9)
 *   9 → 3   → maxFreq = 3, result = 9
 *   3 → 1   → no change
 *   4 → 3   → same freq, result becomes 4 (4 < 9)
 *
 * Final answer = 4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Additional Insight:</b>
 *
 * <p>This approach can be extended to solve:</p>
 * <ul>
 *   <li>Top-K frequent elements</li>
 *   <li>Frequency-based sorting</li>
 *   <li>Finding the mode of a dataset</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass with constant-time map operations.<br>
 * <b>Space Complexity:</b> O(n) — frequency map may store all unique elements.
 * -----------------------------------------------------------------------
 */
public class MostFrequentElement {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3};
        int[] nums2 = {4, 9, 4, 9, 9, 3, 4};
        int[] nums3 = {7, 7, 7, 7};
        int[] nums4 = {5, 3, 3, 5, 3, 5};

        System.out.println("1. Most frequent in [1,2,2,3,3]: " + mostFrequentElement(nums1));
        System.out.println("\n2. Most frequent in [4,9,4,9,9,3,4]: " + mostFrequentElement(nums2));
        System.out.println("\n3. Most frequent in [7,7,7,7]: " + mostFrequentElement(nums3));
        System.out.println("\n4. Most frequent in [5,3,3,5,3,5]: " + mostFrequentElement(nums4));
    }

    /**
     * Returns the most frequent element in {@code nums}.
     * If multiple elements share the same highest frequency,
     * returns the smallest among them.
     */
    public static int mostFrequentElement(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        // Traverse array, build frequency map, and track best candidate
        for (int num : nums) {

            // 1. Update frequency using merge
            freqMap.merge(num, 1, Integer::sum);

            // 2. Retrieve updated frequency
            int count = freqMap.get(num);

            // 3. Check if this num is a better candidate
            if (count > maxFreq || (count == maxFreq && num < result)) {
                maxFreq = count;
                result = num;
            }
        }

        return result;
    }
}
