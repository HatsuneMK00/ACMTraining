package xyz.leetcode;

import java.util.HashSet;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (Integer integer : set) {
//            这个思路非常巧妙
//            我们只考虑integer - 1不在set中的情况 因为如果在的话 包含integer的连续序列会在这个序列最小值的时候被计算一遍 因此不需要考虑integer了
//            并且这个算法是线性复杂度
//            虽然有两层循环 但是内层循环只在出现了一个连续序列的最小值的时候才会执行
//            而这样的连续序列的长度的和最多也只有n
//            因此内部的代码只执行n次
            if (!set.contains(integer - 1)) {
                int current = integer;
                int tempLength = 0;
                while (set.contains(current)) {
                    current++;
                    tempLength++;
                }
                maxLength = Math.max(maxLength, tempLength);
            }
        }
        return maxLength;
    }
}
