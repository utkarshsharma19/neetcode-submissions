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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode node = slow.next;
        slow.next = null;
        while(node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        ListNode start = head;
        while(prev!=null) {
            ListNode temp1 = start.next;
            ListNode temp2 = prev.next;

            start.next = prev;
            prev.next = temp1;
            start = temp1;
            prev = temp2;
        }

    }
}
