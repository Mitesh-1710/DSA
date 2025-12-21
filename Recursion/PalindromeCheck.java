/**
 * Problem:
 * Check whether a given string is a palindrome using recursion.
 *
 * <p>A palindrome is a string that reads the same forward and backward.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The recursive approach is based on the idea of comparing characters
 * from the <b>outside moving inward</b>:</p>
 *
 * <ul>
 *   <li>Compare the first and last characters.</li>
 *   <li>If they match, recursively check the remaining substring.</li>
 *   <li>If at any point they differ, the string is not a palindrome.</li>
 * </ul>
 *
 * <p><b>Key Observations:</b></p>
 * <ul>
 *   <li>Only two indices are needed: <code>left</code> and <code>right</code>.</li>
 *   <li>Each recursive call reduces the problem size by 2 characters.</li>
 *   <li>Recursion naturally models the symmetry of a palindrome.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Base Case:</b>
 *
 * <ul>
 *   <li>If <code>left >= right</code>, all character pairs have been checked.</li>
 *   <li>This means the string is a palindrome.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Case:</b>
 *
 * <ul>
 *   <li>If <code>s.charAt(left) != s.charAt(right)</code> → not a palindrome.</li>
 *   <li>Otherwise, move inward and recurse:
 *     <code>isPalindrome(s, left + 1, right - 1)</code>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * s = "madam"
 *
 * Compare m & m → match
 * Compare a & a → match
 * Compare d & d → match
 * left >= right → palindrome
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — each character is checked once.<br>
 * <b>Space Complexity:</b> O(n) — recursion call stack.
 * -----------------------------------------------------------------------
 */
public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println("Is 'madam' palindrome?  " + palindromeCheck("madam"));
        System.out.println("Is 'racecar' palindrome? " + palindromeCheck("racecar"));
        System.out.println("Is 'hello' palindrome?   " + palindromeCheck("hello"));
    }

    /**
     * Method to check if a string is a palindrome.
     * This method initiates the recursive comparison.
     *
     * @param s input string
     * @return true if palindrome, false otherwise
     */
    private static boolean palindromeCheck(String s) {
        if (s == null || s.length() <= 1) return true;
        return isPalindrome(s, 0, s.length() - 1);
    }

    /**
     * Recursive helper method that checks palindrome property
     * by comparing characters from both ends.
     *
     * @param s     input string
     * @param left  starting index
     * @param right ending index
     * @return true if substring is palindrome
     */
    private static boolean isPalindrome(String s, int left, int right) {

        // Base Case: pointers have crossed or met
        if (left >= right) {
            return true;
        }

        // If characters at current positions do not match
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Recursive call moving inward
        return isPalindrome(s, left + 1, right - 1);
    }
}
