package xyz.leetcode;

import java.util.HashMap;

public class Problem138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> randomMap = new HashMap<>();
        Node newHead = new Node(head.val);
        randomMap.put(head, newHead);
        Node current = head.next;
        Node newCurrent = newHead;
        while (current != null) {
            newCurrent.next = new Node(current.val);
            newCurrent = newCurrent.next;
            randomMap.put(current, newCurrent);
            current = current.next;
        }
        current = head;
        newCurrent = newHead;
        while (newCurrent != null) {
            newCurrent.random = randomMap.get(current.random);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newHead;
    }
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
