package questions.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostToCutABoardIntoSquares {
//    Q - https://www.geeksforgeeks.org/minimum-cost-cut-board-squares/
    public int solve(int[] x, int[] y, int m, int n) {
//        sorting in descending order in typical array is not possible
//        so either i have to choose Integer wrapper class or simply reverse the array
//        in both cases time complexity will remain same
//        I AM GOING TO REVERSE THE ARRAY AFTER SORTING

        Arrays.sort(x);
        Arrays.sort(y);

        reverseArray(x);
        reverseArray(y);
//        SORTING IN DESCENDING ORDER IS DONE

        int i = 0, j = 0;

        int horizontalPieces = 1, verticalPieces = 1; // initially uncut pieces will be 1

        int res = 0;

        while (i < m && j < n) {
            if (x[i] > y[j]) {
                res += x[i] * verticalPieces;
                i++;
                horizontalPieces++;
            } else {
                res += y[j] * horizontalPieces;
                j++;
                verticalPieces++;
            }
        }

//        Handle the remains
        int totalRemain = 0;
        while (i < m) {
            totalRemain += x[i++];
        }

        res += totalRemain * verticalPieces;

        totalRemain = 0;
        while (j < n) {
            totalRemain += x[j++];
        }
        res += totalRemain * horizontalPieces;

        return res;
    }
    private void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
