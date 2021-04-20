package questions.Matrix;

import java.util.Arrays;

public class GivenAMatrixOfOAndXReplaceOWithXIfSurroundedByX {
//    Q - https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
    public char[][] solve(char[][] a) {
        int n = a.length, m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O')
                    a[i][j] = 'R';
            }
        }

        for (int i = 0, j = 0; j < m; j++) {
            if (a[i][j] == 'R')
                floodFill(a, i, j);
        }
        for (int i = 0, j = m - 1; i < n; i++) {
            if (a[i][j] == 'R')
                floodFill(a, i, j);
        }
        for (int i = n - 1, j = m - 1; j >= 0; j--) {
            if (a[i][j] == 'R')
                floodFill(a, i, j);
        }
        for (int i = n - 1, j = 0; i >= 0; i--) {
            if (a[i][j] == 'R')
                floodFill(a, i, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'R') {
                    a[i][j] = 'X';
                }
            }
        }

        return a;
    }
    private void floodFill(char[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 'X' || a[i][j] == 'O')
            return;

        if (a[i][j] == 'R')
            a[i][j] = 'O';

        floodFill(a, i - 1, j);
        floodFill(a, i, j + 1);
        floodFill(a, i + 1, j);
        floodFill(a, i, j - 1);

    }
}
