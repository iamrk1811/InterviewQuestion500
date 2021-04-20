package questions.Matrix;

public class CreateAMatrixWithAlternatingRectanglesOfOAndX {
//    Q - https://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
    public char[][] solve(int m, int n) {
        char[][] res = new char[m][n];
        int count = 0;
        int rotationNumber = 0;

        int minRow = 0, minCol = 0;
        int maxRow = m - 1, maxCol = n - 1;

        while (count < m * n) {
//            first
            for (int i = minRow, j = minCol; j <= maxCol && count < m * n; j++) {
                res[i][j] = rotationNumber % 2 == 0 ? 'X' : '0';
                count++;
            }
            minRow++;
//            second
            for (int i = minRow, j = maxCol; i <= maxRow && count < m * n; i++) {
                res[i][j] = rotationNumber % 2 == 0 ? 'X' : '0';
                count++;
            }
            maxCol--;
//            third
            for (int i = maxRow, j = maxCol; j >= minCol && count < m * n; j--) {
                res[i][j] = rotationNumber % 2 == 0 ? 'X' : '0';
                count++;
            }
            maxRow--;
//            fourth
            for (int i = maxRow, j = minCol; i >= minRow && count < m * n; i--) {
                res[i][j] = rotationNumber % 2 == 0 ? 'X' : '0';
                count++;
            }
            minCol++;
            rotationNumber++;
        }

        return res;
    }
}
