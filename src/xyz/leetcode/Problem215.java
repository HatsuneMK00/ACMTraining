package xyz.leetcode;

public class Problem215 {
//    TOOL 选择算法 找出第k大的元素
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestRecursive(nums, 0, nums.length, k);
    }

    public int findKthLargestRecursive(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot + 1 == k) {
            return nums[pivot];
        }
        if (pivot + 1 > k) {
            return findKthLargestRecursive(nums, start, pivot, k);
        } else {
            return findKthLargestRecursive(nums, pivot + 1, end, k);
        }
    }

//    TOOL 快速排序中的数组划分子程序 降序
    int partition(int[] nums, int start, int end) {
//        首元素作为pivot
        int pivot = nums[start];
        int i = start;
        int j;
        int temp;
        for (j = start + 1; j < end; j++) {
            if (nums[j] > pivot) {
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
        return i;
    }
}
