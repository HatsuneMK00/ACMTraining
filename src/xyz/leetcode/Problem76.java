package xyz.leetcode;

import java.util.HashMap;

public class Problem76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        int lengthT = t.length();
        int lengthS = s.length();
        for (int i = 0; i < lengthT; i++) {
            Integer count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int need = 0;
        int winStart = 0;
        int winEnd = 0;
        int winLength = lengthS + 1;
        while (left <= right) {
            if (need == lengthT) {
                if (right - left < winLength) {
                    winLength = right - left;
                    winStart = left;
                    winEnd = right;
                }
                if (windowMap.containsKey(s.charAt(left))) {
                    if (windowMap.get(s.charAt(left)) <= tMap.get(s.charAt(left))) {
                        need--;
                    }
                    windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                }
                left++;
            } else {
                if (right == lengthS) {
                    break;
                }
                if (tMap.containsKey(s.charAt(right))) {
                    if (windowMap.getOrDefault(s.charAt(right), 0) < tMap.get(s.charAt(right))) {
                        need++;
                    }
                    windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }
        }
        return s.substring(winStart, winEnd);
    }
}
