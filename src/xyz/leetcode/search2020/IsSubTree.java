package xyz.leetcode.search2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsSubTree {
    Set<TreeNode> accessed = new HashSet<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode node = findNode(s, t);
        List<Integer> preOrderS = new ArrayList<>();
        List<Integer> inOrderS = new ArrayList<>();
        List<Integer> preOrderT = new ArrayList<>();
        List<Integer> inOrderT = new ArrayList<>();
        boolean same = false;
        while (node != null && !same) {
            accessed.add(node);
            preOrderTraverse(node, preOrderS);
            preOrderTraverse(t, preOrderT);
            inOrderTraverse(node, inOrderS);
            inOrderTraverse(t, inOrderT);
            same = sameTree(preOrderS, preOrderT, inOrderS, inOrderT);
            node = findNode(s, t);
            preOrderS.clear();
            inOrderS.clear();
            preOrderT.clear();
            inOrderT.clear();
        }
        return same;
    }

    public boolean sameTree(List<Integer> preOrderS,
                            List<Integer> preOrderT,
                            List<Integer> inOrderS,
                            List<Integer> inOrderT) {
        if (preOrderS.size() != preOrderT.size()) return false;
        for (int i = 0; i < preOrderS.size(); i++) {
            if (!preOrderS.get(i).equals(preOrderT.get(i))) return false;
        }
        for (int i = 0; i < inOrderS.size(); i++) {
            if (!inOrderS.get(i).equals(inOrderT.get(i))) return false;
        }
        return true;
    }

    public void preOrderTraverse(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }
        order.add(root.val);
        preOrderTraverse(root.left, order);
        preOrderTraverse(root.right, order);
    }

    public void inOrderTraverse(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, order);
        order.add(root.val);
        inOrderTraverse(root.right, order);
    }

    public TreeNode findNode(TreeNode root, TreeNode target) {
        if (root == null) return null;
        if (root.val == target.val) {
            if (!accessed.contains(root)) return root;
        }
        TreeNode node = findNode(root.left, target);
        if (node == null) {
            node = findNode(root.right, target);
        }
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
