import java.util.List;
import java.util.ArrayList;

/**
 * Problem:
 * Given a positive integer {@code n}, return all the factors
 * (divisors) of {@code n} in ascending order.
 *
 * <p>A factor of a number is an integer that divides the number
 * without leaving a remainder.</p>
 *
 * Example:
 * <pre>
 * Input:  n = 36
 * Output: [1, 2, 3, 4, 6, 9, 12, 18, 36]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Naive Approach:
 * <ul>
 *   <li>Check every number from 1 to n.</li>
 *   <li>If {@code n % i == 0}, add it to the result.</li>
 * </ul>
 *
 * This results in:
 *
 * <pre>
 * O(n)
 * </pre>
 *
 * which is inefficient for large numbers.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Factors always appear in pairs.</li>
 *   <li>If {@code i} divides {@code n}, then {@code n/i} is also a factor.</li>
 * </ul>
 *
 * Therefore we only need to check numbers up to:
 *
 * <pre>
 * √n
 * </pre>
 *
 * This reduces the complexity significantly.
 *
 * -----------------------------------------------------------------------
 * <b>Factor Pair Concept (Detailed Explanation):</b>
 *
 * Every factor pair multiplies to form the number.
 *
 * Example:
 *
 * <pre>
 * n = 36
 *
 * 1 × 36
 * 2 × 18
 * 3 × 12
 * 4 × 9
 * 6 × 6
 * </pre>
 *
 * Notice:
 *
 * <pre>
 * smaller factor ≤ √n
 * larger factor ≥ √n
 * </pre>
 *
 * So when we find a factor {@code i},
 * we automatically get its pair {@code n / i}.
 *
 * To keep the result sorted:
 *
 * <ul>
 *   <li>Store smaller factors immediately.</li>
 *   <li>Store larger factors separately.</li>
 *   <li>Append larger factors in reverse order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create two lists:
 *       one for small factors and one for large factors.</li>
 *   <li>Loop from 1 to √n.</li>
 *   <li>If {@code i} divides {@code n}:</li>
 *   <ul>
 *     <li>Add {@code i} to the result list.</li>
 *     <li>Add {@code n / i} to the large factors list
 *         (if not equal to {@code i}).</li>
 *   </ul>
 *   <li>Append large factors in reverse order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 36
 *
 * Loop until √36 = 6
 *
 * i = 1 → add 1, 36
 * i = 2 → add 2, 18
 * i = 3 → add 3, 12
 * i = 4 → add 4, 9
 * i = 5 → skip
 * i = 6 → add 6 (pair same)
 *
 * Result:
 * [1,2,3,4,6,9,12,18,36]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Reduces iterations from n to √n.</li>
 *   <li>Uses factor pair symmetry.</li>
 *   <li>Maintains sorted order efficiently.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(√n)
 *
 * <b>Space Complexity:</b>
 * O(k), where k is number of factors.
 * -----------------------------------------------------------------------
 */
public class FindFactors {

    public static void main(String[] args) {

        int n = 36;

        List<Integer> result = findFactors(n);

        System.out.println("Factors: " + result);
    }

    /**
     * Returns all factors of the number in ascending order.
     *
     * @param n input number
     * @return list of factors
     */
    public static List<Integer> findFactors(int n) {

        List<Integer> res = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        // Traverse only up to √n
        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                // Small factor
                res.add(i);

                // Large factor (avoid duplicate for perfect squares)
                if (i != n / i) {
                    large.add(n / i);
                }
            }
        }

        // Append larger factors in reverse order
        for (int i = large.size() - 1; i >= 0; i--) {
            res.add(large.get(i));
        }

        return res;
    }
}