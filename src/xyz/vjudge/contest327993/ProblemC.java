package xyz.vjudge.contest327993;

import java.util.Scanner;

public class ProblemC {
    private static char[][] paintBoard;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int boxLength;
        while (n != -1) {
            boxLength = lengthFractalBox(n);
            paintBoard = new char[boxLength][boxLength];
            initPrintBoard(boxLength);
            drawFractalBox(n,0,0);
            drawPrintBoard(boxLength);
            System.out.println('-');
            n = in.nextInt();
        }
    }

    private static void drawFractalBox(int n, int r, int c) {
        if (n == 1) {
            paintBoard[r][c] = 'X';
            return;
        }
        int boxLength = lengthFractalBox(n - 1);
        drawFractalBox(n - 1, r, c);
        printNBlank(boxLength, r, c + boxLength);
        drawFractalBox(n - 1, r, c + 2 * boxLength);
        r += boxLength;
        printNBlank(boxLength,r,c);
        drawFractalBox(n-1,r,c+boxLength);
        r += boxLength;
        drawFractalBox(n - 1, r, c);
        printNBlank(boxLength, r, c + boxLength);
        drawFractalBox(n - 1, r, c + 2 * boxLength);
    }

    private static int lengthFractalBox(int n) {
        return (int) Math.pow(3, n - 1);
    }

    private static void printNBlank(int n, int r, int c) {
        for (int i = 0; i < n; i++) {
            paintBoard[r][c + i] = ' ';
        }
    }

    private static void initPrintBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paintBoard[i][j] = ' ';
            }
        }
    }

    private static void drawPrintBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(paintBoard[i][j]);
            }
            System.out.println();
        }
    }
}
