import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Problem:
 * You are given a list of paths where:
 *
 * <pre>
 * paths[i] = [cityA, cityB]
 * </pre>
 *
 * meaning there is a direct path from cityA → cityB.
 *
 * <p>Return the <b>destination city</b>, i.e., the city with no outgoing paths.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1436:
 * Destination City</b></p>
 * <p>🔗 https://leetcode.com/problems/destination-city/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * We need a city that:
 *
 * <pre>
 * appears as destination
 * BUT never appears as starting point
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Naive Approach:</b>
 *
 * <ul>
 *   <li>For each destination, scan all paths to check if it appears as start.</li>
 * </ul>
 *
 * Time:
 *
 * <pre>
 * O(n²)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Optimized Approach:</b>
 *
 * Use a set to store all starting cities.
 *
 * Then:
 *
 * <ul>
 *   <li>Check each destination.</li>
 *   <li>If not in set → that's the answer.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Concept (Detailed Explanation): Sink Node in Directed Graph</b>
 *
 * Think of paths as a graph:
 *
 * <pre>
 * A → B → C → D
 * </pre>
 *
 * Destination city:
 *
 * <pre>
 * node with no outgoing edges
 * </pre>
 *
 * i.e.:
 *
 * <pre>
 * not present in "start" set
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a set of all starting cities.</li>
 *   <li>Traverse paths again:</li>
 *   <ul>
 *     <li>If destination not in set → return it.</li>
 *   </ul>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:
 * paths = [["London","New York"],
 *          ["New York","Lima"],
 *          ["Lima","Sao Paulo"]]
 *
 * starts = {London, New York, Lima}
 *
 * Check:
 * New York → in set ❌
 * Lima → in set ❌
 * Sao Paulo → not in set ✅
 *
 * Output:
 * "Sao Paulo"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Uses hashing for O(1) lookup.</li>
 *   <li>Avoids nested loops.</li>
 *   <li>Simple graph interpretation.</li>
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
public class LeetCode1436_DestinationCity {

    public static void main(String[] args) {

        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
        );

        String result = destCity(paths);

        System.out.println("Destination: " + result);
    }

    /**
     * Finds destination city using set lookup.
     */
    public static String destCity(List<List<String>> paths) {

        Set<String> starts = new HashSet<>();

        // Collect all starting cities
        for (List<String> path : paths) {
            starts.add(path.get(0));
        }

        // Find city that is never a starting point
        for (List<String> path : paths) {

            String destination = path.get(1);

            if (!starts.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}