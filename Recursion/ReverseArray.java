import java.util.ArrayList;

/**
 * Problem:
 * Reverse a string represented as an {@link ArrayList} of characters using recursion.
 *
 * <p>The reversal must be done <b>in-place</b>, without using extra data structures.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process:</b>
 *
 * <p>The idea is to use the <b>two-pointer technique</b> implemented recursively:</p>
 *
 * <ul>
 *   <li>One pointer starts from the beginning (left).</li>
 *   <li>The corresponding character from the end is determined as:
 *       <code>size - 1 - index</code>.</li>
 *   <li>Swap the characters at these two positions.</li>
 *   <li>Move the pointer inward and repeat.</li>
 * </ul>
 *
 * <p><b>Key Observation:</b></p>
 * <ul>
 *   <li>We only need to recurse until the middle of the list.</li>
 *   <li>For a list of size <code>n</code>, recursion stops at <code>index == n / 2</code>.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Recursive Breakdown:</b>
 *
 * <p><b>Base Case:</b></p>
 * <ul>
 *   <li>When <code>index >= size / 2</code>, all swaps are complete.</li>
 * </ul>
 *
 * <p><b>Recursive Case:</b></p>
 * <ul>
 *   <li>Swap characters at positions <code>index</code> and
 *       <code>size - 1 - index</code>.</li>
 *   <li>Recurse for the next index.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * Input:  ['h', 'e', 'l', 'l', 'o']
 *
 * Step 1: swap(0,4) → o e l l h
 * Step 2: swap(1,3) → o l l e h
 * Stop at index = 2
 *
 * Output: ['o', 'l', 'l', 'e', 'h']
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(n)<br>
 * <b>Space Complexity:</b> O(n) — recursion stack
 * -----------------------------------------------------------------------
 */
public class ReverseArray {

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<>();
        for (char c : "hello".toCharArray()) {
            input.add(c);
        }

        System.out.println("Original: " + input);
        reverseString(input);
        System.out.println("Reversed: " + input);
    }

    /**
     * Reverses the given list of characters using recursion.
     *
     * @param chars list of characters to reverse
     * @return the same list after in-place reversal
     */
    public static ArrayList<Character> reverseString(ArrayList<Character> chars) {
        reverseHelper(chars, 0);
        return chars;
    }

    /**
     * Recursive helper that swaps characters symmetrically.
     *
     * @param chars the character list
     * @param index current left index
     */
    private static void reverseHelper(ArrayList<Character> chars, int index) {

        // Base case: stop when we reach the middle
        if (index >= chars.size() / 2) {
            return;
        }

        int oppositeIndex = chars.size() - 1 - index;

        // Swap characters
        char temp = chars.get(index);
        chars.set(index, chars.get(oppositeIndex));
        chars.set(oppositeIndex, temp);

        // Recursive call for next index
        reverseHelper(chars, index + 1);
    }
}