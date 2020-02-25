package xyz.leetcode;

import java.util.PriorityQueue;

public class Problem152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tempMax = 1;
        int tempMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            tempMax = Math.max(tempMax * nums[i], nums[i]);
            tempMin = Math.min(tempMin * nums[i], nums[i]);
            max = Math.max(tempMax, max);
        }
        return max;
    }
}
