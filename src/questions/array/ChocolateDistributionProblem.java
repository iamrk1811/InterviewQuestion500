package questions.array;

import java.util.Arrays;

public class ChocolateDistributionProblem {
//    Q - https://www.geeksforgeeks.org/chocolate-distribution-problem/
    public int solve(int[] arr, int m) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n < m) return -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++) {
            int dif = arr[i + m - 1] - arr[i];
            min = Math.min(min, dif);
        }
        return min;
    }
}
