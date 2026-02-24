/**
 * Problem:
 * You are given a string {@code s} and an integer array {@code indices}
 * of the same length.
 *
 * <p>The string {@code s} will be shuffled such that
 * the character at position {@code i} moves to position {@code indices[i]}.</p>
 *
 * <p>Return the shuffled string.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1528: Shuffle String</b></p>
 * <p>🔗 https://leetcode.com/problems/shuffle-string/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem defines a direct mapping:</p>
 * <pre>
 * original index i  →  new index indices[i]
 * </pre>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Create a new string builder.</li>
 *   <li>For each position, insert character at correct index.</li>
 * </ul>
 *
 * <p>However, inserting into StringBuilder at arbitrary positions
 * is costly (O(n) per insertion).</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Create a character array of the same length.</li>
 *   <li>Place each character directly at its target index.</li>
 * </ul>
 *
 * <p>This avoids shifting and ensures linear time.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Direct Index Mapping Concept (Detailed Explanation):</b>
 *
 * <p>The array {@code indices} represents a permutation of positions.</p>
 *
 * <p>Meaning:</p>
 * <ul>
 *   <li>No duplicate positions.</li>
 *   <li>Every index from 0 to n-1 appears exactly once.</li>
 * </ul>
 *
 * <p>Thus, we can safely assign:</p>
 * <pre>
 * result[indices[i]] = s.charAt(i)
 * </pre>
 *
 * <p>This guarantees:</p>
 * <ul>
 *   <li>Each position is filled exactly once.</li>
 *   <li>No overwriting occurs.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a char array of size n.</li>
 *   <li>Traverse from i = 0 to n-1.</li>
 *   <li>Place {@code s.charAt(i)} at position {@code indices[i]}.</li>
 *   <li>Return new String from array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * s = "code"
 * indices = [3, 1, 2, 0]
 *
 * Mapping:
 * i = 0 → 'c' → position 3
 * i = 1 → 'o' → position 1
 * i = 2 → 'd' → position 2
 * i = 3 → 'e' → position 0
 *
 * Result array:
 * ['e', 'o', 'd', 'c']
 *
 * Output:
 * "eodc"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over input.</li>
 *   <li>No shifting or resizing operations.</li>
 *   <li>Direct placement using permutation property.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — extra array for rearranged characters.
 * -----------------------------------------------------------------------
 */
public class LeetCode1528_ShuffleString {

    public static void main(String[] args) {

        String s = "eodc";
        int[] indices = {3, 1, 2, 0};

        String result = restoreString(s, indices);

        System.out.println("Shuffled string: " + result);
    }

    /**
     * Restores the shuffled string using given index mapping.
     *
     * @param s        input string
     * @param indices  permutation array
     * @return shuffled string
     */
    public static String restoreString(String s, int[] indices) {

        char[] arr = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {

            // Place character at its correct position
            arr[indices[i]] = s.charAt(i);
        }

        return new String(arr);
    }
}