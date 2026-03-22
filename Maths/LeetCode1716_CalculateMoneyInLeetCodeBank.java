/**
 * Problem:
 * Hercy saves money in a bank following a specific pattern:
 *
 * <ul>
 *   <li>On the first Monday, he deposits $1.</li>
 *   <li>Each day, he deposits $1 more than the previous day.</li>
 *   <li>Every new week starts with an additional $1 compared to the previous week's Monday.</li>
 * </ul>
 *
 * <p>Given an integer {@code n}, return the total amount of money
 * in the bank after {@code n} days.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1716:
 * Calculate Money in Leetcode Bank</b></p>
 * <p>🔗 https://leetcode.com/problems/calculate-money-in-leetcode-bank/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The pattern is:
 *
 * Week 1: 1 2 3 4 5 6 7 → sum = 28
 * Week 2: 2 3 4 5 6 7 8 → sum = 35
 * Week 3: 3 4 5 6 7 8 9 → sum = 42
 *
 * Observation:
 *
 * <ul>
 *   <li>Each week forms an Arithmetic Progression (AP).</li>
 *   <li>Each new week shifts the starting value by +1.</li>
 * </ul>
 *
 * Instead of simulating day-by-day, we:
 *
 * <ul>
 *   <li>Compute sum of full weeks.</li>
 *   <li>Compute sum of remaining days.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Arithmetic Progression (AP)</b>
 *
 * An AP has:
 *
 * <pre>
 * a = first term
 * d = common difference
 * n = number of terms
 * </pre>
 *
 * Sum formula:
 *
 * <pre>
 * S = n/2 * (2a + (n-1)d)
 * </pre>
 *
 * OR:
 *
 * <pre>
 * S = n/2 * (first + last)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Deriving Weekly Sum (Important Insight):</b>
 *
 * Week 1:
 *
 * <pre>
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
 * </pre>
 *
 * This is:
 *
 * <pre>
 * S = 7 * (1 + 7) / 2 = 28
 * </pre>
 *
 * Week 2:
 *
 * <pre>
 * 2 + 3 + ... + 8 = 35
 * </pre>
 *
 * Instead of recomputing:
 *
 * <pre>
 * WeekSum = 28 + 7*(weekIndex)
 * </pre>
 *
 * So total for k weeks:
 *
 * <pre>
 * weeks * 28 + 7 * (0 + 1 + 2 + ... + (weeks-1))
 * </pre>
 *
 * And:
 *
 * <pre>
 * 0 + 1 + 2 + ... + (k-1) = k*(k-1)/2
 * </pre>
 *
 * So:
 *
 * <pre>
 * weekSum = weeks * 28 + 7 * (weeks*(weeks-1)/2)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Remaining Days (AP Again):</b>
 *
 * After full weeks, remaining days start from:
 *
 * <pre>
 * starting value = weeks + 1
 * </pre>
 *
 * Example:
 *
 * Week count = 2 → next start = 3
 *
 * If remaining days = d:
 *
 * <pre>
 * Sum = d/2 * (2*(weeks+1) + (d-1))
 * </pre>
 *
 * Simplified:
 *
 * <pre>
 * daySum = d * (2*weeks + d + 1) / 2
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Compute full weeks: {@code weeks = n / 7}</li>
 *   <li>Compute remaining days: {@code days = n % 7}</li>
 *   <li>Compute sum of full weeks using AP formula</li>
 *   <li>Compute sum of remaining days using AP</li>
 *   <li>Return total</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 10
 *
 * weeks = 1
 * days = 3
 *
 * Week 1 sum = 28
 *
 * Remaining:
 * 2 + 3 + 4 = 9
 *
 * Output:
 * 28 + 9 = 37
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Avoids simulation.</li>
 *   <li>Uses mathematical pattern recognition.</li>
 *   <li>Constant time computation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(1)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1716_CalculateMoneyInLeetCodeBank {

    public static void main(String[] args) {

        int n = 10;

        int result = totalMoney(n);

        System.out.println("Total money: " + result);
    }

    /**
     * Returns total money saved after n days.
     */
    public static int totalMoney(int n) {

        int weeks = n / 7;
        int days = n % 7;

        // Sum of full weeks
        int weekSum = (weeks * 28) + (7 * (weeks * (weeks - 1) / 2));

        // Sum of remaining days
        int daySum = (days * (2 * weeks + days + 1)) / 2;

        return weekSum + daySum;
    }
}