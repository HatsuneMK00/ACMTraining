package xyz.leetcode;

public class Problem64 {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int gridRowNum = grid.length;
        int gridColNum = grid[0].length;
        int i, j;

        int[][] dp = new int[gridRowNum][gridColNum];
        for (i = 0; i < gridRowNum; i++) {
            for (j = 0; j < gridColNum; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else {
                        dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
                    }
                }
            }
        }
        return dp[gridRowNum - 1][gridColNum - 1];
    }

    private static int min(int a, int b){
        if(a < b){
            return a;
        }
        else{
            return b;
        }
    }
}
