package questions.array;

public class RotateMatrix90AntiClockWise {
//  Q - https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
    public int[][] solve(int[][] matrix) {
        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse rows
        int low = 0, top = matrix.length - 1;
        while (low < top) {
            int[] temp = matrix[low];
            matrix[low] = matrix[top];
            matrix[top] = temp;
            low++; top--;
        }
        return matrix;
    }
}
