package xyz.leetcode;

public class Problem42 {
    public static void main(String[] args) {
        Problem42 problem42 = new Problem42();
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(problem42.trap(ints));
    }

    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int max = height[0];
        for (int i : height) {
            max = Math.max(max, i);
        }
        int trap = length * max;
        trap -= trim(height, max);
        for (int i = 0; i < length; i++) {
            trap -= height[i];
        }
        return trap;
    }

    public int trim(int[] nums, int max) {
        int count = 0;
        int total = 0;
        int currentHeight = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentHeight < nums[i]) {
                count++;
                total += (count * (max - currentHeight));
                currentHeight = nums[i];
                count = 0;
            } else {
                count++;
            }
        }
        count = 0;
        currentHeight = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > currentHeight) {
                count++;
                total += (count * (max - currentHeight));
                currentHeight = nums[i];
                count = 0;
            } else {
                count++;
            }
        }
        return total;
    }
}
