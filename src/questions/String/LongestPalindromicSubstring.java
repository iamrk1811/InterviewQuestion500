package questions.String;

public class LongestPalindromicSubstring {
//    Q - https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
    public String solve(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String res = "";
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] && res.length() < j + 1 - i) res = s.substring(i, j + 1);
            }
        }

        return res;
    }
}
