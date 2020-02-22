package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    public static void main(String[] args) {
        Problem51 problem51 = new Problem51();
        System.out.println(problem51.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new StringBuilder().append(".".repeat(n)));
        }
        solveNQueensRecursive(n, answer, 0, board);
        return answer;
    }

    private void solveNQueensRecursive(int n, List<List<String>> answer, int row, List<StringBuilder> board) {
        if (row == n) {
            List<String> boardString = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boardString.add(board.get(i).toString());
            }
            answer.add(boardString);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isCollision(row, i, board)) {
                board.get(row).replace(i, i + 1, "Q");
                solveNQueensRecursive(n, answer, row + 1, board);
                board.get(row).replace(i, i + 1, ".");
            }
        }
    }

    boolean isCollision(int queenI, int queenJ, List<StringBuilder> board) {
//        row check
        StringBuilder rowI = board.get(queenI);
        for (int i = 0; i < rowI.length(); i++) {
            if (rowI.charAt(i) == 'Q') {
                return true;
            }
        }
//        column check
        for (StringBuilder row : board) {
            if (row.charAt(queenJ) == 'Q') {
                return true;
            }
        }
//        斜着的check
//        斜率为正的那条线check
        int n = board.size();
        for (int i = 0; i < n; i++) {
            int startI = 0;
            int startJ = queenJ + queenI;
            if (startJ - i < n && startJ - i >= 0) {
                if (board.get(startI + i).charAt(startJ - i) == 'Q') {
                    return true;
                }
            }
        }
//        斜率为负的那条线check
        for (int i = 0; i < n; i++) {
            int startI = 0;
            int startJ = queenJ - queenI;
            if (startJ + i >= 0 && startJ + i < n) {
                if (board.get(startI + i).charAt(startJ + i) == 'Q') {
                    return true;
                }
            }
        }
        return false;
    }
}
