package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if (depth % 2 == 0) {
            nums.get(depth).add(root.val);
        } else {
            nums.get(depth).add(0, root.val);
        }
        preOrderTraversal(root.left, depth + 1, nums);
        preOrderTraversal(root.right, depth + 1, nums);
    }
}
