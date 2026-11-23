/**
 * LeetCode 215 - Kth Largest Element in an Array (Medium)
 * Day 11 - Heap / Priority Queue
 *
 * Problem: Given an integer array nums and an integer k, return the
 * kth largest element in the array. Note that it is the kth largest
 * in sorted order, not the kth distinct element — duplicates each
 * take their own rank.
 * Example: nums = [3,2,1,5,6,4], k = 2 -> 5
 *          nums = [3,2,3,1,2,4,5,5,6], k = 4 -> 4
 *
 * Approach: Keep a min-heap of size k holding the k largest values
 * seen so far. The root of the heap is the smallest of those k, i.e.
 * the current kth largest. For every new number, push it in; if the
 * heap grows past k, pop the smallest — it can never be the answer.
 * When the whole array is scanned, the root is the kth largest.
 * This beats sorting the whole array when k is much smaller than n.
 *
 * Time: O(n log k) — n pushes, each O(log k) on a heap of size k
 *       | Space: O(k) — the heap holds at most k elements
 */
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of the k largest values seen so far.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                // Evict the smallest of the k+1 — it cannot be
                // among the k largest.
                minHeap.poll();
            }
        }
        // The root is the smallest of the k largest = kth largest.
        return minHeap.peek();
    }
}
