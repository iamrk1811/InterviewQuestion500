package questions.Matrix;

public class RotateMatrixElements {
//    Q - https://www.geeksforgeeks.org/rotate-matrix-elements/
    public int[][] solve(int[][] matrix) {

        int ROW = matrix.length;
        int COLUMN = matrix[0].length;

        if (ROW == 1) return matrix;

        int count = 0, totalCount = ROW * COLUMN;

        int minRow = 0, minCol = 0, maxRow = ROW - 1, maxCol = COLUMN - 1;

        int current;
        int prev = matrix[minRow + 1][minCol];

        while (count < totalCount) {
            if (minRow == maxRow) break;
//            first wall
            for (int i = minRow, j = minCol; j <= maxCol && count < totalCount; j++) {
                current = matrix[i][j];
                matrix[i][j] = prev;
                prev = current;
                count++;
            }
            minRow++;
//            second wall
            for (int i = minRow, j = maxCol; i <= maxRow && count < totalCount; i++) {
                current = matrix[i][j];
                matrix[i][j] = prev;
                prev = current;
                count++;
            }
            maxCol--;
//            third wall
            for (int i = maxRow, j = maxCol; j >= minCol && count < totalCount; j--) {
                current = matrix[i][j];
                matrix[i][j] = prev;
                prev = current;
                count++;
            }
            maxRow--;
//            fourth wall
            for (int i = maxRow, j = minCol; i >= minRow && count < totalCount; i--) {
                current = matrix[i][j];
                matrix[i][j] = prev;
                prev = current;
                count++;
            }
            minCol++;
            if (minCol + 1 == COLUMN || minRow + 1 == ROW) break;
            prev = matrix[minRow + 1][minCol];
        }
        return matrix;
    }
}
