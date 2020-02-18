package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversalRecursive(root, nums);
        boolean valid = true;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) >= nums.get(i)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public void inorderTraversalRecursive(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, nums);
        nums.add(root.val);
        inorderTraversalRecursive(root.right, nums);
    }
}
