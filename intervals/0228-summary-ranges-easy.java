/**
 * LeetCode 228 - Summary Ranges (Easy)
 * Day 14 - Intervals
 *
 * Problem: Given a sorted array of unique integers, return the smallest
 * sorted list of ranges that covers every number exactly. A range
 * [a, b] is written as "a->b" when a != b, and as "a" when a == b.
 * Example: nums = [0, 1, 2, 4, 5, 7] -> ["0->2", "4->5", "7"]
 *
 * Approach: One linear scan. The array is already sorted, so a range
 * is just a run of numbers that increase by exactly 1. Start a run at
 * nums[i], extend it while the next number is one more than the
 * current one, then write the run out ("a" for a lone number,
 * "a->b" otherwise) and start the next run where this one ended.
 * (nums[i] + 1 cannot overflow here: if nums[i] were Integer.MAX_VALUE
 * it would have to be the last element, and the loop only looks ahead
 * when a next element exists.)
 *
 * Time: O(n) — each element is visited once
 * Space: O(1) extra — besides the output list
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // nums[i] starts a new run; extend it while the numbers
            // stay consecutive.
            int start = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            // nums[i] is now the last number of this run.
            if (start == nums[i]) {
                ranges.add(String.valueOf(start));
            } else {
                ranges.add(start + "->" + nums[i]);
            }
        }
        return ranges;
    }
}
