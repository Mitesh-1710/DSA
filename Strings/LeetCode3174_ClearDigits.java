/**
 * Problem:
 * Given a string {@code s} consisting of lowercase letters and digits,
 * process the string such that:
 *
 * <ul>
 *   <li>If a digit is encountered, remove the closest non-digit character
 *       to its left (if any).</li>
 *   <li>Otherwise, keep the character.</li>
 * </ul>
 *
 * Return the resulting string after processing all characters.
 *
 * <p>This is the solution to <b>LeetCode Problem 3174:
 * Clear Digits</b></p>
 * <p>🔗 https://leetcode.com/problems/clear-digits/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem behaves like:
 *
 * <pre>
 * "push characters" and "pop when digit appears"
 * </pre>
 *
 * Naive Approach:
 * <ul>
 *   <li>Use a stack (Stack<Character>).</li>
 *   <li>Push characters.</li>
 *   <li>When digit appears → pop one character.</li>
 * </ul>
 *
 * This works but introduces extra object overhead.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Simulate a stack using a character array.</li>
 *   <li>Use a pointer {@code idx} as the stack top.</li>
 * </ul>
 *
 * This avoids using an actual stack and improves performance.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Stack Simulation Using Array</b>
 *
 * Instead of:
 *
 * <pre>
 * Stack<Character>
 * </pre>
 *
 * we use:
 *
 * <pre>
 * char[] result
 * int idx → acts as stack pointer
 * </pre>
 *
 * Operations:
 *
 * <ul>
 *   <li>Push → {@code result[idx++] = c}</li>
 *   <li>Pop  → {@code idx--}</li>
 * </ul>
 *
 * This mimics stack behavior with O(1) operations.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a character array of size n.</li>
 *   <li>Initialize idx = 0.</li>
 *   <li>Traverse each character:</li>
 *   <ul>
 *     <li>If digit → decrement idx (pop), if possible.</li>
 *     <li>If letter → store in array and increment idx.</li>
 *   </ul>
 *   <li>Construct result string from array up to idx.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "abc3d"
 *
 * Process:
 *
 * a → push → [a]
 * b → push → [a,b]
 * c → push → [a,b,c]
 * 3 → pop  → [a,b]
 * d → push → [a,b,d]
 *
 * Output:
 * "abd"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Simulates stack without extra overhead.</li>
 *   <li>Single pass through the string.</li>
 *   <li>Efficient push/pop operations.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) — for the result array.
 * -----------------------------------------------------------------------
 */
public class LeetCode3174_ClearDigits {

    public static void main(String[] args) {

        String s = "abc3d";

        String result = clearDigits(s);

        System.out.println("Result: " + result);
    }

    /**
     * Removes characters based on digit instructions.
     */
    public static String clearDigits(String s) {

        char[] result = new char[s.length()];
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // If digit → simulate pop
            if (c >= '0' && c <= '9') {

                if (idx > 0) idx--;

            } else {

                // Push character
                result[idx++] = c;
            }
        }

        return new String(result, 0, idx);
    }
}