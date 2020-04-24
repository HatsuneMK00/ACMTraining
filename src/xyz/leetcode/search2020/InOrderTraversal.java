package xyz.leetcode.search2020;

import xyz.leetcode.search2020.IsSubTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
//    TOOL 迭代实现的中序遍历 递归 -> 迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode r = root;
        while(!stack.isEmpty() || r != null) {
            if (r != null) {
                stack.add(r);
                r = r.left;
            } else {
                r = stack.pop();
                result.add(r.val);
                r = r.right;
            }
        }
        return result;
    }
}
