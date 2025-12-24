/**
 * Problem:
 * Given an integer {@code n}, print different left-aligned inverted right-angled triangle patterns.
 *
 * <p>The program demonstrates multiple variations:</p>
 * <ul>
 *   <li><b>1.</b> Asterisk Pattern — Prints '*' characters in decreasing order per row.</li>
 *   <li><b>2.</b> Decremental Number Pattern — Prints numbers from 1 to (n - i + 1) in each row.</li>
 *   <li><b>3.</b> Row Number Pattern — Prints the same number (row index) per row in decreasing fashion.</li>
 *   <li><b>4.</b> Binary Pattern — Alternates 1 and 0 based on parity of (i + j).</li>
 *   <li><b>5.</b> Continuous Number Pattern — Prints continuously decreasing numbers in inverted rows.</li>
 *   <li><b>6.</b> Decremental Alphabet Pattern — Prints letters decreasing from 'A'.</li>
 *   <li><b>7.</b> Repeated Alphabet Pattern — Prints same letter per row in decreasing order of rows.</li>
 *   <li><b>8.</b> Reverse Alphabet Start Pattern — Starts each row with increasing letters but decreasing row count.</li>
 * </ul>
 *
 * <p><b>Common Thought Process:</b></p>
 * <ul>
 *   <li>The pattern forms a <b>left-aligned inverted right-angled triangle</b> with {@code n} rows.</li>
 *   <li>The <b>outer loop</b> (variable {@code i}) runs from {@code n} down to {@code 1}.</li>
 *   <li>The <b>inner loop</b> (variable {@code j}) runs from {@code 1} to {@code i}.</li>
 *   <li>The <b>print logic</b> varies depending on the desired pattern (asterisk, number, letter, etc.).</li>
 *   <li>After each row, a newline is printed to move to the next row.</li>
 * </ul>
 *
 * <p><b>Example Output for {@code n = 5}:</b></p>
 *
 * <pre>
 * 1. Asterisk Pattern:
 * *****
 * ****
 * ***
 * **
 * *
 *
 * 2. Decremental Number Pattern:
 * 12345
 * 1234
 * 123
 * 12
 * 1
 *
 * 3. Row Number Pattern:
 * 55555
 * 4444
 * 333
 * 22
 * 1
 *
 * 4. Binary Pattern:
 * 10101
 * 0101
 * 101
 * 01
 * 1
 *
 * 5. Continuous Number Pattern:
 * 15 14 13 12 11
 * 10 9 8 7
 * 6 5 4
 * 3 2
 * 1
 *
 * 6. Decremental Alphabet Pattern:
 * ABCDE
 * ABCD
 * ABC
 * AB
 * A
 *
 * 7. Repeated Alphabet Pattern:
 * EEEEE
 * DDDD
 * CCC
 * BB
 * A
 *
 * 8. Reverse Alphabet Start Pattern:
 * ABCDE
 * BCDE
 * CDE
 * DE
 * E
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n²) — total prints ≈ n(n + 1)/2.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.</p>
 */
public class LeftAlignedInvertedTriangle {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Asterisk Pattern:");
        printAsteriskInvertedTriangle(n);

        System.out.println("\n2. Decremental Number Pattern:");
        printDecrementalNumberTriangle(n);

        System.out.println("\n3. Row Number Pattern:");
        printRowNumberTriangle(n);

        System.out.println("\n4. Binary Pattern:");
        printBinaryTriangle(n);

        System.out.println("\n5. Continuous Number Pattern:");
        printContinuousNumberTriangle(n);

        System.out.println("\n6. Decremental Alphabet Pattern:");
        printDecrementalAlphabetTriangle(n);

        System.out.println("\n7. Repeated Alphabet Pattern:");
        printRepeatedAlphabetTriangle(n);

        System.out.println("\n8. Reverse Alphabet Start Pattern:");
        printReverseAlphabetStartTriangle(n);
    }

    /**
     * Prints an inverted triangle of asterisks ('*').
     */
    public static void printAsteriskInvertedTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Prints numbers from 1 to i (decreasing number of columns each row).
     */
    public static void printDecrementalNumberTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Prints the same number (the row number) across each row in decreasing order.
     */
    public static void printRowNumberTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Prints a binary pattern where each element depends on (i + j) parity:
     * <pre>
     * if ((i + j) % 2 == 0) → 1
     * else                   → 0
     * </pre>
     */
    public static void printBinaryTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(((i + j) % 2 == 0) ? 1 : 0);
            }
            System.out.println();
        }
    }

    /**
     * Prints a triangle with continuous numbers decreasing across all rows.
     */
    public static void printContinuousNumberTriangle(int n) {
        int num = (n * (n + 1)) / 2;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num-- + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prints decreasing-length alphabet sequences from 'A'.
     */
    public static void printDecrementalAlphabetTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }

    /**
     * Prints the same letter repeated in decreasing-length rows (starting from 'A' + n - 1).
     */
    public static void printRepeatedAlphabetTriangle(int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }

    /**
     * Prints decreasing-length sequences starting from an increasing letter each row.
     */
    public static void printReverseAlphabetStartTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }
}
