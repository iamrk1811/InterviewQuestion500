package questions.Greedy;

import java.util.Arrays;

public class MaximizeSumOfConsecutiveDifferencesInACircularArray {
    //    Q - https://www.geeksforgeeks.org/maximize-sum-consecutive-differences-circular-array/
    public long solve(int[] arr) {
        int n = arr.length;
        long sum = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }

        return sum;
    }
}
