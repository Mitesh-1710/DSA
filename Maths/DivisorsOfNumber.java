/**
 * Problem:
 * Given an integer {@code n}, return a sorted list of all its factors.
 *
 * <p>A factor (or divisor) of a number is any positive integer that divides the number
 * without leaving a remainder.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind Efficient Factor Generation:</b>
 *
 * <p>The naive (brute-force) approach is:</p>
 * <ul>
 *   <li>Loop from <code>1 → n</code> and check each number using <code>n % i == 0</code>.</li>
 *   <li>This works but has time complexity O(n).</li>
 * </ul>
 *
 * <p>However, factors occur in <b>pairs</b>.
 * For any divisor <code>i</code>:</p>
 *
 * <pre>
 * i × (n / i) = n
 * </pre>
 *
 * <p>This means:</p>
 * <ul>
 *   <li>One factor is ≤ √n</li>
 *   <li>The corresponding pair factor is ≥ √n</li>
 * </ul>
 *
 * <p>Thus we only need to loop until <b>√n</b>, making the algorithm much faster.</p>
 *
 * <p><b>Efficient Logic Breakdown:</b></p>
 * <ul>
 *   <li>Loop from <code>2 → sqrt(n)</code>.</li>
 *   <li>Whenever <code>i</code> divides <code>n</code>:
 *     <ul>
 *       <li>Add <code>i</code> as a factor.</li>
 *       <li>If the paired factor <code>(n / i)</code> is different, add that too.</li>
 *     </ul>
 *   </li>
 *   <li>Always include <code>1</code> and <code>n</code> as factors.</li>
 *   <li>Sort the list for ascending order output.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>  n = 28
 *
 * <pre>
 * Factors found:
 * 1 (initial)
 * 2 → pair 14
 * 4 → pair 7
 * 28 (added at the end)
 *
 * Sorted result = [1, 2, 4, 7, 14, 28]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Brute Force Approach (Not Used Here):</b>
 * <p>
 * Loop from <code>1 → n</code> and add every <code>i</code> where <code>n % i == 0</code>.
 * <br>This works but is O(n), slower for large inputs.
 * </p>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(√n)
 * <b>Space Complexity:</b> O(k) — where k is number of factors
 * -----------------------------------------------------------------------
 */
import java.util.*;

public class DivisorsOfNumber {

    public static void main(String[] args) {
        System.out.println("Factors of 36: " + getAllFactors(36));
        System.out.println("Factors of 97: " + getAllFactors(97));
        System.out.println("Factors of 100: " + getAllFactors(100));
    }

    /**
     * Returns a sorted list of all factors of the given number {@code n}.
     */
    public static List<Integer> getAllFactors(int n) {

        List<Integer> result = new ArrayList<>();

        // 1. 1 is always a factor
        result.add(1);

        // 2. Check all potential factors up to √n
        for (int i = 2; i * i <= n; i++) {

            // If i divides n, it's a factor pair
            if (n % i == 0) {

                result.add(i);           // add smaller factor

                // Add paired factor if it's distinct
                if (i != (n / i)) {
                    result.add(n / i);
                }
            }
        }

        // 3. n is also a factor of itself
        if (n > 1) {
            result.add(n);
        }

        // 4. Sort result list for ascending order
        Collections.sort(result);

        return result;
    }
}