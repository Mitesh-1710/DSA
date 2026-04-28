import java.util.Arrays;

/**
 * Problem:
 * You are given a list of operations {@code operations} representing
 * a baseball game score system.
 *
 * <p>Operations can be:</p>
 *
 * <ul>
 *   <li>Integer → record a new score</li>
 *   <li>"+" → sum of last two scores</li>
 *   <li>"D" → double the last score</li>
 *   <li>"C" → invalidate the last score</li>
 * </ul>
 *
 * <p>Return the total score after processing all operations.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 682:
 * Baseball Game</b></p>
 * <p>🔗 https://leetcode.com/problems/baseball-game/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Each operation depends on previous scores:
 *
 * <pre>
 * last score
 * last two scores
 * remove last score
 * </pre>
 *
 * This is a classic:
 *
 * <pre>
 * LIFO (Last In First Out)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>Recompute sum after each operation.</li>
 * </ul>
 *
 * This leads to unnecessary repeated work.
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * <ul>
 *   <li>Use stack-like array to store scores.</li>
 *   <li>Maintain running total.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Stack Simulation</b>
 *
 * We simulate stack using array:
 *
 * <pre>
 * record[index] → acts like push
 * index-- → acts like pop
 * </pre>
 *
 * Operations:
 *
 * <ul>
 *   <li>"+" → record[index-1] + record[index-2]</li>
 *   <li>"D" → 2 * record[index-1]</li>
 *   <li>"C" → remove last → index--</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create array to simulate stack.</li>
 *   <li>Initialize index = 0 and total = 0.</li>
 *   <li>Traverse operations:</li>
 *   <ul>
 *     <li>Handle "+", "D", "C", or number.</li>
 *     <li>Update stack and total accordingly.</li>
 *   </ul>
 *   <li>Return total.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * operations = ["5","2","C","D","+"]
 *
 * Process:
 * 5 → [5]
 * 2 → [5,2]
 * C → [5]
 * D → [5,10]
 * + → [5,10,15]
 *
 * Total:
 * 30
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>O(1) operations for push/pop.</li>
 *   <li>No recomputation of sum.</li>
 *   <li>Efficient simulation.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n)
 *
 * <b>Space Complexity:</b>
 * O(n)
 * -----------------------------------------------------------------------
 */
public class LeetCode682_BaseballGame {

    public static void main(String[] args) {

        String[] operations = {"5", "2", "C", "D", "+"};

        int result = calPoints(operations);

        System.out.println("Result: " + result);
    }

    /**
     * Simulates baseball game scoring.
     */
    public static int calPoints(String[] operations) {

        int[] record = new int[operations.length];
        int index = 0;
        int total = 0;

        for (String op : operations) {

            if (op.equals("+")) {

                int score = record[index - 1] + record[index - 2];
                record[index++] = score;
                total += score;

            } else if (op.equals("D")) {

                int score = record[index - 1] * 2;
                record[index++] = score;
                total += score;

            } else if (op.equals("C")) {

                total -= record[--index];

            } else {

                int score = Integer.parseInt(op);
                record[index++] = score;
                total += score;
            }
        }

        return total;
    }
}