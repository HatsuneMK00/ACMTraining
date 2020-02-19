package xyz.leetcode;

import xyz.leetcode.Problem94.TreeNode;

//TOOL ��������ǰ������������� ������
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeRecursive(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeRecursive(int[] preorder, int pStart, int pEnd,
                                   int[] inorder, int inStart, int inEnd) {
        if (inEnd - inStart == 1) {
            return new TreeNode(inorder[inStart]);
        }
        if (inEnd - inStart == 0) {
            return null;
        }
        int rootIndex = inStart;
        int rootVal = preorder[pStart];
        for (int i = inStart; i < inEnd; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = buildTreeRecursive(preorder, pStart + 1, pEnd, inorder, inStart, rootIndex);
//        ע������ĺ��壡 pStartָ������������Ŀ�ʼ Ҳ����˵��ԭ����pStart����������������Ԫ������rootIndex - instart����1�����ڵ㣩
        TreeNode right = buildTreeRecursive(preorder, pStart + rootIndex - inStart + 1, pEnd, inorder, rootIndex + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
