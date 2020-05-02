package xyz.leetcode.algorithmsearchtable;

import java.awt.print.PrinterGraphics;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] answer = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            answer[i] = integer;
            i++;
        }
        return answer;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            int count = map1.getOrDefault(num, 0);
            count++;
            map1.put(num, count);
        }
        for (int num : nums2) {
            int count = map2.getOrDefault(num, 0);
            count++;
            map2.put(num, count);
        }

        HashMap<Integer, Integer> record = new HashMap<>();
        int length = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                record.put(key, Math.min(map1.get(key), map2.get(key)));
                length += record.get(key);
            }
        }
        int[] answer = new int[length];
        int i = 0;
        for (Integer key : record.keySet()) {
            int count = record.get(key);
            while (count > 0) {
                answer[i] = key;
                i++;
                count--;
            }
        }
        return answer;
    }
}
