package xyz.leetcode;

public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result, i, oneCount;
        result = 0;
        for (i = 0, oneCount = 0; i < nums.length; i++) {
            if (nums[i] == 1) oneCount++;
            else oneCount = 0;
            if (oneCount > result) result = oneCount;
        }
        return result;
    }
}
