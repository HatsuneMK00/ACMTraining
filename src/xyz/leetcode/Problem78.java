package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsRecursive(nums, nums.length);
    }

    public List<List<Integer>> subsetsRecursive(int[] nums, int length) {
        if (length == 0) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        List<List<Integer>> lists = subsetsRecursive(nums, length - 1);
        List<List<Integer>> newLists = new ArrayList<>(lists);
        for (List<Integer> list : lists) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[length - 1]);
            newLists.add(temp);
        }
        return newLists;
    }
}
