/**
 * Problem:
 * Determine whether a given integer {@code num} is a prime number using recursion.
 *
 * <p>A prime number is defined as a number greater than 1 that has exactly two
 * distinct positive divisors:</p>
 * <ul>
 *   <li>1</li>
 *   <li>Itself</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Recursive Prime Check:</b>
 *
 * <p>The key idea is to test whether {@code num} is divisible by any integer
 * other than 1 and itself.</p>
 *
 * <p><b>Optimizations Applied:</b></p>
 * <ul>
 *   <li>There is no need to check divisors beyond <code>√num</code>.</li>
 *   <li>If a number has a factor greater than √num, it must also have
 *       a factor smaller than √num.</li>
 * </ul>
 *
 * <p><b>Recursive Strategy:</b></p>
 * <ul>
 *   <li>Start checking divisibility from {@code divisor = 2}.</li>
 *   <li>If {@code divisor * divisor > num}, no divisor exists → prime.</li>
 *   <li>If {@code num % divisor == 0}, the number is composite.</li>
 *   <li>Otherwise, recurse with {@code divisor + 1}.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Base Cases:</b>
 * <ul>
 *   <li>{@code num == 1} → not prime</li>
 *   <li>{@code num == 2 or 3} → prime</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Example Walkthrough:</b>
 *
 * <pre>
 * num = 29
 *
 * isPrime(29, 2) → 29 % 2 ≠ 0
 * isPrime(29, 3) → 29 % 3 ≠ 0
 * isPrime(29, 4) → 4 * 4 > 29 → true
 *
 * Result: Prime
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(√n) — checks divisors up to square root.<br>
 * <b>Space Complexity:</b> O(√n) — recursion call stack depth.
 * -----------------------------------------------------------------------
 */
public class IsPrime {

    public static void main(String[] args) {
        System.out.println("Is 1 prime?  " + checkPrime(1));
        System.out.println("Is 2 prime?  " + checkPrime(2));
        System.out.println("Is 17 prime? " + checkPrime(17));
        System.out.println("Is 25 prime? " + checkPrime(25));
        System.out.println("Is 29 prime? " + checkPrime(29));
    }

    /**
     * Entry method to check if a number is prime using recursion.
     *
     * @param num the number to be checked
     * @return {@code true} if prime, {@code false} otherwise
     */
    public static boolean checkPrime(int num) {

        // Base cases
        if (num == 1) return false;
        if (num == 2 || num == 3) return true;

        // Start recursive divisor check from 2
        return isPrime(num, 2);
    }

    /**
     * Recursively checks whether {@code num} has any divisors starting from {@code divisor}.
     *
     * @param num     the number being tested
     * @param divisor current divisor to test
     * @return {@code true} if no divisors found (prime), {@code false} otherwise
     */
    private static boolean isPrime(int num, int divisor) {

        // 1. If divisor^2 > num, no factors remain
        if (divisor * divisor > num) return true;

        // 2. If divisible, not prime
        if (num % divisor == 0) return false;

        // 3. Recur with next divisor
        return isPrime(num, divisor + 1);
    }
}