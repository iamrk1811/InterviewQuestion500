package questions.SearchAndSorting;

import java.util.Arrays;

public class SortDates {
//    Q - https://www.geeksforgeeks.org/how-to-efficiently-sort-a-big-list-dates-in-20s/
    public int[][] solve(int[][] arr) {
        radixSort(arr, 0); // 0 means o 'th column == dates - sort the array based on Days
        radixSort(arr, 1); // 1 means 1 st column == months - sort the array based on Months
        radixSort(arr, 2); // 2 means 2 nd column == years - sort the array based on Years
        for (int[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }
        return arr;
    }

    private void radixSort(int[][] arr, int col) {
        int max = getMax(arr, col);
        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp, col);
            exp *= 10;
        }
    }

    private void countSort(int[][] arr, int exp, int col) {
        int n = arr.length;

        int[] prefix = new int[10];

        for (int i = 0; i < n; i++) {
            prefix[(arr[i][col] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            prefix[i] += prefix[i - 1];
        }
        int[][] ans = new int[n][3];
        for (int i = n - 1; i >= 0; i--) {
            int lastDigit = (arr[i][col] / exp) % 10;

            // Build the output array
            for (int j = 2; j >= 0; j--) {
                ans[prefix[lastDigit] - 1][j] = arr[i][j];
            }
            prefix[lastDigit]--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ans[i][j];
            }
        }
    }

    private int getMax(int[][] arr, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i][col]);
        }
        return max;
    }
}
