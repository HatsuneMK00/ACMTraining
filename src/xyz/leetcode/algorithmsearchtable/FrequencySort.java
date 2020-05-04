package xyz.leetcode.algorithmsearchtable;

import java.util.Arrays;

//将字符串按照字符出现频率降序排序
public class FrequencySort {
    public String frequencySort(String s) {
        char[] sb = new char[s.length()];
//        包含ascii表上32-127的字符 即所有的可显示字符
        int[] counts = new int[96];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - ' '] += 100;
        }
        Arrays.sort(counts);
        int j = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            int code = counts[i] % 100;
            while (counts[i] >= 100) {
                sb[j] = (char) (' ' + code);
                j++;
                counts[i] -= 100;
            }
        }
        return String.valueOf(sb);
    }
}
