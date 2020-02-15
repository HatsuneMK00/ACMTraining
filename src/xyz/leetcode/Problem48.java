package xyz.leetcode;

//TODO ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ�񡣽�ͼ��˳ʱ����ת 90 �ȡ�������ԭ����ת
public class Problem48 {
    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {4, 5, 6};
        int[] ints3 = {7, 8, 9};
        int[][] ints = new int[3][3];
        ints[0] = ints1;
        ints[1] = ints2;
        ints[2] = ints3;
        Problem48 problem48 = new Problem48();
        problem48.rotate(ints);
    }

    public void rotate(int[][] matrix) {
        rotateRecursive(matrix, 0, 0, matrix.length);
    }

//    rowΪ�п�ʼ���� colΪ�п�ʼ����
    public void rotateRecursive(int[][] matrix, int row, int col, int size) {
        if (size == 1) {
            return;
        }
        if (size == 2) {
            int temp = matrix[row][col + 1];
            matrix[row][col + 1] = matrix[row][col];
            matrix[row][col] = matrix[row + 1][col];
            matrix[row + 1][col] = matrix[row + 1][col + 1];
            matrix[row + 1][col + 1] = temp;
            return;
        }
        rotateRecursive(matrix, row + 1, col + 1, size - 2);
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = matrix[row][col + i];
        }
//        �ϲ���
        for (int i = 0; i < size; i++) {
            matrix[row][col + size - 1 - i] = matrix[row + i][col];
        }
//        �����
        for (int i = 0; i < size; i++) {
            matrix[row + i][col] = matrix[row + size - 1][col + i];
        }
//        �²���
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                matrix[row + size - 1][col + i] = temp[size - 1];
            } else {
                matrix[row + size - 1][col + i] = matrix[row + size - 1 - i][col + size - 1];
            }
        }
//        �Ҳ���
        for (int i = 0; i < size; i++) {
            matrix[row + i][col + size - 1] = temp[i];
        }
    }
}
