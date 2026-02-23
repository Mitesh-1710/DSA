/**
 * Problem:
 * Given a string {@code s}, return the string after replacing
 * every uppercase letter with the same lowercase letter.
 *
 * <p>This is the solution to <b>LeetCode Problem 709: To Lower Case</b></p>
 * <p>🔗 https://leetcode.com/problems/to-lower-case/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The task is straightforward: convert uppercase letters
 * to lowercase while keeping other characters unchanged.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Use built-in method {@code s.toLowerCase()}.</li>
 * </ul>
 *
 * <p>This works perfectly but hides the underlying character logic.</p>
 *
 * <p>Optimized / Educational Approach:</p>
 * <ul>
 *   <li>Manually convert characters using ASCII arithmetic.</li>
 *   <li>Traverse the string once.</li>
 * </ul>
 *
 * <p>This demonstrates understanding of character encoding.</p>
 *
 * -----------------------------------------------------------------------
 * <b>ASCII Case Conversion Concept (Detailed Explanation):</b>
 *
 * <p>In ASCII encoding:</p>
 * <pre>
 * 'A' → 65
 * 'Z' → 90
 *
 * 'a' → 97
 * 'z' → 122
 * </pre>
 *
 * <p>The difference between uppercase and lowercase letters is constant:</p>
 *
 * <pre>
 * 'a' - 'A' = 32
 * </pre>
 *
 * <p>Therefore, to convert an uppercase letter to lowercase:</p>
 *
 * <pre>
 * lowercase = uppercase + ('a' - 'A')
 * </pre>
 *
 * <p>We only apply this transformation if the character
 * lies within the uppercase range.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert string to character array.</li>
 *   <li>Traverse each character.</li>
 *   <li>If character is between 'A' and 'Z':</li>
 *   <ul>
 *     <li>Add ('a' - 'A') to convert it.</li>
 *   </ul>
 *   <li>Return new string from modified array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   "Hello"
 *
 * Transformation:
 *   'H' → 'h'
 *   'e' → unchanged
 *   'l' → unchanged
 *   'l' → unchanged
 *   'o' → unchanged
 *
 * Output:
 *   "hello"
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * Input:
 *   "LOVELY"
 *
 * Output:
 *   "lovely"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over string.</li>
 *   <li>No extra data structures beyond char array.</li>
 *   <li>Demonstrates understanding of ASCII arithmetic.</li>
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
public class LeetCode709_ToLowerCase {

    public static void main(String[] args) {

        String s = "Hello WORLD";

        String result = toLowerCase(s);

        System.out.println("Lowercase string: " + result);
    }

    /**
     * Converts uppercase letters in the string to lowercase.
     *
     * @param s input string
     * @return lowercase version of string
     */
    public static String toLowerCase(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // Check if character is uppercase
            if (arr[i] >= 'A' && arr[i] <= 'Z') {

                // Convert to lowercase using ASCII difference
                arr[i] += 'a' - 'A';
            }
        }

        return new String(arr);
    }
}