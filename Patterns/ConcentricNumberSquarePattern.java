/**
 * Problem:
 * Given an integer {@code n}, print a square numeric pattern of size
 * {@code (2*n - 1) x (2*n - 1)} where the numbers form concentric layers
 * decreasing towards the center.
 *
 * <p>For example, when {@code n = 5}, the pattern is:</p>
 *
 * <pre>
 * 5 5 5 5 5 5 5 5 5
 * 5 4 4 4 4 4 4 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 2 1 2 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 4 4 4 4 4 4 5
 * 5 5 5 5 5 5 5 5 5
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Pattern:</b>
 *
 * <p>This pattern is based on the concept of <b>concentric squares</b>.
 * Each layer from the outer boundary towards the center decreases in value.</p>
 *
 * <p>The key idea is to determine how far a cell is from the nearest boundary.</p>
 *
 * <ul>
 *   <li>The grid size is <code>(2*n - 1)</code>.</li>
 *   <li>For each cell (i, j), calculate its distance from all four sides.</li>
 *   <li>The minimum of those distances determines the layer.</li>
 *   <li>The printed value is: <code>n - minimumDistance</code>.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Distance Calculation:</b>
 *
 * For each cell (i, j):
 * <ul>
 *   <li><b>Top</b>    = i</li>
 *   <li><b>Left</b>   = j</li>
 *   <li><b>Bottom</b> = (2*n - 2) - i</li>
 *   <li><b>Right</b>  = (2*n - 2) - j</li>
 * </ul>
 *
 * <p>The smallest of these four values tells us how deep the cell is
 * inside the square.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Works:</b>
 *
 * <ul>
 *   <li>Outer layer → distance = 0 → value = n</li>
 *   <li>Next layer  → distance = 1 → value = n-1</li>
 *   <li>Center cell → distance = n-1 → value = 1</li>
 * </ul>
 *
 * This logic generalizes cleanly for any value of {@code n}.
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n²) — iterates over a (2*n - 1) square.<br>
 * <b>Space Complexity:</b> O(1) — no extra space used.
 * -----------------------------------------------------------------------
 */
public class ConcentricNumberSquarePattern {

    public static void main(String[] args) {
        int n = 5;
        printConcentricNumberSquare(n);
    }

    /**
     * Prints a concentric square number pattern for the given {@code n}.
     *
     * @param n the maximum number and number of layers in the pattern
     */
    public static void printConcentricNumberSquare(int n) {

        int size = (2 * n) - 1;

        // Traverse each row
        for (int i = 0; i < size; i++) {

            // Traverse each column
            for (int j = 0; j < size; j++) {

                // 1. Distance from top edge
                int top = i;

                // 2. Distance from left edge
                int left = j;

                // 3. Distance from bottom edge
                int bottom = (2 * n - 2) - i;

                // 4. Distance from right edge
                int right = (2 * n - 2) - j;

                // Find the nearest boundary
                int minDistance = Math.min(
                        Math.min(top, bottom),
                        Math.min(left, right)
                );

                // Compute value for the current layer
                int value = n - minDistance;

                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}