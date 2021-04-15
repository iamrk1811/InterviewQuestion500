package questions.String;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchAWordInATwoDGridOfCharacters {
//    Q - https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
    public int[][] solve(char[][] grid, String word) {

        int rowSize = grid.length;
        int colSize = grid[0].length;

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {

                if (searchIn2DGrid(grid, i, j, word)) {
                    System.out.println("H");
                    list.add(new Pair(i, j));
                }
            }
        }

        int[][] res = new int[list.size()][2];
        int index = 0;
        for (Pair pair : list) {
            res[index][0] = pair.first;
            res[index][1] = pair.second;
            index++;
        }
        return res;
    }
    private boolean searchIn2DGrid(char[][] grid, int row, int col, String word) {
        if (grid[row][col] != word.charAt(0)) return false;
        for (int dir = 0; dir < 8; dir++) {

            int rowDir = row + x[dir], colDir = col + y[dir];

            int charIndex = 1;

            for (; charIndex < word.length(); charIndex++) {
                if (rowDir >= grid.length || rowDir < 0 || colDir >= grid[0].length || colDir < 0)
                    break;
                if (grid[rowDir][colDir] != word.charAt(charIndex))
                    break;

                rowDir += x[dir];
                colDir += y[dir];
            }

            if (word.length() == charIndex) return true;
        }

        return false;
    }
}
