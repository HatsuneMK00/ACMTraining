package xyz.leetcode;

//TODO 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[] existed = new boolean[10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (existed[board[i][j] - '0']) {
                        return false;
                    } else {
                        existed[board[i][j] - '0'] = true;
                    }
                }
            }
            for (int j = 0; j < 10; j++) {
                existed[j] = false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (existed[board[i][j] - '0']) {
                        return false;
                    } else {
                        existed[board[i][j] - '0'] = true;
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                existed[i] = false;
            }
        }
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3) {
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (board[i + ii][j + jj] != '.') {
                            if (existed[board[i + ii][j + jj] - '0']) {
                                return false;
                            } else {
                                existed[board[i + ii][j + jj] - '0'] = true;
                            }
                        }
                    }
                }
                for (int ii = 0; ii < 10; ii++) {
                    existed[ii] = false;
                }
            }
        }
        return true;
    }
}
