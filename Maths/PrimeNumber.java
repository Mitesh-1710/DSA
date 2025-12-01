/**
 * Problem:
 * Determine whether a given integer {@code n} is a prime number.
 *
 * <p>A prime number is a number greater than 1 that has no divisors other than
 * 1 and itself. Examples:</p>
 * <ul>
 *   <li>2 → Prime</li>
 *   <li>3 → Prime</li>
 *   <li>4 → Not Prime (divisible by 2)</li>
 *   <li>41 → Prime</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Optimized Prime Check:</b>
 *
 * <p>The naive approach checks divisibility from 1 to n, which is inefficient.
 * Instead, we use several mathematical observations:</p>
 *
 * <ul>
 *
 *   <li><b>1. Only check up to √n</b>
 *     <ul>
 *       <li>If a number has a factor larger than √n, the complementary factor is smaller than √n.</li>
 *       <li>So checking divisibility only up to √n is sufficient.</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>2. Handle small cases upfront</b>
 *     <ul>
 *       <li>n ≤ 1 → Not prime</li>
 *       <li>2 and 3 → Prime</li>
 *       <li>Even numbers → Not prime</li>
 *       <li>Multiples of 3 → Not prime</li>
 *     </ul>
 *   </li>
 *
 *   <li><b>3. Skip even numbers using 6k ± 1 optimization</b>
 *     <ul>
 *       <li>All primes > 3 are of the form: <code>6k - 1</code> or <code>6k + 1</code></li>
 *       <li>Reason: any number can be expressed as 6k + x (where x=0..5)</li>
 *       <li>Forms that are definitely not prime:
 *         <ul>
 *           <li>6k → divisible by 6</li>
 *           <li>6k + 2 → divisible by 2</li>
 *           <li>6k + 3 → divisible by 3</li>
 *           <li>6k + 4 → divisible by 2</li>
 *         </ul>
 *       </li>
 *       <li>So we only test divisors: <code>i</code> and <code>i + 2</code></li>
 *     </ul>
 *   </li>
 *
 *   <li><b>4. Efficiency of this approach</b>
 *     <ul>
 *       <li>Reduces loop checks by ~66% compared to simple √n method.</li>
 *       <li>Ideal for checking primality in competitive programming & optimizations.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Using the Same Logic for Prime Ranges:</b>
 *
 * <p>This optimized checking method can be extended to find:</p>
 * <ul>
 *   <li>All prime numbers up to a given limit N</li>
 *   <li>Prime counts in a range</li>
 *   <li>Filtering prime numbers inside arrays</li>
 * </ul>
 *
 * <p>Such implementations loop through values and apply this same <b>O(√n)</b>
 * primality test to each number.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Example Checks:</b>
 * <pre>
 * 41 → true
 * 27 → false (divisible by 3)
 * 97 → true
 * 100 → false (divisible by 2)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b> O(√n)  
 * <b>Space Complexity:</b> O(1)
 * -----------------------------------------------------------------------
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int n = 100;

        System.out.println("1. Checking if the number is Prime:");
        System.out.println("Is " + n + " prime? → " + isPrimeNumber(n));

        System.out.println("\n2. Prime Numbers up to 100 (Demonstration of the same 6k ± 1 logic):");
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }


    /**
     * Checks whether the given integer {@code n} is a prime number.
     *
     * <p>Uses optimized checks:</p>
     * <ul>
     *   <li>Reject small and composite numbers early</li>
     *   <li>Skip even numbers and multiples of 3</li>
     *   <li>Check only numbers of the form 6k ± 1</li>
     * </ul>
     *
     * @param n the number to check
     * @return {@code true} if prime, else {@code false}
     */
    public static boolean isPrimeNumber(int n) {

        // 1. Handle small values
        if (n <= 1) return false;
        if (n <= 3) return true;

        // 2. Remove obvious composites (even or divisible by 3)
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 3. Check potential factors in form 6k - 1 or 6k + 1
        for (int i = 5; i * i <= n; i += 6) {

            // Check i and i+2 for possible divisors
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
