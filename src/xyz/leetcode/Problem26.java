package xyz.leetcode;

import java.util.Arrays;

public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        int newLength = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
            else {
                nums[newLength] = nums[i];
                newLength++;
            }
        }
        return newLength;
    }
}
