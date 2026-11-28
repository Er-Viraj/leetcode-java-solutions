/**
 * LeetCode 14 - Longest Common Prefix (Easy)
 * Day 16 - Trie
 *
 * Problem: Write a function to find the longest common prefix string
 * amongst an array of strings. If there is no common prefix, return
 * an empty string "".
 * Example: strs = ["flower", "flow", "flight"] -> "fl"
 *          strs = ["dog", "racecar", "car"] -> ""
 *
 * Approach: Start with the first string as the candidate prefix. For
 * each following string, shrink the prefix from the end until that
 * string starts with it; if the prefix becomes empty, there is no
 * common prefix. The surviving prefix is common to every string.
 *
 * Time: O(S) - each character of the strings is compared at most once
 * in total, where S is the sum of the lengths of all strings
 * Space: O(1) extra - besides the prefix itself
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
