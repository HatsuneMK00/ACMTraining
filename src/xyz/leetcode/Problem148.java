package xyz.leetcode;

import xyz.leetcode.Problem21.ListNode;

public class Problem148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode current = head;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(7);
        Problem148 problem148 = new Problem148();
        current = problem148.sortList(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public ListNode sortList(ListNode head) {
        quickSortLinkedList(head, null);
        return head;
    }

    void quickSortLinkedList(ListNode start, ListNode end) {
        if (start == end || start.next == end) {
            return;
        }
        ListNode x = partition(start, end);
        quickSortLinkedList(start, x);
        quickSortLinkedList(x.next, end);
    }

    ListNode partition(ListNode start, ListNode end) {
        int pivot = start.val;
        ListNode i = start;
        ListNode j = start.next;
        while (j != end) {
            if (j.val < pivot) {
                i = i.next;
                swap(i, j);
            }
            j = j.next;
        }
        swap(start, i);
        return i;
    }

//    TODO: 在单链表中交换i和j 只交换节点的值即可
    void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
