/**
 * Problem:
 * You are given an array of strings {@code words}.
 *
 * <p>Return the <b>first palindromic string</b> in the array.
 * If no such string exists, return an empty string.</p>
 *
 * <p>A string is a palindrome if it reads the same forward and backward.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2108:
 * Find First Palindromic String in the Array</b></p>
 * <p>🔗 https://leetcode.com/problems/find-first-palindromic-string-in-the-array/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The task is to find the first string in the array that is a palindrome.
 *
 * Naive Approach:
 * <ul>
 *   <li>Reverse every string using StringBuilder.</li>
 *   <li>Compare the reversed string with the original.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * String reversed = new StringBuilder(s).reverse().toString();
 * if (s.equals(reversed))
 * </pre>
 *
 * While correct, this requires extra space for the reversed string.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Use the <b>Two-Pointer Palindrome Pattern</b>.</li>
 *   <li>Compare characters from both ends moving toward the center.</li>
 * </ul>
 *
 * This avoids extra memory and runs in-place.
 *
 * -----------------------------------------------------------------------
 * <b>Two-Pointer Palindrome Pattern (Detailed Explanation):</b>
 *
 * A palindrome means:
 *
 * <pre>
 * s[0] == s[n-1]
 * s[1] == s[n-2]
 * s[2] == s[n-3]
 * ...
 * </pre>
 *
 * We use two pointers:
 *
 * <pre>
 * i → start of string
 * j → end of string
 * </pre>
 *
 * If characters match:
 *
 * <pre>
 * i++
 * j--
 * </pre>
 *
 * If any mismatch occurs, the string is not a palindrome.
 *
 * If pointers cross:
 *
 * <pre>
 * i >= j
 * </pre>
 *
 * the string is confirmed as a palindrome.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Traverse each word in the array.</li>
 *   <li>Use two pointers to check if the word is a palindrome.</li>
 *   <li>If a palindrome is found, return it immediately.</li>
 *   <li>If none are found, return an empty string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * words = ["abc", "car", "ada", "racecar", "cool"]
 *
 * Check "abc" → not palindrome
 * Check "car" → not palindrome
 * Check "ada" → palindrome
 *
 * Return "ada"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses in-place comparison.</li>
 *   <li>No additional memory allocation.</li>
 *   <li>Stops immediately once first palindrome is found.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n * m)
 *
 * where:
 * <ul>
 *   <li>n = number of words</li>
 *   <li>m = average length of each word</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode2108_FindFirstPalindromicStringInArray {

    public static void main(String[] args) {

        String[] words = {"abc", "car", "ada", "racecar", "cool"};

        String result = firstPalindrome(words);

        System.out.println("First palindrome: " + result);
    }

    /**
     * Returns the first palindromic string in the array.
     *
     * @param words input array of strings
     * @return first palindrome or empty string
     */
    public static String firstPalindrome(String[] words) {

        for (String s : words) {

            int i = 0;
            int j = s.length() - 1;

            // Check palindrome using two-pointer technique
            while (i < j && s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }

            if (i >= j) {
                return s;
            }
        }

        return "";
    }
}