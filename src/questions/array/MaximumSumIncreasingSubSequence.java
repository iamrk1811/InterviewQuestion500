package questions.array;

import java.lang.reflect.Array;

public class MaximumSumIncreasingSubSequence {
//    Q - https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
    public int solve(int[] arr) {
        int[] dp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Integer currentMax = null;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (currentMax == null) {
                        currentMax = dp[j];
                    } else if (currentMax <= dp[j]) {
                        currentMax = dp[j];
                    }
                }
            }
            dp[i] = currentMax == null ? arr[i] : currentMax + arr[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
