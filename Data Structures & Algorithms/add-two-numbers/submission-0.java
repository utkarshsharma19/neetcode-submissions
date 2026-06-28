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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 != null && l2 == null) {
            return l1;
        }

        if (l1 == null && l2 != null) {
            return l2;
        }

        // Build numbers as strings (in reverse order)
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while (l1 != null) {
            num1.insert(0, l1.val); // insert at beginning to reverse
            l1 = l1.next;
        }

        while (l2 != null) {
            num2.insert(0, l2.val);
            l2 = l2.next;
        }

        // Convert to BigInteger for safe addition
        java.math.BigInteger n1 = new java.math.BigInteger(num1.toString());
        java.math.BigInteger n2 = new java.math.BigInteger(num2.toString());

        java.math.BigInteger sum = n1.add(n2);
        String sumStr = sum.toString();

        // Build result list in reverse order
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i = sumStr.length() - 1; i >= 0; i--) {
            int digit = sumStr.charAt(i) - '0';
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}
