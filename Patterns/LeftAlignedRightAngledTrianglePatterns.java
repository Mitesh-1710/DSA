/**
 * Problem:
 * Given an integer {@code n}, print different left-aligned right-angled triangle patterns.
 *
 * <p>The program demonstrates multiple variations:</p>
 * <ul>
 *   <li><b>1.</b> Asterisk Pattern — Prints '*' characters.</li>
 *   <li><b>2.</b> Incremental Number Pattern — Prints numbers from 1 up to {@code i} in each row.</li>
 *   <li><b>3.</b> Row Number Pattern — Prints the same number (the row number) in each row.</li>
 *   <li><b>4.</b> Binary Pattern — Prints 1 or 0 depending on whether {@code (i + j)} is even or odd.</li>
 *   <li><b>5.</b> Continuous Number Pattern — Prints continuous numbers across all rows.</li>
 *   <li><b>6.</b> Incremental Alphabet Pattern — Prints letters incrementally from 'A'.</li>
 *   <li><b>7.</b> Repeated Alphabet Pattern — Prints the same letter repeated per row.</li>
 *   <li><b>8.</b> Reverse Alphabet Start Pattern — Starts each row with a decreasing letter from 'E' down to 'A'.</li>
 * </ul>
 *
 * <p><b>Common Thought Process:</b></p>
 * <ul>
 *   <li>The pattern forms a <b>left-aligned right-angled triangle</b> with {@code n} rows.</li>
 *   <li>The <b>outer loop</b> (variable {@code i}) controls the number of rows — runs from 1 to {@code n}.</li>
 *   <li>The <b>inner loop</b> (variable {@code j}) controls what gets printed in each row — runs from 1 to {@code i}.</li>
 *   <li>The <b>print logic</b> inside the inner loop changes depending on the desired pattern (asterisk, number, or letter).</li>
 *   <li>After each row is printed, a newline is added to move to the next row.</li>
 * </ul>
 *
 * <p><b>Example Output for {@code n = 5}:</b></p>
 *
 * <pre>
 * 1. Asterisk Pattern:
 * *
 * **
 * ***
 * ****
 * *****
 *
 * 2. Incremental Number Pattern:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 *
 * 3. Row Number Pattern:
 * 1
 * 22
 * 333
 * 4444
 * 55555
 *
 * 4. Binary Pattern:
 * 1
 * 01
 * 101
 * 0101
 * 10101
 *
 * 5. Continuous Number Pattern:
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 *
 * 6. Incremental Alphabet Pattern:
 * A
 * AB
 * ABC
 * ABCD
 * ABCDE
 *
 * 7. Repeated Alphabet Pattern:
 * A
 * BB
 * CCC
 * DDDD
 * EEEEE
 *
 * 8. Reverse Alphabet Start Pattern:
 * E
 * DE
 * CDE
 * BCDE
 * ABCDE
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n²) — total prints ≈ n(n + 1)/2.<br>
 * <b>Space Complexity:</b> O(1) — constant extra space.</p>
 */
public class LeftAlignedRightAngledTrianglePatterns {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("1. Asterisk Pattern:");
        printAsteriskTriangle(n);

        System.out.println("\n2. Incremental Number Pattern:");
        printIncrementalNumberTriangle(n);

        System.out.println("\n3. Row Number Pattern:");
        printRowNumberTriangle(n);

        System.out.println("\n4. Binary Pattern:");
        printBinaryTriangle(n);

        System.out.println("\n5. Continuous Number Pattern:");
        printContinuousNumberTriangle(n);

        System.out.println("\n6. Incremental Alphabet Pattern:");
        printIncrementalAlphabetTriangle(n);

        System.out.println("\n7. Repeated Alphabet Pattern:");
        printRepeatedAlphabetTriangle(n);

        System.out.println("\n8. Reverse Alphabet Start Pattern:");
        printReverseAlphabetStartTriangle(n);
    }

    /** Prints a left-aligned triangle of asterisks ('*'). */
    public static void printAsteriskTriangle(int n) {
        validateInput(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /** Prints numbers from 1 to i in each row. */
    public static void printIncrementalNumberTriangle(int n) {
        validateInput(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /** Prints the current row number repeatedly in each row. */
    public static void printRowNumberTriangle(int n) {
        validateInput(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Prints a binary triangle pattern where each element is determined by:
     * <pre>
     * if ((i + j) % 2 == 0) → 1
     * else                   → 0
     * </pre>
     */
    public static void printBinaryTriangle(int n) {
        validateInput(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(((i + j) % 2 == 0) ? 1 : 0);
            }
            System.out.println();
        }
    }

    /** Prints a triangle with continuous numbers increasing across rows. */
    public static void printContinuousNumberTriangle(int n) {
        validateInput(n);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    /** Prints a triangle where each row contains increasing letters from 'A'. */
    public static void printIncrementalAlphabetTriangle(int n) {
        validateInput(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + (j)));
            }
            System.out.println();
        }
    }

    /** Prints a triangle where each row contains the same letter repeated. */
    public static void printRepeatedAlphabetTriangle(int n) {
        validateInput(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }

    /**
     * Prints a triangle where the starting letter of each row decreases from 'A' + j down to 'A'.
     */
    public static void printReverseAlphabetStartTriangle(int n) {
        validateInput(n);
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j <= n-1; j++ ) {
                System.out.print( (char) ('A' + j));
            }
            System.out.println();
        }
    }

    /** Validates that {@code n} is a positive integer. */
    private static void validateInput(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size 'n' must be a positive integer.");
        }
    }
}
