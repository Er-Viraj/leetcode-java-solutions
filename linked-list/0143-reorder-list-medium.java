/**
 * LeetCode 143 - Reorder List (Medium)
 * Day 6 - Linked List
 *
 * Problem: You are given the head of a singly linked list
 * L0 -> L1 -> ... -> Ln-1 -> Ln. Reorder it to
 * L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
 * You may not modify the values in the list's nodes. Only nodes
 * themselves may be changed.
 * Example: head = [1, 2, 3, 4] -> [1, 4, 2, 3]
 *          head = [1, 2, 3, 4, 5] -> [1, 5, 2, 4, 3]
 *
 * Approach: Three steps, all in place.
 * 1. Find the middle with slow/fast pointers: fast moves two steps,
 *    slow one, so when fast hits the end slow is at the middle.
 * 2. Reverse the second half (same pointer-flip trick as LeetCode 206)
 *    and cut the list in two at the middle.
 * 3. Weave the two halves together: take one node from the first half,
 *    then one from the reversed second half, and repeat until the second
 *    half runs out. The method modifies the list in place and returns
 *    nothing, per the problem's signature.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: find the middle (slow ends on the last node of the first half)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse the second half and split the list
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        second = prev;

        // Step 3: merge the two halves, one node at a time
        ListNode first = head;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
