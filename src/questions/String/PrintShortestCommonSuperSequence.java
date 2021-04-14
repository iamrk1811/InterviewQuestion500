package questions.String;

public class PrintShortestCommonSuperSequence {
//    Q - https://www.geeksforgeeks.org/print-shortest-common-supersequence/
    public String solve(String s, String t) {
        int[][] dp = findLCS(s, t);
        String res = getShortedCommonSubSequence(dp, s, t);
        return res;
    }

    private String getShortedCommonSubSequence(int[][] dp, String s, String t) {

        StringBuilder str = new StringBuilder();

        int i = s.length(), j = t.length();
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                str.append(s.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    str.append(t.charAt(j - 1));
                    j--;
                } else {
                    str.append(s.charAt(i - 1));
                    i--;
                }
            }
        }

        while (i > 0) {
            str.append(s.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            str.append(t.charAt(j - 1));
            j--;
        }

        return str.reverse().toString();

    }

    private int[][] findLCS(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 1 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
}
