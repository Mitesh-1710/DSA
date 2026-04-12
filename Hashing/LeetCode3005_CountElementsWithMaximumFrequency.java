/**
 * Problem:
 * You are given an integer array {@code nums}.
 *
 * <p>Return the total number of elements that appear with the
 * <b>maximum frequency</b>.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3005:
 * Count Elements With Maximum Frequency</b></p>
 * <p>🔗 https://leetcode.com/problems/count-elements-with-maximum-frequency/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need:
 *
 * <pre>
 * 1. Find maximum frequency (maxFreq)
 * 2. Count how many elements have that frequency
 * 3. Return total occurrences → count * maxFreq
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Build frequency array/map.</li>
 *   <li>Find max frequency.</li>
 *   <li>Traverse again to count elements with maxFreq.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n + range)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (Single Pass):</b>
 *
 * While building frequency:
 *
 * <ul>
 *   <li>Track max frequency dynamically.</li>
 *   <li>Track count of elements reaching max frequency.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Dynamic Max Tracking</b>
 *
 * For each number:
 *
 * <pre>
 * f = updated frequency
 * </pre>
 *
 * Cases:
 *
 * 1️. New maximum found:
 *
 * <pre>
 * f > maxFreq → update maxFreq
 * count = 1 (new leader)
 * </pre>
 *
 * 2️. Same maximum:
 *
 * <pre>
 * f == maxFreq → increment count
 * </pre>
 *
 * 3️. Smaller frequency:
 *
 * <pre>
 * ignore
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create frequency array.</li>
 *   <li>Initialize maxFreq = 0, count = 0.</li>
 *   <li>Traverse nums:</li>
 *   <ul>
 *     <li>Increment frequency.</li>
 *     <li>Update maxFreq and count accordingly.</li>
 *   </ul>
 *   <li>Return count * maxFreq.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 2, 3, 1, 4]
 *
 * Frequencies:
 * 1 → 2
 * 2 → 2
 * 3 → 1
 * 4 → 1
 *
 * maxFreq = 2
 * elements with maxFreq = 2 (1 and 2)
 *
 * Output:
 * 2 * 2 = 4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass solution.</li>
 *   <li>No second iteration needed.</li>
 *   <li>Efficient state tracking.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1) (bounded frequency array)
 * -----------------------------------------------------------------------
 */
public class LeetCode3005_CountElementsWithMaximumFrequency {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 4};

        int result = maxFrequencyElements(nums);

        System.out.println("Result: " + result);
    }

    /**
     * Returns total count of elements with maximum frequency.
     */
    public static int maxFrequencyElements(int[] nums) {

        int[] freq = new int[101];

        int maxFreq = 0;
        int count = 0;

        for (int num : nums) {

            int f = ++freq[num];

            if (f > maxFreq) {

                // New maximum frequency found
                maxFreq = f;
                count = 1;

            } else if (f == maxFreq) {

                // Another element reaches max frequency
                count++;
            }
        }

        return count * maxFreq;
    }
}