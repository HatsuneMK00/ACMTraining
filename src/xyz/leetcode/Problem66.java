package xyz.leetcode;

import java.util.Arrays;

//TOOL ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ
public class Problem66 {
    //    ��������0�⣬������0��ͷ
    public int[] plusOne(int[] digits) {
        int plus = 0;
        int i = 1;
        int length = digits.length;
        digits[length - 1]++;
        if (digits[length - 1] >= 10) {
            plus = 1;
            digits[length - 1] -= 10;
        }
        while (plus > 0 && i < length) {
            digits[length - 1 - i]++;
            if (digits[length - 1 - i] >= 10) digits[length - 1 - i] -= 10;
            else plus = 0;
            i++;
        }
        if (plus == 1) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, length);
            return newDigits;
        }
        return digits;
    }
}
