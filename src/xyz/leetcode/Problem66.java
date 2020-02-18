package xyz.leetcode;

import java.util.Arrays;

//TOOL 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
public class Problem66 {
    //    除了整数0外，不会以0开头
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
