package xyz.leetcode;

import xyz.leetcode.Problem21.ListNode;

import java.util.HashSet;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if (set.contains(current.val)) {
                previous.next = current.next;
            } else {
                set.add(current.val);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
