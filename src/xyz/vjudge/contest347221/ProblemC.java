package xyz.vjudge.contest347221;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int id, floorNum, ballNum;
        int t, max = Integer.MAX_VALUE;
        int[][] dp = new int[51][1001];

//        for (int i = 0; i < 1001; i++) {
//            for (int j = 0; j < 51; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
        for (int i = 0; i < 1001; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i < 51; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i < p; i++) {
            id = in.nextInt();
            ballNum = in.nextInt();
            floorNum = in.nextInt();
            for (int l = 2; l <= ballNum; l++) {
                for (int j = 2; j <= floorNum; j++) {
                    for (int k = 1; k < j; k++) {
                        t = Math.max(dp[l - 1][k - 1], dp[l][j-k]);
                        max = Math.min(max, t);
                    }
                    dp[l][j] = max + 1;
                    max = Integer.MAX_VALUE;
                }
            }
            System.out.println(dp[floorNum][ballNum]);
        }
    }
}
