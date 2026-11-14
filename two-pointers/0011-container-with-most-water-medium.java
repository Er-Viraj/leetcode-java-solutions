/**
 * LeetCode 11 - Container With Most Water (Medium)
 * Day 2 - Two Pointers
 *
 * Problem: Given height[i] = height of a vertical line at position i,
 * pick two lines that, together with the x-axis, form a container
 * holding the most water. Area = (distance between lines) x (height
 * of the shorter line). Return the maximum area.
 * Example: height = [1,8,6,2,5,4,8,3,7] -> 49 (lines 8 and 7, width 7)
 *
 * Approach: Start with the widest container (pointers at both ends).
 * The water level is set by the shorter line, so moving the taller
 * line inward can never help — the width shrinks and the height is
 * still capped by the shorter line. So always move the shorter line
 * inward, keeping the best area seen. Every step discards a line
 * that cannot be part of a better container.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);

            // Move the shorter line inward; the taller one stays.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
