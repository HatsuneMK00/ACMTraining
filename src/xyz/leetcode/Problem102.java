package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TOOL 返回树的层次遍历结果 结果为二维数组 按层划分 使用广度优先 两个队列
// 注意层次遍历可能更应该拿广度优先搜索来写
// 前中后序搜索都属于深度优先搜索
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level = 0;
        queue1.add(root);
        while (!(queue1.isEmpty() && queue2.isEmpty())) {
            result.add(new ArrayList<>());
            if (level % 2 == 0) {
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    result.get(level).add(node.val);
                    if (node.left != null) queue2.add(node.left);
                    if (node.right != null) queue2.add(node.right);
                }
                level++;
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    result.get(level).add(node.val);
                    if (node.left != null) queue1.add(node.left);
                    if (node.right != null) queue1.add(node.right);
                }
                level++;
            }
        }
        return result;
    }
}
