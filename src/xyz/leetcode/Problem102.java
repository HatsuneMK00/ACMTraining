package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TOOL �������Ĳ�α������ ���Ϊ��ά���� ���㻮�� �ڲ�ʹ����ǰ�����
// ע���α������ܸ�Ӧ���ù������������д
// ǰ�к������������������������
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nums = new ArrayList<>();
        preOrderTraversal(root, 0, nums);
        return nums;
    }

//    TOOL ����һ�������� ǰ�������
    public void preOrderTraversal(TreeNode root, int depth, List<List<Integer>> nums) {

    }
}
