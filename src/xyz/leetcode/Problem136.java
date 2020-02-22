package xyz.leetcode;

import java.util.HashMap;

public class Problem136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }
        return -1;
    }
}
