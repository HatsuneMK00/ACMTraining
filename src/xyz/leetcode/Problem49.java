package xyz.leetcode;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = countSort(str);
            if (map.containsKey(sortedStr)) {
                List<String> strings = map.get(sortedStr);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(sortedStr, strings);
            }
        }
        return new ArrayList<>(map.values());
    }

//    使用计数排序对字符串中的字符按照升序排序，返回一个新的字符串
    public String countSort(String string) {
        int[] b = new int[26];
        int length = string.length();
        for (int i = 0; i < length; i++) {
            b[string.charAt(i) - 'a']++;
        }
        for (int i = 1; i < 26; i++) {
            b[i] += b[i - 1];
        }
        char[] newStr = new char[length];
        for (int i = length - 1; i >= 0; i--) {
            int currentCharVal = string.charAt(i) - 'a';
            b[currentCharVal]--;
            newStr[b[currentCharVal]] = string.charAt(i);
        }
        return Arrays.toString(newStr);
    }

}
