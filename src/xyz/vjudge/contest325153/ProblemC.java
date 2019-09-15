package xyz.vjudge.contest325153;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, n, N;
        while (true) {
            a = in.nextInt();
            b = in.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
