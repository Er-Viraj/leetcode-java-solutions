/**
 * LeetCode 102 - Binary Tree Level Order Traversal (Medium)
 * Day 7 - Trees
 *
 * Problem: Given the root of a binary tree, return the level order
 * traversal of its nodes' values — one list per level, top to bottom.
 * Example: root = [3, 9, 20, null, null, 15, 7]
 *          -> [[3], [9, 20], [15, 7]]
 *          root = [1] -> [[1]]
 *          root = [] -> []
 *
 * Approach: Breadth-first search with a queue. Start with the root in
 * the queue. Each pass through the loop handles exactly one level:
 * record the queue size first (that is how many nodes this level has),
 * dequeue that many nodes, collect their values into the current
 * level's list, and enqueue their non-null children for the next pass.
 * The recorded size is the key trick — it keeps levels from mixing.
 *
 * Time: O(n) | Space: O(n) — the queue holds at most one level's nodes
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // nodes on this level only
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
