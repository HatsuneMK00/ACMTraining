package xyz.leetcode;

public class Problem215 {
//    TOOL ѡ���㷨 �ҳ���k���Ԫ��
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

//    TOOL ���������е����黮���ӳ��� ����
    int partition(int[] nums, int start, int end) {
//        ��Ԫ����Ϊpivot
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
