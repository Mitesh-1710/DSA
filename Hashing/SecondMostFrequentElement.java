import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an integer array {@code nums}, find the <b>second most frequent element</b>.
 *
 * <p>If multiple elements have the same frequency, the <b>smaller element</b>
 * is preferred.</p>
 *
 * <p>The frequency of an element is the number of times it appears in the array.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The solution is divided into two clear phases:</p>
 *
 * <ul>
 *   <li><b>Phase 1:</b> Count the frequency of each element using a hash map.</li>
 *   <li><b>Phase 2:</b> Traverse the frequency map to determine:
 *     <ul>
 *       <li>The most frequent element</li>
 *       <li>The second most frequent element</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Key Observations:</b></p>
 * <ul>
 *   <li>We must track both the element value and its frequency.</li>
 *   <li>While updating the first and second positions:
 *     <ul>
 *       <li>If a higher frequency is found, shift first → second.</li>
 *       <li>If frequencies are equal, pick the smaller element.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Why this works efficiently:</b></p>
 * <ul>
 *   <li>Each element is processed only a constant number of times.</li>
 *   <li>No sorting is required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  [1, 1, 2, 2, 2, 3, 3]
 *
 * Frequencies:
 * 1 → 2
 * 2 → 3
 * 3 → 2
 *
 * Most frequent     = 2
 * Second frequent   = min(1, 3) → 1
 *
 * Output: 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — one pass for counting, one for evaluation.<br>
 * <b>Space Complexity:</b> O(n) — hash map for frequency storage.
 * -----------------------------------------------------------------------
 */
public class SecondMostFrequentElement {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        System.out.println("Second most frequent element: "
                + secondMostFrequentElement(nums));
    }

    /**
     * Returns the second most frequent element in the array.
     *
     * <p>If multiple elements have the same frequency, the smaller element
     * is returned.</p>
     *
     * @param nums input integer array
     * @return second most frequent element
     */
    public static int secondMostFrequentElement(int[] nums) {

        // Step 1: Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        // Track most and second most frequent elements
        int mostFrequentElement = -1;
        int secondMostFrequentElement = -1;

        int mostFrequency = 0;
        int secondMostFrequency = 0;

        // Step 2: Evaluate frequencies
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            int element = entry.getKey();
            int frequency = entry.getValue();

            // Case 1: New highest frequency found
            if (frequency > mostFrequency) {
                secondMostFrequency = mostFrequency;
                secondMostFrequentElement = mostFrequentElement;

                mostFrequency = frequency;
                mostFrequentElement = element;

            }
            // Case 2: Tie for highest frequency → choose smaller element
            else if (frequency == mostFrequency) {
                mostFrequentElement = Math.min(mostFrequentElement, element);
            }
            // Case 3: Candidate for second most frequent
            else if (frequency > secondMostFrequency) {
                secondMostFrequency = frequency;
                secondMostFrequentElement = element;
            }
            // Case 4: Tie for second most frequent → choose smaller element
            else if (frequency == secondMostFrequency) {
                secondMostFrequentElement =
                        Math.min(secondMostFrequentElement, element);
            }
        }

        return secondMostFrequentElement;
    }
}