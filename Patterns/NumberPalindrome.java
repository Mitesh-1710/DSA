/**
 * Problem:
 * Print a numeric palindrome pattern consisting of increasing numbers on the left,
 * a shrinking middle gap, and decreasing numbers on the right.
 *
 * <p>For example, for {@code n = 5}, the output is:</p>
 * <pre>
 * 1        1
 * 12      21
 * 123    321
 * 1234  4321
 * 1234554321
 * </pre>
 * <p>
 * ---------------------------------------------------------------------
 * Thought Process Behind the Pattern Shape:
 *
 * <p>We break the pattern into three independently identifiable segments:</p>
 *
 * <ul>
 *   <li><b>1. Left Increasing Sequence</b>
 *     <ul>
 *       <li>Standard number growth: 1 → i</li>
 *       <li>Printed using: <code>for (j = 1; j <= i; j++)</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Middle Gap (Core Formula Derivation)</b>
 *     <ul>
 *       <li>Observation: The gap shrinks by exactly 2 spaces per row.</li>
 *       <li>For row i, gap = (total center width) - (reduction due to left + right blocks).</li>
 *       <li>Derived formula:
 *         <pre>(2 * n) - (2 * i)</pre>
 *       </li>
 *       <li>The same identification strategy is used in pyramid/diamond formulas
 *           where we observe shrinking widths (e.g., <code>(2*i)+1</code>).</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. Right Decreasing Sequence</b>
 *     <ul>
 *       <li>Mirror of left side: i → 1</li>
 *       <li>Completes the numeric palindrome.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>Pattern Grouping</b>
 *     <ul>
 *       <li>This belongs to the “Mirrored Symmetric Patterns” family.</li>
 *       <li>We can generate similar structures:
 *         <ul>
 *           <li>Alphabet palindromes</li>
 *           <li>Star-based palindromes</li>
 *           <li>Sandglass number patterns</li>
 *           <li>Right-arrow shapes using mirrored triangles</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * ---------------------------------------------------------------------
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * ---------------------------------------------------------------------
 */
public class NumberPalindrome {

    public static void main(String[] args) {
        printNumberPalindromePattern(5);
    }

    /**
     * Prints the number palindrome pattern with derived center-gap logic.
     */
    public static void printNumberPalindromePattern(int n) {

        // Loop rows from 1 to n
        for (int i = 1; i <= n; i++) {

            // 1. Print left increasing numbers: 1 → i
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // 2. Print center gap
            //    Derived formula:
            //         gap = (2 * n) - (2 * i)
            //    Gap shrinks by 2 spaces per row
            for (int j = 1; j <= (2 * n) - (2 * i); j++) {
                System.out.print(" ");
            }

            // 3. Print right decreasing numbers: i → 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to next line
            System.out.println();
        }
    }
}