package xyz.leetcode;

public class Problem130 {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            markAliveRecursive(board, 0, i);
            markAliveRecursive(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            markAliveRecursive(board, i, 0);
            markAliveRecursive(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void markAliveRecursive(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == 'A') {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = 'A';
            markAliveRecursive(board, row + 1, col);
            markAliveRecursive(board, row - 1, col);
            markAliveRecursive(board, row, col + 1);
            markAliveRecursive(board, row, col - 1);
        }
    }
}
