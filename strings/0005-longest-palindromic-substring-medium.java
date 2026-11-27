/**
 * LeetCode 5 - Longest Palindromic Substring (Medium)
 * Day 15 - Strings
 *
 * Problem: Given a string s, return the longest palindromic substring
 * in s. (If several tie, any one of them is accepted.)
 * Example: s = "babad" -> "bab" (or "aba")
 *          s = "cbbd" -> "bb"
 *
 * Approach: Expand around the centre. Every palindrome has a centre:
 * a single character for odd lengths ("aba") or the gap between two
 * characters for even lengths ("abba"). There are 2n - 1 centres in
 * total. From each centre, grow outwards while the characters on both
 * sides match and record the longest span found. Brute force would
 * check every substring in O(n^3); a full DP table does it in O(n^2)
 * time and O(n^2) space, but centre expansion keeps the same time
 * with only O(1) extra space. (Manacher's algorithm reaches O(n)
 * time, but it is rarely expected in interviews.)
 *
 * Time: O(n^2) — 2n - 1 centres, each expansion runs at most O(n) steps
 * Space: O(1) extra — besides the output string
 */
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // Odd-length palindromes centred on s[i].
            int len1 = expand(s, i, i);
            // Even-length palindromes centred between s[i] and s[i + 1].
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                // The centre i sits in the middle of the span, so the
                // start is (len - 1) / 2 steps to its left.
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Returns the length of the longest palindrome centred between
    // left and right (left == right for odd length).
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
