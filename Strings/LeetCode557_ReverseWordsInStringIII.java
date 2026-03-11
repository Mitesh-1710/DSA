/**
 * Problem:
 * Given a string {@code s}, reverse the characters of each word in the
 * string while preserving whitespace and the original word order.
 *
 * <p>A word is defined as a sequence of non-space characters.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 557:
 * Reverse Words in a String III</b></p>
 * <p>🔗 https://leetcode.com/problems/reverse-words-in-a-string-iii/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The task is to reverse each word individually while keeping
 * the order of the words unchanged.
 *
 * Naive Approach:
 * <ul>
 *   <li>Split the string using {@code s.split(" ")}.</li>
 *   <li>Reverse each word using {@code StringBuilder.reverse()}.</li>
 *   <li>Join the words back together.</li>
 * </ul>
 *
 * Although simple, this approach creates extra strings and arrays.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Convert the string into a character array.</li>
 *   <li>Traverse the array and detect word boundaries.</li>
 *   <li>Reverse characters of each word in-place using two pointers.</li>
 * </ul>
 *
 * This avoids extra memory allocations.
 *
 * -----------------------------------------------------------------------
 * <b>In-Place Word Reversal Concept (Detailed Explanation):</b>
 *
 * The idea is similar to reversing an array segment.
 *
 * For every word:
 *
 * <pre>
 * left pointer  → start of word
 * right pointer → end of word
 * </pre>
 *
 * Swap characters while moving pointers inward.
 *
 * Example:
 *
 * <pre>
 * Input:  "Let's code"
 *
 * Word1: "Let's"
 * Reverse → "s'teL"
 *
 * Word2: "code"
 * Reverse → "edoc"
 *
 * Output:
 * "s'teL edoc"
 * </pre>
 *
 * Word boundaries are detected when:
 *
 * <pre>
 * i == arr.length OR arr[i] == ' '
 * </pre>
 *
 * This ensures the final word is also processed.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert string to character array.</li>
 *   <li>Track start index of current word.</li>
 *   <li>Traverse characters until space or end of array.</li>
 *   <li>Reverse characters between start and end.</li>
 *   <li>Move start pointer to next word.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "God Ding"
 *
 * Step 1:
 * "God" → reverse → "doG"
 *
 * Step 2:
 * "Ding" → reverse → "gniD"
 *
 * Output:
 * "doG gniD"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Processes characters in-place.</li>
 *   <li>No extra arrays or split operations.</li>
 *   <li>Single pass through the string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the length of the string.<br>
 *
 * <b>Space Complexity:</b>
 * O(n) due to the character array (strings are immutable in Java).
 * -----------------------------------------------------------------------
 */
public class LeetCode557_ReverseWordsInStringIII {

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        String result = reverseWords(s);

        System.out.println("Result: " + result);
    }

    /**
     * Reverses characters of each word in the string.
     *
     * @param s input string
     * @return string with each word reversed
     */
    public static String reverseWords(String s) {

        char[] arr = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= arr.length; i++) {

            // Word boundary detected
            if (i == arr.length || arr[i] == ' ') {

                reverse(arr, start, i - 1);

                start = i + 1;
            }
        }

        return new String(arr);
    }

    /**
     * Reverses characters between two indices.
     */
    private static void reverse(char[] arr, int l, int r) {

        while (l < r) {

            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }
}