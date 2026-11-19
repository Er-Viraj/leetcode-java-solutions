/**
 * LeetCode 226 - Invert Binary Tree (Easy)
 * Day 7 - Trees
 *
 * Problem: Given the root of a binary tree, invert the tree (make its
 * mirror image) and return its root.
 * Example: root = [4, 2, 7, 1, 3, 6, 9] -> [4, 7, 2, 9, 6, 3, 1]
 *          root = [2, 1, 3] -> [2, 3, 1]
 *          root = [] -> []
 *
 * Approach: Recursion. At every node, swap its left and right children,
 * then invert both subtrees the same way. Swapping first and recursing
 * after (preorder) or recursing first and swapping on the way back
 * (postorder) both work — here we swap first, then recurse into the
 * children we just moved. A null node is already "inverted", so it is
 * the base case. Nothing new is allocated; the same nodes are rewired.
 *
 * Time: O(n) | Space: O(h) — recursion depth = tree height
 *        (O(log n) for a balanced tree, O(n) if it is skewed)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the two children of this node.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert each subtree.
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
