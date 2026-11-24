/**
 * LeetCode 46 - Permutations (Medium)
 * Day 12 - Backtracking
 *
 * Problem: Given an array nums of distinct integers, return all the
 * possible permutations. You can return the answer in any order.
 * Example: nums = [1,2,3] ->
 *          [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Approach: Backtracking — choose, recurse, undo. Build the
 * permutation slot by slot: at each step, any element not yet used
 * is a valid next choice, so track used elements with a boolean
 * array. When the path has n elements it is a complete permutation,
 * so record a copy. Then pop the last element and clear its used
 * flag so the next sibling choice starts from the same state.
 * Unlike Subsets, order matters here, so there is no `start` index
 * — the loop always restarts from 0 and skips only used elements.
 *
 * Time: O(n * n!) — there are n! permutations and copying each one
 *       costs O(n)
 *       | Space: O(n) — recursion depth, the path and the used array;
 *       the output itself is O(n * n!)
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current,
                           List<List<Integer>> result) {
        // A full path is one complete permutation — record a copy.
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // this element is already in the path
            }
            used[i] = true;               // choose
            current.add(nums[i]);
            backtrack(nums, used, current, result);  // explore
            current.remove(current.size() - 1);      // undo
            used[i] = false;
        }
    }
}
