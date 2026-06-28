class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        ListNode secondHalf = prev;

        while (secondHalf != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = temp1;

            first = temp1;
            secondHalf = temp2;
        }
    }
}