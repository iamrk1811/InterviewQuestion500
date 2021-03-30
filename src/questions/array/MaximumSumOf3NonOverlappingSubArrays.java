package questions.array;

public class MaximumSumOf3NonOverlappingSubArrays {
//    Q - https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
    public int[] solve(int[] nums, int k) {
        int n = nums.length;
        // calculate the acc
        int[] acc = new int[nums.length + 1];
        for (int i = 0; i < n; i++) {
            acc[i+1] = acc[i];
            acc[i+1] += nums[i];
        }

        // dynamic programming
        int[][] dp = new int[4][nums.length + 1];
        int[][] idx = new int[4][nums.length + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i*k; j <= n-(3-i)*k; j++) {
                dp[i][j] = dp[i][j-1];
                idx[i][j] = idx[i][j-1];
                int cur = acc[j]-acc[j-k] + dp[i-1][j-k];
                if (cur > dp[i][j]) {
                    dp[i][j] = cur;
                    idx[i][j] = j-k+1;
                }
            }
        }

        // gather the results
        int last = idx[3][n];
        int mid = idx[2][last-1];
        int first = idx[1][mid-1];

        last--; mid--; first--;

        return new int[]{first, mid, last};
    }
}
