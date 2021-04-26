package questions.Matrix;

public class FindACommonElementInAllRowsOfAGivenRowWiseSortedMatrix {
//    Q - https://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
    public int solve(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
//        minimum column index array of every row will be stored here
        int[] arr = new int[R];
        for (int i = 0; i < R; i++) {
            arr[i] = C - 1;
        }
        int minRow = 0;
        while (arr[minRow] >= 0) {
           for (int i = 0; i < R; i++) {
               if (matrix[i][arr[i]] < matrix[minRow][arr[minRow]])
                   minRow = i;
           }

           int count = 0;
           for (int i = 0; i < R; i++) {
               if (matrix[i][arr[i]] > matrix[minRow][arr[minRow]]) {
                   if (arr[0] == 0) {
                       return -1;
                   }
                   arr[i]--;
               } else {
                   count++;
               }
           }
           if (count == R) return matrix[minRow][arr[minRow]];
        }
        return Integer.MIN_VALUE;
    }
}
