/**
 * LeetCode 56 - Merge Intervals (Medium)
 * Day 14 - Intervals
 *
 * Problem: Given an array of intervals [start, end], merge all
 * overlapping intervals and return the non-overlapping intervals that
 * cover the input. Intervals that touch count as overlapping.
 * Example: [[1, 3], [2, 6], [8, 10], [15, 18]] -> [[1, 6], [8, 10], [15, 18]]
 *
 * Approach: Sort by start time first. Once sorted, an interval can
 * only ever overlap the last interval already merged — never an
 * earlier one — so a single sweep is enough. For each interval: if
 * its start is <= the end of the last merged interval, they overlap,
 * so stretch the last interval's end to the max of the two ends
 * (max, not the new end — the new interval may be fully swallowed,
 * e.g. [1, 10] and [2, 3]); otherwise start a fresh merged interval.
 * Note the comparator uses Integer.compare, not a[0] - b[0], which
 * would overflow on values spanning the int range.
 *
 * Time: O(n log n) — sorting dominates; the sweep is O(n)
 * Space: O(n) — the output list (O(log n) for the sort itself)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // Last merged interval, or null while the list is empty.
            int[] last = merged.isEmpty() ? null : merged.get(merged.size() - 1);
            if (last != null && interval[0] <= last[1]) {
                // Overlap (or touching): stretch the merged interval.
                // max() matters — interval may sit entirely inside last.
                last[1] = Math.max(last[1], interval[1]);
            } else {
                // Gap: this interval starts a new merged block.
                merged.add(new int[] { interval[0], interval[1] });
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
