/**
 * LeetCode 70 - Climbing Stairs (Easy)
 * Day 8 - Dynamic Programming
 *
 * Problem: You are climbing a staircase with n steps. Each time you can
 * climb either 1 or 2 steps. In how many distinct ways can you reach
 * the top?
 * Example: n = 2 -> 2 (1+1, 2)
 *          n = 3 -> 3 (1+1+1, 1+2, 2+1)
 *          n = 5 -> 8
 *
 * Approach: 1-D dynamic programming. Let ways(i) be the number of ways
 * to reach step i. The last move to step i is either a 1-step (from
 * i-1) or a 2-step (from i-2), and those two groups don't overlap, so
 * ways(i) = ways(i-1) + ways(i-2) — the Fibonacci recurrence. We only
 * need the previous two values, so two rolling variables replace the
 * whole table. Base cases: ways(0) = 1 (one way to stand still) and
 * ways(1) = 1.
 *
 * Time: O(n) | Space: O(1) — two variables, no table
 */
class Solution {
    public int climbStairs(int n) {
        // a = ways(i), b = ways(i + 1) as we walk up the stairs.
        int a = 1; // ways(0)
        int b = 1; // ways(1)

        // After i steps, a holds ways(i). After n steps, a is ways(n).
        for (int i = 0; i < n; i++) {
            int next = a + b; // ways(i + 2) = ways(i + 1) + ways(i)
            a = b;
            b = next;
        }

        return a;
    }
}
