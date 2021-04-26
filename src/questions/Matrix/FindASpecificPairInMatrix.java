package questions.Matrix;

public class FindASpecificPairInMatrix {
    public int solve(int[][] matrix) {
        int[][] maxArray = new int[matrix.length][matrix.length];
        int n = matrix.length;
        maxArray[n - 1][n - 1] = matrix[n - 1][n -1];
        int maxVal = matrix[n - 1][n -1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxVal < matrix[i][n - 1]) {
                maxVal = matrix[i][n - 1];
            }
            maxArray[i][n - 1] = maxVal;
        }

        maxVal = matrix[n - 1][n -1];;
        for (int j = n - 2; j >= 0; j--) {
            if (maxVal < matrix[n - 1][j]) {
                maxVal = matrix[n - 1][j];
            }
            maxArray[n - 1][j] = maxVal;
        }

        int max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (max < maxArray[i + 1][j + 1] - matrix[i][j]) {
                    max = maxArray[i + 1][j + 1] - matrix[i][j];
                }
                maxArray[i][j] = Math.max(matrix[i][j], Math.max(maxArray[i + 1][j], maxArray[i][j + 1]));
            }
        }
        return max;
    }
}
