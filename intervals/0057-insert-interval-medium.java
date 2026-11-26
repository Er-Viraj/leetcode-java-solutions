/**
 * LeetCode 57 - Insert Interval (Medium)
 * Day 14 - Intervals
 *
 * Problem: Given a sorted array of non-overlapping intervals and one
 * new interval, insert the new interval so the list stays sorted and
 * non-overlapping, merging wherever it overlaps.
 * Example: intervals = [[1, 3], [6, 9]], newInterval = [2, 5]
 *          -> [[1, 5], [6, 9]]
 *
 * Approach: The input is already sorted and disjoint, so the intervals
 * split into three runs relative to the new one, handled in one pass
 * with a single index:
 *   1. Before — intervals ending before the new one starts: copy over
 *      unchanged (end < newInterval[0]).
 *   2. Overlap — intervals starting at or before the new one ends:
 *      absorb each into the new interval (min start, max end).
 *   3. After — everything left starts after the new one ends: copy
 *      over unchanged.
 * No re-sorting is needed because the input order is already correct.
 * (The naive alternative — append then run Merge Intervals — is
 * O(n log n); this is O(n).)
 *
 * Time: O(n) — a single pass over the intervals
 * Space: O(n) — the output list
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: intervals entirely before the new one — copy as-is.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: intervals overlapping the new one — absorb them.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Phase 3: intervals entirely after the new one — copy as-is.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
