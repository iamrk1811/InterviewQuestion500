package questions.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ZigZagArray {
//    Q - https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
//    a < b > c < d > e < f.
    public int[] solve(int[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag == 0) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            } else {
                if (arr[i] < arr[i + 1])
                    swap(arr, i, i + 1);
            }
            flag = flag == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
