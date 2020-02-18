package xyz.leetcode;

import java.util.Arrays;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean same = true;
        int i = 0;
        if (strs.length == 0) {
            return "";
        }
        while (same) {
            Character previousStrChar = null;
            for (String str : strs) {
                if (!(i < str.length())) {
                    same = false;
                    break;
                }
                if (previousStrChar != null && str.charAt(i) != previousStrChar) {
                    same = false;
                    break;
                }
                previousStrChar = str.charAt(i);
            }
            if (same) {
                stringBuilder.append(strs[0].charAt(i));
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
