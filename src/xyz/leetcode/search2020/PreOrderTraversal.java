package xyz.leetcode.search2020;

import xyz.leetcode.search2020.IsSubTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = root;
        while (!stack.isEmpty() || r != null) {
            if (r != null) {
                result.add(r.val);
                stack.add(r);
                r = r.left;
            } else {
                r = stack.pop();
                r = r.right;
            }
        }
        return result;
    }
}
