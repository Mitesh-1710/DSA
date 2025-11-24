/**
 * Problem:
 * Print a centered hollow diamond pattern using '*' characters.
 *
 * <p>The shape is formed by pairing two symmetric hollow halves:</p>
 * <ul>
 *   <li><b>Upper Hollow Pyramid</b> — width decreases in stars while the center gap widens.</li>
 *   <li><b>Lower Hollow Inverted Pyramid</b> — the reverse: stars widen and the center gap shrinks.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Diamond Shape:</b>
 *
 * <p>This pattern is built on the idea of <b>symmetric halves</b>, where each row
 * contains:</p>
 *
 * <ul>
 *   <li><b>Left Border Stars</b> — decreasing or increasing based on row index.</li>
 *   <li><b>Center Hollow Space</b> — always an even count: <code>2 * i</code>.</li>
 *   <li><b>Right Border Stars</b> — mirrors the left side.</li>
 * </ul>
 *
 * <p>Row index is <b>0-based</b>.</p>
 *
 * <p><b>1. Star Count Observation</b></p>
 * <ul>
 *   <li>Left stars = <code>(n - i)</code></li>
 *   <li>Right stars = <code>(n - i)</code></li>
 *   <li>This gives symmetric walls of the hollow diamond.</li>
 * </ul>
 *
 * <p><b>2. Hollow Region Observation</b></p>
 * <ul>
 *   <li>The inner space grows by +2 each row.</li>
 *   <li>Formula: <code>2 * i</code></li>
 *   <li>This matches the idea that the diamond “opens” symmetrically.</li>
 * </ul>
 *
 * <p><b>3. Two-Halves Symmetry</b></p>
 * <ul>
 *   <li><b>Upper Half (0 → n-1):</b>
 *     <ul>
 *       <li>Stars shrink each row.</li>
 *       <li>Hollow space expands each row.</li>
 *     </ul>
 *   </li>
 *   <li><b>Lower Half (n-1 → 0):</b>
 *     <ul>
 *       <li>Exact reverse process.</li>
 *       <li>Stars expand while hollow shrinks.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This pattern belongs to the “Hollow Symmetric Shapes” family, similar to:</p>
 * <ul>
 *   <li>Hollow hourglass patterns</li>
 *   <li>Hollow triangles</li>
 *   <li>Hollow butterflies</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output for {@code n = 5}:</b>
 *
 * <pre>
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²)<br>
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class HollowDiamondPattern {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Hollow Diamond Pattern:");
        printHollowDiamondPattern(n);
    }

    /**
     * Prints a hollow diamond using two symmetric halves:
     *  - Upper shrinking star walls + expanding hollow
     *  - Lower expanding star walls + shrinking hollow
     */
    public static void printHollowDiamondPattern(int n) {

        // UPPER HALF: rows 0 → n-1
        for (int i = 0; i < n; i++) {

            // 1. Left stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            // 2. Center hollow → (2 * i) spaces
            for (int j = 0; j < (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: rows n-1 → 0
        for (int i = n - 1; i >= 0; i--) {

            // 1. Left stars → mirror of upper half
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            // 2. Center hollow → shrinking (2 * i)
            for (int j = 0; j < (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → mirror of upper half
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}