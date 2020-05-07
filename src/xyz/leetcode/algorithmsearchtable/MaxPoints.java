package xyz.leetcode.algorithmsearchtable;

import java.util.HashMap;

//ֱ�������ĵ���
public class MaxPoints {
    public static void main(String[] args) {
        new MaxPoints().maxPoints(new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}});
    }

    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        if (points.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 1; i < points.length; i++) {
//            �������ʱΪ��¼�ж��ٸ���ͬ��׼���� ��һ����ͬ�� ���й��ߵĵ㶼��+1
            int samePoint = 0;
            for (int j = 0; j < i; j++) {
                double slope;
                if (points[j][0] - points[i][0] == 0) {
                    if (points[j][1] - points[i][1] == 0) {
//                        ��ͬ�ĵ�Ͳ���ʹ��ѭ���Ĵ����߼��� ֱ����������㼴��
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
//            �����������ֻ����ͬ���ʹ��mapΪ�յ����׼����
            max = Math.max(max, 1 + samePoint);
            map.clear();
        }
        return max;
    }
}
