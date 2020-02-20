package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        int[] tempMaxSum = new int[1];
        tempMaxSum[0] = Integer.MIN_VALUE;
        int maxPathSumRecursive = maxPathSumRecursive(root, tempMaxSum);
        return Math.max(maxPathSumRecursive, tempMaxSum[0]);
    }

//    tempMaxSum���ݴ�������������ͣ��޷����Ϸ����ø��׽ڵ�ʹ�õ���� ��·���жϵ������
//    1. ���ڵ�Ϊ�� ��ʱ�����������ӽڵ���������ֵ ��·���ڸ��ڵ������
//    2. ���ڵ�����Һ���һ��ѡ���Ϊ���ֵ����� ��ʱ·��Ҳ���ڸ��ڵ����
//    3. ����ѡ����һ������ ��Ϊ�������Ŀ������ֵ���Ϸ���
//    ���Ƚ��ݴ�ֵ�ͷ���ֵ ѡ����Ǹ�
    public int maxPathSumRecursive(TreeNode root, int[] tempMaxSum) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftPathSum = maxPathSumRecursive(root.left, tempMaxSum);
        int rightPathSum = maxPathSumRecursive(root.right, tempMaxSum);
        if (root.val < 0) {
            tempMaxSum[0] = Math.max(tempMaxSum[0], leftPathSum);
            tempMaxSum[0] = Math.max(tempMaxSum[0], rightPathSum);
        }
        tempMaxSum[0] = Math.max(tempMaxSum[0], root.val + Math.max(leftPathSum, 0) + Math.max(rightPathSum, 0));
        int pathSum = root.val;
        pathSum += (Math.max(Math.max(leftPathSum, rightPathSum), 0));
        return pathSum;
    }
}
