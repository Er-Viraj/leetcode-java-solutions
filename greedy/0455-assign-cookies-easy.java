/**
 * LeetCode 455 - Assign Cookies (Easy)
 * Day 9 - Greedy
 *
 * Problem: Each child i has a greed factor g[i] (the smallest cookie
 * size that makes them content) and each cookie j has a size s[j].
 * Give each child at most one cookie; a cookie goes to at most one
 * child. Return the maximum number of content children.
 * Example: g = [1,2,3], s = [1,1] -> 1 (only the child with greed 1)
 *          g = [1,2], s = [1,2,3] -> 2
 *
 * Approach: Greedy — never waste a big cookie on a small appetite.
 * Sort both arrays. Walk the cookies from smallest to largest and
 * always try the least greedy unfed child: if the current cookie is
 * big enough, feed that child and move to the next one; either way
 * the cookie is used up or too small for anyone left (everyone still
 * unfed is greedier). The child pointer ends up counting exactly how
 * many children got fed.
 *
 * Time: O(n log n + m log m) — sorting both arrays dominates; the
 * sweep itself is linear | Space: O(1) extra (sorting is in place)
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // child = least greedy unfed child, cookie = smallest unused cookie.
        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // Smallest cookie that satisfies this child — feed them.
                child++;
            }
            // Cookie used up, or too small for anyone left — move on.
            cookie++;
        }

        return child;
    }
}
