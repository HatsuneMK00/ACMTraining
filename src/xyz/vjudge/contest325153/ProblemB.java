package xyz.vjudge.contest325153;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b,n,N;
        n = 0;
        N = in.nextInt();
        while(n < N){
            a = in.nextInt();
            b = in.nextInt();
            n++;
            System.out.println(a + b);
        }
    }
}
