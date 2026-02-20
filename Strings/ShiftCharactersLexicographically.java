/**
 * Problem:
 * Given a string {@code s}, change every alphabetic character
 * to its next lexicographic character.
 *
 * <p>Rules:</p>
 * <ul>
 *   <li>For lowercase letters: 'a' → 'b', ..., 'z' → 'a'</li>
 *   <li>For uppercase letters: 'A' → 'B', ..., 'Z' → 'A'</li>
 *   <li>Non-alphabetic characters remain unchanged.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem requires shifting each letter forward by one
 * position in the alphabet, with wrap-around behavior.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Use multiple conditional checks for each letter.</li>
 *   <li>Handle edge cases explicitly (e.g., 'z' → 'a').</li>
 * </ul>
 *
 * <p>This works but can become verbose.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Use arithmetic properties of character encoding (ASCII).</li>
 *   <li>Leverage modulo operation for wrap-around.</li>
 * </ul>
 *
 * <p>This keeps the implementation concise and scalable.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Lexicographic Shift Concept (Detailed Explanation):</b>
 *
 * <p>For lowercase letters:</p>
 * <pre>
 * 'a' → ASCII 97
 * 'z' → ASCII 122
 * </pre>
 *
 * <p>To shift a character:</p>
 * <pre>
 * newChar = base + (current - base + 1) % 26
 * </pre>
 *
 * <p>Where:</p>
 * <ul>
 *   <li>{@code base} is 'a' for lowercase letters.</li>
 *   <li>{@code base} is 'A' for uppercase letters.</li>
 *   <li>{@code (current - base)} gives position in alphabet.</li>
 *   <li>{@code +1} shifts forward.</li>
 *   <li>{@code % 26} ensures wrap-around.</li>
 * </ul>
 *
 * <p>This ensures:</p>
 * <ul>
 *   <li>'z' becomes 'a'</li>
 *   <li>'Z' becomes 'A'</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert string to character array.</li>
 *   <li>Traverse each character.</li>
 *   <li>If uppercase → apply uppercase shift formula.</li>
 *   <li>If lowercase → apply lowercase shift formula.</li>
 *   <li>Ignore non-alphabetic characters.</li>
 *   <li>Return new string from modified array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   "AbcZz!"
 *
 * Transformation:
 *   'A' → 'B'
 *   'b' → 'c'
 *   'c' → 'd'
 *   'Z' → 'A'
 *   'z' → 'a'
 *   '!' → unchanged
 *
 * Output:
 *   "BcdAa!"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses constant-time arithmetic operations.</li>
 *   <li>No additional data structures required.</li>
 *   <li>Handles wrap-around elegantly using modulo.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — due to character array copy.
 * -----------------------------------------------------------------------
 */
public class ShiftCharactersLexicographically {

    public static void main(String[] args) {

        String s = "AbcZz!";

        String result = shiftCharacters(s);

        System.out.println("Shifted string: " + result);
    }

    /**
     * Shifts each alphabetic character to its next lexicographic character.
     *
     * @param s input string
     * @return transformed string
     */
    public static String shiftCharacters(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            char c = arr[i];

            // Shift uppercase letters
            if (c >= 'A' && c <= 'Z') {
                arr[i] = (char) ('A' + (c - 'A' + 1) % 26);
            }
            // Shift lowercase letters
            else if (c >= 'a' && c <= 'z') {
                arr[i] = (char) ('a' + (c - 'a' + 1) % 26);
            }
        }

        return new String(arr);
    }
}