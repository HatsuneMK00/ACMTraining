package xyz.leetcode;

import java.util.Arrays;

public class Problem31 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int num:nums
             ) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int last, i;
        last = nums.length - 1;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[last]) {
                int tempSwap;
                tempSwap = nums[i];
                nums[i] = nums[last];
                nums[last] = tempSwap;
                Arrays.sort(nums, i + 1, nums.length - 1);
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(nums);
        }
    }
}
