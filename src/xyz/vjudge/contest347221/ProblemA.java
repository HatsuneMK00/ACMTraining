package xyz.vjudge.contest347221;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length = 1;
        int pos = 0;
        int[] nums = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i + 1] = 10001;
        }
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            pos = lowerBound(dp, 1, length + 1, nums[i]);
            dp[pos] = nums[i];
            if (pos >= length) length = pos;
        }
        System.out.println(length);
    }

    public static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] < target)
            return l + 1;
        else
            return l;
    }
}
