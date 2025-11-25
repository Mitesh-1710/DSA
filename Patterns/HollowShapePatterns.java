/**
 * Problem:
 * Print two hollow symmetric patterns using '*' characters:
 *
 * <ul>
 *   <li><b>1. Hollow Diamond Pattern</b> — two symmetric hollow halves forming a diamond.</li>
 *   <li><b>2. Hollow Hourglass Pattern</b> — an hourglass created using expanding/contracting walls.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Diamond Shape:</b>
 *
 * <p>The hollow diamond is constructed using <b>two symmetric halves</b>:</p>
 * <ul>
 *   <li><b>Upper Half</b> — star count decreases while center hollow increases.</li>
 *   <li><b>Lower Half</b> — the reverse: stars expand while hollow shrinks.</li>
 * </ul>
 *
 * <p>Each row contains three logical regions:</p>
 * <ul>
 *   <li><b>Left Border Stars</b> — printed (n - i) times.</li>
 *   <li><b>Center Hollow</b> — even-width spacing defined as <code>2 * i</code>.</li>
 *   <li><b>Right Border Stars</b> — same as left, ensuring symmetry.</li>
 * </ul>
 *
 * <p><b>Row index is 0-based.</b></p>
 *
 * <p><b>1. Star Count Logic</b></p>
 * <ul>
 *   <li>Left Stars  = <code>(n - i)</code></li>
 *   <li>Right Stars = <code>(n - i)</code></li>
 *   <li>This forms two vertical walls of equal thickness.</li>
 * </ul>
 *
 * <p><b>2. Hollow Space Logic</b></p>
 * <ul>
 *   <li>Hollow gap follows: <pre>0, 2, 4, 6, ... = (2 * i)</pre></li>
 *   <li>Grows in the upper half and shrinks in the lower half.</li>
 * </ul>
 *
 * <p><b>3. Two-Halves Symmetry</b></p>
 * <ul>
 *   <li><b>Upper Half (0 → n-1):</b>
 *     <ul>
 *       <li>Stars shrink each row.</li>
 *       <li>Hollow expands each row.</li>
 *     </ul>
 *   </li>
 *   <li><b>Lower Half (n-1 → 0):</b>
 *     <ul>
 *       <li>Stars expand each row.</li>
 *       <li>Hollow shrinks each row.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Hollow Hourglass Pattern:</b>
 *
 * <p>The hollow hourglass is also built using <b>two symmetric halves</b>, but inverted:</p>
 *
 * <ul>
 *   <li><b>Upper Half</b> — star count increases while center shrinks.</li>
 *   <li><b>Lower Half</b> — reverse process: star count decreases while center expands.</li>
 * </ul>
 *
 * <p>The inner spacing is computed using:</p>
 * <pre>(n * 2) - (2 * i)</pre>
 *
 * <p>This preserves the hourglass tapering effect.</p>
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
     * Prints a hollow hourglass pattern by pairing:
     *  - Upper half: increasing stars + shrinking hollow
     *  - Lower half: decreasing stars + expanding hollow
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
}