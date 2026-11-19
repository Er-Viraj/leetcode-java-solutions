# LeetCode Solutions in Java

Daily LeetCode practice in Java — 2–3 problems a day, topic by topic.
I solve on LeetCode myself under `engineer_viraj`; this repo is my organised
reference copy, with the approach and complexity written on each file so I can
revise fast before interviews.

By Viraj Kumar ([engineer-viraj](https://github.com/engineer-viraj)).

## How it's organised

One folder per topic. Inside a folder, files are named
`NNNN-problem-name-difficulty.java`, so the problem number and difficulty are
visible without opening the file.

## Progress

| Day | Date | Topic | Problems |
| --- | --- | --- | --- |
| 1 | 13 Nov 2026 | Arrays & Hashing | 3 |
| 2 | 14 Nov 2026 | Two Pointers | 3 |
| 3 | 15 Nov 2026 | Sliding Window | 3 |
| 4 | 16 Nov 2026 | Stack | 3 |
| 5 | 17 Nov 2026 | Binary Search | 3 |
| 6 | 18 Nov 2026 | Linked List | 3 |
| 7 | 19 Nov 2026 | Trees | 3 |

## Arrays & Hashing

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | HashMap | [0001-two-sum-easy.java](arrays-hashing/0001-two-sum-easy.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Sorted key + HashMap | [0049-group-anagrams-medium.java](arrays-hashing/0049-group-anagrams-medium.java) |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | HashMap + min-heap of size k | [0347-top-k-frequent-elements-medium.java](arrays-hashing/0347-top-k-frequent-elements-medium.java) |

## Two Pointers

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Medium | Two pointers, move the shorter line | [0011-container-with-most-water-medium.java](two-pointers/0011-container-with-most-water-medium.java) |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Easy | Two pointers, skip non-alphanumeric | [0125-valid-palindrome-easy.java](two-pointers/0125-valid-palindrome-easy.java) |
| 167 | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Two pointers on sorted array | [0167-two-sum-ii-input-array-is-sorted-medium.java](two-pointers/0167-two-sum-ii-input-array-is-sorted-medium.java) |

## Sliding Window

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Sliding window + last-index map | [0003-longest-substring-without-repeating-characters-medium.java](sliding-window/0003-longest-substring-without-repeating-characters-medium.java) |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Track min price, best profit so far | [0121-best-time-to-buy-and-sell-stock-easy.java](sliding-window/0121-best-time-to-buy-and-sell-stock-easy.java) |
| 424 | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Sliding window, at most k replacements | [0424-longest-repeating-character-replacement-medium.java](sliding-window/0424-longest-repeating-character-replacement-medium.java) |

## Stack

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 20 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | Easy | Stack of openers, match on closer | [0020-valid-parentheses-easy.java](stack/0020-valid-parentheses-easy.java) |
| 150 | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Medium | Stack of operands, apply operator to top two | [0150-evaluate-reverse-polish-notation-medium.java](stack/0150-evaluate-reverse-polish-notation-medium.java) |
| 155 | [Min Stack](https://leetcode.com/problems/min-stack/) | Medium | Second stack tracking min at each level | [0155-min-stack-medium.java](stack/0155-min-stack-medium.java) |

## Binary Search

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Binary search, one half is always sorted | [0033-search-in-rotated-sorted-array-medium.java](binary-search/0033-search-in-rotated-sorted-array-medium.java) |
| 153 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Medium | Binary search on the rotation point | [0153-find-minimum-in-rotated-sorted-array-medium.java](binary-search/0153-find-minimum-in-rotated-sorted-array-medium.java) |
| 704 | [Binary Search](https://leetcode.com/problems/binary-search/) | Easy | Classic binary search | [0704-binary-search-easy.java](binary-search/0704-binary-search-easy.java) |

## Linked List

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 19 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Two pointers with a fixed gap, dummy head | [0019-remove-nth-node-from-end-of-list-medium.java](linked-list/0019-remove-nth-node-from-end-of-list-medium.java) |
| 143 | [Reorder List](https://leetcode.com/problems/reorder-list/) | Medium | Find middle, reverse second half, weave halves | [0143-reorder-list-medium.java](linked-list/0143-reorder-list-medium.java) |
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy | Iterative three-pointer reversal | [0206-reverse-linked-list-easy.java](linked-list/0206-reverse-linked-list-easy.java) |

## Trees

| # | Problem | Difficulty | Approach | Solution |
| --- | --- | --- | --- | --- |
| 98 | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | In-order traversal, strictly increasing | [0098-validate-binary-search-tree-medium.java](trees/0098-validate-binary-search-tree-medium.java) |
| 102 | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | BFS, one queue pass per level | [0102-binary-tree-level-order-traversal-medium.java](trees/0102-binary-tree-level-order-traversal-medium.java) |
| 226 | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) | Easy | Recursion, swap children at every node | [0226-invert-binary-tree-easy.java](trees/0226-invert-binary-tree-easy.java) |

## Note

Reference solutions for learning and revision. These solutions are also
submitted on LeetCode under `engineer_viraj`.
