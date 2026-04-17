/**
 * Problem:
 * Given a matrix {@code grid} of size m x n, where each row and column
 * is sorted in <b>non-increasing order</b> (i.e., decreasing),
 * return the number of negative numbers in the matrix.
 *
 * <p>This is the solution to <b>LeetCode Problem 1351:
 * Count Negative Numbers in a Sorted Matrix</b></p>
 * <p>🔗 https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * The matrix has a key property:
 *
 * <pre>
 * rows and columns are sorted in decreasing order
 * </pre>
 *
 * Example:
 *
 * <pre>
 * [ 5  3  1 -1 ]
 * [ 3  2  0 -2 ]
 * [ 1  0 -1 -3 ]
 * </pre>
 *
 * Once a negative number appears in a row,
 * all elements to its right are also negative.
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach (Your Solution):</b>
 *
 * <ul>
 *   <li>Traverse every element.</li>
 *   <li>Count negatives.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(m * n)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach (IMPORTANT): Staircase Traversal</b>
 *
 * Use the sorted property:
 *
 * <ul>
 *   <li>Start from top-right corner.</li>
 *   <li>If element is negative → all elements below are negative.</li>
 *   <li>If element is positive → move right.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Monotonic Matrix Traversal</b>
 *
 * Start:
 *
 * <pre>
 * row = 0, col = n-1
 * </pre>
 *
 * Rules:
 *
 * <ul>
 *   <li>If grid[row][col] < 0:</li>
 *   <ul>
 *     <li>All elements below are negative.</li>
 *     <li>Add (m - row) to count.</li>
 *     <li>Move left.</li>
 *   </ul>
 *   <li>Else:</li>
 *   <ul>
 *     <li>Move down.</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps (Optimized):</b>
 *
 * <ul>
 *   <li>Initialize row = 0, col = n-1.</li>
 *   <li>While within bounds:</li>
 *   <ul>
 *     <li>If negative → count += remaining rows.</li>
 *     <li>Move left.</li>
 *     <li>Else → move down.</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * grid =
 * [
 *  [ 4, 3, 2, -1],
 *  [ 3, 2, 1, -1],
 *  [ 1, 1, -1, -2],
 *  [-1,-1, -2, -3]
 * ]
 *
 * Output:
 * 8
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses sorted property.</li>
 *   <li>Avoids visiting all elements.</li>
 *   <li>Linear traversal across matrix boundary.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(m + n)
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1351_CountNegativeNumbersInSortedMatrix {

    public static void main(String[] args) {

        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int result = countNegatives(grid);

        System.out.println("Result: " + result);
    }

    /**
     * Optimized solution using staircase traversal.
     */
    public static int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int row = 0, col = n - 1;
        int count = 0;

        while (row < m && col >= 0) {

            if (grid[row][col] < 0) {

                // All elements below are negative
                count += (m - row);
                col--;

            } else {

                row++;
            }
        }

        return count;
    }
}