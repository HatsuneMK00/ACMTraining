package xyz.leetcode;

public class Problem202 {
    public boolean isHappy(int n) {
        int slowN = n;
        int fastN = squareSum(n);
        int i = 0;
        while (fastN != slowN) {
            if (i % 2 == 1) {
                slowN = squareSum(slowN);
            }
            fastN = squareSum(fastN);
            i++;
        }
        if (fastN == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
