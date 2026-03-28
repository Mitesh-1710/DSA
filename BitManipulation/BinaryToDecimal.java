/**
 * Problem:
 * Given a binary string {@code N}, convert it into its decimal (base-10) equivalent.
 *
 * <p>The string consists only of characters '0' and '1'.</p>
 *
 * Example:
 * <pre>
 * Input:  "1011"
 * Output: 11
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Binary numbers follow positional values based on powers of 2.
 *
 * Example:
 *
 * <pre>
 * "1011" = 1×2³ + 0×2² + 1×2¹ + 1×2⁰ = 11
 * </pre>
 *
 * Naive Approach:
 * <ul>
 *   <li>Traverse from right to left.</li>
 *   <li>Multiply each digit by powers of 2.</li>
 * </ul>
 *
 * This requires computing powers repeatedly.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Traverse from left to right.</li>
 *   <li>Use bit shifting to simulate multiplication by 2.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Left Shift = Multiply by 2</b>
 *
 * Binary shifting:
 *
 * <pre>
 * decimal << 1  → multiply by 2
 * </pre>
 *
 * So:
 *
 * <pre>
 * decimal = decimal * 2 + currentBit
 * </pre>
 *
 * Which is equivalent to:
 *
 * <pre>
 * decimal = (decimal << 1) + (digit)
 * </pre>
 *
 * ---------------------------------------------------------------
 *
 * Example:
 *
 * <pre>
 * N = "1011"
 *
 * Step-by-step:
 *
 * decimal = 0
 *
 * '1' → (0<<1)+1 = 1
 * '0' → (1<<1)+0 = 2
 * '1' → (2<<1)+1 = 5
 * '1' → (5<<1)+1 = 11
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize decimal = 0.</li>
 *   <li>Traverse each character in string.</li>
 *   <li>Left shift decimal (multiply by 2).</li>
 *   <li>Add current bit.</li>
 *   <li>Return final value.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * "1101"
 *
 * Process:
 *
 * 0 → 1 → 3 → 6 → 13
 *
 * Output:
 * 13
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No power computation required.</li>
 *   <li>Efficient bit-level operation.</li>
 *   <li>Single pass through string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is length of string.
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class BinaryToDecimal {

    public static void main(String[] args) {

        String N = "1011";

        int result = binaryToDecimal(N);

        System.out.println("Decimal value: " + result);
    }

    /**
     * Converts binary string to decimal using bit manipulation.
     */
    public static int binaryToDecimal(String N) {

        int decimal = 0;

        for (int i = 0; i < N.length(); i++) {

            // Left shift (multiply by 2) and add current bit
            decimal = (decimal << 1) + (N.charAt(i) - '0');
        }

        return decimal;
    }
}