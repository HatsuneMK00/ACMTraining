package xyz.leetcode;

import xyz.leetcode.Problem21.ListNode;

// TOOL ��תһ������
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next;
        ListNode previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
