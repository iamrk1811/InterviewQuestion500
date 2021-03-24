package questions.array;

public class LongestIncreasingSubsequenceLength {
    public int solve(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int currentMaxLen = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i])
                    currentMaxLen = Math.max(currentMaxLen, dp[j]);
            }
            dp[i] = currentMaxLen + 1;

        }
        int max = Integer.MIN_VALUE;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }
}
