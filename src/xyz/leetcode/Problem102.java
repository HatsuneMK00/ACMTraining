package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TOOL 返回树的层次遍历结果 结果为二维数组 按层划分
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
