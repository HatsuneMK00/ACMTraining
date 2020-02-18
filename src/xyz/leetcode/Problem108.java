package xyz.leetcode;

import java.rmi.dgc.VMID;

import static xyz.leetcode.Problem94.*;

//TOOL 将一个有序数组插入为一个平衡BST
public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursive(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBSTRecursive(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftChild = sortedArrayToBSTRecursive(nums, start, mid);
        TreeNode rightChild = sortedArrayToBSTRecursive(nums, mid + 1, end);
        node.left = leftChild;
        node.right = rightChild;
        return node;
    }

    //TOOL    向一个二叉搜索树插入一个节点
    public void insertIntoBST(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        if (node.val < root.val) insertIntoBST(root.left, node);
        else insertIntoBST(root.right, node);
    }
}
