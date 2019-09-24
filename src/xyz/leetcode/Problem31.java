package xyz.leetcode;

import java.util.Arrays;

public class Problem31 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int num : nums
        ) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int j, i, minIndex, min;
        min = Integer.MAX_VALUE;
        for (j = nums.length - 2; j >= 0; j--) {
            for (i = j + 1, minIndex = -1; i < nums.length; i++) {
                if (nums[i] > nums[j] && nums[i] < min) {
                    minIndex = i;
                    min = nums[minIndex];
                }
            }
            if (minIndex != -1) {
                int tempSwap;
                tempSwap = nums[minIndex];
                nums[minIndex] = nums[j];
                nums[j] = tempSwap;
                Arrays.sort(nums, j + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
