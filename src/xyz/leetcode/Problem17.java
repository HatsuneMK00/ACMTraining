package xyz.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem17 {
    static HashMap<Character, List<String>> keyMap = new HashMap<>();

    static {
        keyMap.put('2', List.of("a", "b", "c"));
        keyMap.put('3', List.of("d", "e", "f"));
        keyMap.put('4', List.of("g", "h", "i"));
        keyMap.put('5', List.of("j", "k", "l"));
        keyMap.put('6', List.of("m", "n", "o"));
        keyMap.put('7', List.of("p", "q", "r", "s"));
        keyMap.put('8', List.of("t", "u", "v"));
        keyMap.put('9', List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        if (digits.length() == 1) {
            return new ArrayList<>(keyMap.get(digits.charAt(0)));
        }
        int length = digits.length();
        List<String> list = letterCombinations(digits.substring(0, length - 1));
        List<String> newList = new ArrayList<>();

        for (String item : list) {
            for (String key: keyMap.get(digits.charAt(length - 1))) {
                newList.add(item.concat(key));
            }
        }

        return newList;
    }
}
