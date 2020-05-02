package xyz.leetcode.algorithmarray;

public class FindKthBiggestElement {
    public static void main(String[] args) {
        new FindKthBiggestElement().findKthLargest(new int[]{2,1}, 2);
    }
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int l = 0, r = length;
        int target = partition(nums, l, r);
        while (l < r && target != length - k) {
            if (target > length - k) {
                r = target;
            } else {
                l = target + 1;
            }
            target = partition(nums, l, r);
        }
        return nums[target];
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = start + 1;
        int temp;
        while (j < end) {
            if (nums[j] <= pivot) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        nums[start] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
