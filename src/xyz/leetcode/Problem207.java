package xyz.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem207 {
    public static void main(String[] args) {
        Problem207 problem207 = new Problem207();
        int[][] ints = {new int[]{1, 0}};
        System.out.println(problem207.canFinish(2, ints));
    }
    int time = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!nodes.containsKey(prerequisite[0])) {
                nodes.put(prerequisite[0], new Node(prerequisite[0]));
            }
            if (!nodes.containsKey(prerequisite[1])) {
                nodes.put(prerequisite[1], new Node(prerequisite[1]));
            }
        }
        Map<Node, List<Node>> graph = initialGraph(prerequisites, nodes);
        return DFSSearch(graph);
    }

//    TOOL 有向图的深度优先搜索
//    只用于检测有向图中是否有环路 不返回拓扑序 不构建深度搜索树（前驱子树）
    boolean DFSSearch(Map<Node, List<Node>> graph) {
        boolean result = true;
        for (Node node : graph.keySet()) {
            if (node.color == 0) {
                result = result && DFSVisit(graph, node);
            }
        }
        return result;
    }

    boolean DFSVisit(Map<Node, List<Node>> graph, Node u) {
        time++;
        u.d = time;
        u.color = 1;
        boolean result = true;
        for (Node node : graph.getOrDefault(u, new ArrayList<>())) {
            if (node.color == 0) {
                result = DFSVisit(graph, node);
            } else if (node.color == 1) {
                return false;
            }
            if (!result) {
                break;
            }
        }
        u.color = 2;
        time++;
        u.f = time;
        return result;
    }

    private Map<Node, List<Node>> initialGraph(int[][] prerequisites, Map<Integer, Node> nodes) {
        HashMap<Node, List<Node>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Node node = nodes.get(prerequisite[1]);
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<>());
            }
            List<Node> nodeList = map.get(node);
            nodeList.add(nodes.get(prerequisite[0]));
        }
        return map;
    }

    //    给DFS搜索使用的结点
    public static class Node {
        int node;
//        发现时间
        int d;
//        处理完成时间
        int f;
//        结点颜色
//        0 为白色
//        1 为灰色
//        2 为黑色
        int color = 0;
//        int pi; 前驱节点

        public Node(int node) {
            this.node = node;
        }
    }
}
