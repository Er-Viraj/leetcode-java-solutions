/**
 * LeetCode 206 - Reverse Linked List (Easy)
 * Day 6 - Linked List
 *
 * Problem: Given the head of a singly linked list, reverse the list
 * and return the reversed list.
 * Example: head = [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
 *          head = [1, 2] -> [2, 1]
 *          head = [] -> []
 *
 * Approach: Iterative three-pointer reversal. Keep `prev` as the head of
 * the part already reversed (null at first) and walk `curr` down the
 * list. At each node, save `curr.next` in a temp variable first (so we
 * don't lose the rest of the list), point `curr.next` back at `prev`,
 * then move both pointers one step forward. When `curr` becomes null,
 * `prev` is the new head. Nothing is copied — only the `next` links
 * are flipped, in place.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save the rest of the list
            curr.next = prev;          // flip this link backwards
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
