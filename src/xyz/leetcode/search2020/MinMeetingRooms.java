package xyz.leetcode.search2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int m = intervals.length;
        if (m == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        queue.add(intervals[0][1]);
        for (int i = 1; i < m; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }

        return queue.size();
    }
}
