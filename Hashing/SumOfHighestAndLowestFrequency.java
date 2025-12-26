import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an integer array {@code nums}, find the sum of:
 * <ul>
 *   <li>The <b>highest frequency</b> of any element in the array</li>
 *   <li>The <b>lowest frequency</b> of any element in the array</li>
 * </ul>
 *
 * <p>Frequency refers to how many times an element appears in the array.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The problem can be broken into two clear phases:</p>
 *
 * <ul>
 *   <li><b>1. Frequency Counting</b>
 *     <ul>
 *       <li>Use a {@link Map} to store how many times each number appears.</li>
 *       <li>Key   → array element</li>
 *       <li>Value → frequency of that element</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Frequency Analysis</b>
 *     <ul>
 *       <li>Iterate over the frequency values.</li>
 *       <li>Track the maximum frequency.</li>
 *       <li>Track the minimum frequency.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>The final answer is simply:</p>
 * <pre>
 * maxFrequency + minFrequency
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input: nums = [1, 1, 2, 2, 2, 3]
 *
 * Frequencies:
 * 1 → 2
 * 2 → 3
 * 3 → 1
 *
 * Highest frequency = 3
 * Lowest frequency  = 1
 *
 * Output = 3 + 1 = 4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 * <ul>
 *   <li>Single-element array → max = min = 1 → result = 2</li>
 *   <li>All elements unique → max = min = 1 → result = 2</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass to build frequency map,
 * plus a pass over unique elements.<br>
 * <b>Space Complexity:</b> O(k) — where {@code k} is the number of unique elements.
 * -----------------------------------------------------------------------
 */
public class SumOfHighestAndLowestFrequency {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};

        int result = sumHighestAndLowestFrequency(nums);
        System.out.println("Sum of highest and lowest frequency: " + result);
    }

    /**
     * Returns the sum of the highest and lowest frequencies
     * among all elements in the array.
     *
     * @param nums input integer array
     * @return sum of max frequency and min frequency
     */
    public static int sumHighestAndLowestFrequency(int[] nums) {

        // Frequency map: element → count
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 1. Build frequency map
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        // 2. Find max and min frequency
        for (int count : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, count);
            minFrequency = Math.min(minFrequency, count);
        }

        // 3. Return their sum
        return maxFrequency + minFrequency;
    }
}