package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        int[] tempMaxSum = new int[1];
        tempMaxSum[0] = Integer.MIN_VALUE;
        int maxPathSumRecursive = maxPathSumRecursive(root, tempMaxSum);
        return Math.max(maxPathSumRecursive, tempMaxSum[0]);
    }

//    tempMaxSum中暂存特殊情况的最大和（无法向上返回让父亲节点使用的情况 即路径中断的情况）
//    1. 根节点为负 此时它的两个孩子节点可能是最大值 而路径在根节点出结束
//    2. 根节点和左右孩子一起选择成为最大值的情况 此时路径也会在根节点结束
//    3. 否则选择大的一个子树 作为整棵树的可能最大值向上返回
//    最后比较暂存值和返回值 选大的那个
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
