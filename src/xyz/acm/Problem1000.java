package xyz.acm;

import java.util.Scanner;

public class Problem1000 {
    public static void main(String[] args) {
        int a, b;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
