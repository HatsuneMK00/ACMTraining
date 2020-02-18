package xyz.leetcode;

import xyz.leetcode.Problem21.ListNode;

//TOOL 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode current = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (head == null) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = current.next;
            }
        }
        while (l1 != null) {
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }
        return head;
    }
}
