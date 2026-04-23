/**
 * Problem:
 * You are given a string {@code coordinates} representing a square on a chessboard.
 *
 * <p>The coordinate consists of:</p>
 * <ul>
 *   <li>a letter ('a' to 'h') → column</li>
 *   <li>a digit  ('1' to '8') → row</li>
 * </ul>
 *
 * <p>Return {@code true} if the square is white, otherwise {@code false}.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1812:
 * Determine Color of a Chessboard Square</b></p>
 * <p>🔗 https://leetcode.com/problems/determine-color-of-a-chessboard-square/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Chessboard coloring alternates like:
 *
 * <pre>
 * Black White Black White ...
 * White Black White Black ...
 * </pre>
 *
 * Key observation:
 *
 * <pre>
 * Color depends on parity of (row + column)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Coordinate Mapping</b>
 *
 * Convert:
 *
 * <pre>
 * column = coordinates.charAt(0) - 'a'  → 0 to 7
 * row    = coordinates.charAt(1) - '1'  → 0 to 7
 * </pre>
 *
 * Then:
 *
 * <pre>
 * (row + column) % 2
 * </pre>
 *
 * If:
 *
 * <pre>
 * even → black
 * odd  → white
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Trick:</b>
 *
 * Instead of:
 *
 * <pre>
 * % 2
 * </pre>
 *
 * use:
 *
 * <pre>
 * & 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Convert column and row to numbers.</li>
 *   <li>Add them.</li>
 *   <li>Check parity using bit operation.</li>
 *   <li>Return true if odd (white).</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * coordinates = "a1"
 *
 * column = 0
 * row = 0
 *
 * sum = 0 → even → black → false
 * </pre>
 *
 * <pre>
 * Input:
 * coordinates = "c7"
 *
 * column = 2
 * row = 6
 *
 * sum = 8 → even → black → false
 * </pre>
 *
 * <pre>
 * Input:
 * coordinates = "h3"
 *
 * column = 7
 * row = 2
 *
 * sum = 9 → odd → white → true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No board simulation needed.</li>
 *   <li>Constant time calculation.</li>
 *   <li>Elegant parity-based logic.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(1)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1812_DetermineColorOfChessboardSquare {

    public static void main(String[] args) {

        String coordinates = "h3";

        boolean result = squareIsWhite(coordinates);

        System.out.println("Is White: " + result);
    }

    /**
     * Determines if square is white using parity.
     */
    public static boolean squareIsWhite(String coordinates) {

        return ((((coordinates.charAt(0) - 'a')
                + (coordinates.charAt(1) - '1'))) & 1) == 1;
    }
}