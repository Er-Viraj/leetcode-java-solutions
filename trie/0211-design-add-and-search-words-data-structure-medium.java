/**
 * LeetCode 211 - Design Add and Search Words Data Structure (Medium)
 * Day 16 - Trie
 *
 * Problem: Design a data structure that supports adding words and
 * searching for a word that may contain '.' as a wildcard matching
 * any single letter. addWord(word) adds a word; search(word) returns
 * true if any added word matches, with '.' matching any letter.
 * Example: addWord("bad"); addWord("dad"); addWord("mad");
 *          search("pad") -> false; search("bad") -> true;
 *          search(".ad") -> true; search("b..") -> true
 *
 * Approach: Store the words in a trie, one 26-slot node per letter,
 * with a flag at the end of each word. Search walks the trie
 * recursively; a '.' branches to every non-null child, while a
 * concrete letter follows its single child.
 *
 * Time: O(m) for addWord, where m is the word length; search is
 * O(26^m) in the worst case, when every character is '.'
 * Space: O(N * 26) in the worst case - each trie node holds a 26-slot
 * child array, where N is the number of nodes
 */
class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(root, word, 0);
    }

    private boolean searchInNode(TrieNode node, String word, int index) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (searchInNode(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        return searchInNode(node.children[ch - 'a'], word, index + 1);
    }
}
