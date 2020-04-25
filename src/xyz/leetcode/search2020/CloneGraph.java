package xyz.leetcode.search2020;

import java.math.BigInteger;
import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> nodeMap = new HashMap<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashSet<Node> accessed = new HashSet<>();
        DFS(node, accessed);
        for (int i = 1; i <= accessed.size(); i++) {
            nodeMap.put(i, new Node(i));
        }
        for (Integer key : nodeMap.keySet()) {
            nodeMap.get(key).neighbors = integer2Node(adjMap.get(key));
        }
        return nodeMap.get(1);
    }

    public void DFS(Node node, Set<Node> accessed) {
        adjMap.put(node.val, node2Integer(node.neighbors));
        accessed.add(node);
        for (Node neighbor : node.neighbors) {
            if (!accessed.contains(neighbor)) {
                DFS(neighbor, accessed);
            }
        }
    }

    public List<Integer> node2Integer(List<Node> nodes) {
        List<Integer> integers = new ArrayList<>();
        for (Node node : nodes) {
            integers.add(node.val);
        }
        return integers;
    }

    public List<Node> integer2Node(List<Integer> integers) {
        List<Node> nodes = new ArrayList<>();
        for (Integer integer : integers) {
            nodes.add(nodeMap.get(integer));
        }
        return nodes;
    }
}
