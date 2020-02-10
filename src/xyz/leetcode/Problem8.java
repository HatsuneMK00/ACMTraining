package xyz.leetcode;

public class Problem8 {
    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        System.out.println(Integer.parseInt("+42"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(0) != '-' && str.charAt(0) != '+' && !Character.isDigit(str.charAt(0))) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (!Character.isDigit(str.charAt(0))) {
            i = 1;
            stringBuilder.append(str.charAt(0));
        }
        for (; i < length; i++) {
            if (Character.isDigit(str.charAt(i))) {
                stringBuilder.append(str.charAt(i));
            } else {
                break;
            }
        }
        String s = stringBuilder.toString();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            if (s.charAt(0) == '-') {
//                可能是只有一个'-'或一个'+'，没有任何数字导致的抛错 而不是溢出
                if (s.length() == 1) {
                    return 0;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (s.length() == 1) {
                    return 0;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
    }
}
