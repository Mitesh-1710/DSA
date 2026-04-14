/**
 * Problem:
 * You are given an array of strings {@code details}, where each string
 * represents passenger information.
 *
 * <p>Each string has a fixed format:</p>
 *
 * <pre>
 * "xxxxxxxxxxAABB"
 *            ↑↑
 *          age digits (positions 11 and 12)
 * </pre>
 *
 * <p>Return the number of passengers whose age is strictly greater than 60.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2678:
 * Number of Senior Citizens</b></p>
 * <p>🔗 https://leetcode.com/problems/number-of-senior-citizens/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Each string encodes age at fixed positions:
 *
 * <pre>
 * index 11 → tens digit
 * index 12 → ones digit
 * </pre>
 *
 * So we extract:
 *
 * <pre>
 * age = (digit1 * 10) + digit2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Extract substring using {@code substring(11, 13)}</li>
 *   <li>Convert to integer using {@code Integer.parseInt()}</li>
 * </ul>
 *
 * This involves:
 * <ul>
 *   <li>Extra string creation</li>
 *   <li>Parsing overhead</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Directly compute integer using characters:
 *
 * <pre>
 * age = (s.charAt(11) - '0') * 10 + (s.charAt(12) - '0')
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Character to Integer Conversion</b>
 *
 * ASCII trick:
 *
 * <pre>
 * '0' = 48
 * '5' = 53
 *
 * '5' - '0' = 5
 * </pre>
 *
 * So:
 *
 * <pre>
 * (char - '0') → gives numeric value
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize count = 0.</li>
 *   <li>Traverse each string in array.</li>
 *   <li>Extract age using character arithmetic.</li>
 *   <li>If age > 60 → increment count.</li>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * details = ["7868190130M7522", "5303914400F9211"]
 *
 * Ages:
 * 75 → counted
 * 92 → counted
 *
 * Output:
 * 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No substring creation.</li>
 *   <li>No parsing overhead.</li>
 *   <li>Constant-time extraction.</li>
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
public class LeetCode2678_NumberOfSeniorCitizens {

    public static void main(String[] args) {

        String[] details = {
                "7868190130M7522",
                "5303914400F9211"
        };

        int result = countSeniors(details);

        System.out.println("Senior Count: " + result);
    }

    /**
     * Counts number of senior citizens.
     */
    public static int countSeniors(String[] details) {

        int count = 0;

        for (String s : details) {

            // Extract age using character arithmetic
            int age = (s.charAt(11) - '0') * 10
                    + (s.charAt(12) - '0');

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}