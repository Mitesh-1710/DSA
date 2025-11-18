/**
 * Problem:
 * Given an integer {@code n}, print different centered pyramid patterns.
 *
 * <p>The program demonstrates two variations:</p>
 * <ul>
 *   <li><b>1.</b> Asterisk Pyramid — Forms a centered pyramid using '*' characters.</li>
 *   <li><b>2.</b> Alphabet Pyramid — Uses letters ('A', 'B', 'C', ...) in the same pyramid structure.</li>
 * </ul>
 *
 * <p><b>Thought Process Behind the Pattern Shape:</b></p>
 * <ul>
 *   <li>The shape required is a <b>center-aligned pyramid</b> with {@code n} rows.</li>
 *   <li>The <b>row index</b> is 0-based (i = 0 to n - 1).</li>
 *   <li>Each row consists of two parts:
 *     <ul>
 *       <li><b>Leading spaces</b> to center the pyramid → (n - i - 1)</li>
 *       <li><b>Characters to print</b> forming the pyramid → an odd count</li>
 *     </ul>
 *   </li>
 *   <li>To find the number of characters printed in each row, observe the pattern progression:
 *     <pre>
 *     Row 0 → 1 character
 *     Row 1 → 3 characters
 *     Row 2 → 5 characters
 *     Row 3 → 7 characters
 *     ...
 *     </pre>
 *   </li>
 *   <li>This sequence forms a mathematical pattern:
 *     <b>1, 3, 5, 7, ... = 2*i + 1</b>
 *   </li>
 *   <li>Thus, the print-width formula is derived as:
 *     <ul>
 *       <li>Width at row i = (2 * i) + 1</li>
 *     </ul>
 *   </li>
 *   <li>Changing only the printed character (star, letter, etc.) gives multiple patterns with the same structure.</li>
 * </ul>
 *
 * <p><b>Example Output for {@code n = 5}:</b></p>
 * <pre>
 * 1. Asterisk Pyramid:
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *
 * 2. Alphabet Pyramid:
 *     A
 *    BBB
 *   CCCCC
 *  DDDDDDD
 * EEEEEEEEE
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n²) — nested loops constructing the pyramid shape.<br>
 * <b>Space Complexity:</b> O(1) — no additional space used.</p>
 */
public class PyramidPatterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Asterisk Pyramid:");
        printPyramid(n);

        System.out.println("\n2. Alphabet Pyramid:");
        printAlphabetPyramid(n);
    }

    /** Prints a centered pyramid using '*' characters (width = 2*i + 1). */
    public static void printPyramid(int n) {
        validateInput(n);

        for (int i = 0; i < n; i++) {

            // 1. Print leading spaces → (n - i - 1)
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 2. Print characters → width = (2 * i) + 1
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /** Prints a centered alphabet pyramid using (2*i + 1) characters per row. */
    public static void printAlphabetPyramid(int n) {
        validateInput(n);

        for (int i = 0; i < n; i++) {

            // 1. Print leading spaces
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // Character for the row
            char ch = (char) ('A' + i);

            // 2. Print characters based on the formula (2 * i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    /** Ensures {@code n} is positive before proceeding. */
    private static void validateInput(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size 'n' must be a positive integer.");
        }
    }
}
