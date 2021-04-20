package questions.Matrix;

public class FindTheNumberOfIslands {
    public int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    explore(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void explore(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return;

        if (!visited[i][j]) {
            visited[i][j] = true;

            // explore 8 direction;
            explore(grid, visited, i - 1, j - 1);
            explore(grid, visited, i - 1, j);
            explore(grid, visited, i - 1, j + 1);
            explore(grid, visited, i, j - 1);

            explore(grid, visited, i, j + 1);
            explore(grid, visited, i + 1, j - 1);
            explore(grid, visited, i + 1, j);
            explore(grid, visited, i + 1, j + 1);
        }
    }
}
