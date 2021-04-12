package questions.String;

public class CountPalindromicSubstrings {
    public int solve(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];

        int count = 0;

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                    else {
                        dp[i][j] = false;
                    }
                }
                count += dp[i][j] ? 1 : 0;
            }
        }
        return count;
    }
}
