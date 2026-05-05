import java.util.*;

/**
 * Problem:
 * Given a string {@code s}, remove all trailing vowels and return the resulting string.
 *
 * <p>Trailing vowels are defined as consecutive vowels at the end of the string.</p>
 *
 * <pre>
 * vowels = {a, e, i, o, u}
 * </pre>
 *
 * <p>This is the solution to <b>LeetCode Problem 3856:
 * Trim Trailing Vowels</b></p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to:
 *
 * <pre>
 * remove vowels only from the end (suffix), not from the entire string
 * </pre>
 *
 * This suggests a backward traversal.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Check from end repeatedly and remove characters one by one.</li>
 *   <li>Each removal creates a new string.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n²)
 * </pre>
 *
 * (due to repeated substring operations)
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Traverse from end once.</li>
 *   <li>Stop at first non-vowel character.</li>
 *   <li>Return substring up to that index.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Two-Pointer Backward Scan</b>
 *
 * -----------------------------------------------------
 * <b>1. Reverse Traversal for Suffix Problems</b>
 *
 * When dealing with suffix constraints:
 *
 * <pre>
 * start from end → move backward
 * </pre>
 *
 * This avoids unnecessary checks on the entire string.
 *
 * -----------------------------------------------------
 * <b>2. Early Break Optimization</b>
 *
 * As soon as we encounter:
 *
 * <pre>
 * non-vowel character
 * </pre>
 *
 * we stop immediately.
 *
 * This ensures:
 *
 * <ul>
 *   <li>Best case → O(1)</li>
 *   <li>Worst case → O(n)</li>
 * </ul>
 *
 * -----------------------------------------------------
 * <b>3. Substring Boundary Handling</b>
 *
 * After traversal:
 *
 * <pre>
 * valid substring = s[0 ... i]
 * </pre>
 *
 * So:
 *
 * <pre>
 * return s.substring(0, i + 1)
 * </pre>
 *
 * Edge case:
 *
 * <pre>
 * if all characters are vowels → i = -1 → substring(0, 0) → ""
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize pointer i = n - 1.</li>
 *   <li>While i >= 0:</li>
 *   <ul>
 *     <li>If character is vowel → move left.</li>
 *     <li>Else → break.</li>
 *   </ul>
 *   <li>Return substring from 0 to i + 1.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * s = "hellooo"
 *
 * Traversal:
 * i = 6 → 'o' → vowel → i--
 * i = 5 → 'o' → vowel → i--
 * i = 4 → 'o' → vowel → i--
 * i = 3 → 'l' → stop
 *
 * Result:
 * s.substring(0, 4) → "hell"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * s = "aeiou"
 *
 * All vowels → i = -1
 *
 * Result:
 * ""
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single backward pass.</li>
 *   <li>No repeated string creation.</li>
 *   <li>Efficient early stopping.</li>
 *   <li>Clean boundary handling.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3856_TrimTrailingVowels {

    public static void main(String[] args) {

        String s = "hellooo";

        String result = trimTrailingVowels(s);

        System.out.println("Result: " + result);
    }

    /**
     * Removes trailing vowels from the string.
     */
    public static String trimTrailingVowels(String s) {

        int i = s.length() - 1;

        // Traverse from end until non-vowel is found
        while (i >= 0) {

            char c = s.charAt(i);

            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                break;
            }

            i--;
        }

        // Return valid prefix
        return s.substring(0, i + 1);
    }
}