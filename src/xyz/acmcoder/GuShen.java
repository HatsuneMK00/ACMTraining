package xyz.acmcoder;

import java.util.Scanner;

public class GuShen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, i = 0, answer = 0;
        while (in.hasNextInt()) {
            n = in.nextInt();
            while (((i + 3) * i) <= ((n - 1) * 2)) {
                i++;
            }
            i--;
            answer += (1 + (i - 1) * i / 2 + (n - 1 - ((3 + i) * i / 2)));
            System.out.println(answer);
            answer = 0;
            i = 0;
        }
    }
}
