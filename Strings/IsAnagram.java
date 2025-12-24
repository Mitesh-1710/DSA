/**
 * Problem:
 * Given two strings {@code s} and {@code t}, determine whether {@code t} is an
 * anagram of {@code s}.
 *
 * <p>An <b>Anagram</b> is a word or phrase formed by rearranging the letters
 * of another word or phrase, using all original letters exactly once.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The key idea is to compare the <b>frequency of each character</b>
 * in both strings.</p>
 *
 * <ul>
 *   <li>If the lengths differ, they cannot be anagrams.</li>
 *   <li>Since the problem is restricted to lowercase English letters,
 *       we can use a fixed-size frequency array of size 26.</li>
 * </ul>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Traverse both strings simultaneously.</li>
 *   <li>Increment frequency for characters in {@code s}.</li>
 *   <li>Decrement frequency for characters in {@code t}.</li>
 *   <li>If both strings are anagrams, all frequencies must end up as zero.</li>
 * </ul>
 *
 * <p>This works because each increment from {@code s} must be exactly
 * cancelled by a decrement from {@code t}.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * s = "anagram"
 * t = "nagaram"
 *
 * Frequency changes:
 * a → +1 (s), -1 (t) → 0
 * n → +1, -1 → 0
 * g → +1, -1 → 0
 * ...
 *
 * Final frequency array → all zeros
 * Result → true
 * </pre>
 *
 * <pre>
 * s = "rat"
 * t = "car"
 *
 * Frequencies differ → result = false
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n) — single pass over the strings.<br>
 * <b>Space Complexity:</b> O(1) — fixed array of size 26.
 * -----------------------------------------------------------------------
 */
public class AnagramStrings {

    public static void main(String[] args) {

        System.out.println("anagram / nagaram → " +
                areAnagrams("anagram", "nagaram"));

        System.out.println("rat / car → " +
                areAnagrams("rat", "car"));
    }

    /**
     * Checks whether two strings are anagrams of each other.
     *
     * @param s first input string
     * @param t second input string
     * @return {@code true} if {@code t} is an anagram of {@code s},
     *         otherwise {@code false}
     */
    public static boolean areAnagrams(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        // Count frequency differences
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Verify all frequencies are zero
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}
