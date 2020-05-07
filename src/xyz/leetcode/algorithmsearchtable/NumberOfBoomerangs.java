package xyz.leetcode.algorithmsearchtable;

import java.util.HashMap;

// 回旋镖的数量
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = distance(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer val : map.values()) {
                answer += (val * (val - 1));
            }
            map.clear();
        }
        return answer;
    }

    public int distance(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }
}
