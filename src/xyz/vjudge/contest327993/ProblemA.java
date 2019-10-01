package xyz.vjudge.contest327993;


import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, i;

        while (in.hasNext()) {
            n = in.nextInt();
            int[] nums = new int[n];
            m = in.nextInt();
            for (i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            for (i = n - 1; i >= n - m; i--) {
                System.out.print(nums[i]);
                if (i == n - m){
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }
    }
}
