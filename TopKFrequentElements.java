import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode 347 - Top K Frequent Elements (Medium)
 * Day 1 - Arrays & Hashing
 *
 * Problem: Given nums and k, return the k most frequent elements.
 *
 * Approach: 1) Count frequencies with a HashMap.
 * 2) Keep a min-heap of size k ordered by frequency.
 *    The smallest frequency stays on top and gets removed
 *    when the heap grows past k, leaving only the top k.
 *
 * Time: O(n log k) | Space: O(n)
 * Note: A bucket-sort version runs in O(n), heap version is
 * the cleanest to write in an interview.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]); // [value, frequency]

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
