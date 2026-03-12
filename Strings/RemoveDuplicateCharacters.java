import java.lang.StringBuilder;

/**
 * Problem:
 * Given a string {@code s} consisting of lowercase English letters,
 * remove duplicate characters so that each character appears only once
 * while preserving the original order of appearance.
 *
 * Example:
 * <pre>
 * Input:  "programming"
 * Output: "progamin"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The goal is to remove duplicate characters while keeping the
 * first occurrence of each character.
 *
 * Naive Approach:
 * <ul>
 *   <li>Traverse the string and check whether the character
 *       already exists in the result string.</li>
 *   <li>If not present, append it.</li>
 * </ul>
 *
 * However, checking existence inside a growing string requires scanning,
 * resulting in:
 *
 * <pre>
 * O(n²)
 * </pre>
 *
 * which becomes inefficient for longer strings.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use a constant-size structure to track characters already seen.</li>
 *   <li>Append characters only the first time they appear.</li>
 * </ul>
 *
 * Since the alphabet contains only 26 lowercase letters,
 * we can track presence efficiently.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Character Presence Tracking</b>
 *
 * Each lowercase character maps to an index:
 *
 * <pre>
 * 'a' → 0
 * 'b' → 1
 * ...
 * 'z' → 25
 * </pre>
 *
 * Using this mapping we can track characters using:
 *
 * <pre>
 * boolean[] seen = new boolean[26];
 * </pre>
 *
 * When processing character {@code c}:
 *
 * <pre>
 * seen[c - 'a']
 * </pre>
 *
 * If the value is false, the character has not appeared before.
 *
 * We then:
 * <ul>
 *   <li>Mark it as seen.</li>
 *   <li>Add it to the result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Bitmask Optimization (Advanced Concept):</b>
 *
 * Instead of using a boolean array, we can compress the entire
 * alphabet tracking into a single integer using bit manipulation.
 *
 * Mapping:
 *
 * <pre>
 * bit 0  → 'a'
 * bit 1  → 'b'
 * ...
 * bit 25 → 'z'
 * </pre>
 *
 * To create the bit for a character:
 *
 * <pre>
 * int bit = 1 << (c - 'a');
 * </pre>
 *
 * Check if character was seen:
 *
 * <pre>
 * (mask & bit) != 0
 * </pre>
 *
 * Mark character as seen:
 *
 * <pre>
 * mask |= bit
 * </pre>
 *
 * This compresses the entire set of characters into **one integer**.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a boolean array to track characters.</li>
 *   <li>Create a StringBuilder for the result.</li>
 *   <li>Traverse the string character by character.</li>
 *   <ul>
 *     <li>If character not seen → mark seen and append.</li>
 *   </ul>
 *   <li>Return the final string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "programming"
 *
 * Process:
 *
 * p → add
 * r → add
 * o → add
 * g → add
 * r → skip
 * a → add
 * m → add
 * m → skip
 * i → add
 * n → add
 * g → skip
 *
 * Output:
 * "progamin"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass through the string.</li>
 *   <li>Constant-time duplicate detection.</li>
 *   <li>Maintains original order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the string length.
 *
 * <b>Space Complexity:</b>
 * O(1) — fixed-size tracking structure.
 * -----------------------------------------------------------------------
 */
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        String s = "programming";

        String result = removeDuplicates(s);

        System.out.println("Result: " + result);
    }

    /**
     * Removes duplicate characters while preserving order.
     */
    public static String removeDuplicates(String s) {

        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (!seen[c - 'a']) {

                seen[c - 'a'] = true;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}