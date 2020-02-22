package xyz.leetcode;

import java.util.HashSet;

import static xyz.leetcode.Problem21.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (nodes.contains(current)) {
                return true;
            }
            nodes.add(current);
            current = current.next;
        }
        return false;
    }
}
