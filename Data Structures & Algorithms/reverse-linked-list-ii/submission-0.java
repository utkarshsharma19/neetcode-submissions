/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;   // node to be moved
            curr.next = next.next;       // detach `next` from chain
            next.next = pre.next;        // `next` points to current front of sublist
            pre.next = next;             // `pre` now points to `next` as new front
        }

        return dummy.next;
    }
}