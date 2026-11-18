/**
 * LeetCode 19 - Remove Nth Node From End of List (Medium)
 * Day 6 - Linked List
 *
 * Problem: Given the head of a linked list, remove the nth node from
 * the end of the list and return its head.
 * Example: head = [1, 2, 3, 4, 5], n = 2 -> [1, 2, 3, 5]
 *          head = [1], n = 1 -> []
 *          head = [1, 2], n = 1 -> [1]
 *
 * Approach: One pass with two pointers kept a fixed gap apart. Put a
 * dummy node before the head so that removing the head itself needs no
 * special case. Move `fast` n + 1 steps ahead of `slow`, then move both
 * forward together. When `fast` reaches the end, `slow` sits just before
 * the node to delete (the gap guarantees it), so `slow.next =
 * slow.next.next` unlinks it. The dummy's `next` is the answer, which
 * is the original head unless the head was the deleted node.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n + 1 nodes ahead so slow lands just before the target
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next; // unlink the nth node from the end
        return dummy.next;
    }
}
