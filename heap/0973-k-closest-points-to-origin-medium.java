/**
 * LeetCode 973 - K Closest Points to Origin (Medium)
 * Day 11 - Heap / Priority Queue
 *
 * Problem: Given an array of points where points[i] = [xi, yi] and
 * an integer k, return the k points closest to the origin (0, 0) by
 * Euclidean distance. You may return the answer in any order; the
 * answer is guaranteed to be unique apart from the order.
 * Example: points = [[1,3],[-2,2]], k = 1 -> [[-2,2]]
 *          points = [[3,3],[5,-1],[-2,4]], k = 2 -> [[3,3],[-2,4]]
 *
 * Approach: Keep a max-heap of size k, ordered by distance from the
 * origin, holding the k closest points seen so far. The root is the
 * farthest of those k. For every new point, push it in; if the heap
 * grows past k, pop the farthest — it cannot be among the k closest.
 * Compare squared distances only: skipping the square root keeps
 * the ordering identical and avoids floating-point work.
 *
 * Time: O(n log k) — n pushes, each O(log k) on a heap of size k
 *       | Space: O(k) — the heap holds at most k points
 */
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap by squared distance: the farthest of the k
        // closest sits at the root, ready to be evicted.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(dist(b), dist(a)));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Squared distance from the origin — same ordering as the real
    // distance, no square root needed.
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
