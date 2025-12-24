/**
 * Problem:
 * Print two symmetry-based star patterns:
 *
 * <ul>
 *   <li><b>1. Centered Diamond Pattern</b> — formed using two mirrored pyramids.</li>
 *   <li><b>2. Right-Arrow Pattern</b> — formed using two mirrored left-aligned triangles.</li>
 * </ul>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Pattern Shapes:</b>
 *
 * <p>Both patterns rely on one core idea: <b>symmetry</b>.
 * The shapes are constructed by pairing an increasing structure with a decreasing one.</p>
 *
 * <ul>
 *
 *   <li><b>I. Diamond Pattern — Core Mathematical Structure</b>
 *     <ul>
 *       <li>The diamond is a combination of:
 *         <ul>
 *           <li><b>Upper centered pyramid</b> (width grows)</li>
 *           <li><b>Lower inverted centered pyramid</b> (width shrinks)</li>
 *         </ul>
 *       </li>
 *       <li>Row index is <b>0-based</b>.</li>
 *     </ul>
 *
 *     <p><b>1. Width Formula (Odd Number Sequence)</b></p>
 *     <ul>
 *       <li>The count of characters per row follows:
 *         <pre>1, 3, 5, 7, ... = (2*i + 1)</pre>
 *       </li>
 *       <li>This formula applies to both halves of the diamond.</li>
 *     </ul>
 *
 *     <p><b>2. Leading Space Logic</b></p>
 *     <ul>
 *       <li>For center alignment, each row begins with spaces.</li>
 *       <li><b>Upper Half (0 → n-1):</b>
 *         <ul><li>Spaces = {@code n - i - 1}</li></ul>
 *       </li>
 *       <li><b>Lower Half (n-2 → 0):</b>
 *         <ul><li>Spaces = {@code n - 1 - i}</li></ul>
 *       </li>
 *     </ul>
 *
 *     <p><b>3. Structural Insight</b></p>
 *     <ul>
 *       <li>A diamond = an upright pyramid + an inverted pyramid.</li>
 *       <li>Both halves obey the same width formula; only space alignment changes.</li>
 *       <li>This belongs to the family of “two-halves symmetric” patterns.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>II. Right-Arrow Pattern — Symmetry in Left-Aligned Shapes</b>
 *     <ul>
 *       <li>Constructed from:
 *         <ul>
 *           <li><b>Upper Half:</b> left-aligned triangle</li>
 *           <li><b>Lower Half:</b> left-aligned inverted triangle</li>
 *         </ul>
 *       </li>
 *       <li>No spaces are needed since the shape is left-aligned.</li>
 *       <li>Star count:
 *         <pre>
 *         1, 2, 3, ..., n
 *         n-1, ..., 2, 1
 *         </pre>
 *       </li>
 *       <li>This resembles the “right-arrow” shape commonly used in CLI outputs.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>III. Reusing Symmetry Logic for Other Patterns</b>
 *     <ul>
 *       <li>The key technique is to:
 *         <ul>
 *           <li>Identify a base increasing pattern, then</li>
 *           <li>Mirror it by reversing the loop range.</li>
 *         </ul>
 *       </li>
 *       <li>This idea generates multiple patterns such as:
 *         <ul>
 *           <li>Hourglass</li>
 *           <li>Butterfly patterns</li>
 *           <li>Sandglass patterns</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Example Output for {@code n = 5}:</b>
 *
 * <p>1. Diamond Pattern:</p>
 * <pre>
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 * </pre>
 *
 * <p>2. Right Arrow Pattern:</p>
 * <pre>
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 * </pre>
 * <p>
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²)<br>
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class DiamondPattern {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Diamond Pattern:");
        printDiamondPattern(n);

        System.out.println("\n2. Right Arrow Pattern:");
        printArrowPattern(n);
    }

    /**
     * Prints a centered diamond using '*' characters.
     * Built from two symmetric halves, both using the width formula (2*i + 1).
     */
    public static void printDiamondPattern(int n) {

        // UPPER HALF: rows 0 → n-1 (increasing width)
        for (int i = 0; i < n; i++) {

            // 1. Leading spaces → decreases as i increases
            //    Formula: (n - i - 1)
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 2. Stars → follow odd-number series (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: rows (n-2 → 0) (decreasing width)
        for (int i = n - 2; i >= 0; i--) {

            // 1. Leading spaces → increases as i decreases
            //    Equivalent: (n - 1 - i)
            for (int k = i; k < n - 1; k++) {
                System.out.print(" ");
            }

            // 2. Stars → same odd-number formula (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * Prints a right-arrow-like shape using '*' characters.
     * Formed by mirroring an increasing left-aligned triangle with a decreasing one.
     */
    public static void printArrowPattern(int n) {

        // UPPER HALF: triangle grows (1 → n)
        for (int i = 0; i < n; i++) {

            // Print (i+1) stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: triangle shrinks (n-1 → 1)
        for (int i = n - 2; i >= 0; i--) {

            // Print (i+1) stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}