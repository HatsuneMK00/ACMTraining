package xyz.leetcode;

public class Problem189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[(i + k) % length] = nums[i];
        }
        System.arraycopy(ints, 0, nums, 0, length);
    }
}
