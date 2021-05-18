package questions.OrderStatisticsHeapHash;

import java.util.Arrays;

public class ChooseKArrayElementsSuchThatDifferenceOfMaximumAndMinimumIsMinimized {
//    Q - https://www.geeksforgeeks.org/k-numbers-difference-maximum-minimum-k-number-minimized/
    public long solve(long[] arr, int K) {
        Arrays.sort(arr);

        long min = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - K; i++) {
            min = Math.min(arr[i + K - 1] - arr[i], min);
        }

        return min;
    }
}
