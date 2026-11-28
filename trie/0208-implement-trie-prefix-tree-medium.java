/**
 * LeetCode 208 - Implement Trie (Prefix Tree) (Medium)
 * Day 16 - Trie
 *
 * Problem: Implement a trie (prefix tree) with insert(word),
 * search(word) and startsWith(prefix). search returns true only if
 * the word was inserted as a whole word; startsWith returns true if
 * any inserted word has the given prefix.
 * Example: trie.insert("apple"); trie.search("apple") -> true
 *          trie.search("app") -> false; trie.startsWith("app") -> true
 *
 * Approach: Each node holds 26 child slots (one per lowercase letter)
 * and a flag marking the end of a word. Insert creates missing nodes
 * along the word and marks the last node; search and startsWith walk
 * down the same path, returning null early when a child is missing.
 *
 * Time: O(m) per operation, where m is the length of the word or prefix
 * Space: O(N * 26) in the worst case - each trie node holds a 26-slot
 * child array, where N is the number of nodes
 */
class Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = walk(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    private TrieNode walk(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
