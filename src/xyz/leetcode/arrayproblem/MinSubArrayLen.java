package xyz.leetcode.arrayproblem;

public class MinSubArrayLen {

//    最小满足和>=s的子数组
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int length = nums.length;
        int minLength = length + 1;
        int sum = 0;
        while (true) {
            if (sum < s) {
                right++;
                if (right < length) {
                    sum += nums[right];
                } else {
                    break;
                }
            } else {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength > length ? 0 : minLength;
    }
}
