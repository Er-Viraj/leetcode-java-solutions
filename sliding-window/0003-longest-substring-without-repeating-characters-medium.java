import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3 - Longest Substring Without Repeating Characters (Medium)
 * Day 3 - Sliding Window
 *
 * Problem: Given a string s, find the length of the longest substring
 * without repeating characters.
 * Example: "abcabcbb" -> 3 ("abc"), "pwwkew" -> 3 ("wke")
 *
 * Approach: Sliding window with a map of character -> last index seen.
 * Expand the right end one character at a time. If the new character was
 * seen inside the current window, jump the left end to just after its
 * previous occurrence. The window always holds distinct characters, and
 * its length is a candidate answer.
 *
 * Time: O(n) | Space: O(min(n, alphabet size))
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If c appeared inside the current window, shrink from the left
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }

            lastIndex.put(c, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
