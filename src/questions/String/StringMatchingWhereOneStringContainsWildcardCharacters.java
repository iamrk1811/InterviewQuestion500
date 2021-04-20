package questions.String;

public class StringMatchingWhereOneStringContainsWildcardCharacters {
//    Q - https://www.geeksforgeeks.org/wildcard-character-matching/
    public boolean solve(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = dp.length - 1, j = 0; j < dp[0].length - 1; j++) {
            dp[i][j] = false;
        }
        dp[dp.length - 1][dp[0].length - 1] = true;
        for (int i = dp.length - 2, j = dp[0].length - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                dp[i][j] = dp[i + 1][j];
            } else {
                dp[i][j] = false;
            }
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {

                if(p.charAt(i) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                }else if(p.charAt(i) == '*') {
                    dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                }else if(p.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }else {
                    dp[i][j] = false;
                }

            }
        }
        return dp[0][0];
    }
}
