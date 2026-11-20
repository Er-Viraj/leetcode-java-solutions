/**
 * LeetCode 198 - House Robber (Medium)
 * Day 8 - Dynamic Programming
 *
 * Problem: You are a professional robber planning to rob houses along a
 * street. Each house has a certain amount of money stashed. You cannot
 * rob two adjacent houses, or the security system will alert the police.
 * Given nums (money in each house), return the maximum amount you can
 * rob tonight without alerting the police.
 * Example: nums = [1, 2, 3, 1] -> 4 (rob houses 1 and 3)
 *          nums = [2, 7, 9, 3, 1] -> 12 (rob houses 1, 3 and 5)
 *
 * Approach: 1-D DP, take-or-skip at each house. Let dp[i] be the best
 * total using houses 0..i. At house i there are two choices: skip it
 * (best stays dp[i-1]) or rob it (then house i-1 must be untouched,
 * so best is dp[i-2] + nums[i]). Take the larger:
 * dp[i] = max(dp[i-1], dp[i-2] + nums[i]). The recurrence only reaches
 * two entries back, so two rolling variables are enough — prev holds
 * dp[i-2] and cur holds dp[i-1]. Greedy (grab the biggest houses)
 * fails here: one big house can block two medium ones.
 *
 * Time: O(n) | Space: O(1) — two variables, no table
 */
class Solution {
    public int rob(int[] nums) {
        int prev = 0; // best total two houses back (dp[i - 2])
        int cur = 0;  // best total one house back (dp[i - 1])

        for (int money : nums) {
            // New best: skip this house (cur) or rob it (prev + money).
            int next = Math.max(cur, prev + money);
            prev = cur;
            cur = next;
        }

        return cur;
    }
}
