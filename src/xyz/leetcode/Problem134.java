package xyz.leetcode;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remained = new int[n];
        for (int i = 0; i < n; i++) {
            remained[i] = gas[i] - cost[i];
        }
        int tempMaxSumIndex = 0;
        int tempMaxSum = 0;
        int maxSumIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (tempMaxSum + remained[i] < 0) {
                tempMaxSumIndex = i + 1;
                maxSumIndex = tempMaxSumIndex;
                tempMaxSum = 0;
            } else {
                tempMaxSum += remained[i];
            }
            if (maxSum <= tempMaxSum) {
                maxSum = tempMaxSum;
                maxSumIndex = tempMaxSumIndex;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += remained[i];
        }
        if (sum >= 0) {
            return maxSumIndex % n;
        } else {
            return -1;
        }
    }
}
