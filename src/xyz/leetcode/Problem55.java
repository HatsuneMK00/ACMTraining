package xyz.leetcode;

public class Problem55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(nums[i] + i, dp[i - 1]);
        }
        return dp[length - 2] >= length - 1;
    }
}
