package xyz.leetcode.algorithmsearchtable;

import java.util.HashMap;
import java.util.HashSet;

//直线上最多的点数
public class MaxPoints {

    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        if (points.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 1; i < points.length; i++) {
//            这个变量时为记录有多少个相同点准备的 有一个相同点 所有共线的点都会+1
            int samePoint = 0;
            for (int j = 0; j < i; j++) {
                double slope;
                if (points[j][0] - points[i][0] == 0) {
                    if (points[j][1] - points[i][1] == 0) {
//                        相同的点就不能使用循环的处理逻辑了 直接跳过这个点即可
                        samePoint++;
                        continue;
                    } else slope = Double.MAX_VALUE;
                }
                else slope = (points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);

                map.put(slope, map.getOrDefault(slope, 1) + 1);

            }
            for (Integer value : map.values()) {
                max = Math.max(max, value + samePoint);
            }
//            这个语句是针对只有相同点而使得map为空的情况准备的
            max = Math.max(max, 1 + samePoint);
            map.clear();
        }
        return max;
    }
}
