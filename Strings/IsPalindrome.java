/**
 * Problem:
 * Determine whether a given string is a palindrome.
 *
 * <p>
 * A palindrome is a sequence of characters that reads the same
 * forward and backward. Examples include:
 * </p>
 * <ul>
 *   <li>"madam" → palindrome</li>
 *   <li>"racecar" → palindrome</li>
 *   <li>"hello" → not a palindrome</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Palindrome Check:</b>
 *
 * <p>The fundamental observation is that a palindrome exhibits
 * <b>mirror symmetry</b>. That means:</p>
 *
 * <ul>
 *   <li>The first character must equal the last.</li>
 *   <li>The second must equal the second-last.</li>
 *   <li>And so on...</li>
 * </ul>
 *
 * <p>To exploit this symmetry efficiently, we use the
 * <b>Two-Pointer Technique</b>:</p>
 *
 * <ul>
 *   <li><b>Left pointer</b> starts at index 0.</li>
 *   <li><b>Right pointer</b> starts at index length - 1.</li>
 *   <li>Move both inward while comparing characters.</li>
 * </ul>
 *
 * <p><b>Why Two Pointers?</b></p>
 * <ul>
 *   <li>A single linear scan gives a full palindrome verification.</li>
 *   <li>No extra memory is needed (unlike reversing the entire string).</li>
 *   <li>Time complexity remains O(n), which is optimal.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * Input:  "level"
 *
 * left = 0 ('l'), right = 4 ('l') → match
 * left = 1 ('e'), right = 3 ('e') → match
 * left = 2, right = 2              → middle reached
 *
 * Result: true (it's a palindrome)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Brute-Force Approach (for understanding):</b>
 *
 * <p>Compare the string with its reversed version:</p>
 *
 * <pre>
 * reverse(s) and check if reverse(s).equals(s)
 * </pre>
 *
 * <p>
 * This works, but takes extra memory for building the reversed string.
 * The two-pointer approach is more optimal.
 * </p>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single left/right scan.<br>
 * <b>Space Complexity:</b> O(1) — no additional memory needed.
 * -----------------------------------------------------------------------
 */
public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println("1. Is 'madam' palindrome? → " + palindromeCheck("madam"));
        System.out.println("2. Is 'hello' palindrome? → " + palindromeCheck("hello"));
        System.out.println("3. Is 'racecar' palindrome? → " + palindromeCheck("racecar"));
        System.out.println("4. Is 'abca' palindrome? → " + palindromeCheck("abca"));
    }

    /**
     * Determines whether a given string {@code s} is a palindrome.
     *
     * <p>The method uses the efficient two-pointer technique:</p>
     * <ul>
     *   <li>Compare characters from both ends.</li>
     *   <li>If any pair mismatches → not a palindrome.</li>
     *   <li>Otherwise continue until pointers cross.</li>
     * </ul>
     *
     * @param s the input string
     * @return {@code true} if palindrome, else {@code false}
     */
    public static boolean palindromeCheck(String s) {

        int left = 0;
        int right = s.length() - 1;

        // Two-pointer inward scanning
        while (left < right) {

            // 1. Compare mirrored characters
            if (s.charAt(left) != s.charAt(right)) {
                return false; // mismatch → not palindrome
            }

            // 2. Move inward
            left++;
            right--;
        }

        return true; // All mirrored characters matched
    }
}