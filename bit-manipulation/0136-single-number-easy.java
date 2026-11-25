/**
 * LeetCode 136 - Single Number (Easy)
 * Day 13 - Bit Manipulation
 *
 * Problem: Given a non-empty array of integers, every element appears
 * twice except for one. Find that single one. Linear time and only
 * constant extra space.
 * Example: nums = [2, 2, 1] -> 1; nums = [4, 1, 2, 1, 2] -> 4
 *
 * Approach: XOR cancels pairs. x ^ x = 0, x ^ 0 = x, and XOR is
 * commutative and associative, so XOR-ing the whole array collapses
 * every pair to 0 and leaves only the element that appears once.
 * One pass, one running variable.
 *
 * Time: O(n) — one pass over the array
 * Space: O(1) — a single int
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // Each pair cancels itself: x ^ x = 0, so only the lone
        // element survives in the running XOR.
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
