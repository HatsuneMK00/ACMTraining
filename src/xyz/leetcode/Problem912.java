package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;


public class Problem912 {
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

//    TOOL 快速排序中的数组划分子程序 升序
    int partition(int[] nums, int start, int end) {
//        首元素作为pivot
        int pivot = nums[start];
        int i = start;
        int j;
        int temp;
        for (j = start + 1; j < end; j++) {
            if (nums[j] < pivot) {
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

    void quickSort(int[] nums, int start, int end) {
        int length = end - start;
        if (length <= 1) {
            return;
        }
        int x = partition(nums, start, end);
        quickSort(nums, start, x);
        quickSort(nums, x + 1, end);
    }
}
