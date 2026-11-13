import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1 - Two Sum (Easy)
 * Day 1 - Arrays & Hashing
 *
 * Problem: Given nums and target, return indices of the two numbers
 * that add up to target. Exactly one solution exists.
 *
 * Approach: HashMap (value -> index). For each num, check if
 * target - num was seen before. If yes, return both indices.
 *
 * Time: O(n) | Space: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }

        // Problem guarantees one solution, so this is unreachable.
        return new int[]{};
    }
}
