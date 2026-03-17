import java.lang.StringBuilder;

/**
 * Problem:
 * Given a string {@code s}, remove all vowels from the string
 * and return the resulting string.
 *
 * Vowels include both lowercase and uppercase:
 *
 * <pre>
 * a, e, i, o, u, A, E, I, O, U
 * </pre>
 *
 * Example:
 * <pre>
 * Input:  "Hello World"
 * Output: "Hll Wrld"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires filtering out specific characters (vowels)
 * while preserving the order of the remaining characters.
 *
 * Naive Approach:
 * <ul>
 *   <li>For each character, check if it is a vowel using multiple
 *       comparisons (if-else chain).</li>
 * </ul>
 *
 * This works but becomes verbose and less readable.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Traverse the string once.</li>
 *   <li>Use a switch statement to efficiently identify vowels.</li>
 *   <li>Append only non-vowel characters to the result.</li>
 * </ul>
 *
 * This keeps the logic clean and efficient.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Character Filtering</b>
 *
 * This problem follows the general pattern:
 *
 * <pre>
 * Traverse → Check condition → Keep or skip
 * </pre>
 *
 * For each character:
 *
 * <ul>
 *   <li>If it is a vowel → skip</li>
 *   <li>Otherwise → append to result</li>
 * </ul>
 *
 * The {@code switch} statement allows grouping multiple cases
 * (all vowels) into one block, improving readability.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a StringBuilder for result.</li>
 *   <li>Traverse each character in the string.</li>
 *   <li>If character is a vowel → skip.</li>
 *   <li>Else → append to result.</li>
 *   <li>Return the final string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "Hello World"
 *
 * Process:
 *
 * H → keep
 * e → remove
 * l → keep
 * l → keep
 * o → remove
 *   → keep
 * W → keep
 * o → remove
 * r → keep
 * l → keep
 * d → keep
 *
 * Output:
 * "Hll Wrld"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through the string.</li>
 *   <li>Efficient character filtering.</li>
 *   <li>Readable and maintainable using switch-case grouping.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — for the resulting string.
 * -----------------------------------------------------------------------
 */
public class RemoveVowels {

    public static void main(String[] args) {

        String s = "Hello World";

        String result = removeVowels(s);

        System.out.println("Result: " + result);
    }

    /**
     * Removes all vowels from the string.
     */
    public static String removeVowels(String s) {

        StringBuilder sb = new StringBuilder(s.length());

        for (char c : s.toCharArray()) {

            switch (c) {

                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    // Skip vowels
                    break;

                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}