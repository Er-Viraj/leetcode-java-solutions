/**
 * LeetCode 242 - Valid Anagram (Easy)
 * Day 15 - Strings
 *
 * Problem: Given two strings s and t, return true if t is an anagram
 * of s, and false otherwise. An anagram uses exactly the same letters,
 * the same number of times, in any order.
 * Example: s = "anagram", t = "nagaram" -> true
 *          s = "rat", t = "car" -> false
 *
 * Approach: An anagram is defined by counts, not order, so compare
 * character frequencies instead of the strings themselves. First
 * reject different lengths outright. Then use one 26-slot count array
 * (the inputs are lowercase English letters): add 1 for each letter
 * of s, subtract 1 for each letter of t, and check that every slot
 * ends at zero.
 *
 * Time: O(n) — one pass over each string plus a fixed 26-slot check
 * Space: O(1) — the count array has a fixed size of 26
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
