package xyz.leetcode;

public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] profits = new int[prices.length - 1];
        for (int i = 0; i < profits.length; i++) {
            profits[i] = prices[i + 1] - prices[i];
        }
        int count = 0;
        for (int i = 0; i < profits.length; i++) {
            if (profits[i] > 0) {
                count += profits[i];
            }
        }
        return count;
    }
}
