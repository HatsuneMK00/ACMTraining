package xyz.leetcode;

import static xyz.leetcode.Problem21.*;

public class Problem19 {
    //    TODO: 给定一个单链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previousI, j;
        int count = 0;
        boolean moveI = false;
        previousI = null;
        j = head;
        while (j != null) {
            if (moveI) {
                previousI = previousI.next;
            }
            if (count == n) {
                previousI = head;
                moveI = true;
            }
            j = j.next;
            count++;
        }
//        删除节点i
        if (previousI == null) {
            head = head.next;
        } else {
            previousI.next = previousI.next.next;
        }
        return head;
    }
}
