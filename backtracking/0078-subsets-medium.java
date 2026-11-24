/**
 * LeetCode 78 - Subsets (Medium)
 * Day 12 - Backtracking
 *
 * Problem: Given an integer array nums of unique elements, return all
 * possible subsets (the power set). The solution set must not contain
 * duplicate subsets, and can be returned in any order.
 * Example: nums = [1,2,3] ->
 *          [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Approach: Backtracking — choose, recurse, undo. At every node of
 * the recursion tree the current path IS a valid subset, so record a
 * copy of it on entry. Then, from index `start` onwards, try adding
 * each remaining element in turn and recurse with start = i + 1.
 * Only ever picking elements to the right of the last one chosen
 * keeps subsets in increasing index order, so [1,2] is built once
 * and [2,1] is never built — no duplicates.
 *
 * Time: O(n * 2^n) — there are 2^n subsets and copying each one
 *       costs up to O(n)
 *       | Space: O(n) — recursion depth and the current path; the
 *       output itself is O(n * 2^n)
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current,
                           List<List<Integer>> result) {
        // Every node is a subset — record a copy of the path so far.
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);              // choose
            backtrack(i + 1, nums, current, result);  // explore
            current.remove(current.size() - 1);       // undo
        }
    }
}
