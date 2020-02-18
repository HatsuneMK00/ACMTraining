package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.List;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        return inorderTraversalRecursive(root);
    }

    public int inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = inorderTraversalRecursive(root.left);
        int rightDepth = inorderTraversalRecursive(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
