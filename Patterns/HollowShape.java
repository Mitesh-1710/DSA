/**
 * Problem:
 * Print three hollow symmetric patterns using '*' characters:
 *
 * <ul>
 *   <li><b>1. Hollow Diamond Pattern</b> — formed by two symmetric hollow halves.</li>
 *   <li><b>2. Hollow Hourglass Pattern</b> — created by tapering walls inward and outward.</li>
 *   <li><b>3. Hollow Square Pattern</b> — a simple boundary-only square.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Diamond Shape:</b>
 *
 * <p>The hollow diamond is constructed using <b>two symmetric halves</b>:</p>
 * <ul>
 *   <li><b>Upper Half</b> — stars shrink while the center hollow expands.</li>
 *   <li><b>Lower Half</b> — stars expand while the center hollow shrinks.</li>
 * </ul>
 *
 * <p>Each row contains three regions:</p>
 * <ul>
 *   <li><b>Left Stars</b> → printed (n - i) times.</li>
 *   <li><b>Hollow Region</b> → grows as <code>(2 * i)</code>.</li>
 *   <li><b>Right Stars</b> → same as left, ensuring symmetry.</li>
 * </ul>
 *
 * <p><b>Row index is 0-based.</b></p>
 *
 * <b>1. Star Count Logic</b>
 * <ul>
 *   <li>Left Stars  = <code>(n - i)</code></li>
 *   <li>Right Stars = <code>(n - i)</code></li>
 *   <li>Both sides always remain mirror images.</li>
 * </ul>
 *
 * <b>2. Hollow Region Logic</b>
 * <ul>
 *   <li>Center gap follows:
 *   <pre>0, 2, 4, 6, ... = (2 * i)</pre>
 *   </li>
 *   <li>This creates the “opening” of the diamond.</li>
 * </ul>
 *
 * <b>3. Two-Halves Symmetry</b>
 * <ul>
 *   <li><b>Upper Half (0 → n−1):</b> stars shrink + hollow expands.</li>
 *   <li><b>Lower Half (n−1 → 0):</b> stars expand + hollow shrinks.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Hourglass Pattern:</b>
 *
 * <p>The hollow hourglass mirrors the same two-half concept:</p>
 *
 * <ul>
 *   <li><b>Upper Half</b> — star columns move outward while hollow shrinks.</li>
 *   <li><b>Lower Half</b> — reverse tapering completes the hourglass.</li>
 * </ul>
 *
 * <p>The inner hollow is computed using:</p>
 * <pre>(n * 2) - (2 * i)</pre>
 *
 * <p>That ensures a symmetrical inward collapse and outward expansion.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Square Pattern:</b>
 *
 * <p>This is the simplest hollow structure, defined entirely by boundaries:</p>
 *
 * <ul>
 *   <li>The first and last rows → completely filled with '*'</li>
 *   <li>The middle rows:
 *     <ul>
 *       <li>First column = '*'</li>
 *       <li>Last column = '*'</li>
 *       <li>Everything between = space</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Cell-Level Logic:</b></p>
 * <pre>
 * If (i == 1 OR i == n OR j == 1 OR j == n)
 *       print '*'
 * Else
 *       print ' '
 * </pre>
 *
 * <p>This makes the square a perfect boundary-only shape.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Output for {@code n = 5}:</b>
 *
 * <p>1. Hollow Diamond:</p>
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
 * <p>2. Hollow Hourglass:</p>
 * <pre>
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
 * </pre>
 *
 * <p>3. Hollow Square:</p>
 * <pre>
 * *****
 * *   *
 * *   *
 * *   *
 * *****
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²)
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class HollowShapePatterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Hollow Diamond Pattern:");
        printHollowDiamondPattern(n);

        System.out.println("\n2. Hollow Hourglass Pattern:");
        printHollowHourglassPattern(n);

        System.out.println("\n3. Hollow Square Pattern:");
        printHollowSquare(n);
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

            // 2. Center hollow → (2 * i)
            for (int j = 0; j < (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → mirror of left side
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: rows n-1 → 0
        for (int i = n - 1; i >= 0; i--) {

            // 1. Left stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            // 2. Center hollow → shrinks (2 * i)
            for (int j = 0; j < (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * Prints a hollow hourglass pattern using:
     *  - Upper half: expanding stars + shrinking center
     *  - Lower half: shrinking stars + expanding center
     */
    public static void printHollowHourglassPattern(int n) {

        // UPPER HALF: rows 1 → n
        for (int i = 1; i <= n; i++) {

            // 1. Left stars → i times
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 2. Center hollow → (n*2) - (2*i)
            for (int j = 1; j <= (n * 2) - (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → i times
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // LOWER HALF: rows 1 → n-1
        for (int i = 1; i < n; i++) {

            // 1. Left stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            // 2. Center hollow → (2 * i)
            for (int j = 0; j < (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Right stars → (n - i)
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
     * Prints a hollow square of size n × n:
     *  - Boundary rows and columns are stars.
     *  - Inner region is hollow.
     */
    public static void printHollowSquare(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                // Boundary conditions for a hollow square top , bottom , left and right
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
