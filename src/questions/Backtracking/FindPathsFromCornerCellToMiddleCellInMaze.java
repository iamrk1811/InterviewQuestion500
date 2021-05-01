package questions.Backtracking;

public class FindPathsFromCornerCellToMiddleCellInMaze {
//    Q - https://www.geeksforgeeks.org/find-paths-from-corner-cell-to-middle-cell-in-maze/
    public String solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m % 2 != 1 || n % 2 != 1) return "Tell me which cell is the mis point !";

        int midRow = m / 2;
        int midCol = n / 2;

        solution(matrix, 0, 0, new boolean[m][n], "", midRow, midCol);
        return ans;
    }
    String ans = "NO";
    private void solution(int[][] matrix, int row, int col, boolean[][] visited, String path, int midRow, int midCol) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col]) {
            return;
        }
        if (row == midRow && col == midCol) {
            ans = path + "MID";
            return;
        }
        visited[row][col] = true;
//        top
        solution(matrix, row - matrix[row][col], col, visited, path + "(" + row + ", " + col +") -> ", midRow, midCol);
//        right
        solution(matrix, row, col + matrix[row][col], visited, path + "(" + row + ", " + col +") -> ", midRow, midCol);
//        down
        solution(matrix, row + matrix[row][col], col , visited, path + "(" + row + ", " + col +") -> ", midRow, midCol);
//        left
        solution(matrix, row, col - matrix[row][col], visited, path + "(" + row + ", " + col +") -> ", midRow, midCol);

        visited[row][col] = false;
    }
}
