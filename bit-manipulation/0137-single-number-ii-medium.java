/**
 * LeetCode 137 - Single Number II (Medium)
 * Day 13 - Bit Manipulation
 *
 * Problem: Every element in the array appears three times except for
 * one, which appears exactly once. Find that single element. Linear
 * time and only constant extra space.
 * Example: nums = [2, 2, 3, 2] -> 3; nums = [0, 1, 0, 1, 0, 1, 99] -> 99
 *
 * Approach: Plain XOR only cancels pairs, not triples (x ^ x ^ x = x),
 * so count each bit modulo 3 instead. A count mod 3 has three states
 * (0, 1, 2), which fits in two bits — keep two masks:
 *   ones — bits seen once so far (mod 3)
 *   twos — bits seen twice so far (mod 3)
 * For each x:
 *   ones = (ones ^ x) & ~twos — toggle x's bits into ones, unless the
 *          bit was already counted twice
 *   twos = (twos ^ x) & ~ones — toggle into twos, using the NEW ones,
 *          so a bit seen a third time is cleared from both masks
 * At the end, ones holds exactly the bits seen once mod 3: the answer.
 * Works for negatives too, since Java ints are two's complement and
 * the masks operate on all 32 bits.
 *
 * Time: O(n) — constant work per element
 * Space: O(1) — two ints
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int x : nums) {
            // Toggle x's bits into ones, but not bits already counted twice.
            ones = (ones ^ x) & ~twos;
            // Toggle x's bits into twos, using the new ones so a bit seen
            // a third time drops out of both masks (count resets to 0).
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }
}
