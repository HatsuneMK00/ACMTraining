package xyz.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem116 {
    public Node connect(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        preOrderTraversal(root, 0, map);
        return root;
    }

    public void preOrderTraversal(Node root, int depth, Map<Integer, Node> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(depth)) {
            Node previous = map.get(depth);
            previous.next = root;
            map.put(depth, root);
        } else {
            map.put(depth, root);
        }
        preOrderTraversal(root.left, depth + 1, map);
        preOrderTraversal(root.right, depth + 1, map);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
