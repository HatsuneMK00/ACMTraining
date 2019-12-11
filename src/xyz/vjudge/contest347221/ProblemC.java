package xyz.vjudge.contest347221;

import java.util.Scanner;

/*
* ˵����
* 1����Ŀ����Ҫ����߲�һ����ˤ������˶���һ����n���¥�㣬�������n�β��ܱ�֤ȷ�����ˤ����¥��
* ��˵�һ��forѭ����ֵʱdp[1][i] = i
*
* 2�� ���۶��ٸ���¥��Ϊ1ʱ��ֻ��Ҫ����1�ξͿ��Եõ����ۣ�ע��ֻ��һ��Ҳ����Ҫ����1�εģ�
* ��˵ڶ���forѭ��Ϊdp[i][1] = 1��ֵ
*
* 3��������״̬������Ϊ2��¥����Ϊ2��ʼ����Ӧ������forѭ���ĵڶ���forѭ��
*
* 4������dp[i][j]��ʾi���򣬴���¥��Ϊj�����Ǵӵ�k����һ������ԣ�1<=k<j��
* ������ˣ������ת��Ϊ��dp[i-1][k-1]
* �����û���������ת��Ϊ��dp[i][j-k]
* ����ÿһ��(i,j)����һ���ȡ��k��ѡȡ��������е����ֵ����ȡ����k�е���Сֵ,��+1(�����һ��)
* ����dp[i][j]��ֵ
*
* 5�����dp�����ÿһ�е�ÿһ��ֵ�����ҽ���������һ���Լ���һ�������ڸ�Ԫ��ǰ������ֵ
* ����Ǵ�dp[2][2]��ʼ���ÿһ��������ֱ�������Ҫ���������
* ����һ�к͵�һ���Ǽ����⣬ֱ����Ⲣ�ҳ�ʼ����ֵ�ģ�˵���е���Ŀ1��2��
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
