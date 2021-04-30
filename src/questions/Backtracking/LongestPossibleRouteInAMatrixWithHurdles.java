package questions.Backtracking;

public class LongestPossibleRouteInAMatrixWithHurdles {
//    Q - https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
    int maxResult = Integer.MIN_VALUE;
    public int solve(int[][] matrix, int startRow, int startCol, int destRow, int destCol) {
        solution(matrix, 0, 0, destRow, destCol, 0, new boolean[matrix.length][matrix[0].length]);
        return maxResult;
    }
    private void solution(int[][] matrix, int row, int col, int destRow, int destCol, int pathCount, boolean[][] visited) {
        if (row == destRow && col == destCol) {
            if (pathCount > maxResult) {
                maxResult = pathCount;
            }
            return;
        }

        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        solution(matrix, row - 1, col, destRow, destCol, pathCount + 1, visited);
        solution(matrix, row + 1, col, destRow, destCol, pathCount + 1, visited);
        solution(matrix, row, col - 1, destRow, destCol, pathCount + 1, visited);
        solution(matrix, row, col + 1, destRow, destCol, pathCount + 1, visited);
        visited[row][col] = false;
    }
}
