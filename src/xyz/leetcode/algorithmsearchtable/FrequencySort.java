package xyz.leetcode.algorithmsearchtable;

import java.util.Arrays;

//���ַ��������ַ�����Ƶ�ʽ�������
public class FrequencySort {
    public String frequencySort(String s) {
        char[] sb = new char[s.length()];
//        ����ascii����32-127���ַ� �����еĿ���ʾ�ַ�
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
