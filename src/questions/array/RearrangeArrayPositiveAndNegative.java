package questions.array;

import java.util.Arrays;

public class RearrangeArrayPositiveAndNegative {
    public int[] solve(int[] arr) {
        int n = arr.length;

        int lastIndex = partition(arr, n);
        int i = 1, j = lastIndex;
        while (i < n && j < n) {
            swap(arr, i, j);
            i += 2;
            j++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    private int partition(int[] arr, int n) {
        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                j++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return i;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
