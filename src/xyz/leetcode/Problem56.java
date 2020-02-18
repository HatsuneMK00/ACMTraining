package xyz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                intervals[i][0] = intervals[i - 1][1];
                if (intervals[i][0] > intervals[i][1]) {
                    intervals[i][1] = intervals[i][0];
                }
            }
        }
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (answer.get(answer.size() - 1)[1] == intervals[i][0]) {
                answer.get(answer.size() - 1)[1] = intervals[i][1];
            } else {
                answer.add(intervals[i]);
            }
        }
        int[][] newIntervals = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            newIntervals[i][0] = answer.get(i)[0];
            newIntervals[i][1] = answer.get(i)[1];
        }
        return newIntervals;
    }
}
