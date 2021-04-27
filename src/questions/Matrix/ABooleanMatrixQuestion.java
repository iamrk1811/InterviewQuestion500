package questions.Matrix;

public class ABooleanMatrixQuestion {
//    Q - https://www.geeksforgeeks.org/a-boolean-matrix-question/
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && j == 0) {
                    col = false;
                } else if (matrix[i][j] == 1) {
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == 0 && !col) {
                    matrix[i][j] = 1;
                } else if (matrix[0][j] == 1 || matrix[i][0] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }
}
