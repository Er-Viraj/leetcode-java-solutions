/**
 * LeetCode 167 - Two Sum II - Input Array Is Sorted (Medium)
 * Day 2 - Two Pointers
 *
 * Problem: Given a 1-indexed array `numbers` sorted in non-decreasing
 * order and a target, find two numbers that add up to target. Return
 * their indices as [index1, index2] (1-indexed). Exactly one solution
 * exists, and only O(1) extra space may be used.
 * Example: numbers = [2,7,11,15], target = 9 -> [1,2]
 *
 * Approach: Two pointers at both ends. Because the array is sorted,
 * if the sum is too small we must move the left pointer right (to get
 * a bigger sum); if too large, move the right pointer left (to get a
 * smaller sum). Each step discards one index that cannot be part of
 * the answer, so the unique pair is never missed.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // 1-indexed answer
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;   // need a bigger sum
            } else {
                right--;  // need a smaller sum
            }
        }

        // Problem guarantees one solution, so this is unreachable.
        return new int[]{-1, -1};
    }
}
