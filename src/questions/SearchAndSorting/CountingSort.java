package questions.SearchAndSorting;

import java.util.Arrays;

public class CountingSort {
    public int[] solve(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val < min) {
                min = val;
            }
            if (val > max) {
                max = val;
            }
        }

        int[] prefix = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[arr[i] - min]++;
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        int[] res = new int[arr.length];
        for (int i = res.length - 1; i >= 0; i--) {
            int index = prefix[arr[i] - min] - 1;
            res[index] = arr[i];
            prefix[arr[i] - min]--;
        }
        System.out.println(Arrays.toString(res));
        return arr;
    }
}
