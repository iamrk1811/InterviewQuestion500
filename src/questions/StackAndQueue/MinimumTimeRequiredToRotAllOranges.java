package questions.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumTimeRequiredToRotAllOranges {
    //    Q - https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
    static class Node {
        int time;
        int row, col;

        Node(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    public int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(0, i, j));
                }

                if (grid[i][j] == 1) {
                    if (isIsolate(grid, i, j))
                        return -1;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int res = -1;
        while (!queue.isEmpty()) {
            if (queue.size() == 1)
                res = queue.peek().time;

            Node node = queue.remove();

            for (int i = 0; i < 4; i++) {
                int row = node.row + dRow[i];
                int col = node.col + dCol[i];

                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1 && grid[row][col] != 2) {
                    grid[row][col] = 2;
                    queue.add(new Node(node.time + 1, row, col));
                }
            }

        }
        return res;
    }

    private boolean isIsolate(int[][] grid, int row, int col) {
        if (row + 1 < grid.length && (grid[row + 1][col] == 1 || grid[row + 1][col] == 2)) return false;

        if (col + 1 < grid[0].length && (grid[row][col + 1] == 1 || grid[row][col + 1] == 2)) return false;

        if (col - 1 >= 0 && (grid[row][col - 1] == 1 || grid[row][col - 1] == 2)) return false;

        if (row - 1 >= 0 && (grid[row - 1][col] == 1 || grid[row - 1][col] == 2)) return false;

        return true;
    }
}
