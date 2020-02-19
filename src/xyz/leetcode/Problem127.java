package xyz.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

// �����������Ӧ���ù�������������� �����������������Ѱ����Ȩͼ�����·��
// ��Ҫ���и�Ч��Ԥ����
// TODO �������� ������ν���Ԥ����Ѱ���ھӺ͹����������
public class Problem127 {
    public static void main(String[] args) {
        Problem127 problem127 = new Problem127();
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(problem127.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int v = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                v = i;
            }
        }
        if (v < 0) {
            return 0;
        }
        int words = wordList.size();
        int[][] graph = new int[words + 1][words + 1];
        for (int i = 0; i <= words; i++) {
            for (int j = 0; j <= words; j++) {
                String a = (i == words ? beginWord : wordList.get(i));
                String b = (j == words ? beginWord : wordList.get(j));
                int distance = calculateStringDistance(a, b);
                if (distance > 1) {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = distance;
                }
            }
        }
        boolean f = false;
        for (int i = 0; i <= words; i++) {
            if (graph[words][i] == 1) {
                f = true;
                break;
            }
        }
        if (!f) {
            return 0;
        }
        return Dijkstra(graph, words, v) + 1;
    }

    int calculateStringDistance(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

//    TOOL ð��Dijkstra�㷨 v�ǲ���Ҫ��
    int Dijkstra(int[][] graph, int s, int v) {
        int vertexes = graph.length;
        HashSet<Node> settled = new HashSet<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        for (int i = 0; i < vertexes; i++) {
            Node current;
            if (i == s) {
                current = new Node(i, 0);

            } else {
                current = new Node(i, Integer.MAX_VALUE);
            }
            queue.add(current);
            nodeMap.put(i, current);
        }
        while (!queue.isEmpty()) {
            Node u = queue.poll();
            settled.add(u);
            for (int i = 0; i < vertexes; i++) {
                if (graph[u.node][i] > 0) {
                    if (nodeMap.get(i).d > u.d + graph[u.node][i]) {
//                        ���ȶ���û�а취���޸���ֵ֮�����н��б䶯
//                        ֻ��ɾ����Ԫ�����������
                        queue.remove(nodeMap.get(i));
                        nodeMap.get(i).d = u.d + graph[u.node][i];
                        queue.add(nodeMap.get(i));
                    }
                }
            }
        }
        return nodeMap.get(v).d;
    }

//    ��Dijkstra�㷨�õ�Node
    public static class Node {
//        �ڵ���
        int node;
//        ��Դ�ڵ�Ĺ��ƾ���
        int d;

        public Node(int node, int d) {
            this.node = node;
            this.d = d;
        }
    }

}
