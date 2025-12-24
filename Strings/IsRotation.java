/**
 * Problem:
 * Given two strings {@code s} and {@code goal}, determine whether {@code s}
 * can become {@code goal} after performing some number of left rotations.
 *
 * <p>A single left rotation moves the leftmost character of {@code s}
 * to the rightmost position.</p>
 *
 * <p>Example:</p>
 * <pre>
 * s = "abcde"
 * After 1 shift → "bcdea"
 * After 2 shifts → "cdeab"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The key observation is that all possible rotations of a string {@code s}
 * are substrings of {@code s + s}.</p>
 *
 * <ul>
 *   <li>Concatenating {@code s} with itself produces all cyclic rotations.</li>
 *   <li>If {@code goal} exists inside {@code (s + s)}, then {@code goal}
 *       must be a valid rotation of {@code s}.</li>
 * </ul>
 *
 * <p><b>Important Constraint:</b></p>
 * <ul>
 *   <li>If {@code s} and {@code goal} are of different lengths,
 *       rotation is impossible.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * s = "abcde"
 * goal = "cdeab"
 *
 * s + s = "abcdeabcde"
 * "cdeab" exists inside "abcdeabcde" → true
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Edge Cases:</b>
 * <ul>
 *   <li>Different lengths → return false</li>
 *   <li>Empty strings → valid rotation</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — substring search on doubled string.<br>
 * <b>Space Complexity:</b> O(n) — concatenated string storage.
 * -----------------------------------------------------------------------
 */
public class IsRotation {

    public static void main(String[] args) {
        System.out.println("Rotation check (abcde → cdeab): "
                + rotateString("abcde", "cdeab"));

        System.out.println("Rotation check (abcde → abced): "
                + rotateString("abcde", "abced"));
    }

    /**
     * Returns {@code true} if {@code s} can be rotated to become {@code goal}.
     *
     * @param s     original string
     * @param goal  target string after rotations
     * @return {@code true} if rotation is possible, otherwise {@code false}
     */
    public static boolean rotateString(String s, String goal) {

        // 1. Length mismatch → rotation impossible
        if (s.length() != goal.length()) return false;

        // 2. Concatenate s with itself to include all rotations
        String doubled = s + s;

        // 3. Check if goal exists as a substring
        return doubled.contains(goal);
    }
}