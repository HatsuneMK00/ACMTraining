package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

//TODO 给定一个没有重复数字的序列，返回其所有可能的全排列
public class Problem46 {
    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        int[] ints = {1, 2, 3};
        System.out.println(problem46.permute(ints));
    }
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
