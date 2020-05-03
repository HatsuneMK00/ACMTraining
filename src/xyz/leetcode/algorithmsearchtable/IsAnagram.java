package xyz.leetcode.algorithmsearchtable;

import java.util.HashMap;
import java.util.Map;

// 两个字符串是否是同字母异位词
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            count++;
            map.put(s.charAt(i), count);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) return false;
            if (map.get(t.charAt(i)) == 0) return false;
            int count = map.get(t.charAt(i));
            count--;
            map.put(t.charAt(i), count);
        }
        for (Integer value : map.values()) {
            if (value > 0) return false;
        }
        return true;
    }
}
