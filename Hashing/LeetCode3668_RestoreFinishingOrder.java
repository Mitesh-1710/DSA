import java.util.Set;
import java.util.HashSet;

/**
 * Problem:
 * You are given two integer arrays:
 * <ul>
 *   <li>{@code order} — representing the finishing order of participants.</li>
 *   <li>{@code friends} — representing a subset of participants.</li>
 * </ul>
 *
 * <p>Return the finishing order of only those participants present
 * in {@code friends}, while preserving their relative order
 * from the {@code order} array.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 3668: Restore Finishing Order</b></p>
 * <p>🔗 https://leetcode.com/problems/restore-finishing-order/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The requirement is to filter elements from {@code order}
 * while preserving relative ordering.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>For each element in {@code order}, check if it exists in
 *       {@code friends} using linear search.</li>
 * </ul>
 *
 * <p>This results in O(n × m) time complexity.</p>
 *
 * <p>For small constraints, this approach is acceptable.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Store {@code friends} in a HashSet for constant-time lookups.</li>
 *   <li>Traverse {@code order} once.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>HashSet Lookup Concept (Detailed Explanation):</b>
 *
 * <p>A {@link java.util.HashSet} provides average O(1) time for
 * insertion, lookup, and removal.</p>
 *
 * <p>By inserting all {@code friends} into a set:</p>
 * <ul>
 *   <li>We can instantly check membership.</li>
 *   <li>Using {@code remove()} ensures each friend is processed once.</li>
 * </ul>
 *
 * <p>We also pre-size the HashSet to avoid internal resizing.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Insert all {@code friends} into a HashSet.</li>
 *   <li>Create a result array of size {@code friends.length}.</li>
 *   <li>Traverse {@code order}:</li>
 *   <ul>
 *     <li>If element exists in set → add to result.</li>
 *     <li>Remove from set.</li>
 *     <li>Stop once all friends are found.</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * order   = [3, 1, 2, 4, 5]
 * friends = [1, 5, 3]
 *
 * Traverse order:
 * 3 → in set → add
 * 1 → in set → add
 * 2 → skip
 * 4 → skip
 * 5 → in set → add
 *
 * Output:
 *   [3, 1, 5]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over {@code order}.</li>
 *   <li>Constant-time membership checks.</li>
 *   <li>Preserves original relative order.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + m), where:
 * <ul>
 *   <li>{@code n = order.length}</li>
 *   <li>{@code m = friends.length}</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(m) — space used by the HashSet.
 * -----------------------------------------------------------------------
 */
public class LeetCode3668_RestoreFinishingOrder {

    public static void main(String[] args) {

        int[] order = {3, 1, 2, 4, 5};
        int[] friends = {1, 5, 3};

        int[] result = recoverOrder(order, friends);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    /**
     * Restores the finishing order of participants present in friends.
     *
     * @param order   complete finishing order
     * @param friends subset of participants
     * @return finishing order restricted to friends
     */
    public static int[] recoverOrder(int[] order, int[] friends) {

        // Pre-size HashSet to avoid rehashing (0.75 is default load factor)
        Set<Integer> friendsSet =
                new HashSet<>((int) (friends.length / 0.75f) + 1);

        for (int friend : friends) {
            friendsSet.add(friend);
        }

        int[] result = new int[friends.length];
        int i = 0;

        for (int o : order) {
            if (friendsSet.remove(o)) {
                result[i++] = o;

                if (i == result.length) {
                    break;
                }
            }
        }

        return result;
    }
}