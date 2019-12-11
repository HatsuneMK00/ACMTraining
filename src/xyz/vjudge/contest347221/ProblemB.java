package xyz.vjudge.contest347221;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x, y;
        int lengthX, lengthY;
        int[][] dp = new int[201][201];
        while (in.hasNext()) {
            x = in.next();
            y = in.next();
            lengthX = x.length();
            lengthY = y.length();
            for (int i = 1; i <= lengthX; i++) {
                for (int j = 1; j <= lengthY; j++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            System.out.println(dp[lengthX][lengthY]);
        }
    }
}
