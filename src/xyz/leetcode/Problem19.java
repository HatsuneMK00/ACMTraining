package xyz.leetcode;

import static xyz.leetcode.Problem21.*;

public class Problem19 {
    //    TODO: ����һ��������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ���
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
//        ɾ���ڵ�i
        if (previousI == null) {
            head = head.next;
        } else {
            previousI.next = previousI.next.next;
        }
        return head;
    }
}
