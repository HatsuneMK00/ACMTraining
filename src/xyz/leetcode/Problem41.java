package xyz.leetcode;

//TOOL 给定一个未排序的整数数组，找出其中没有出现的最小的正整数 算法的时间复杂度应为O(n)
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) return 1;
//        预处理
//        把所有无效值 0，复数都变成1 确保1出现在原数组中
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }

//        使用正负号作为存储信息的媒介 保存数字是否出现的信息 不需要保存n+1以上的值
//        使用数值信息的时候不关心正负
        for (int i = 0; i < length; i++) {
            if (Math.abs(nums[i]) <= length && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

//        对数组的正负号信息（相当于布尔数组）进行迭代
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
