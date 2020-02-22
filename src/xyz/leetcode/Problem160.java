package xyz.leetcode;

import java.util.HashSet;

import static xyz.leetcode.Problem21.ListNode;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode current = headA;
        while (current != null) {
            if (nodes.contains(current)) {
                return current;
            } else {
                nodes.add(current);
            }
            current = current.next;
        }
        current = headB;
        while (current != null) {
            if (nodes.contains(current)) {
                return current;
            } else {
                nodes.add(current);
            }
            current = current.next;
        }
        return null;
    }
}
