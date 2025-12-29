import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem:
 * Given a string {@code s}, return a list of unique characters sorted by:
 *
 * <ul>
 *   <li><b>Highest frequency first</b></li>
 *   <li>If two characters have the same frequency, sort them in
 *       <b>alphabetical (lexicographical) order</b></li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>This problem can be broken down into two clear phases:</p>
 *
 * <ol>
 *   <li><b>Frequency Counting</b></li>
 *   <li><b>Sorting based on custom rules</b></li>
 * </ol>
 *
 * <p><b>1. Frequency Counting</b></p>
 * <ul>
 *   <li>Traverse the string once.</li>
 *   <li>Use a {@link Map} to store the frequency of each character.</li>
 *   <li>Each character is mapped to the number of times it appears.</li>
 * </ul>
 *
 * <p><b>2. Sorting Logic</b></p>
 * <ul>
 *   <li>Convert the map entries into a stream.</li>
 *   <li>Sort using a custom comparator:</li>
 *   <ul>
 *     <li>Primary key → frequency (descending)</li>
 *     <li>Secondary key → character (ascending alphabetical order)</li>
 *   </ul>
 *   <li>Collect only the characters into a result list.</li>
 * </ul>
 *
 * <p>This approach ensures:</p>
 * <ul>
 *   <li>All characters are unique.</li>
 *   <li>Ordering strictly follows the problem constraints.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  "tree"
 *
 * Frequencies:
 * t → 1
 * r → 1
 * e → 2
 *
 * Sorting:
 * e (2) → highest frequency
 * r (1), t (1) → same frequency, sorted alphabetically
 *
 * Output: [e, r, t]
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n log n)
 * <ul>
 *   <li>O(n) for frequency counting</li>
 *   <li>O(k log k) for sorting unique characters (k ≤ n)</li>
 * </ul>
 *
 * <b>Space Complexity:</b> O(k)
 * <ul>
 *   <li>Frequency map + result list</li>
 * </ul>
 * -----------------------------------------------------------------------
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String input = "tree";
        System.out.println("Input: " + input);
        System.out.println("Sorted characters by frequency: " + sortFrequency(input));
    }

    /**
     * Returns a list of unique characters sorted by:
     *  1. Highest frequency first
     *  2. Alphabetical order if frequencies are equal
     *
     * @param s input string
     * @return list of characters sorted by frequency and lexicographical order
     */
    public static List<Character> sortFrequency(String s) {

        // 1. Frequency map to count occurrences of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.merge(s.charAt(i), 1, Integer::sum);
        }

        // 2. Sort entries based on:
        //    - Frequency descending
        //    - Character ascending (alphabetical)
        return frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    int frequencyComparison =
                            entry2.getValue().compareTo(entry1.getValue());

                    // If frequencies are equal, sort alphabetically
                    if (frequencyComparison == 0) {
                        return Character.compare(entry1.getKey(), entry2.getKey());
                    }

                    return frequencyComparison;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
