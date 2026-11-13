import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49 - Group Anagrams (Medium)
 * Day 1 - Arrays & Hashing
 *
 * Problem: Given strings, group anagrams together. Anagrams use
 * the same letters with the same counts, in any order.
 *
 * Approach: Sorted letters as the key. Anagrams share the same
 * sorted form, e.g. "eat", "tea", "ate" -> "aet".
 * Group every string under its sorted key in a HashMap.
 *
 * Time: O(n * k log k), n = number of strings, k = max length
 * Space: O(n * k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
