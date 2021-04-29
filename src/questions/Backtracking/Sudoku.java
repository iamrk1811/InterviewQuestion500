package questions.Backtracking;

import java.util.Arrays;

public class Sudoku {
//    Q - https://www.geeksforgeeks.org/sudoku-backtracking-7/
    public void solve(int[][] matrix) {
        fill(matrix, 0, 0);
    }
    private void fill(int[][] matrix, int row, int col) {
        if (row == matrix.length) {
            for (int[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        int nextRow;
        int nextCol;

        if (col == matrix.length - 1) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (matrix[row][col] != 0) {
            fill(matrix, nextRow, nextCol);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isValid(matrix, row, col, val)) {
                    matrix[row][col] = val;
                    fill(matrix, nextRow, nextCol);
                    matrix[row][col] = 0;
                }
            }
        }
    }
    private boolean isValid(int[][] matrix, int row, int col, int val) {
        for (int j = 0; j < 9; j++) {
            if (matrix[row][j] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (matrix[i][col] == val) return false;
        }

        int cornerRow = row / 3 * 3;
        int cornerCol = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i + cornerRow][j + cornerCol] == val) return false;
            }
        }
        return true;
    }
}
