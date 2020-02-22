package xyz.leetcode;

import java.util.*;

import static xyz.leetcode.Problem207.*;

public class Problem210 {
    int time = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] answer = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                answer[i] = i;
            }
            return answer;
        }
        HashMap<Integer, Node> nodes = new HashMap<>();
//        课程编号是按顺序来的 直接插入nodes就行
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i, new Node(i));
        }
        Map<Node, List<Node>> graph = initialGraph(prerequisites, nodes);
        if (DFSSearch(graph)) {
            PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.f - o1.f);
            int[] answer = new int[numCourses];
            int i = 0;
            queue.addAll(nodes.values());
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                answer[i++] = node.node;
            }
            return answer;
        } else {
            return new int[0];
        }
    }

    //    TOOL 有向图的深度优先搜索并构造拓扑序(如果存在)
//    只用于检测有向图中是否有环路 返回拓扑序 不构建深度搜索树（前驱子树）
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
}
