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
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode ptr = slow.next;
        ListNode node = null;
        slow.next = null;
        while(ptr!=null) {
            ListNode temp = ptr.next;
            ptr.next = node;
            node = ptr;
            ptr = temp;
        }

        ListNode top = head;
        while(node!=null) {
            ListNode temp1 = top.next;
            ListNode temp2 = node.next;

            top.next = node;
            node.next = temp1;
            top = temp1;
            node = temp2;
        }
    }  
}
