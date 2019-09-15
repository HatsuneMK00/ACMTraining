package xyz.vjudge.contest325153;

import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum, i, n;
        while (in.hasNext()) {
            n = in.nextInt();
            for (i = 0, sum = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
