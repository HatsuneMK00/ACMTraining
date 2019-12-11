package xyz.vjudge.contest347221;

import java.util.Scanner;

/*
* 说明：
* 1、题目并不要求最高层一定会摔坏，因此对于一个球n层的楼层，必须测试n次才能保证确定最低摔坏的楼层
* 因此第一个for循环赋值时dp[1][i] = i
*
* 2、 不论多少个球，楼层为1时都只需要测试1次就可以得到结论（注意只有一层也是需要测试1次的）
* 因此第二个for循环为dp[i][1] = 1赋值
*
* 3、其他的状态从球数为2，楼层数为2开始，对应第三个for循环的第二层for循环
*
* 4、考虑dp[i][j]表示i个球，待测楼层为j，考虑从第k层扔一个球测试（1<=k<j）
* 如果球坏了，问题就转化为了dp[i-1][k-1]
* 如果球没坏，问题就转化为了dp[i][j-k]
* 对于每一个(i,j)遍历一遍可取的k，选取两种情况中的最大值，再取所有k中的最小值,再+1(多测了一次)
* 就是dp[i][j]的值
*
* 5、这个dp数组的每一行的每一个值依赖且仅依赖于上一行以及这一行所有在该元素前的所有值
* 因此是从dp[2][2]开始填充每一个子问题直到解决需要解决的问题
* 而第一行和第一列是简单问题，直接求解并且初始化赋值的（说明中的条目1和2）
*
* */
public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int id, floorNum, ballNum;
        int t, max = Integer.MAX_VALUE;
        int[][] dp = new int[51][1001];

        for (int i = 0; i < 1001; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i < 51; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i < p; i++) {
            id = in.nextInt();
            ballNum = in.nextInt();
            floorNum = in.nextInt();
            for (int l = 2; l <= ballNum; l++) {
                for (int j = 2; j <= floorNum; j++) {
                    for (int k = 1; k < j; k++) {
                        t = Math.max(dp[l - 1][k - 1], dp[l][j-k]);
                        max = Math.min(max, t);
                    }
                    dp[l][j] = max + 1;
                    max = Integer.MAX_VALUE;
                }
            }
            System.out.println(id + " " + dp[ballNum][floorNum]);
        }
    }
}
