import java.util.*;

/**
 * Problem:
 * Given an integer array {@code arr}, return {@code true} if the number of occurrences
 * of each value in the array is unique.
 *
 * <p>In other words:</p>
 *
 * <pre>
 * No two distinct numbers should have the same frequency
 * </pre>
 *
 * <p>This is the solution to <b>LeetCode Problem 1207:
 * Unique Number of Occurrences</b></p>
 * <p>🔗 https://leetcode.com/problems/unique-number-of-occurrences/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to ensure:
 *
 * <pre>
 * all frequencies are distinct
 * </pre>
 *
 * This naturally breaks into two steps:
 *
 * <ul>
 *   <li>Count frequencies</li>
 *   <li>Check uniqueness of those frequencies</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Use a HashMap to count frequencies.</li>
 *   <li>Store frequencies in a list.</li>
 *   <li>Compare each pair of frequencies.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n²)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Use frequency array (since range is bounded).</li>
 *   <li>Track seen frequencies using a boolean array.</li>
 *   <li>If any frequency repeats → return false.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Frequency Counting + Uniqueness Tracking</b>
 *
 * -----------------------------------------------------
 * <b>1. Frequency Counting with Offset</b>
 *
 * Given constraints:
 *
 * <pre>
 * -1000 ≤ arr[i] ≤ 1000
 * </pre>
 *
 * We map values using:
 *
 * <pre>
 * index = num + 1000
 * </pre>
 *
 * So:
 *
 * <ul>
 *   <li>freq[0]     → -1000</li>
 *   <li>freq[1000]  → 0</li>
 *   <li>freq[2000]  → 1000</li>
 * </ul>
 *
 * This avoids using HashMap.
 *
 * -----------------------------------------------------
 * <b>2. Frequency Uniqueness Check</b>
 *
 * We use:
 *
 * <pre>
 * boolean[] seen
 * </pre>
 *
 * Where:
 *
 * <pre>
 * seen[f] = true → frequency f already exists
 * </pre>
 *
 * If:
 *
 * <pre>
 * seen[f] == true → duplicate frequency → invalid
 * </pre>
 *
 * -----------------------------------------------------
 * <b>3. Important Observation</b>
 *
 * Maximum frequency can be at most:
 *
 * <pre>
 * n (length of array)
 * </pre>
 *
 * Hence:
 *
 * <pre>
 * seen size = 1001 (safe upper bound)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create frequency array of size 2001.</li>
 *   <li>Count occurrences using offset mapping.</li>
 *   <li>Create boolean array to track seen frequencies.</li>
 *   <li>Traverse frequency array:</li>
 *   <ul>
 *     <li>Skip zero frequencies.</li>
 *     <li>If frequency already seen → return false.</li>
 *     <li>Mark frequency as seen.</li>
 *   </ul>
 *   <li>Return true.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * arr = [1,2,2,1,1,3]
 *
 * Frequencies:
 * 1 → 3
 * 2 → 2
 * 3 → 1
 *
 * seen:
 * index 3 → true
 * index 2 → true
 * index 1 → true
 *
 * All unique → true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * arr = [1,2]
 *
 * Frequencies:
 * 1 → 1
 * 2 → 1
 *
 * seen[1] already true → duplicate → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids HashMap → faster constant factors.</li>
 *   <li>Direct array access (O(1)).</li>
 *   <li>Single pass for counting + single pass for validation.</li>
 *   <li>Clean separation of counting and validation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + k) → O(n)
 * (k = 2001, constant)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * (fixed-size arrays)
 * -----------------------------------------------------------------------
 */
public class LeetCode1207_UniqueNumberOfOccurrences {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};

        boolean result = uniqueOccurrences(arr);

        System.out.println("Result: " + result);
    }

    /**
     * Checks if all occurrence counts are unique.
     */
    public static boolean uniqueOccurrences(int[] arr) {

        int[] freq = new int[2001];

        // Count frequencies using offset
        for (int num : arr) {
            freq[num + 1000]++;
        }

        boolean[] seen = new boolean[1001];

        // Validate uniqueness of frequencies
        for (int f : freq) {

            if (f == 0) continue;

            if (seen[f]) {
                return false;
            }

            seen[f] = true;
        }

        return true;
    }
}