/**
 * Problem:
 * Given a positive integer {@code N}, return the minimum and maximum
 * digit present in the number.
 *
 * The result should be returned as an array:
 *
 * <pre>
 * [minDigit, maxDigit]
 * </pre>
 *
 * Example:
 * <pre>
 * Input:  N = 573920
 * Output: [0, 9]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The problem requires inspecting every digit of the number and
 * determining the smallest and largest digits.
 *
 * Naive Approach:
 * <ul>
 *   <li>Convert the number to a string.</li>
 *   <li>Traverse each character and convert it back to a digit.</li>
 *   <li>Track minimum and maximum values.</li>
 * </ul>
 *
 * Although this works, it introduces unnecessary string conversion.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Extract digits directly using arithmetic operations.</li>
 *   <li>Use modulo (%) to obtain the last digit.</li>
 *   <li>Use division (/) to remove the last digit.</li>
 * </ul>
 *
 * This avoids additional memory allocation and works directly on the number.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Digit Extraction</b>
 *
 * Digits of a number can be extracted using:
 *
 * <pre>
 * digit = N % 10
 * </pre>
 *
 * This gives the last digit of the number.
 *
 * Example:
 *
 * <pre>
 * N = 573920
 *
 * 573920 % 10 = 0
 * </pre>
 *
 * To remove the last digit:
 *
 * <pre>
 * N = N / 10
 * </pre>
 *
 * Example:
 *
 * <pre>
 * 573920 / 10 = 57392
 * </pre>
 *
 * Repeating this process extracts all digits.
 *
 * -----------------------------------------------------------------------
 * <b>Edge Case Handling:</b>
 *
 * If {@code N = 0}, the loop will not execute because the condition
 * {@code N > 0} fails immediately.
 *
 * Therefore we return:
 *
 * <pre>
 * [0, 0]
 * </pre>
 *
 * since the only digit present is 0.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Handle the special case where N = 0.</li>
 *   <li>Initialize min digit to 9 and max digit to 0.</li>
 *   <li>While N > 0:</li>
 *   <ul>
 *     <li>Extract the last digit using N % 10.</li>
 *     <li>Update min and max values.</li>
 *     <li>Remove the last digit using N / 10.</li>
 *   </ul>
 *   <li>Return the result array.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * N = 573920
 *
 * Process:
 *
 * digit = 0 → min=0, max=0
 * digit = 2 → min=0, max=2
 * digit = 9 → min=0, max=9
 * digit = 3 → min=0, max=9
 * digit = 7 → min=0, max=9
 * digit = 5 → min=0, max=9
 *
 * Result:
 * [0,9]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Processes digits directly using arithmetic operations.</li>
 *   <li>Avoids converting the number to a string.</li>
 *   <li>Single traversal of all digits.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(d), where {@code d} is the number of digits in N.
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class MinMaxDigits {

    public static void main(String[] args) {

        long N = 573920;

        int[] result = minMaxDigits(N);

        System.out.println("Min digit: " + result[0]);
        System.out.println("Max digit: " + result[1]);
    }

    /**
     * Returns the minimum and maximum digit present in the number.
     */
    public static int[] minMaxDigits(long N) {

        // Edge case when number is zero
        if (N == 0) {
            return new int[]{0, 0};
        }

        int min = 9;
        int max = 0;

        while (N > 0) {

            int digit = (int) (N % 10); // Extract last digit

            N /= 10; // Remove last digit

            if (digit < min) min = digit;

            if (digit > max) max = digit;
        }

        return new int[]{min, max};
    }
}