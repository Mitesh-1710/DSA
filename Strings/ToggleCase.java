/**
 * Problem:
 * Given a string {@code s}, toggle the case of each alphabetic character:
 * <ul>
 *   <li>Uppercase letters are converted to lowercase.</li>
 *   <li>Lowercase letters are converted to uppercase.</li>
 * </ul>
 *
 * <p>Non-alphabetic characters must remain unchanged.</p>
 *
 * <p>The relative order of characters must be preserved.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The problem can be solved efficiently by processing the string
 * character-by-character:</p>
 *
 * <ul>
 *   <li>Convert the string into a character array for in-place modification.</li>
 *   <li>Iterate through each character once.</li>
 *   <li>Use ASCII value ranges to detect uppercase and lowercase letters.</li>
 * </ul>
 *
 * <p>For each character:</p>
 * <ul>
 *   <li>If it lies between {@code 'A'–'Z'}, convert it to lowercase.</li>
 *   <li>If it lies between {@code 'a'–'z'}, convert it to uppercase.</li>
 *   <li>Otherwise, leave it unchanged.</li>
 * </ul>
 *
 * <p>This avoids additional data structures and keeps the solution linear.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   "Hello World 123"
 *
 * Transformation:
 *   'H' → 'h'
 *   'e' → 'E'
 *   'l' → 'L'
 *   'o' → 'O'
 *   ' ' → ' '
 *   'W' → 'w'
 *
 * Output:
 *   "hELLO wORLD 123"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Empty string.</li>
 *   <li>String with no alphabetic characters.</li>
 *   <li>String with all uppercase or all lowercase letters.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the string.<br>
 * <b>Space Complexity:</b> O(n) — character array used for transformation.
 * -----------------------------------------------------------------------
 */
public class ToggleCase {

    public static void main(String[] args) {

        String input = "Hello World 123";

        String result = toggleCase(input);

        System.out.println("Transformed string:");
        System.out.println(result);
    }

    /**
     * Toggles the case of each alphabetic character in the given string.
     *
     * @param s input string
     * @return string with toggled character cases
     */
    public static String toggleCase(String s) {
        char[] result = s.toCharArray();

        for (int i = 0; i < result.length; i++) {
            char current = result[i];

            if (current >= 'A' && current <= 'Z') {
                result[i] = (char) (current + ('a' - 'A'));
            } else if (current >= 'a' && current <= 'z') {
                result[i] = (char) (current - ('a' - 'A'));
            }
        }

        return new String(result);
    }
}