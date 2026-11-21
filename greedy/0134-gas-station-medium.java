/**
 * LeetCode 134 - Gas Station (Medium)
 * Day 9 - Greedy
 *
 * Problem: There are n gas stations on a circular route. Station i
 * gives gas[i] fuel, and driving from station i to i+1 costs cost[i].
 * You start with an empty tank at one of the stations. Return the
 * starting station's index if you can travel around the circuit once,
 * otherwise -1. If a solution exists, it is guaranteed unique.
 * Example: gas = [1,2,3,4,5], cost = [3,4,5,1,2] -> 3
 *          gas = [2,3,4], cost = [3,4,3] -> -1
 *
 * Approach: Greedy — two facts do all the work. (1) If total gas is
 * less than total cost, no start can work, because over one lap you
 * burn more than you collect. If the total is non-negative, a valid
 * start always exists. (2) A failed stretch rules itself out in one
 * go: if you start at `start` and the tank first goes negative after
 * station i, no station between start and i can work either — you
 * reached each of them from `start` with a non-negative tank, so
 * starting there with an empty tank is never better. So skip straight
 * to i+1 as the new candidate and reset the tank. One pass finds it.
 *
 * Time: O(n) — one pass | Space: O(1) — three integers
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // total = balance over the whole lap; tank = balance since
        // the current candidate start.
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                // Every start from `start` to i fails here — skip them.
                start = i + 1;
                tank = 0;
            }
        }

        // total < 0 means not enough fuel for a lap from anywhere.
        return total < 0 ? -1 : start;
    }
}
