package questions.Matrix;

public class DiagonalTraverse {
//    Q - LeetCode 498
    public int[] solve(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] res = new int[n * m];

        int row = 0, col = 0;
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[index++] = mat[row][col];
            if ((row + col) % 2 == 0) { // up
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else { // down
                if (row ==  m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return res;
    }

}
