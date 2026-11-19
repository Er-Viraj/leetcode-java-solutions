/**
 * LeetCode 98 - Validate Binary Search Tree (Medium)
 * Day 7 - Trees
 *
 * Problem: Given the root of a binary tree, determine if it is a valid
 * binary search tree (BST). A valid BST means: every node in the left
 * subtree is strictly smaller than the node, every node in the right
 * subtree is strictly greater, and both subtrees are themselves valid
 * BSTs.
 * Example: root = [2, 1, 3] -> true
 *          root = [5, 1, 4, null, null, 3, 6] -> false
 *          (4 is in the right subtree of 5 but is smaller than 5)
 *
 * Approach: In-order traversal. A valid BST always yields a strictly
 * increasing sequence in in-order (left, node, right). So we walk the
 * tree in-order and remember the previous value seen (`prev`). If the
 * current node's value is not greater than `prev`, the tree is not a
 * BST and we stop right there. `prev` is a Long, not an int — a node
 * can legitimately hold Integer.MIN_VALUE, and starting `prev` at
 * null (nothing seen yet) avoids any fake comparison on the first node.
 * Checking only "left < root < right" at each node is NOT enough:
 * a node deep in the left subtree could still be bigger than an
 * ancestor, and this in-order check catches exactly that.
 *
 * Time: O(n) | Space: O(h) — recursion depth = tree height
 */
class Solution {
    private Long prev = null; // last value seen in in-order

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Left subtree must be a valid BST first.
        if (!isValidBST(root.left)) {
            return false;
        }

        // Current node must be strictly greater than the previous value.
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = (long) root.val;

        // Right subtree must be a valid BST too.
        return isValidBST(root.right);
    }
}
