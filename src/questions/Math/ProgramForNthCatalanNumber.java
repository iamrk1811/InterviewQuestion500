package questions.Math;

public class ProgramForNthCatalanNumber {
//    Q - https://www.geeksforgeeks.org/program-nth-catalan-number/
    public int recursive(int n) {
        if (n <= 1) return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += recursive(i) * recursive(n - i - 1);
        }

        return result;
    }
    public int dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
