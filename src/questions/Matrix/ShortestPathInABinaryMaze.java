package questions.Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInABinaryMaze {
//    Q - https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
    public int solve(int[][] matrix, int r, int c) {
        int m = matrix.length, n = matrix[0].length;

        if (matrix[0][0] != 1) return 0;
        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{0, 0, 0});

        matrix[0][0] = 0; // visited

        int[] distRow = {-1, 0, 1, 0};
        int[] distCol = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] current = queue.remove();

            if (current[0] == r && current[1] == c) return current[2];

            for (int i = 0; i < 4; i++) {
                int row = current[0] + distRow[i];
                int col = current[1] + distCol[i];

                if (row >= 0 && col >= 0 && row < m && col < n && matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                    queue.add(new int[]{row, col, current[2] + 1});
                }
            }
        }
        return 0;
    }
}
