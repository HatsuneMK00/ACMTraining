package xyz.vjudge.contest327993;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int i, k, n;
        for (i = 0; i < t; i++) {
            n = in.nextInt();
            k = in.nextInt();
            System.out.println(fiboString(k, n));
        }
    }

    private static char fiboString(int k, int i) {
        if (i == 2) {
            if (k == 1) return 'a';
            else return 'b';
        } else if (i == 1) return 'b';
        else if (i == 0) return 'a';

        int temp = fibo(i - 2);
        char answer;
        if (k <= temp) {
            answer = fiboString(k, i - 2);
        } else {
            answer = fiboString(k - temp, i - 1);
        }
        return answer;
    }

    private static int fibo(int n) {
        int a0 = 1;
        int a1 = 1;
        int answer = a0 + a1;
        int i = 0;
        if (n == 0) return a0;
        else if (n == 1) return a1;
        else {
            for (i = 0; i < n - 2; i++) {
                a0 = a1;
                a1 = answer;
                answer = a0 + a1;
            }
        }
        return answer;
    }
}
