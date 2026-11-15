/**
 * LeetCode 424 - Longest Repeating Character Replacement (Medium)
 * Day 3 - Sliding Window
 *
 * Problem: Given a string s of uppercase letters and an integer k, you may
 * change at most k characters to any other uppercase letter. Return the
 * length of the longest substring that can be made of a single repeated
 * letter.
 * Example: "AABABBA", k = 1 -> 4 ("BBBB" from "BABB"), "ABAB", k = 2 -> 4
 *
 * Approach: Sliding window with a frequency count of the letters inside
 * it. A window can be made uniform if (window length - count of its most
 * frequent letter) <= k, i.e. the other letters can all be replaced. When
 * the window needs more than k replacements, shrink it from the left.
 * The most-frequent count never needs to decrease for the answer, so we
 * just track the max count seen so far.
 *
 * Time: O(n) | Space: O(1) — at most 26 letters
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0; // most frequent letter inside the window
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Window needs (length - maxFreq) replacements; shrink if > k
            while (right - left + 1 - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
