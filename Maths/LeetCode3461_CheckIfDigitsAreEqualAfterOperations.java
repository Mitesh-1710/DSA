/**
 * Problem:
 * You are given a string {@code s} consisting of digits.
 *
 * <p>Perform the following operation repeatedly until the string
 * length becomes 2:</p>
 *
 * <ul>
 *   <li>Replace each adjacent pair with their sum modulo 10.</li>
 * </ul>
 *
 * <p>Return {@code true} if the final two digits are equal,
 * otherwise return {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3461:
 * Check If Digits Are Equal in String After Operations I</b></p>
 * <p>🔗 https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We repeatedly reduce the array:
 *
 * <pre>
 * new[i] = (old[i] + old[i+1]) % 10
 * </pre>
 *
 * until only 2 elements remain.
 *
 * This resembles a triangular reduction process.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach (Simulation):</b>
 *
 * <ul>
 *   <li>Convert string to integer array.</li>
 *   <li>Simulate reduction step-by-step.</li>
 *   <li>Stop when size becomes 2.</li>
 * </ul>
 *
 * This is exactly your approach.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Triangle Reduction Pattern</b>
 *
 * Example:
 *
 * <pre>
 * s = "1234"
 *
 * Step 1:
 * [1,2,3,4] → [3,5,7]
 *
 * Step 2:
 * [3,5,7] → [8,2]
 *
 * Result:
 * [8,2] → false
 * </pre>
 *
 * This forms a structure similar to:
 *
 * <pre>
 * Pascal Triangle (mod 10 influence)
 * </pre>
 *
 * Each element is influenced by multiple previous elements.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert string into integer array.</li>
 *   <li>While size > 2:</li>
 *   <ul>
 *     <li>Update each element with adjacent sum % 10.</li>
 *     <li>Reduce size.</li>
 *   </ul>
 *   <li>Compare last two digits.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "3902"
 *
 * Step 1:
 * [3,9,0,2] → [2,9,2]
 *
 * Step 2:
 * [2,9,2] → [1,1]
 *
 * Output:
 * true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Direct simulation matches problem statement.</li>
 *   <li>No extra complex structures needed.</li>
 *   <li>In-place updates reduce space usage.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n²)
 *
 * (Each reduction reduces size by 1 → total operations ≈ n²)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode3461_CheckIfDigitsAreEqualAfterOperations {

    public static void main(String[] args) {

        String s = "3902";

        boolean result = hasSameDigits(s);

        System.out.println("Result: " + result);
    }

    /**
     * Simulates reduction process.
     */
    public static boolean hasSameDigits(String s) {

        int n = s.length();
        int[] a = new int[n];

        // Convert string to integer array
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }

        // Reduce until size becomes 2
        while (n > 2) {

            for (int i = 0; i < n - 1; i++) {

                a[i] = (a[i] + a[i + 1]) % 10;
            }

            n--;
        }

        return a[0] == a[1];
    }
}