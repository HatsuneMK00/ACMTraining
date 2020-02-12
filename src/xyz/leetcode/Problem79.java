package xyz.leetcode;

//一道回溯法的题
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existRecursive(board, used, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existRecursive(char[][] board, boolean[][] used, String word, int wordIndex, int startI, int startJ) {
        boolean found = false;
        if (wordIndex >= word.length()) {
            found = true;
            return found;
        }
        if (startI < 0 || startI >= board.length || startJ < 0 || startJ >= board[0].length) {
            return false;
        }
        if (board[startI][startJ] == word.charAt(wordIndex) && !used[startI][startJ]) {
            used[startI][startJ] = true;
            found = existRecursive(board, used, word, wordIndex + 1, startI - 1, startJ);
            if (!found) {
                found = existRecursive(board, used, word, wordIndex + 1, startI + 1, startJ);
            }
            if (!found) {
                found = existRecursive(board, used, word, wordIndex + 1, startI, startJ - 1);
            }
            if (!found) {
                found = existRecursive(board, used, word, wordIndex + 1, startI, startJ + 1);
            }
            used[startI][startJ] = false;
        }
        return found;
    }
}
