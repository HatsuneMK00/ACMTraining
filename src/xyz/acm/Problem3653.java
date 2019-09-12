package xyz.acm;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Problem3653 {
    public static void main(String []args) throws IOException {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        String problemS = in.nextLine();
        int problemNum = in.nextInt();
        int t = 0;
        while (t<problemNum) {
            int problemN = in.nextInt();
            BigInteger problemNBigInt = BigInteger.valueOf(problemN);
            String problemEnd = in.nextLine().trim();

            System.out.println(solution(problemS,problemEnd,problemN));
            t++;
        }

    }

    private static long solution(String s, String end, int n) {
        int sLength = s.length();
        int[] db1 = new int[sLength + 1];
        long[] db2 = new long[sLength + 1];
        int i = 0;
        long sum = 0;

        for (i = sLength - 1; i >= 0; i--) {
            if (end.charAt(1) == s.charAt(i)) {
                db1[i] = db1[i + 1] + 1;
            } else {
                db1[i] = db1[i + 1];
            }
        }
        for (i = 0; i < sLength; i++) {
            if(end.charAt(0) == s.charAt(i)){
                if(end.charAt(0) != end.charAt(1)){
                    db2[i] = db1[i] * C(i, n-2);
                }
                else{
                    db2[i] = (db1[i] - 1) * C(i, n-2);
                }
            }
        }
        for (i = 0;i<sLength;i++) {
            sum += db2[i];
        }
        return sum;
    }

    private static long C(int n, int m)// 应用组合数的互补率简化计算量
    {
        if(n<m){
            return 0;
        }
        int half = n / 2;
        if (m > half)
        {
            m = n - m;
        }
        long numerator = A(n, m);
        long denominator = A(m, m);
        return (numerator / denominator) % 1000000007;
    }

    private static long A(int n, int m)
    {
        long result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--)
        {

//            is this right??
            result = result * (n % 1000000007);
            n--;// 下一次减一
        }
        return result % 1000000007;
    }
}

