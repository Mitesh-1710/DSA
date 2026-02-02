/**
 * Problem:
 * Given an integer {@code n} and an index {@code i}, determine whether
 * the <b>i-th bit</b> (0-based indexing) in the binary representation
 * of {@code n} is set (i.e., equals 1).
 *
 * <p>The bit position {@code i = 0} refers to the least significant bit.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>To check whether a specific bit is set, we need a way to isolate
 * the bit at position {@code i}.</p>
 *
 * <p>The idea is:</p>
 * <ul>
 *   <li>Create a mask by left-shifting {@code 1} by {@code i} positions.</li>
 *   <li>Use a bitwise OR operation to see whether setting that bit
 *       changes the value of {@code n}.</li>
 * </ul>
 *
 * <p>If the i-th bit is already set:</p>
 * <ul>
 *   <li>{@code n | (1 << i)} will be equal to {@code n}.</li>
 * </ul>
 *
 * <p>If the i-th bit is not set:</p>
 * <ul>
 *   <li>{@code n | (1 << i)} will change {@code n}, resulting in a
 *       different value.</li>
 * </ul>
 *
 * <p>This allows us to determine the bit state using a single
 * constant-time operation.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 10  → binary: 1010
 *
 * i = 1 → bit at position 1 is 1 → true
 * i = 0 → bit at position 0 is 0 → false
 *
 * Explanation:
 * n | (1 << 1) = 1010 | 0010 = 1010 → same → bit is set
 * n | (1 << 0) = 1010 | 0001 = 1011 → different → bit is not set
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 *
 * <ul>
 *   <li>{@code i} is greater than the number of bits in {@code n}.</li>
 *   <li>{@code n = 0}.</li>
 *   <li>{@code i = 0} (least significant bit).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(1) — constant-time bitwise operation.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — no extra space used.
 * -----------------------------------------------------------------------
 */
public class CheckIthBitSet {

    public static void main(String[] args) {

        int n = 10; // binary: 1010

        System.out.println(checkIthBit(n, 1)); // true
        System.out.println(checkIthBit(n, 0)); // false
    }

    /**
     * Checks whether the i-th bit in the integer {@code n} is set.
     *
     * @param n input number
     * @param i bit index (0-based)
     * @return {@code true} if the i-th bit is set, otherwise {@code false}
     */
    public static boolean checkIthBit(int n, int i) {
        return (n | (1 << i)) == n;
    }
}