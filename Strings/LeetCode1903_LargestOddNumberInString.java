/**
 * Problem:
 * You are given a numeric string {@code num}.
 *
 * <p>Return the largest-valued odd integer (as a string)
 * that is a non-empty substring of {@code num}.</p>
 *
 * <p>A number is odd if its last digit is odd.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1903:
 * Largest Odd Number in String</b></p>
 * <p>🔗 https://leetcode.com/problems/largest-odd-number-in-string/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The goal is to find the largest odd substring from the given string.
 *
 * Observation:
 * The value of a number depends on its leftmost digits,
 * so the largest possible substring must start at index 0.
 *
 * Therefore we only need to determine the rightmost position
 * where the number becomes odd.
 *
 * Key Insight:
 * A number is odd if its last digit is odd.
 *
 * Instead of generating all substrings, we simply scan from
 * the rightmost digit until we find the first odd digit.
 *
 * Once an odd digit is found at index i:
 *
 * <pre>
 * substring = num.substring(0, i + 1)
 * </pre>
 *
 * This produces the largest odd substring.
 *
 * -----------------------------------------------------------------------
 * <b>Bitwise Odd Check Concept (Detailed Explanation):</b>
 *
 * A digit is odd if its least significant bit is 1.
 *
 * Example:
 *
 * <pre>
 * '3' ASCII → 51 → 110011
 * '5' ASCII → 53 → 110101
 * '7' ASCII → 55 → 110111
 * </pre>
 *
 * Notice that odd digits always have the last bit set.
 *
 * So we can check oddness using:
 *
 * <pre>
 * (num.charAt(i) & 1) == 1
 * </pre>
 *
 * This works because:
 *
 * <pre>
 * even number  → last bit = 0
 * odd number   → last bit = 1
 * </pre>
 *
 * This avoids converting the character to an integer.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Traverse the string from right to left.</li>
 *   <li>Check if the current digit is odd.</li>
 *   <li>If found, return substring from index 0 to i+1.</li>
 *   <li>If no odd digit exists, return an empty string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "35427"
 *
 * Scan from right:
 *
 * 7 → odd
 *
 * Return:
 * "35427"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 * "4206"
 *
 * Scan:
 * 6 → even
 * 0 → even
 * 2 → even
 * 4 → even
 *
 * No odd digit found → return ""
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass from right to left.</li>
 *   <li>No substring generation except final result.</li>
 *   <li>Uses efficient bitwise odd detection.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode1903_LargestOddNumberInString {

    public static void main(String[] args) {

        String num = "35427";

        String result = largestOddNumber(num);

        System.out.println("Largest odd substring: " + result);
    }

    /**
     * Returns the largest odd-valued substring.
     *
     * @param num numeric string
     * @return largest odd substring
     */
    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            // Check if digit is odd using bitwise operation
            if ((num.charAt(i) & 1) == 1) {

                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}