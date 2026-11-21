/**
 * LeetCode 55 - Jump Game (Medium)
 * Day 9 - Greedy
 *
 * Problem: You are given an integer array nums, starting at index 0.
 * Each element nums[i] is the maximum jump length from position i.
 * Return true if you can reach the last index, false otherwise.
 * Example: nums = [2,3,1,1,4] -> true (jump 0 -> 1 -> 4)
 *          nums = [3,2,1,0,4] -> false (every path lands on index 3,
 *          whose value is 0)
 *
 * Approach: Greedy — track only the farthest index reachable so far.
 * Reachable indices always form one solid block 0..reach, because
 * from any reachable index you can land on every index before its
 * max jump. Walk left to right: if i is beyond reach, it can never
 * be stood on, so return false; otherwise extend reach with
 * i + nums[i]. If the scan finishes, the last index was reachable.
 * (A DP table of "can I reach i?" works too, but it is O(n^2) and
 * the table collapses into this single running maximum.)
 *
 * Time: O(n) — one pass | Space: O(1) — a single integer
 */
class Solution {
    public boolean canJump(int[] nums) {
        // Farthest index reachable so far.
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                // This index is beyond everything we can reach — stuck.
                return false;
            }
            // From i we can get as far as i + nums[i].
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }
}
