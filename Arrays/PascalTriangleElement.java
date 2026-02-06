/**
 * Problem:
 * Given two integers {@code r} and {@code c}, return the value at the
 * <b>r-th row</b> and <b>c-th column</b> (1-indexed) in
 * <b>Pascal's Triangle</b>.
 *
 * <p>Pascal’s Triangle follows the rule:</p>
 * <ul>
 *   <li>Each element is the sum of the two elements directly above it.</li>
 *   <li>The first and last element of every row is {@code 1}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>A direct simulation of Pascal’s Triangle up to row {@code r}
 * would work, but it is unnecessary and inefficient for finding
 * a single value.</p>
 *
 * <p>Key observation:</p>
 * <ul>
 *   <li>Each value in Pascal’s Triangle corresponds to a
 *       <b>binomial coefficient</b>.</li>
 * </ul>
 *
 * <p>Specifically:</p>
 * <pre>
 * Value at (r, c) = C(r - 1, c - 1)
 * </pre>
 *
 * <p>This allows us to compute the answer mathematically instead
 * of constructing the entire triangle.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Binomial Coefficient Concept (nCr):</b>
 *
 * <p>The binomial coefficient is defined as:</p>
 *
 * <pre>
 * C(n, r) = n! / (r! * (n - r)!)
 * </pre>
 *
 * <p>However, computing factorials directly can lead to:</p>
 * <ul>
 *   <li>Integer overflow</li>
 *   <li>Unnecessary computation</li>
 * </ul>
 *
 * <p>Instead, we compute {@code nCr} iteratively using the formula:</p>
 *
 * <pre>
 * C(n, r) = C(n, r - 1) * (n - r + 1) / r
 * </pre>
 *
 * <p>Additionally, we optimize by using:</p>
 * <pre>
 * r = min(r, n - r)
 * </pre>
 *
 * <p>This minimizes the number of iterations.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert 1-based indexing to 0-based:
 *       {@code n = r - 1}, {@code k = c - 1}.</li>
 *   <li>Compute {@code C(n, k)} using an iterative multiplication
 *       and division approach.</li>
 *   <li>Return the computed value.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * r = 5, c = 3
 *
 * Pascal's Triangle (row 5):
 * 1 4 6 4 1
 *
 * Value at column 3 → 6
 *
 * Calculation:
 * C(4, 2) = (4 * 3) / (2 * 1) = 6
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No need to build Pascal’s Triangle.</li>
 *   <li>Runs in linear time relative to {@code min(c, r - c)}.</li>
 *   <li>Avoids overflow caused by factorials.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(min(c, r - c)) — number of iterations in nCr computation.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class PascalTriangleElement {

    public static void main(String[] args) {

        int r = 5;
        int c = 3;

        int result = pascalTriangleI(r, c);

        System.out.println("Pascal Triangle value: " + result);
    }

    /**
     * Returns the value at the r-th row and c-th column
     * in Pascal's Triangle (1-indexed).
     *
     * @param r row number (1-indexed)
     * @param c column number (1-indexed)
     * @return value at the specified position
     */
    public static int pascalTriangleI(int r, int c) {
        return nCr(r - 1, c - 1);
    }

    /**
     * Computes the binomial coefficient C(n, r).
     */
    private static int nCr(int n, int r) {

        // Take advantage of symmetry
        if (r > n - r) {
            r = n - r;
        }

        int ncr = 1;

        for (int i = 0; i < r; i++) {
            ncr = ncr * (n - i);
            ncr = ncr / (i + 1);
        }

        return ncr;
    }
}