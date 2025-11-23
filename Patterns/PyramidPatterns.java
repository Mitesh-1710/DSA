/**
 * Problem:
 * Given an integer {@code n}, print different centered pyramid patterns.
 *
 * <p>The program demonstrates three variations:</p>
 * <ul>
 *   <li><b>1.</b> Asterisk Pyramid — Forms a centered pyramid using '*' characters.</li>
 *   <li><b>2.</b> Alphabet Pyramid — Uses ('A', 'B', 'C', ...) with the same pyramid width formula.</li>
 *   <li><b>3.</b> Alphabet Symmetry Pyramid — Prints left-to-middle increasing alphabets and
 *       then mirrors them on the right, forming a centered alphabetical palindrome.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Pattern Shape:</b>
 *
 * <p>All three patterns are based on identifying the same core structure:
 * a <b>center-aligned pyramid</b> whose width grows using an <b>odd-number progression</b>.</p>
 *
 * <ul>
 *   <li><b>1. Leading Spaces</b>
 *     <ul>
 *       <li>Required for center alignment.</li>
 *       <li>Formula for each row: <code>(n - i - 1)</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Width Formula</b>
 *     <ul>
 *       <li>Observing the character counts per row:
 *         <pre>1, 3, 5, 7, ...</pre>
 *       </li>
 *       <li>This forms the sequence <b>2*i + 1</b>, which appears in many symmetric pyramid patterns.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. Variation by Character Type</b>
 *     <ul>
 *       <li>Only the type of printed character differs:
 *         <ul>
 *            <li>* for simple pyramid</li>
 *            <li>Repeating alphabet for alphabet pyramid</li>
 *            <li>Increasing + decreasing alphabet for symmetric palindrome pyramid</li>
 *         </ul>
 *       </li>
 *       <li>The core mathematical structure remains the same.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>4. Alphabet Symmetry Pyramid — Additional Insight</b>
 *     <ul>
 *       <li>We split the printed characters into:
 *         <ul>
 *           <li>Left increasing sequence:   A → rowChar</li>
 *           <li>Right mirrored sequence:    rowChar → A</li>
 *         </ul>
 *       </li>
 *       <li>This pattern belongs to the “Palindromic Pyramid” group,
 *           similar to number palindromes or mirrored star triangles.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output for {@code n = 5}:</b>
 *
 * <p>1. Asterisk Pyramid:</p>
 * <pre>
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * </pre>
 *
 * <p>2. Alphabet Pyramid:</p>
 * <pre>
 *     A
 *    BBB
 *   CCCCC
 *  DDDDDDD
 * EEEEEEEEE
 * </pre>
 *
 * <p>3. Alphabet Symmetry Pyramid:</p>
 * <pre>
 *     A
 *    ABA
 *   ABCBA
 *  ABCDCBA
 * ABCDEDCBA
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²)
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class PyramidPatterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Asterisk Pyramid:");
        printAsteriskPyramid(n);

        System.out.println("\n2. Alphabet Pyramid:");
        printAlphabetPyramid(n);

        System.out.println("\n3. Alphabet Symmetry Pyramid:");
        printAlphabetSymmetryPyramid(n);
    }

    /** Prints a centered pyramid using '*' characters (width = 2*i + 1). */
    public static void printAsteriskPyramid(int n) {
        validateInput(n);

        for (int i = 0; i < n; i++) {

            // 1. Leading spaces → (n - i - 1)
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 2. Characters → width follows odd-number formula (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /** Prints a centered alphabet pyramid (AAA... growing width = 2*i + 1). */
    public static void printAlphabetPyramid(int n) {
        validateInput(n);

        for (int i = 0; i < n; i++) {

            // 1. Leading spaces
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // Character increases each row: A, B, C, ...
            char ch = (char) ('A' + i);

            // 2. Use the width formula (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    /**
     * Prints a centered alphabet palindrome pyramid such as:
     *     A
     *    ABA
     *   ABCBA
     *  ABCDCBA
     * ABCDEDCBA
     */
    public static void printAlphabetSymmetryPyramid(int n) {
        validateInput(n);

        for (int i = 0; i < n; i++) {

            // 1. Leading spaces → same alignment rule as the other pyramids
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // 2. Left increasing sequence: A → rowChar
            int k;
            for (k = 0; k <= i; k++) {
                System.out.print((char) ('A' + k));
            }

            // 3. Right mirrored sequence: (rowChar - 1) → A
            for (int j = k - 2; j >= 0; j--) {
                System.out.print((char) ('A' + j));
            }

            System.out.println();
        }
    }

    /** Input validation for positive values. */
    private static void validateInput(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size 'n' must be a positive integer.");
        }
    }
}