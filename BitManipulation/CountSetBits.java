/**
 * Problem:
 * Given an integer {@code n}, return the number of set bits (1s)
 * in its binary representation.
 *
 * <p>This is the classic <b>Count Set Bits</b> problem.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Naive Approach:
 * <ul>
 *   <li>Check each bit using (n & 1).</li>
 *   <li>Right shift the number.</li>
 * </ul>
 *
 * <pre>
 * while (n > 0) {
 *     count += (n & 1);
 *     n >>= 1;
 * }
 * </pre>
 *
 * Time Complexity:
 * O(number of bits) → O(32)
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (Brian Kernighan’s Algorithm):</b>
 *
 * Instead of checking all bits, we directly remove set bits one by one.
 *
 * Key Idea:
 *
 * <pre>
 * n & (n - 1)
 * </pre>
 *
 * removes the <b>rightmost set bit</b> from {@code n}.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Brian Kernighan’s Algorithm</b>
 *
 * Let’s understand:
 *
 * Example:
 * <pre>
 * n = 12 → binary: 1100
 * </pre>
 *
 * Step:
 *
 * <pre>
 * n - 1 = 1011
 * </pre>
 *
 * Now:
 *
 * <pre>
 * 1100
 * 1011
 * ----
 * 1000
 * </pre>
 *
 * → Rightmost set bit removed.
 *
 * ---------------------------------------------------------------
 *
 * Another example:
 *
 * <pre>
 * n = 10 → 1010
 *
 * n-1 = 1001
 *
 * 1010
 * 1001
 * ----
 * 1000
 * </pre>
 *
 * Again, rightmost 1 is removed.
 *
 * -----------------------------------------------------------------------
 * <b>Key Insight:</b>
 *
 * Each iteration removes exactly <b>one set bit</b>.
 *
 * So number of iterations = number of set bits.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize count = 0.</li>
 *   <li>While n ≠ 0:</li>
 *   <ul>
 *     <li>Remove rightmost set bit: n = n & (n - 1)</li>
 *     <li>Increment count</li>
 *   </ul>
 *   <li>Return count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 13 → binary: 1101
 *
 * Iterations:
 *
 * 1101 → 1100 → 1000 → 0000
 *
 * Count = 3
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Skips zero bits entirely.</li>
 *   <li>Only iterates over set bits.</li>
 *   <li>Much faster when number has few 1s.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(k), where {@code k} = number of set bits.
 *
 * (Better than O(32) in sparse numbers)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class CountSetBits {

    public static void main(String[] args) {

        int n = 13;

        int result = countSetBits(n);

        System.out.println("Set bits count: " + result);
    }

    /**
     * Counts number of set bits using Brian Kernighan’s algorithm.
     */
    public static int countSetBits(int n) {

        int count = 0;

        while (n != 0) {

            n = n & (n - 1); // removes rightmost set bit

            count++;
        }

        return count;
    }
}