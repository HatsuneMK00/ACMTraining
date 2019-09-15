package xyz.vjudge.contest325153;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, sum, n, i;
        while (true) {
            n = in.nextInt();
            if (n == 0) break;
            for (i = 0, sum = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
