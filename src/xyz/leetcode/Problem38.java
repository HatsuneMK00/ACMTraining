package xyz.leetcode;

public class Problem38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        str = str.concat(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                stringBuilder.append(Integer.toString(count));
                stringBuilder.append(str.charAt(i - 1));
                count = 1;
            }
        }
        return stringBuilder.toString();
    }
}
