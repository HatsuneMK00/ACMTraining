package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversalRecursive(root, nums, 0);
        boolean isSymmetric = true;
        int length = nums.size();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 0) {
            return false;
        }

        for (int i = 0; i < length / 2; i++) {
            if (nums.get(i) != nums.get(length - 1 - i)) {
                isSymmetric = false;
                break;
            }
        }
        return isSymmetric;
    }

    public void inorderTraversalRecursive(TreeNode root, List<Integer> nums, int depth) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, nums, depth + 1);
        nums.add(root.val * (depth % 2 == 0 ? 1 : -1));
        inorderTraversalRecursive(root.right, nums, depth + 1);
    }
}
