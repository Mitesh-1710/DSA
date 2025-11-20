/**
 * Problem:
 * Print a centered diamond pattern using '*' characters.
 *
 * <p>The diamond is composed of two symmetric pyramids:</p>
 * <ul>
 *   <li><b>Upper Pyramid</b> — grows from 1 star to (2*n - 1) stars.</li>
 *   <li><b>Lower Inverted Pyramid</b> — shrinks back to 1 star.</li>
 * </ul>
 *
 * <p><b>Thought Process Behind the Pattern Shape:</b></p>
 * <ul>
 *   <li>The pattern must be <b>center-aligned</b>, so each row starts with leading spaces.</li>
 *   <li>Row index is <b>0-based</b>.</li>
 *
 *   <li><b>Width Formula (Core Observation):</b>
 *     <ul>
 *       <li>The star count follows the odd-number sequence:
 *         <pre>1, 3, 5, 7, … = (2*i + 1)</pre>
 *       </li>
 *       <li>This same formula works for both the upper and lower halves.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Upper Half Logic (0 → n-1):</b>
 *     <ul>
 *       <li>Spaces before stars → <code>n - i - 1</code></li>
 *       <li>Stars printed → <code>(2*i) + 1</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Lower Half Logic (n-2 → 0):</b>
 *     <ul>
 *       <li>Spaces before stars → increases as we go down</li>
 *       <li>Stars printed → same width formula <code>(2*i) + 1</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Identifying Symmetry Helps Build Other Patterns:</b>
 *     <ul>
 *       <li>The diamond = an upright centered pyramid + an inverted centered pyramid.</li>
 *       <li>Using the same concept, other shapes can be constructed.</li>
 *       <li>Example: A <b>Right Arrow</b> pattern =
 *         <ul>
 *           <li>Left-aligned right-angled triangle (increasing)</li>
 *           <li>Left-aligned inverted right-angled triangle (decreasing)</li>
 *         </ul>
 *       </li>
 *       <li>The technique is to recognize symmetric halves and combine them.</li>
 *     </ul>
 *   </li>
 * </ul>
 */
public class DiamondPattern {

    public static void main(String[] args) {
        printDiamondPattern(5);
        printArrowPattern(5);
    }

    /**
     * Prints a centered diamond using '*' characters.
     * Both halves follow the star-width formula: (2*i + 1).
     */
    public static void printDiamondPattern(int n) {

        // UPPER PYRAMID: rows 0 → n-1
        for (int i = 0; i < n; i++) {

            // 1. Print leading spaces → decreases as i increases
            //    Formula: (n - i - 1)
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 2. Print stars → odd count based on (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER INVERTED PYRAMID: rows n-2 → 0
        for (int i = n - 2; i >= 0; i--) {

            // 1. Leading spaces → increases as i decreases
            //    Equivalent to: (n - 1 - i)
            for (int k = i; k < n - 1; k++) {
                System.out.print(" ");
            }

            // 2. Print stars → same formula (2*i + 1)
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * Prints a right-arrow-like shape using '*'.
     *
     * This is built using the same symmetry logic identified in the diamond:
     *  - First half: normal left-aligned triangle   (0 → n-1)
     *  - Second half: inverted left-aligned triangle (n-2 → 0)
     */
    public static void printArrowPattern(int n) {

        // UPPER HALF: increasing stars
        for (int i = 0; i < n; i++) {

            // Print (i+1) stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: decreasing stars
        for (int i = n - 2; i >= 0; i--) {

            // Print (i+1) stars in decreasing order
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
