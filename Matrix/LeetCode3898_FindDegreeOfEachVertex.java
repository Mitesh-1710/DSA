/**
 * Problem:
 * You are given an adjacency matrix {@code matrix} representing a graph.
 *
 * <p>The value {@code matrix[i][j] = 1} means there is an edge between
 * vertex {@code i} and vertex {@code j}.</p>
 *
 * <p>Return an array where each element represents the <b>degree</b>
 * of the corresponding vertex.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3898:
 * Find the Degree of Each Vertex</b></p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Degree of a vertex:
 *
 * <pre>
 * number of edges connected to it
 * </pre>
 *
 * In adjacency matrix:
 *
 * <pre>
 * degree(i) = sum of row i
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>For each vertex, count number of 1s in its row.</li>
 * </ul>
 *
 * This is already optimal for adjacency matrix.
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Adjacency Matrix Representation</b>
 *
 * Matrix representation:
 *
 * <pre>
 * matrix[i][j] = 1 → edge exists
 * matrix[i][j] = 0 → no edge
 * </pre>
 *
 * Example:
 *
 * <pre>
 * [
 *  [0,1,1],
 *  [1,0,0],
 *  [1,0,0]
 * ]
 *
 * degree:
 * 0 → 2
 * 1 → 1
 * 2 → 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create result array.</li>
 *   <li>For each row i:</li>
 *   <ul>
 *     <li>Sum all elements in that row.</li>
 *     <li>Store in result[i].</li>
 *   </ul>
 *   <li>Return result.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * matrix =
 * [
 *  [0,1,1],
 *  [1,0,0],
 *  [1,0,0]
 * ]
 *
 * Output:
 * [2, 1, 1]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Direct mapping from matrix to degree.</li>
 *   <li>No extra data structures needed.</li>
 *   <li>Simple and intuitive.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n²)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode3898_FindDegreeOfEachVertex {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1},
                {1, 0, 0},
                {1, 0, 0}
        };

        int[] result = findDegrees(matrix);

        System.out.println(java.util.Arrays.toString(result));
    }

    /**
     * Computes degree of each vertex using row sum.
     */
    public static int[] findDegrees(int[][] matrix) {

        int n = matrix.length;
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {

            int total = 0;

            for (int j = 0; j < matrix[0].length; j++) {

                total += matrix[i][j];
            }

            degree[i] = total;
        }

        return degree;
    }
}