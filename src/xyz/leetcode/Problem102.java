package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TOOL �������Ĳ�α������ ���Ϊ��ά���� ���㻮�� ʹ�ù������ ��������
// ע���α������ܸ�Ӧ���ù������������д
// ǰ�к������������������������
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
                level = traverseAndGetLevel(queue1, queue2, result, level);
            } else {
                level = traverseAndGetLevel(queue2, queue1, result, level);
            }
        }
        return result;
    }

    private int traverseAndGetLevel(Queue<TreeNode> queue1, Queue<TreeNode> queue2, List<List<Integer>> result, int level) {
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            result.get(level).add(node.val);
            if (node.left != null) queue2.add(node.left);
            if (node.right != null) queue2.add(node.right);
        }
        level++;
        return level;
    }
}
