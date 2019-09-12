package xyz.leetcode;

import java.util.Arrays;

public class Problem16 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(threeSumClosest(nums, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int numsLength = nums.length;
        int l, r, i, dist, answer = 0;
        dist = Integer.MAX_VALUE;

        for (i = 0; i < numsLength; i++) {
            l = i + 1;
            r = numsLength - 1;
            while (l < r) {
                int currentDist = nums[i] + nums[l] + nums[r] - target;
                if (Math.abs(currentDist) < dist) {
                    dist = Math.abs(currentDist);
                    answer = nums[i] + nums[l] + nums[r];
                }
                if (currentDist > 0) r--;
                else if (currentDist < 0) l++;
                else break;
            }
            if (dist == 0) break;
        }
        return answer;
    }
}
