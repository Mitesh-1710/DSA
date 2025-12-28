/**
 * Problem:
 * Given two strings {@code s} and {@code t}, determine if they are <b>isomorphic</b>.
 *
 * <p>Two strings are isomorphic if the characters in {@code s} can be replaced to get {@code t},
 * with the following rules:</p>
 * <ul>
 *   <li>Each character must map to exactly one other character.</li>
 *   <li>No two different characters may map to the same character.</li>
 *   <li>Character order must be preserved.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key challenge is ensuring a <b>consistent one-to-one mapping</b> between characters
 * of {@code s} and {@code t}.</p>
 *
 * <p>Instead of explicitly storing mappings using hash maps, we track the
 * <b>last seen index</b> of each character in both strings.</p>
 *
 * <p><b>Core Insight:</b></p>
 * <ul>
 *   <li>If two characters were last seen at the same index before,
 *       they must appear together again.</li>
 *   <li>If their last-seen positions differ, the mapping is inconsistent.</li>
 * </ul>
 *
 * <p>This allows us to validate isomorphism in a single pass.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Step-by-Step Logic:</b>
 *
 * <ul>
 *   <li>If lengths differ → return false immediately.</li>
 *   <li>Use two arrays:
 *     <ul>
 *       <li>{@code sLastSeen[c]} → last index where character {@code c} appeared in {@code s}</li>
 *       <li>{@code tLastSeen[c]} → last index where character {@code c} appeared in {@code t}</li>
 *     </ul>
 *   </li>
 *   <li>Traverse both strings together.</li>
 *   <li>If last seen indices differ → strings are not isomorphic.</li>
 *   <li>Otherwise, update both arrays with the current index.</li>
 * </ul>
 *
 * <p><b>Why use (index + 1)?</b></p>
 * <ul>
 *   <li>Arrays default to 0.</li>
 *   <li>Using {@code i + 1} avoids ambiguity between unseen characters and index 0.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * s = "egg", t = "add"
 *
 * e → a
 * g → d
 *
 * Mapping is consistent → true
 *
 * s = "foo", t = "bar"
 *
 * f → b
 * o → a (first time)
 * o → r (conflict)
 *
 * Result → false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single traversal of both strings.<br>
 * <b>Space Complexity:</b> O(1) — fixed-size arrays for character tracking.
 * -----------------------------------------------------------------------
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println("Isomorphic (egg, add): " + isIsomorphic("egg", "add"));
        System.out.println("Isomorphic (foo, bar): " + isIsomorphic("foo", "bar"));
        System.out.println("Isomorphic (paper, title): " + isIsomorphic("paper", "title"));
    }

    /**
     * Checks whether two strings are isomorphic.
     *
     * @param s first input string
     * @param t second input string
     * @return true if strings are isomorphic, false otherwise
     */
    public static boolean isIsomorphic(String s, String t) {

        // Length mismatch → cannot be isomorphic
        if (s.length() != t.length()) return false;

        // Track last seen positions for each character
        int[] sLastSeen = new int[65536];
        int[] tLastSeen = new int[65536];

        // Traverse both strings together
        for (int i = 0; i < s.length(); i++) {

            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // If last seen positions differ, mapping is inconsistent
            if (sLastSeen[sc] != tLastSeen[tc]) {
                return false;
            }

            // Update last seen index (i + 1 to avoid zero ambiguity)
            sLastSeen[sc] = i + 1;
            tLastSeen[tc] = i + 1;
        }

        return true;
    }
}