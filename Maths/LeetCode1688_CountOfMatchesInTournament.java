/**
 * Problem:
 * You are given an integer {@code n}, representing the number of teams
 * in a tournament with the following rules:
 *
 * <ul>
 *   <li>If n is even:
 *       n / 2 matches are played and n / 2 teams advance.</li>
 *   <li>If n is odd:
 *       (n - 1) / 2 matches are played,
 *       one team advances automatically,
 *       and ((n - 1) / 2 + 1) teams advance.</li>
 * </ul>
 *
 * <p>Return the total number of matches played until a winner is decided.</p>
 *
 * <p>This is the solution to <b>LeetCode Problem 1688:
 * Count of Matches in Tournament</b></p>
 * <p>🔗 https://leetcode.com/problems/count-of-matches-in-tournament/</p>
 *
 * -----------------------------------------------------------------------
 * <b>Thought Process Behind the Solution:</b>
 *
 * <p>At first glance, the problem looks like a simulation problem.</p>
 *
 * <p>Naive Simulation Approach:</p>
 * <ul>
 *   <li>While n > 1:</li>
 *   <ul>
 *     <li>If n is even → add n/2 matches, set n = n/2.</li>
 *     <li>If n is odd → add (n-1)/2 matches,
 *         set n = (n-1)/2 + 1.</li>
 *   </ul>
 * </ul>
 *
 * <p>This correctly simulates the tournament round by round.</p>
 *
 * <p>However — this is where most candidates overthink.</p>
 *
 * -----------------------------------------------------------------------
 * <b>Critical Insight (Keynote Observation):</b>
 *
 * <p>Every match eliminates exactly <b>one team</b>.</p>
 *
 * <ul>
 *   <li>Start with n teams.</li>
 *   <li>End with 1 winner.</li>
 * </ul>
 *
 * <p>That means we must eliminate:</p>
 *
 * <pre>
 * n - 1 teams
 * </pre>
 *
 * <p>Since each match eliminates exactly one team:</p>
 *
 * <pre>
 * Total matches = n - 1
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why The Examples Trick Us:</b>
 *
 * The examples describe detailed rounds:
 *
 * n = 7:
 * 3 + 2 + 1 = 6
 *
 * n = 14:
 * 7 + 3 + 2 + 1 = 13
 *
 * <p>These detailed breakdowns make us think
 * we need to simulate each round.</p>
 *
 * <p>But if you observe carefully:</p>
 *
 * <pre>
 * 7  → 6  matches
 * 14 → 13 matches
 * </pre>
 *
 * <p>It always equals n - 1.</p>
 *
 * <p>Most of the time in competitive programming and interviews,
 * problems are intentionally written with detailed scenarios
 * to distract from a simple invariant.</p>
 *
 * <b>The keynote here is identifying the invariant:</b>
 *
 * <pre>
 * Each match removes exactly one team.
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Invariant Concept (Detailed Explanation):</b>
 *
 * <p>An invariant is a property that remains true throughout the process.</p>
 *
 * <p>In this problem:</p>
 *
 * <ul>
 *   <li>No matter how pairing happens,</li>
 *   <li>No matter whether n is even or odd,</li>
 *   <li>Each match eliminates exactly one team.</li>
 * </ul>
 *
 * <p>Thus:</p>
 *
 * <pre>
 * Matches played = Total eliminations
 *                 = n - 1
 * </pre>
 *
 * This holds universally.
 *
 * -----------------------------------------------------------------------
 * <b>Example:</b>
 *
 * <pre>
 * n = 7
 *
 * To reach 1 winner:
 * Must eliminate 6 teams.
 *
 * Therefore:
 * Matches = 6
 * </pre>
 *
 * Another example:
 *
 * <pre>
 * n = 1
 * Already winner.
 * Matches = 0
 * (1 - 1 = 0)
 * </pre>
 *
 * -----------------------------------------------------------------------
 * <b>Why This Approach Works Well:</b>
 *
 * <ul>
 *   <li>No simulation required.</li>
 *   <li>Constant-time solution.</li>
 *   <li>Relies on identifying invariant rather than process details.</li>
 * </ul>
 *
 * -----------------------------------------------------------------------
 * <b>Time Complexity:</b>
 * O(1)<br>
 *
 * <b>Space Complexity:</b>
 * O(1)
 * -----------------------------------------------------------------------
 */
public class LeetCode1688_CountOfMatchesInTournament {

    public static void main(String[] args) {

        int n = 7;

        int result = numberOfMatches(n);

        System.out.println("Total matches: " + result);
    }

    /**
     * Returns the total number of matches played.
     *
     * Key Insight:
     * Each match eliminates exactly one team.
     * To go from n teams to 1 winner,
     * we must eliminate (n - 1) teams.
     *
     * Therefore:
     * Total matches = n - 1
     */
    public static int numberOfMatches(int n) {
        return n - 1;
    }
}