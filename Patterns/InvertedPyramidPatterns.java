/**
 * Problem:
 * Given an integer {@code n}, print different inverted centered pyramid patterns.
 *
 * <p>The program demonstrates two variations:</p>
 * <ul>
 *   <li><b>1.</b> Inverted Asterisk Pyramid — Prints '*' characters in a shrinking centered pyramid.</li>
 *   <li><b>2.</b> Inverted Alphabet Pyramid — Prints letters ('A', 'B', 'C', ...) with the same pyramid structure.</li>
 * </ul>
 *
 * <p><b>Thought Process Behind the Inverted Pyramid Shape:</b></p>
 * <ul>
 *   <li>The required shape is a <b>center-aligned pyramid inverted vertically</b>.</li>
 *   <li>The regular pyramid grows from top to bottom; this one shrinks — hence the loop runs backward.</li>
 *   <li>The <b>row index</b> runs from:
 *     <pre>
 *     i = n - 1 (top row, widest)
 *     down to
 *     i = 0     (last row, single character)
 *     </pre>
 *   </li>
 *
 *   <li>Each row has two components:
 *     <ul>
 *       <li><b>Leading spaces</b> → these increase as rows shrink.</li>
 *       <li><b>Printable characters</b> → follow the same odd-number sequence as a pyramid.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>1. Deriving the number of characters:</b></li>
 *   <p>In a normal pyramid, the character count grows as:</p>
 *   <pre>
 *   Row 0 → 1
 *   Row 1 → 3
 *   Row 2 → 5
 *   ...
 *   </pre>
 *   <p>This follows the formula: <b>(2 * i) + 1</b>.</p>
 *
 *   <li>In an inverted pyramid, we keep the same formula but with decreasing <b>i</b> values:
 *     <ul>
 *       <li>Top row → i = n - 1 → widest</li>
 *       <li>Bottom row → i = 0 → 1 character</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Deriving the leading spaces:</b></li>
 *   <p>In a growing pyramid, spaces decrease each row.</p>
 *   <p>Here, since the pyramid shrinks, spaces must increase:</p>
 *
 *   <pre>
 *   Row i = n - 1 → 0 spaces
 *   Row i = n - 2 → 1 space
 *   Row i = n - 3 → 2 spaces
 *   ...
 *   </pre>
 *
 *   <li>This can be achieved with:
 *     <pre>
 *     for (k = i; k < n - 1; k++) print space
 *     </pre>
 *     — which effectively prints: <b>(n - i - 1)</b> spaces.
 *   </li>
 *
 *   <li>The same structure works for both star and alphabet patterns —
 *       only the printed symbol changes.</li>
 * </ul>
 *
 * <p><b>Example Output for {@code n = 5}:</b></p>
 * <pre>
 * 1. Inverted Asterisk Pyramid:
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 *
 * 2. Inverted Alphabet Pyramid:
 * EEEEEEEEE
 *  DDDDDDD
 *   CCCCC
 *    BBB
 *     A
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n²) — nested loops forming the centered structure.<br>
 * <b>Space Complexity:</b> O(1) — no extra space used.</p>
 */
public class InvertedPyramidPatterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Asterisk Inverted Pyramid:");
        printInvertedPyramid(n);

        System.out.println("\n2. Alphabet Inverted Pyramid:");
        printInvertedAlphabetPyramid(n);
    }

    /**
     * Prints a centered inverted pyramid using '*' characters (width = 2*i + 1).
     */
    public static void printInvertedPyramid(int n) {

        for (int i = n - 1; i >= 0; i--) {

            // 1. Print leading spaces → (n - i - 1)
            for (int k = i; k < n - 1; k++) {
                System.out.print(" ");
            }

            // 2. Print characters → width = (2 * i) + 1
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * Prints a centered inverted alphabet pyramid using (2*i + 1) characters per row.
     */
    public static void printInvertedAlphabetPyramid(int n) {

        for (int i = n - 1; i >= 0; i--) {

            // 1. Print leading spaces
            for (int k = i; k < n - 1; k++) {
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
}
