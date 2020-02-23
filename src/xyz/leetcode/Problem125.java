package xyz.leetcode;

// TOOL 判断字符串是否是回文
public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        boolean isPalindrome = true;
        while (start <= end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }
}
