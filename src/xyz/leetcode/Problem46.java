package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

//TOOL 给定一个没有重复数字的序列，返回其所有可能的全排列
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        return permuteRecursive(nums, nums.length);
    }

    public List<List<Integer>> permuteRecursive(int[] nums, int length) {
        if (length == 1) {
            List<Integer> integers = new ArrayList<>();
            integers.add(nums[0]);
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(integers);
            return lists;
        }
        List<List<Integer>> lists = permuteRecursive(nums, length - 1);
        List<List<Integer>> answer = new ArrayList<>();
        for (List<Integer> list : lists) {
            for (int i = 0; i < length - 1; i++) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(i, nums[length - 1]);
                answer.add(temp);
            }
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[length - 1]);
            answer.add(temp);
        }
        return answer;
    }
}
