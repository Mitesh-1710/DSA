/**
 * Problem:
 * Given an integer {@code n}, print a left-aligned right-angled triangle pattern
 * made of asterisks ('*'), with {@code n} rows.
 *
 * <p>For example, for {@code n = 5}, the output should be:
 * <pre>
 * *
 * **
 * ***
 * ****
 * *****
 * </pre>
 * </p>
 *
 * <p><b>Thought Process:</b></p>
 * <ul>
 *   <li>For each row {@code i} (0-indexed), we print {@code i + 1} asterisks.</li>
 *   <li>The number of rows equals {@code n}.</li>
 *   <li>We can use two nested loops — the outer loop controls rows,
 *       and the inner loop prints asterisks for each row.</li>
 * </ul>
 *
 * <p>
 * <b>Time Complexity:</b> O(n²) — we print a total of (1 + 2 + ... + n) ≈ n²/2 asterisks.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space used.
 * </p>
 */
public class LeftAlignedRightAngledTriangle {

    public static void main(String[] args) {
        printLeftAlignedRightAngledTriangle(5);
    }

    /**
     * Prints a left-aligned right-angled triangle pattern of asterisks ('*')
     * with {@code n} rows.
     *
     * <p>Each line {@code i} (0-indexed) contains {@code i + 1} asterisks.</p>
     * @param n the number of rows in the triangle; must be a positive integer
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static void printLeftAlignedRightAngledTriangle(int n) {
        // Validate input
        if (n <= 0) {
            throw new IllegalArgumentException("Size 'n' must be a positive integer.");
        }

        // Outer loop controls the number of rows (1 to n)
        for (int i = 0; i < n; i++) {
            // Inner loop prints '*' (i + 1) times for the current row
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            // Move to the next line after printing one row
            System.out.println();
        }
    }

}