package xyz.leetcode;

public class Problem7 {
    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.reverse(1534236469));
    }

    public int reverse(int x) {
        String xString = Integer.toString(x);
        if (x < 0) {
            xString = xString.substring(1);
            xString = xString.concat("-");
        }
        StringBuffer stringBuffer = new StringBuffer(xString);
        stringBuffer.reverse();
        try {
            return Integer.parseInt(stringBuffer.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
