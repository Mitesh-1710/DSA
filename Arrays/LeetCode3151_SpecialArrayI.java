/**
 * Problem:
 * An array is called <b>special</b> if every pair of adjacent elements
 * has different parity (one is even, the other is odd).
 *
 * <p>Given an integer array {@code nums}, return {@code true}
 * if it is special, otherwise return {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3151:
 * Special Array I</b></p>
 * <p>🔗 https://leetcode.com/problems/special-array-i/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need to ensure:
 *
 * <pre>
 * nums[i] and nums[i-1] → different parity
 * </pre>
 *
 * That means:
 *
 * <ul>
 *   <li>One must be even</li>
 *   <li>One must be odd</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <pre>
 * if ((nums[i] % 2) == (nums[i-1] % 2)) → invalid
 * </pre>
 *
 * This works but uses modulo operation.
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (Bitwise):</b>
 *
 * Use:
 *
 * <pre>
 * (nums[i] ^ nums[i-1]) & 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): XOR + Parity Check</b>
 *
 * Key idea:
 *
 * <pre>
 * last bit (LSB) determines parity
 * even → ends with 0
 * odd  → ends with 1
 * </pre>
 *
 * Example:
 *
 * <pre>
 * 4 → 100
 * 3 → 011
 * </pre>
 *
 * XOR:
 *
 * <pre>
 * 100
 * 011
 * ---
 * 111 → last bit = 1 → different parity
 * </pre>
 *
 * If parity is same:
 *
 * <pre>
 * 4 (100)
 * 6 (110)
 *
 * XOR → 010 → last bit = 0
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Key Condition:</b>
 *
 * <pre>
 * ((a ^ b) & 1) == 1 → different parity
 * ((a ^ b) & 1) == 0 → same parity
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Traverse array from index 1.</li>
 *   <li>For each adjacent pair:</li>
 *   <ul>
 *     <li>Check parity using XOR.</li>
 *     <li>If same parity → return false.</li>
 *   </ul>
 *   <li>If all pairs valid → return true.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * nums = [1, 2, 3]
 *
 * Pairs:
 * (1,2) → valid
 * (2,3) → valid
 *
 * Output:
 * true
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * nums = [2, 4, 6]
 *
 * (2,4) → same parity → invalid
 *
 * Output:
 * false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Bitwise operations are faster than modulo.</li>
 *   <li>Single pass through array.</li>
 *   <li>Constant space.</li>
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
public class LeetCode3151_SpecialArrayI {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        boolean result = isArraySpecial(nums);

        System.out.println("Is special: " + result);
    }

    /**
     * Checks if array is special using XOR parity trick.
     */
    public static boolean isArraySpecial(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            // If same parity → return false
            if (((nums[i] ^ nums[i - 1]) & 1) == 0) {
                return false;
            }
        }

        return true;
    }
}