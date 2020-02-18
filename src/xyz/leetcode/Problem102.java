package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nums = new ArrayList<>();
        preOrderTraversal(root, 0, nums);
        return nums;
    }

    public void preOrderTraversal(TreeNode root, int depth, List<List<Integer>> nums) {
        if (root == null) {
            return;
        }
        if (nums.size() <= depth) {
            nums.add(new ArrayList<Integer>());
        }
        nums.get(depth).add(root.val);
        preOrderTraversal(root.left, depth + 1, nums);
        preOrderTraversal(root.right, depth + 1, nums);
    }
}
