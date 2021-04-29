package questions.Backtracking;

import java.util.Arrays;

public class TheKnightsTourProblem {
//    Q - https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
    int dRow[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int dCol[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public void solve(int N) {
        int[][] board = new int[N][N];
        knightsTour(board, 0, 0, 0);
    }
    private boolean knightsTour(int[][] board, int row, int col, int move) {
        if (row < 0 || row >= board.length || col < 0 || col >= board.length || board[row][col] > 0) return false;
        if (move == board.length * board.length - 1) {
            board[row][col] = move;
            for (int[] arr : board) {
                System.out.println(Arrays.toString(arr));
            }
            return true;
        }
        board[row][col] = move;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (knightsTour(board, nextRow, nextCol, move + 1))
                return true;
        }
        board[row][col] = 0;
        return false;
    }
}
