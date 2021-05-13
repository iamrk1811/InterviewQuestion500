package questions.Math;

public class MatrixExponentiation {
//    Q - https://www.geeksforgeeks.org/matrix-exponentiation/
//    Q - https://discuss.codechef.com/t/code-for-matrix-exponentiation/72062
    public int[][] solve(int[][] matrix, int dimension, int power) {
        return power(matrix, dimension, power);
    }
    private int[][] power(int[][] matrix, int dimension, int power) {
        int[][] identity = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j)
                    identity[i][j] = 1;
                else
                    identity[i][j] = 0;
            }
        }

        if (power == 1) return matrix;

        power(matrix, dimension, power / 2);

        multiply(matrix, matrix, dimension);

        if (power % 2 == 1) {
            multiply(matrix, identity, dimension);
        }

        return matrix;
    }
    private void multiply(int[][] arr, int[][] F, int dim) {
        int[][] temp = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                int sum = 0;
                for (int k = 0; k < dim; k++) {
                    sum += arr[i][k] * F[j][k];
                }
                temp[i][j] = sum;
            }
        }

        int i = 0;
        for (int[] t : temp) {
            arr[i++] = t;
        }
    }
}
