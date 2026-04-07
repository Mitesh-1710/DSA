import java.util.List;

/**
 * Problem:
 * You are given an integer {@code n} representing an {@code n x n} grid.
 *
 * <p>You start at position (0, 0). You are also given a list of
 * movement commands:</p>
 *
 * <ul>
 *   <li>'U' → move up</li>
 *   <li>'D' → move down</li>
 *   <li>'L' → move left</li>
 *   <li>'R' → move right</li>
 * </ul>
 *
 * <p>After executing all commands, return the final position
 * as a single integer using:</p>
 *
 * <pre>
 * index = row * n + col
 * </pre>
 *
 * <p>This is the solution to <b>LeetCode Problem 3248:
 * Snake in Matrix</b></p>
 * <p>🔗 https://leetcode.com/problems/snake-in-matrix/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We simulate movement on a grid:
 *
 * <ul>
 *   <li>Track row and column.</li>
 *   <li>Update position based on commands.</li>
 * </ul>
 *
 * After all moves, convert 2D position into 1D index.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Grid Simulation</b>
 *
 * Movement rules:
 *
 * <pre>
 * U → row--
 * D → row++
 * L → col--
 * R → col++
 * </pre>
 *
 * We simply apply these transformations step-by-step.
 *
 * -----------------------------------------------------------------------
 * <b>Concept: 2D to 1D Mapping</b>
 *
 * In row-major order:
 *
 * <pre>
 * index = row * n + col
 * </pre>
 *
 * Example (n = 3):
 *
 * <pre>
 * (0,0)=0   (0,1)=1   (0,2)=2
 * (1,0)=3   (1,1)=4   (1,2)=5
 * (2,0)=6   (2,1)=7   (2,2)=8
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Initialize row = 0, col = 0.</li>
 *   <li>Traverse commands:</li>
 *   <ul>
 *     <li>Update row/col based on direction.</li>
 *   </ul>
 *   <li>Return row * n + col.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * n = 3
 * commands = ["RIGHT", "DOWN", "DOWN", "LEFT"]
 *
 * Process:
 *
 * Start → (0,0)
 * RIGHT → (0,1)
 * DOWN → (1,1)
 * DOWN → (2,1)
 * LEFT → (2,0)
 *
 * Output:
 * 2 * 3 + 0 = 6
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Simple simulation.</li>
 *   <li>Constant space.</li>
 *   <li>Linear traversal.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(m), where {@code m} = number of commands
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode3248_SnakeInMatrix {

    public static void main(String[] args) {

        int n = 3;
        List<String> commands = List.of("RIGHT", "DOWN", "DOWN", "LEFT");

        int result = finalPositionOfSnake(n, commands);

        System.out.println("Final Position: " + result);
    }

    /**
     * Simulates snake movement in matrix.
     */
    public static int finalPositionOfSnake(int n, List<String> commands) {

        int row = 0, col = 0;

        for (String c : commands) {

            switch (c.charAt(0)) {

                case 'U': row--; break;
                case 'D': row++; break;
                case 'L': col--; break;
                case 'R': col++; break;
            }
        }

        return row * n + col;
    }
}