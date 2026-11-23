/**
 * LeetCode 1046 - Last Stone Weight (Easy)
 * Day 11 - Heap / Priority Queue
 *
 * Problem: You are given an array of stone weights. On each turn,
 * pick the two heaviest stones and smash them together: if they are
 * equal, both are destroyed; otherwise the heavier one survives with
 * weight reduced by the lighter one. Repeat until at most one stone
 * remains, and return its weight (0 if none remain).
 * Example: stones = [2,7,4,1,8,1] -> 1
 *
 * Approach: A max-heap always hands us the two heaviest stones in
 * O(log n). Smash them: if the weights differ, push the difference
 * back — it is the surviving stone and may be smashed again later.
 * If they are equal, both are gone and nothing is pushed back.
 * The loop ends when the heap holds one stone or is empty.
 *
 * Time: O(n log n) — each stone is pushed/popped a constant number
 *       of times, each heap operation costs O(log n)
 *       | Space: O(n) — the heap holds at most all the stones
 */
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap: Java's PriorityQueue is a min-heap by default,
        // so reverse the ordering.
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int second = maxHeap.poll();
            // Equal stones destroy each other; otherwise the
            // survivor goes back with the reduced weight.
            if (heaviest != second) {
                maxHeap.offer(heaviest - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
