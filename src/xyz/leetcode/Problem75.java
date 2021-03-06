package xyz.leetcode;

public class Problem75 {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int oneIndex = 0;
        int twoIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[oneIndex];
                nums[oneIndex] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex++;
                oneIndex++;
                twoIndex++;
            } else if (nums[i] == 1) {
                nums[i] = nums[oneIndex];
                nums[oneIndex] = 1;
                oneIndex++;
                twoIndex++;
            } else {
                nums[i] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex++;
            }
        }
    }
}
