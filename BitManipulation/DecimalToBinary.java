import java.lang.StringBuilder;

/**
 * Problem:
 * Given an integer {@code n}, return its 32-bit binary representation
 * as a string.
 *
 * <p>The result should include leading zeros to always produce
 * a 32-bit output.</p>
 *
 * Example:
 * <pre>
 * Input:  n = 5
 * Output: "00000000000000000000000000000101"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to extract each bit of the integer from the most significant
 * bit (MSB) to the least significant bit (LSB).
 *
 * Naive Approach:
 * <ul>
 *   <li>Repeatedly divide by 2 and collect remainders.</li>
 *   <li>Reverse the result.</li>
 * </ul>
 *
 * This does not guarantee a fixed 32-bit representation.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Iterate from bit position 31 → 0.</li>
 *   <li>Extract each bit using shifting.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Bit Extraction</b>
 *
 * To extract the i-th bit:
 *
 * <pre>
 * (n >> i) & 1
 * </pre>
 *
 * Explanation:
 * <ul>
 *   <li>Right shift moves the i-th bit to LSB position.</li>
 *   <li>& 1 isolates that bit.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * n = 5 → 000...0101
 *
 * i = 2:
 * (5 >> 2) = 000...0001
 * & 1 → 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Important Concept: >> vs >>> (VERY IMPORTANT)</b>
 *
 * Java has two types of right shift:
 *
 * 1️. Arithmetic Right Shift:
 *
 * <pre>
 * n >> i
 * </pre>
 *
 * <ul>
 *   <li>Preserves sign bit.</li>
 *   <li>If number is negative → fills with 1s.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * n = -1 → 11111111111111111111111111111111
 * n >> 1 → 11111111111111111111111111111111 (still negative)
 * </pre>
 *
 * ---------------------------------------------------------------
 *
 * 2️. Logical Right Shift:
 *
 * <pre>
 * n >>> i
 * </pre>
 *
 * <ul>
 *   <li>Fills left side with 0s.</li>
 *   <li>Does NOT preserve sign.</li>
 * </ul>
 *
 * Example:
 *
 * <pre>
 * n = -1 → 11111111111111111111111111111111
 * n >>> 1 → 01111111111111111111111111111111
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>When to Use >>>:</b>
 *
 * If the number is negative and you want:
 *
 * <ul>
 *   <li>Actual bit representation (unsigned behavior)</li>
 *   <li>Correct logical shifting</li>
 * </ul>
 *
 * then use:
 *
 * <pre>
 * (n >>> i) & 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize StringBuilder.</li>
 *   <li>Loop from i = 31 to 0.</li>
 *   <li>Extract each bit using shift and mask.</li>
 *   <li>Append to result.</li>
 *   <li>Return final string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 5
 *
 * Output:
 * 00000000000000000000000000000101
 * </pre>
 *
 * Negative Example:
 *
 * <pre>
 * n = -1
 *
 * Using >>:
 * remains all 1s (sign preserved)
 *
 * Using >>>:
 * shifts introduce 0s on left
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Direct bit extraction.</li>
 *   <li>Fixed 32-bit representation.</li>
 *   <li>No reversal required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(32) → constant time
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class DecimalToBinary {

    public static void main(String[] args) {

        int n = 5;

        String result = decimalToBinary(n);

        System.out.println("Binary: " + result);
    }

    /**
     * Converts integer to 32-bit binary string.
     */
    public static String decimalToBinary32(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >= 0; i--) {

            // Use >>> for safe handling of negative numbers
            sb.append((n >>> i) & 1);
        }

        return sb.toString();
    }

    /**
     * Converts integer to binary string.
     */
    public static String decimalToBinary(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n & 1); // last bit
            n >>= 1;          // divide by 2
        }

        return sb.reverse().toString();
    }


}