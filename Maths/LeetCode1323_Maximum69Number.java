/**
 * Problem:
 * You are given a positive integer {@code num} consisting only
 * of digits 6 and 9.
 *
 * <p>You may change at most one digit:
 * 6 ↔ 9</p>
 *
 * <p>Return the maximum number you can obtain.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1323:
 * Maximum 69 Number</b></p>
 * <p>🔗 https://leetcode.com/problems/maximum-69-number/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The goal is to maximize the number by changing
 * at most one digit.
 *
 * Observation:
 * <ul>
 *   <li>Changing 9 → 6 decreases the number.</li>
 *   <li>Changing 6 → 9 increases the number.</li>
 * </ul>
 *
 * Therefore, we should:
 * <ul>
 *   <li>Change the most significant 6 to 9.</li>
 * </ul>
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert number to string.</li>
 *   <li>Replace the first occurrence of '6' with '9'.</li>
 * </ul>
 *
 * This works but involves string conversion.
 *
 * Optimized Mathematical Approach:
 * <ul>
 *   <li>Traverse digits using modulo arithmetic.</li>
 *   <li>Track the position of the most significant 6.</li>
 *   <li>Modify the number using positional arithmetic.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Most Significant Digit Replacement Concept (Detailed Explanation):</b>
 *
 * Why most significant 6?
 *
 * Because changing a digit in a higher place value
 * has a larger impact.
 *
 * Example:
 *
 * <pre>
 * 9669
 *
 * Changing leftmost 6 → 9969  (increase by 300)
 * Changing rightmost 6 → 9699 (increase by 3)
 * </pre>
 *
 * Clearly, changing the leftmost 6 gives maximum benefit.
 *
 * Since we extract digits from right to left using modulo,
 * we record the last seen 6 while scanning —
 * which corresponds to the most significant 6.
 *
 * To change a 6 to 9:
 *
 * <pre>
 * 9 - 6 = 3
 * </pre>
 *
 * So we add:
 *
 * <pre>
 * 3 × 10^position
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize position counter.</li>
 *   <li>Traverse digits using modulo.</li>
 *   <li>If digit == 6, record its position.</li>
 *   <li>After traversal, if a 6 exists:</li>
 *   <ul>
 *     <li>Add 3 × 10^position to the number.</li>
 *   </ul>
 *   <li>Return modified number.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * num = 9669
 *
 * Positions (from right):
 * index 0 → 9
 * index 1 → 6
 * index 2 → 6
 * index 3 → 9
 *
 * Most significant 6 is at position 2.
 *
 * Add 3 × 10^2 = 300
 *
 * Result = 9969
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * num = 9999
 * No 6 present → return 9999
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No string conversion required.</li>
 *   <li>Single pass over digits.</li>
 *   <li>Direct positional arithmetic.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is number of digits.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode1323_Maximum69Number {

    public static void main(String[] args) {

        int num = 9669;

        int result = maximum69Number(num);

        System.out.println("Maximum number: " + result);
    }

    /**
     * Returns the maximum number by changing at most one digit.
     *
     * @param num input number consisting of digits 6 and 9
     * @return maximum possible number
     */
    public static int maximum69Number(int num) {

        int temp = num;
        int position = 0;
        int sixPosition = -1;

        // Traverse digits from right to left
        while (temp > 0) {

            if (temp % 10 == 6) {
                sixPosition = position;  // Record position of 6
            }

            temp /= 10;
            position++;
        }

        // If a 6 exists, convert most significant one to 9
        if (sixPosition != -1) {
            num += 3 * (int) Math.pow(10, sixPosition);
        }

        return num;
    }
}