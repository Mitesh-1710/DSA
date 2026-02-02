/**
 * Problem:
 * Convert a date string from decimal format to binary format.
 *
 * <p>The input date is given in the format <code>YYYY-MM-DD</code>.
 * Each numeric component (year, month, day) must be converted to its
 * <b>binary representation</b>, while preserving the dash separators.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3280: Convert Date to Binary</b></p>
 * <p>🔗 https://leetcode.com/problems/convert-date-to-binary/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The date string contains digits and separators ('-'). Instead of
 * splitting the string, we process it character by character:</p>
 *
 * <ul>
 *   <li>Accumulate digits to form a number (year, month, or day).</li>
 *   <li>When a dash is encountered:
 *     <ul>
 *       <li>Convert the accumulated number to binary.</li>
 *       <li>Append it to the result followed by '-'.</li>
 *       <li>Reset the number accumulator.</li>
 *     </ul>
 *   </li>
 *   <li>After the loop, convert and append the last number.</li>
 * </ul>
 *
 * <p>This approach avoids extra string splits and keeps the logic simple
 * and efficient.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Binary Conversion Insight:</b>
 *
 * <p>Java provides a built-in method:</p>
 * <pre>
 * Integer.toBinaryString(int value)
 * </pre>
 *
 * <p>This converts a decimal integer directly into its binary string
 * representation.</p>
 *
 * <p>Example:</p>
 * <pre>
 * Decimal 2024 → Binary "11111101000"
 * Decimal 09   → Binary "1001"
 * Decimal 15   → Binary "1111"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 *   date = "2024-09-15"
 *
 * Processing:
 *   2024 → 11111101000
 *   09   → 1001
 *   15   → 1111
 *
 * Output:
 *   "11111101000-1001-1111"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass over the string.<br>
 * <b>Space Complexity:</b> O(n) — output string builder.
 * -----------------------------------------------------------------------
 */
public class LeetCode3280_ConvertDateToBinary {

    public static void main(String[] args) {

        String date = "2024-09-15";

        String binaryDate = convertDateToBinary(date);

        System.out.println("Binary date: " + binaryDate);
    }

    /**
     * Converts a date string from decimal format to binary format.
     *
     * @param date input date string in the format YYYY-MM-DD
     * @return binary representation of the date
     */
    public static String convertDateToBinary(String date) {

        StringBuilder result = new StringBuilder();
        int currentNumber = 0;

        // Traverse each character of the date string
        for (int i = 0; i < date.length(); i++) {

            char c = date.charAt(i);

            // Build the current numeric component
            if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            // Dash indicates end of one date component
            else if (c == '-') {
                result.append(Integer.toBinaryString(currentNumber));
                result.append('-');
                currentNumber = 0;
            }
        }

        // Convert and append the last component (day)
        result.append(Integer.toBinaryString(currentNumber));

        return result.toString();
    }
}