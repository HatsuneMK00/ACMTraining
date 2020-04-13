package xyz.leetcode;

import xyz.leetcode.Problem21.ListNode;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode accepted = null;
        ListNode newHead = null;
        boolean valid = true;

        while (current != null) {
            if (current.next != null) {
                if (current.val != current.next.val) {
                    if (valid) {
                        if (newHead == null) {
                            newHead = new ListNode(current.val);
                            accepted = newHead;
                        } else {
                            accepted.next = new ListNode(current.val);
                            accepted = accepted.next;
                        }
                    } else {
                        valid = true;
                    }
                } else {
                    valid = false;
                }
            } else {
                if (valid) {
                    if (newHead == null) {
                        newHead = current;
                    } else {
                        accepted.next = current;
                    }
                }
            }
            current = current.next;
        }
        return newHead;
    }
}
