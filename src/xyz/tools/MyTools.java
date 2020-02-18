package xyz.tools;

import java.util.Arrays;

public class MyTools {
//    TOOL upperbound����
    // �ҵ�һ�����ϸ�����������С�ڵ���target�����ֵ����
    // ���û���ҵ�����Ҫ���Ԫ�� ��᷵��-1
    // lΪ������ʼ������rΪ�����������
    private static int upperBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        // return a invalid index if didn't find the element

        if(nums[l]>target){
            return l-1;
        }else{
            return l;
        }
    }

//    TOOL lowerbound����
    // �ҵ�һ�����ϸ����������ڴ��ڵ���target����Сֵ����
    // ���û���ҵ�����Ҫ���Ԫ�� ��᷵��nums.length
    // lΪ������ʼ������rΪ�����������
    private static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        if(nums[l]<target)
            return l+1;
        else
            return l;
    }


//    TOOL ����ַ�����counting sort����
    //    ʹ�ü���������ַ����е��ַ������������򣬷���һ���µ��ַ���
    private static String countSort(String string) {
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
