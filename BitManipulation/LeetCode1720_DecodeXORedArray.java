/**
 * Problem:
 * You are given an encoded array {@code encoded}, where:
 *
 * <pre>
 * encoded[i] = arr[i] XOR arr[i + 1]
 * </pre>
 *
 * and the first element {@code first = arr[0]}.
 *
 * <p>Return the original array {@code arr}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1720:
 * Decode XORed Array</b></p>
 * <p>🔗 https://leetcode.com/problems/decode-xored-array/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Given:
 *
 * <pre>
 * encoded[i] = arr[i] ^ arr[i+1]
 * </pre>
 *
 * We need to find:
 *
 * <pre>
 * arr[i+1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Key XOR Property (VERY IMPORTANT):</b>
 *
 * <pre>
 * a ^ b ^ a = b
 * </pre>
 *
 * So:
 *
 * <pre>
 * arr[i+1] = encoded[i] ^ arr[i]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): XOR Reversal</b>
 *
 * Starting from:
 *
 * <pre>
 * arr[0] = first
 * </pre>
 *
 * We compute:
 *
 * <pre>
 * arr[1] = encoded[0] ^ arr[0]
 * arr[2] = encoded[1] ^ arr[1]
 * ...
 * </pre>
 *
 * This builds the array step-by-step.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create result array of size n + 1.</li>
 *   <li>Set res[0] = first.</li>
 *   <li>For each index i:</li>
 *   <ul>
 *     <li>res[i+1] = res[i] ^ encoded[i]</li>
 *   </ul>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * encoded = [1, 2, 3]
 * first = 1
 *
 * Process:
 * arr[0] = 1
 * arr[1] = 1 ^ 1 = 0
 * arr[2] = 0 ^ 2 = 2
 * arr[3] = 2 ^ 3 = 1
 *
 * Output:
 * [1, 0, 2, 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses XOR cancellation property.</li>
 *   <li>Single pass reconstruction.</li>
 *   <li>No extra structures needed.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode1720_DecodeXORedArray {

    public static void main(String[] args) {

        int[] encoded = {1, 2, 3};
        int first = 1;

        int[] result = decode(encoded, first);

        System.out.println(java.util.Arrays.toString(result));
    }

    /**
     * Decodes XORed array using XOR reversal property.
     */
    public static int[] decode(int[] encoded, int first) {

        int n = encoded.length;
        int[] res = new int[n + 1];

        res[0] = first;

        for (int i = 0; i < n; i++) {

            // Reverse XOR to get next element
            res[i + 1] = res[i] ^ encoded[i];
        }

        return res;
    }
}