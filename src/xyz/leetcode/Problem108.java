package xyz.leetcode;

import java.rmi.dgc.VMID;

import static xyz.leetcode.Problem94.*;

//TOOL ��һ�������������Ϊһ��ƽ��BST
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

    //TOOL    ��һ����������������һ���ڵ�
    public void insertIntoBST(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        if (node.val < root.val) insertIntoBST(root.left, node);
        else insertIntoBST(root.right, node);
    }
}
