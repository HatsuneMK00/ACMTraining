package xyz.vjudge.contest325153;

import java.util.Scanner;

public class ProblemH {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum, m, i, M, n;
        m = 0;
        M = in.nextInt();
        while (m < M) {
            n = in.nextInt();
            for (i = 0, sum = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
            if (m != M-1) {
                System.out.println("");

            }
            m++;
        }
    }
}
