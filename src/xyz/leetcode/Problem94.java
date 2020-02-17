package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

//TODO 给定一个二叉树，返回它的中序遍历
public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversalRecursive(root, nums);
        return nums;
    }

    public void inorderTraversalRecursive(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, nums);
        nums.add(root.val);
        inorderTraversalRecursive(root.right, nums);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
