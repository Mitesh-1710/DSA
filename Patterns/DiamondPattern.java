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
 *       <li>Spaces before stars → increases as row goes down</li>
 *       <li>Stars printed → again <code>(2*i) + 1</code></li>
 *     </ul>
 *   </li>
 *
 *   <li>The diamond is therefore formed by:
 *     <ul>
 *       <li>Upper centered pyramid (increasing width)</li>
 *       <li>Lower centered inverted pyramid (decreasing width)</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Example for n = 5:</b></p>
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
 * <p><b>Time Complexity:</b> O(n²)</p>
 * <p><b>Space Complexity:</b> O(1)</p>
 */
public class DiamondPattern {

    public static void main(String[] args) {
        printDiamondPattern(5);
    }

    /**
     * Prints a centered diamond using '*' characters.
     * The width formula for every row is (2*i + 1).
     */
    public static void printDiamondPattern(int n) {

        // UPPER PYRAMID (0 → n-1)
        for (int i = 0; i < n; i++) {

            // 1. Print leading spaces → (n - i - 1)
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            // 2. Print stars → width = (2*i) + 1
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER INVERTED PYRAMID (n-2 → 0)
        for (int i = n - 2; i >= 0; i--) {

            // 1. Leading spaces → increases as we go down
            //    Equivalent to: (n - 1) - i
            for (int k = i; k < n - 1; k++) {
                System.out.print(" ");
            }

            // 2. Stars → again (2*i) + 1
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
