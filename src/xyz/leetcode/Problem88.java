package xyz.leetcode;

//TOOL 合并两个有序数组
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[l++] = nums1[i++];
            } else {
                nums[l++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[l++] = nums1[i++];
        }
        while (j < n) {
            nums[l++] = nums2[j++];
        }
        System.arraycopy(nums, 0, nums1, 0, nums.length);
    }
}
