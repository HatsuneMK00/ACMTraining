package xyz.leetcode;

public class Problem10 {
    private static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        int i = 0, j = 0;
        boolean dp[][] = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (i = 0; i <= sLength; i++) {
            for (j = 1; j <= pLength; j++) {
                if (i >= 1 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*' && j >= 2) {
                    if (i >= 1 && s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
                        if (i >= 1) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp[sLength][pLength];
    }
}
