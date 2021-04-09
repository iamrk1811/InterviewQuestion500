package questions.SearchAndSorting;

import java.util.Arrays;

public class AProductArrayPuzzle {
//    Q - https://www.geeksforgeeks.org/a-product-array-puzzle/
    public int[] solve(int[] arr) {
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];

//        left part
        long currentProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            currentProduct *= arr[i];
            left[i] = currentProduct;
        }
//        right
        currentProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            currentProduct *= arr[i];
            right[i] = currentProduct;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = (int) right[i + 1];
            }else if (i == arr.length - 1){
                arr[i] = (int) left[i - 1];
            } else {
                arr[i] = (int) (left[i - 1] * right[i + 1]);
            }

        }
        return arr;
    }
    public int[] solve2(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int prod = 1;
        for (int i = 0; i < n; i++) {
            prod *= arr[i];
            left[i] = prod;
        }

        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                left[i] = left[i - 1];
                prod *= arr[i];
            } else if (i == 0) {
                left[i] = prod;
            } else {
                left[i] = left[i - 1] * prod;
                prod *= arr[i];
            }
        }

        return left;
    }
}
