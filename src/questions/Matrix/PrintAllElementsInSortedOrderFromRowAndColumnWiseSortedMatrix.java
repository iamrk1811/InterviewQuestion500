package questions.Matrix;

import java.util.PriorityQueue;

public class PrintAllElementsInSortedOrderFromRowAndColumnWiseSortedMatrix {
//    Q - https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] arr : matrix) {
            for (int val : arr) {
                pq.add(val);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = pq.remove();
            }
        }
        return matrix;
    }
}
