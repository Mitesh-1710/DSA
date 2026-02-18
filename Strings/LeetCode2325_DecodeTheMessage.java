/**
 * Problem:
 * You are given a string {@code key} and a string {@code message}.
 *
 * <p>The {@code key} represents a substitution cipher mapping,
 * where:</p>
 * <ul>
 *   <li>Each unique character in {@code key} (excluding spaces)
 *       maps sequentially to letters 'a' to 'z'.</li>
 *   <li>The first unique character maps to 'a', the second to 'b', and so on.</li>
 * </ul>
 *
 * <p>Using this mapping, decode the {@code message} string.</p>
 *
 * <p>Spaces remain unchanged.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 2325:
 * Decode the Message</b></p>
 * <p>🔗 https://leetcode.com/problems/decode-the-message/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>The problem describes a substitution cipher built dynamically
 * from the given {@code key}.</p>
 *
 * <p>Naive Approach:</p>
 * <ul>
 *   <li>Use a HashMap to store character mappings.</li>
 *   <li>Traverse key, assign next alphabet letter for each new character.</li>
 *   <li>Traverse message and replace characters using the map.</li>
 * </ul>
 *
 * <p>This works but introduces extra object overhead.</p>
 *
 * <p>Optimized Approach:</p>
 * <ul>
 *   <li>Since only lowercase letters are involved, use a fixed-size
 *       character array of size 26.</li>
 *   <li>Map index: {@code c - 'a'}.</li>
 * </ul>
 *
 * <p>This ensures constant-time lookups and minimal memory usage.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Substitution Mapping Concept (Detailed Explanation):</b>
 *
 * <p>We build a mapping array:</p>
 * <pre>
 * map[original_char - 'a'] = decoded_char
 * </pre>
 *
 * <p>Process:</p>
 * <ul>
 *   <li>Initialize current mapped character as 'a'.</li>
 *   <li>Traverse {@code key} from left to right.</li>
 *   <li>If character is not space and not yet mapped:
 *       assign current letter and increment it.</li>
 * </ul>
 *
 * <p>This guarantees:</p>
 * <ul>
 *   <li>First unique character → 'a'</li>
 *   <li>Second unique character → 'b'</li>
 *   <li>...</li>
 * </ul>
 *
 * <p>Then decode {@code message} using this mapping.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Algorithm Steps:</b>
 *
 * <ul>
 *   <li>Create a char array of size 26 for mapping.</li>
 *   <li>Traverse {@code key} to build mapping.</li>
 *   <li>Convert {@code message} to char array.</li>
 *   <li>Replace each non-space character using mapping.</li>
 *   <li>Return new decoded string.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * key     = "the quick brown fox jumps over the lazy dog"
 * message = "vkbs bs t suepuv"
 *
 * Mapping built:
 * t → a
 * h → b
 * e → c
 * ...
 *
 * Decoded message:
 * "this is a secret"
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>Single pass to build mapping.</li>
 *   <li>Single pass to decode message.</li>
 *   <li>Constant-time array access.</li>
 *   <li>No extra dynamic data structures.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(n + m), where:
 * <ul>
 *   <li>{@code n} = length of key</li>
 *   <li>{@code m} = length of message</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * O(1) — fixed-size array of length 26.
 * -----------------------------------------------------------------------
 */
public class LeetCode2325_DecodeTheMessage {

    public static void main(String[] args) {

        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        String result = decodeMessage(key, message);

        System.out.println("Decoded message: " + result);
    }

    /**
     * Decodes the message using substitution mapping derived from key.
     *
     * @param key     cipher key
     * @param message encoded message
     * @return decoded message
     */
    public static String decodeMessage(String key, String message) {

        char[] map = new char[26];
        char curr = 'a';

        // Step 1: Build mapping from key
        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);

            if (c != ' ' && map[c - 'a'] == 0) {
                map[c - 'a'] = curr++;
            }
        }

        // Step 2: Decode message
        char[] result = message.toCharArray();

        for (int i = 0; i < result.length; i++) {

            if (result[i] != ' ') {
                result[i] = map[result[i] - 'a'];
            }
        }

        return new String(result);
    }
}