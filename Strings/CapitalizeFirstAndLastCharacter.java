/**
 * Problem:
 * Given a string {@code s} consisting of one or more words separated by
 * single spaces, capitalize the <b>first and last character</b> of each word.
 *
 * <p>If a word contains only one character, capitalize that character.</p>
 *
 * <p>The relative order of characters and words must be preserved.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The problem can be solved efficiently by processing the string
 * character-by-character:</p>
 *
 * <ul>
 *   <li>Convert the string into a character array for in-place modification.</li>
 *   <li>Track the start index of each word.</li>
 *   <li>Detect word boundaries using spaces or end of string.</li>
 * </ul>
 *
 * <p>For each detected word:</p>
 * <ul>
 *   <li>Capitalize the first character.</li>
 *   <li>Capitalize the last character (if different from the first).</li>
 * </ul>
 *
 * <p>This avoids splitting the string and keeps the solution linear.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  "hello world a java"
 *
 * Words:
 *   "hello" → "HellO"
 *   "world" → "WorlD"
 *   "a"     → "A"
 *   "java"  → "JavA"
 *
 * Output:
 *   "HellO WorlD A JavA"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>Single-character words.</li>
 *   <li>Single word input.</li>
 *   <li>String with only lowercase or uppercase letters.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass through the string.<br>
 * <b>Space Complexity:</b> O(n) — character array used for transformation.
 * -----------------------------------------------------------------------
 */
public class CapitalizeFirstAndLastCharacter {

    public static void main(String[] args) {

        String input = "hello world a java";

        String result = capitalizeFirstLast(input);

        System.out.println("Transformed string:");
        System.out.println(result);
    }

    /**
     * Capitalizes the first and last character of each word in the string.
     *
     * @param s input string containing words separated by single spaces
     * @return transformed string with capitalized first and last characters
     */
    public static String capitalizeFirstLast(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int wordStart = 0;

        // Traverse characters including an extra iteration for end of string
        for (int i = 0; i <= n; i++) {

            // Word boundary detected
            if (i == n || chars[i] == ' ') {

                int wordEnd = i - 1;

                // Capitalize first character of the word
                chars[wordStart] = Character.toUpperCase(chars[wordStart]);

                // Capitalize last character if word length > 1
                if (wordEnd > wordStart) {
                    chars[wordEnd] = Character.toUpperCase(chars[wordEnd]);
                }

                // Move to the start of next word
                wordStart = i + 1;
            }
        }

        return new String(chars);
    }
}