package xyz.leetcode;

//TODO 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
//        输入为空的情况一定要多注意
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = lowerBound(nums, 0, nums.length - 1, target);
        if (i >= nums.length || nums[i] != target) {
            return new int[]{-1, -1};
        }
        int j = upperBound(nums, 0, nums.length - 1, target);
        return new int[]{i, j};
    }

    public int upperBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        /* customized code for problem 15 */
        // return a invalid index if didn't find the element

        if(nums[l]>target){
            return l-1;
        }else{
            return l;
        }
    }

    public int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        /* customized code for problem 15 */
        // return a invalid index if didn't find the element

        if(nums[l]<target)
            return l+1;
        else
            return l;
    }
}
