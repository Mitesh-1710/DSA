import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem:
 * You are given a list of items, where each item is represented as:
 *
 * <pre>
 * [type, color, name]
 * </pre>
 *
 * You are also given:
 * <ul>
 *   <li>{@code ruleKey}  → one of "type", "color", or "name"</li>
 *   <li>{@code ruleValue} → the value to match</li>
 * </ul>
 *
 * Return the number of items that match the given rule.
 *
 * <p>This is the solution to <b>LeetCode Problem 1773:
 * Count Items Matching a Rule</b></p>
 * <p>🔗 https://leetcode.com/problems/count-items-matching-a-rule/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * Each item is a fixed-size list of 3 elements:
 *
 * <pre>
 * index 0 → type
 * index 1 → color
 * index 2 → name
 * </pre>
 *
 * Naive Approach:
 * <ul>
 *   <li>For every item, check all 3 positions.</li>
 *   <li>Compare each with ruleKey and ruleValue.</li>
 * </ul>
 *
 * This works but performs unnecessary comparisons.
 *
 * Optimized Approach:
 * <ul>
 *   <li>Convert {@code ruleKey} into a corresponding index.</li>
 *   <li>Then directly compare only that index for every item.</li>
 * </ul>
 *
 * This reduces redundant condition checks.
 *
 * -----------------------------------------------------------------------
 * <b>Index Mapping Concept (Detailed Explanation):</b>
 *
 * Since each item always follows the structure:
 *
 * <pre>
 * [type, color, name]
 * </pre>
 *
 * We can pre-map:
 *
 * <pre>
 * "type"  → 0
 * "color" → 1
 * "name"  → 2
 * </pre>
 *
 * After determining the correct index,
 * we simply compare:
 *
 * <pre>
 * item.get(index).equals(ruleValue)
 * </pre>
 *
 * This keeps the logic clean and efficient.
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Determine index based on ruleKey.</li>
 *   <li>Initialize counter to 0.</li>
 *   <li>Traverse each item.</li>
 *   <li>If item at that index equals ruleValue → increment counter.</li>
 *   <li>Return counter.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * items = [
 *   ["phone","blue","pixel"],
 *   ["computer","silver","lenovo"],
 *   ["phone","gold","iphone"]
 * ]
 *
 * ruleKey = "color"
 * ruleValue = "silver"
 *
 * index = 1
 *
 * Only ["computer","silver","lenovo"] matches.
 *
 * Output: 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass over items.</li>
 *   <li>Only one comparison per item.</li>
 *   <li>No extra data structures required.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n), where {@code n} is the number of items.<br>
 *
 * <b>Space Complexity:</b>
 * O(1) — constant extra space.
 * -----------------------------------------------------------------------
 */
public class LeetCode1773_CountItemsMatchingARule {

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();

        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        String ruleKey = "color";
        String ruleValue = "silver";

        int result = countMatches(items, ruleKey, ruleValue);

        System.out.println("Output: " + result);
    }

    /**
     * Returns the number of items matching the given rule.
     *
     * @param items     list of items [type, color, name]
     * @param ruleKey   key to match ("type", "color", "name")
     * @param ruleValue value to compare
     * @return number of matching items
     */
    public static int countMatches(List<List<String>> items,
                                   String ruleKey,
                                   String ruleValue) {

        int index = 0;

        // Determine index based on ruleKey
        if ("color".equals(ruleKey)) {
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        }

        int match = 0;

        // Count matching items
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                match++;
            }
        }

        return match;
    }
}