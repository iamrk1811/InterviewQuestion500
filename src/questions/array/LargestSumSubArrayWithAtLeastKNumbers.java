package questions.array;

public class LargestSumSubArrayWithAtLeastKNumbers {
//    Q - https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1#
    public int solve(int[] arr, int k) {

        int n = arr.length;

        int currentMax = arr[0];
        int[] maxSum = new int[n];
        maxSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(currentMax + arr[i], arr[i]);
            maxSum[i] = currentMax;
        }

        int sumOfExactK = 0;
        for (int i = 0; i < k; i++) {
            sumOfExactK += arr[i];
        }

        int res = sumOfExactK;
        for (int i = k; i < n; i++) {
            sumOfExactK += arr[i] - arr[i - k];
            res = Math.max(sumOfExactK, res);

            int atLeastK = sumOfExactK + maxSum[i - k];
            res = Math.max(res, atLeastK);
        }
        return res;
    }
}
