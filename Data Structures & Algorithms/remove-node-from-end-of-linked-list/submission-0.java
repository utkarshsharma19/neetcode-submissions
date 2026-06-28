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
    ListNode next;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode result = head;
        ListNode current1 = head;

        int count = 0;
        while(current!=null) {
            current = current.next;
            count++;
        }

         if (n == count) {
            return head.next;
        }

       int target = count - n;
        ListNode prev = head;
        for (int i = 1; i < target; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return head;

    }
}
