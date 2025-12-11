/**
 * Problem:
 * Given a numeric string {@code s}, extract the largest possible *odd* number
 * that can be formed from a contiguous substring of {@code s}, after removing
 * any leading zeros.
 *
 * <p>The method returns an empty string ("") if no odd number can be formed.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process</b>
 *
 * <p>We want the <b>largest odd number</b> that can be formed by taking a
 * substring of the original number without rearranging digits.</p>
 *
 * <p>This leads to two key observations:</p>
 *
 * <ul>
 *   <li><b>1. Leading zeros do not contribute</b>
 *       Any leading '0' reduces the numeric value of the substring.
 *       So we must skip all zeros from the left before processing.</li>
 *
 *   <li><b>2. The substring must end at an odd digit</b>
 *       The parity of the entire number is determined by the last digit.
 *       So we search from the right until we find an odd digit.</li>
 * </ul>
 *
 * <p>Once we find:</p>
 * <ul>
 *   <li>the first non-zero digit from the left → {@code start}</li>
 *   <li>the last odd digit from the right → {@code end}</li>
 * </ul>
 *
 * <p>The largest odd number is simply:</p>
 * <pre>  s.substring(start, end + 1)</pre>
 *
 * <p>If no odd digit exists after trimming zeros → return "".</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough</b>
 *
 * <pre>
 * Input:  "0057240"
 *
 * Step 1: Skip leading zeros → start = 2 ("57240")
 * Step 2: Move from right to left to find last odd digit:
 *         0 → even
 *         4 → even
 *         2 → even
 *         7 → odd → end = 3
 *
 * Output: substring(2, 3+1) → "57"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 * <ul>
 *   <li>Input = "0000" → Output: ""</li>
 *   <li>Input = "24680" → Output: "" (no odd digit)</li>
 *   <li>Input = "0001350" → Output: "135"</li>
 *   <li>Input = "90700" → Output: "907"</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single-pass from both ends.
 * <b>Space Complexity:</b> O(1) — no extra storage used besides indices.
 * -----------------------------------------------------------------------
 */
public class LargestOddNumberInString {

    public static void main(String[] args) {

        System.out.println("1. Input: \"0057240\"  → Largest Odd Number: " + largeOddNum("0057240"));
        System.out.println("2. Input: \"0000\"     → Largest Odd Number: " + largeOddNum("0000"));
        System.out.println("3. Input: \"24680\"    → Largest Odd Number: " + largeOddNum("24680"));
        System.out.println("4. Input: \"0001350\"  → Largest Odd Number: " + largeOddNum("0001350"));
        System.out.println("5. Input: \"90700\"    → Largest Odd Number: " + largeOddNum("90700"));
    }

    /**
     * Returns the largest odd-valued substring of the numeric string {@code s},
     * after skipping leading zeros.
     *
     * <p>This method preserves the exact sequence of digits — no rearranging or reordering.</p>
     *
     * @param s numeric string
     * @return largest odd-number substring or "" if none exists
     */
    public static String largeOddNum(String s) {

        int start = 0;

        // 1. Skip leading zeros (they lower the numeric value)
        while (start < s.length() && s.charAt(start) == '0') {
            start++;
        }

        // If all characters are zeros → no odd number possible
        if (start == s.length()) return "";

        // 2. Traverse from right to find the last odd digit
        int end = s.length() - 1;
        while (end >= start && ((s.charAt(end) - '0') & 1) == 0) {
            end--;
        }

        // If no odd digit remains → return empty
        return end >= start ? s.substring(start, end + 1) : "";
    }
}