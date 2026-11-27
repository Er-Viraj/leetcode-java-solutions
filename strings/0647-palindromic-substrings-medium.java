/**
 * LeetCode 647 - Palindromic Substrings (Medium)
 * Day 15 - Strings
 *
 * Problem: Given a string s, return the number of palindromic
 * substrings in it. A substring is a contiguous sequence of
 * characters, and substrings at different positions count separately
 * even if they have the same text.
 * Example: s = "abc" -> 3 (the three single letters)
 *          s = "aaa" -> 6 ("a", "a", "a", "aa", "aa", "aaa")
 *
 * Approach: The same expand-around-centre idea as Longest Palindromic
 * Substring (#5), but counting instead of keeping the longest. Every
 * palindrome has a centre, so there are 2n - 1 centres: n on a single
 * character (odd lengths) and n - 1 between two characters (even
 * lengths). Expand outwards from each centre while the ends match —
 * every successful step outwards is one more palindrome, and the
 * moment the ends differ, nothing wider from that centre can work.
 * A full DP table also gives O(n^2) time but needs O(n^2) space.
 *
 * Time: O(n^2) — 2n - 1 centres, each expansion runs at most O(n) steps
 * Space: O(1) extra — only a few counters
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Odd-length palindromes centred on s[i].
            count += expand(s, i, i);
            // Even-length palindromes centred between s[i] and s[i + 1].
            count += expand(s, i, i + 1);
        }
        return count;
    }

    // Counts the palindromes centred between left and right
    // (left == right for odd length): one per successful expansion.
    private int expand(String s, int left, int right) {
        int found = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            found++;
            left--;
            right++;
        }
        return found;
    }
}
