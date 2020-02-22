package xyz.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem207 {
    int time = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Node> nodes = new HashMap<>();
//        �γ̱���ǰ�˳������ ֱ�Ӳ���nodes����
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i, new Node(i));
        }
        Map<Node, List<Node>> graph = initialGraph(prerequisites, nodes);
        return DFSSearch(graph);
    }

//    TOOL ����ͼ�������������
//    ֻ���ڼ������ͼ���Ƿ��л�· ������������ �����������������ǰ��������
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

    //    ��DFS����ʹ�õĽ��
    public static class Node {
        int node;
//        ����ʱ��
        int d;
//        �������ʱ��
        int f;
//        �����ɫ
//        0 Ϊ��ɫ
//        1 Ϊ��ɫ
//        2 Ϊ��ɫ
        int color = 0;
//        int pi; ǰ���ڵ�

        public Node(int node) {
            this.node = node;
        }
    }
}