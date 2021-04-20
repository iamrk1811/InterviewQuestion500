package questions.Matrix;

import java.util.ArrayList;
// Q - https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
public class PrintMatrixDiagonally {
    public ArrayList<Integer> solve(int[][] A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A[0].length;
        int m = A.length;
//        first half
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; i < m && j >= 0; i++, j--) {
                res.add(A[i][j]);
            }
        }
//        second half
        for (int k = 1; k < m; k++) {
            for (int i = k, j = n - 1; i < m && j >= 0; i++, j--) {
                res.add(A[i][j]);
            }
        }
        return res;
    }
    public ArrayList<Integer> solve2(int[][] A) {
        int n = A[0].length;
        int m = A.length;

        ArrayList<Integer> res = new ArrayList<>();

        for (int k = 0; k < m; k++) {
            for (int i = k, j = 0; i >= 0 && j < n; i--, j++) {
                res.add(A[i][j]);
            }
        }

        for (int k = 1; k < n; k++) {
            for (int i = m - 1, j = k; i >= 0 && j < n; i--, j++) {
                res.add(A[i][j]);
            }
        }

        return res;
    }
}
