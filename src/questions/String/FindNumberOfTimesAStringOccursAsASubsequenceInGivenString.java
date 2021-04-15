package questions.String;

public class FindNumberOfTimesAStringOccursAsASubsequenceInGivenString {
//    Q - https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
    public int solve(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0, j = 0; j < t.length() + 1; j++) dp[i][j] = 0;
        for (int i = 0, j = 0; i < s.length() + 1; i++) dp[i][j] = 1;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    public int solve2(String s, String t) {
        return rec(s, t, s.length(), t.length());
    }
    private int rec(String s, String t, int m, int n) {
        if (n == 0) return 1;
        if (m == 0) return 0;

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return rec(s, t, m - 1, n - 1) + rec(s, t, m - 1, n);
        } else {
            return rec(s, t, m - 1, n);
        }
    }
}
