package questions.Backtracking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FindShortestSafeRouteInAPathWithLandmines {
//    Q - https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
    public int solve(int[][] matrix) {
        markUnsafe(matrix);
//        for (int[] arr : matrix) {
//            System.out.println(Arrays.toString(arr));
//        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++)
            min = Math.min(helper(matrix, i, 0, 0, Integer.MAX_VALUE, new boolean[matrix.length][matrix[0].length]), min);
        return min;
    }
    private void markUnsafe(int[][] matrix) {
        int[] dictRow = {-1, 0, 1, 0};
        int[] dictCol = {0, 1, 0, -1};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int row = i + dictRow[k];
                        int col = j + dictCol[k];
                        if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length && matrix[row][col] != 0) {
                            matrix[row][col] = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private int helper(int[][] matrix, int row, int col, int steps, int min, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0 || visited[row][col])
            return min;
        if (col == matrix[0].length - 1 && min > steps) {
            min = steps;
            System.out.println();
            for (int[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
//            min = Math.min(steps, min);
            return min;
        }
        visited[row][col] = true;
        matrix[row][col] = 5;
        min = helper(matrix, row, col + 1, steps + 1, min, visited); // right
        min = helper(matrix, row + 1, col, steps + 1, min, visited); // down
        min = helper(matrix, row, col - 1, steps + 1, min, visited); // left
        min = helper(matrix, row - 1, col, steps + 1, min, visited); // top
        visited[row][col] = false;
        matrix[row][col] = 1;
        return min;
    }
}
