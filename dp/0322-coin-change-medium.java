/**
 * LeetCode 322 - Coin Change (Medium)
 * Day 8 - Dynamic Programming
 *
 * Problem: You are given coins of different denominations and a total
 * amount. Return the fewest number of coins needed to make up that
 * amount. You have an infinite number of each kind of coin. If the
 * amount cannot be made up by any combination, return -1.
 * Example: coins = [1, 2, 5], amount = 11 -> 3 (5 + 5 + 1)
 *          coins = [2], amount = 3 -> -1
 *          coins = [1], amount = 0 -> 0
 *
 * Approach: Bottom-up DP. dp[a] = fewest coins to make amount a.
 * dp[0] = 0 (paying nothing takes no coins). Any way to make amount a
 * ends with some last coin c, so the rest is making a - c — a smaller
 * version of the same question. Try every coin as the last one:
 * dp[a] = 1 + min(dp[a - c]) over all coins c that fit. Fill the table
 * from 0 up to amount, so every smaller amount is already final when
 * it is needed. Greedy (biggest coin first) is wrong here — with
 * coins [1, 3, 4] and amount 6, greedy takes 4 + 1 + 1 (3 coins) but
 * 3 + 3 uses only 2. We use amount + 1 as the "impossible" marker
 * (it is larger than any real answer) and return -1 if dp[amount]
 * still holds it.
 *
 * Time: O(amount * coins) | Space: O(amount) — one table row
 */
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[a] = fewest coins for amount a; amount + 1 means impossible.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
