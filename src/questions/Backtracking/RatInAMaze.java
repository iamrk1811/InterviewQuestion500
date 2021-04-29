package questions.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RatInAMaze {
//    Q - https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
    static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> findPath(int[][] matrix, int n) {
        if (matrix[0][0] != 1) {
            list.add("-1");
            return list;
        }
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        help(matrix, 0, 0, "", visited);

        if (list.isEmpty()) {
            list.add("-1");
        }
        return list;
    }

    private static void help(int[][] matrix, int row, int col, String res, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix.length || matrix[row][col] == 0 || visited[row][col])
            return;
        if (row == matrix.length - 1 && col == matrix.length - 1) {
            list.add(res);
            return;
        }

        visited[row][col] = true;

        help(matrix, row + 1, col, res + "D", visited);

        help(matrix, row, col + 1, res + "R", visited);

        visited[row][col] = false;
    }
}
