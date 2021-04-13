package questions.String;

public class CountBinaryStringsWithKTimesAppearingAdjacentTwoSetBits {
//    Q - https://www.geeksforgeeks.org/count-binary-strings-k-times-appearing-adjacent-two-set-bits/
    public int solve(int n, int k) {
        int[][][] dp = new int[n + 1][k + 1][2];

        // If n = 1 and k = 0.
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i && j < k + 1; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1]; // for zero
                dp[i][j][1] = dp[i - 1][j][0]; // for zero

                if (j - 1 >= 0) {
                    dp[i][j][1] += dp[i - 1][j - 1][1]; // for ones with k - 1 times
                }
            }
        }

        return dp[n][k][0] + dp[n][k][1];
    }
}
