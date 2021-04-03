package questions.SearchAndSorting;

import java.util.Arrays;

public class RadixSort {
    public int[] solve(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (max < val) {
                max = val;
            }
        }
        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }

        return arr;
    }
    private void countSort(int[] arr, int exp) {
        int[] prefix = new int[10];
        for (int val : arr) {
            prefix[val / exp % 10]++;
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = prefix[arr[i] / exp % 10] - 1;
            res[index] = arr[i];
            prefix[arr[i] / exp % 10]--;
        }
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }

    }
}
