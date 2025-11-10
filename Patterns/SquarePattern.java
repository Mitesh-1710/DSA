/**
 * Problem:
 * Given an integer {@code n}, print a square pattern of asterisks ('*')
 * with {@code n} rows and {@code n} columns.
 *
 * <p>For example, for {@code n = 5}, the output should be:
 * <pre>
 * *****
 * *****
 * *****
 * *****
 * *****
 * </pre>
 * </p>
 *
 * <p>
 * <b>Thought Process:</b>
 * <ul>
 *   <li>We observe that for each row, we print {@code n} asterisks ('*').</li>
 *   <li>We need to repeat this row {@code n} times to create the full square pattern.</li>
 *   <li>Two nested loops can achieve this — the outer loop controls rows, and the inner loop controls columns.</li>
 * </ul>
 * </p>
 *
 * <p>
 *     <b>Time Complexity:</b> O(n²) — since we print n * n characters.<br>
 *     <b>Space Complexity:</b> O(1) — uses constant extra space.
 * </p>
 */
public class SquarePattern {

    public static void main(String[] args) {
        printSquare(5);
    }

    /**
     * Prints a square pattern of asterisks of size {@code n x n}.
     *
     * <p>Each line contains {@code n} asterisks without spaces between them,
     * followed by a newline character. The result is a solid square.
     *
     * @param n The number of rows and columns in the square pattern.
     *          Must be a positive integer.
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static void printSquare(int n) {
        // Validate input
        if (n <= 0) {
            throw new IllegalArgumentException("Size 'n' must be a positive integer.");
        }

        // Outer loop controls the number of rows
        for (int i = 0; i < n; i++) {
            // Inner loop prints '*' n times per row
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }

}
