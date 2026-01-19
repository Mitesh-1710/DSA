/**
 * Problem:
 * Determine whether a given integer {@code n} is a <b>power of two</b>.
 *
 * <p>A number is considered a power of two if it can be expressed as:</p>
 *
 * <pre>
 * 2^0 = 1
 * 2^1 = 2
 * 2^2 = 4
 * 2^3 = 8
 * 2^4 = 16
 * ...
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The most efficient way to solve this problem uses <b>bit manipulation</b>.</p>
 *
 * <p><b>Key Observation:</b></p>
 *
 * <ul>
 *   <li>A power of two has <b>exactly one set bit (1)</b> in its binary representation.</li>
 *   <li>All other bits are zero.</li>
 * </ul>
 *
 * <p>Example binary representations:</p>
 *
 * <pre>
 * 1  → 0001
 * 2  → 0010
 * 4  → 0100
 * 8  → 1000
 * </pre>
 *
 * <p><b>What happens when we subtract 1?</b></p>
 *
 * <ul>
 *   <li>The single set bit becomes 0.</li>
 *   <li>All bits to the right of it become 1.</li>
 * </ul>
 *
 * <p>Example:</p>
 *
 * <pre>
 * n = 8        → 1000
 * n - 1 = 7    → 0111
 *
 * n & (n - 1) → 0000
 * </pre>
 *
 * <p>This property holds true <b>only</b> for powers of two.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Why the Condition Works:</b>
 *
 * <pre>
 * (n & (n - 1)) == 0
 * </pre>
 *
 * <ul>
 *   <li>Removes the lowest set bit from {@code n}.</li>
 *   <li>If {@code n} had only one set bit, the result becomes 0.</li>
 *   <li>If {@code n} had more than one set bit, the result is non-zero.</li>
 * </ul>
 *
 * <p>Additionally, we check {@code n > 0} to exclude:</p>
 * <ul>
 *   <li>Zero (0)</li>
 *   <li>Negative numbers</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 16
 * Binary:        10000
 * n - 1:         01111
 * n & (n - 1):   00000 → true
 *
 * n = 18
 * Binary:        10010
 * n - 1:         10001
 * n & (n - 1):   10000 → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>n = 1 → true (2⁰).</li>
 *   <li>n = 0 → false.</li>
 *   <li>Negative numbers → false.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(1) — constant time bit operation.<br>
 * <b>Space Complexity:</b> O(1) — no extra space used.
 * -----------------------------------------------------------------------
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {

        int[] testValues = {1, 2, 4, 8, 16, 18, 0, -4};

        for (int n : testValues) {
            System.out.println(n + " is power of two? " + isPowerOfTwo(n));
        }
    }

    /**
     * Returns {@code true} if the given number is a power of two.
     *
     * @param n input integer
     * @return {@code true} if n is power of two, otherwise {@code false}
     */
    public static boolean isPowerOfTwo(int n) {

        // n must be positive and contain exactly one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }
}