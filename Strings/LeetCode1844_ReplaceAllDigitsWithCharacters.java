/**
 * Problem:
 * You are given a string {@code s} where:
 *
 * <ul>
 *   <li>Even indices contain lowercase letters.</li>
 *   <li>Odd indices contain digits.</li>
 * </ul>
 *
 * <p>For every odd index {@code i}, replace the digit {@code s[i]}
 * with a character obtained by shifting the previous character
 * {@code s[i-1]} forward in the alphabet by {@code s[i]} positions.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1844:
 * Replace All Digits with Characters</b></p>
 * <p>🔗 https://leetcode.com/problems/replace-all-digits-with-characters/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Each odd index represents a digit that tells how much to shift
 * the previous character.
 *
 * Example:
 *
 * <pre>
 * s = "a1c1e1"
 *
 * a + 1 → b
 * c + 1 → d
 * e + 1 → f
 *
 * Output: "abcdef"
 * </pre>
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert digit character to integer.</li>
 *   <li>Apply shifting using arithmetic or helper functions.</li>
 * </ul>
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use direct ASCII arithmetic.</li>
 *   <li>Convert string to char array for in-place modification.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): ASCII Arithmetic</b>
 *
 * Characters in Java are internally stored as ASCII values.
 *
 * Example:
 *
 * <pre>
 * 'a' = 97
 * 'b' = 98
 * 'c' = 99
 * </pre>
 *
 * If we want to shift a character by a digit:
 *
 * <pre>
 * newChar = previousChar + digit
 * </pre>
 *
 * Since digits are characters:
 *
 * <pre>
 * '3' → ASCII 51
 * </pre>
 *
 * To convert to integer:
 *
 * <pre>
 * digit = s[i] - '0'
 * </pre>
 *
 * Final transformation:
 *
 * <pre>
 * ans[i] = (char)(ans[i - 1] + (ans[i] - '0'))
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert string into character array.</li>
 *   <li>Iterate over odd indices (i = 1, 3, 5...).</li>
 *   <li>Replace digit with shifted character.</li>
 *   <li>Return the updated string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "a1c1e1"
 *
 * Process:
 *
 * i=1 → 'a' + 1 = 'b'
 * i=3 → 'c' + 1 = 'd'
 * i=5 → 'e' + 1 = 'f'
 *
 * Output:
 * "abcdef"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>In-place transformation.</li>
 *   <li>Single traversal.</li>
 *   <li>No extra data structures.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — due to character array (string immutability).
 * -----------------------------------------------------------------------
 */
public class LeetCode1844_ReplaceAllDigitsWithCharacters {

    public static void main(String[] args) {

        String s = "a1c1e1";

        String result = replaceDigits(s);

        System.out.println("Result: " + result);
    }

    /**
     * Replaces digits with shifted characters.
     *
     * @param s input string
     * @return transformed string
     */
    public static String replaceDigits(String s) {

        char[] ans = s.toCharArray();

        for (int i = 1; i < ans.length; i += 2) {

            // Shift previous character by digit value
            ans[i] = (char) (ans[i - 1] + ans[i] - '0');
        }

        return new String(ans);
    }
}