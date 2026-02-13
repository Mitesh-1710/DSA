/**
 * Problem:
 * You are given access to a circular street represented by an object {@code Street}.
 *
 * <p>The street contains an unknown number of houses (≤ k).
 * Each house has a door that may initially be open or closed.</p>
 *
 * <p>You start standing in front of some house. Using only the
 * available API methods, determine the total number of houses
 * in the circular street.</p>
 *
 * <p>Street API:</p>
 * <ul>
 *   <li>{@code void openDoor()}</li>
 *   <li>{@code void closeDoor()}</li>
 *   <li>{@code boolean isDoorOpen()}</li>
 *   <li>{@code void moveRight()}</li>
 *   <li>{@code void moveLeft()}</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>This is an interactive circular traversal problem.</p>
 *
 * <p>Key observations:</p>
 * <ul>
 *   <li>The street is circular.</li>
 *   <li>The number of houses ≤ k.</li>
 *   <li>Door states can be modified.</li>
 * </ul>
 *
 * <p>Naive idea:</p>
 * <ul>
 *   <li>Traverse while counting until returning to the starting point.</li>
 * </ul>
 *
 * <p>However, since we cannot directly detect the starting house,
 * we must mark it uniquely.</p>
 *
 * <p>Optimized strategy:</p>
 * <ul>
 *   <li>First normalize all doors to closed.</li>
 *   <li>Mark one house uniquely by opening its door.</li>
 *   <li>Traverse until we encounter the open door again.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Marking & Circular Detection Concept (Detailed Explanation):</b>
 *
 * <p>The key idea is to create a <b>unique marker</b> in the circular system.</p>
 *
 * <ul>
 *   <li>Since doors may initially be open or closed,
 *       we first force all doors to closed.</li>
 *   <li>This guarantees a uniform state.</li>
 *   <li>Then we open exactly one door — this becomes our marker.</li>
 * </ul>
 *
 * <p>Because the street is circular:</p>
 * <ul>
 *   <li>If we move continuously in one direction,</li>
 *   <li>We will eventually return to the marked house.</li>
 * </ul>
 *
 * <p>The number of moves required to encounter the open door again
 * equals the total number of houses.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Move left k times, closing every door encountered.</li>
 *   <li>This guarantees all doors are closed.</li>
 *   <li>Open the current door (marking starting house).</li>
 *   <li>Move left while counting until we encounter the open door again.</li>
 *   <li>Return the count.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * street = [0, 0, 0, 0], k = 10
 *
 * Step 1: Close all doors (already closed).
 * Step 2: Open one door (mark).
 * Step 3: Move left and count until we see open door again.
 *
 * Total moves = 4 → number of houses = 4
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Guarantees unique marker.</li>
 *   <li>Uses circular property safely.</li>
 *   <li>Does not depend on initial door states.</li>
 *   <li>Works within constraint k.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(k) — at most k moves for normalization + at most k moves for counting.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class CountHousesInCircularStreet {

    /**
     * Counts the number of houses in a circular street.
     *
     * @param street Street API instance
     * @param k      upper bound on number of houses
     * @return number of houses
     */
    public int houseCount(Street street, int k) {

        // Step 1: Normalize all doors to closed
        for (int i = 0; i < k; ++i) {
            street.closeDoor();
            street.moveLeft();
        }

        // Step 2: Mark the current house by opening its door
        street.openDoor();

        int count = 1;

        // Step 3: Traverse until we return to the marked house
        street.moveLeft();
        while (!street.isDoorOpen()) {
            street.moveLeft();
            count++;
        }

        return count;
    }
}
