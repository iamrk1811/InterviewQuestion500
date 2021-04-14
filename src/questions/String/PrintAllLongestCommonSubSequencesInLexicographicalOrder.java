package questions.String;

import java.util.*;

public class PrintAllLongestCommonSubSequencesInLexicographicalOrder {
//    Q -  https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
    public List<String> solve(String s, String t) {
        int[][] lcsDP = findLCS(s, t);

        int lcsLength = lcsDP[s.length()][t.length()];

        Set<String> set = new HashSet<>();

        allLCS(lcsDP, s, t, lcsDP.length - 1, lcsDP[0].length - 1, set, "");
        List<String> res = new ArrayList<>(set);

        Collections.sort(res);
        System.out.println(res);
        return res;
    }
    public static void allLCS(int[][] dp, String s, String t, int i, int j, Set<String> set, String str) {
        //return when either of the string length is 0
        if (i == 0 || j == 0) {
            set.add(str);
            return;
        }

        //if last characters are equal, they belong in lcs
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            //prepend the char to lcs since, we are going backwards
            str = s.charAt(i - 1) + str;
            //continue finding lcs in substrings s.substring(0,i-1) and t.substring(0,j-1)
            allLCS(dp, s, t, i - 1, j - 1, set, str);
        } // if there is a tie in matrix cells, we backtrack in both ways,
        // else one way, which ever is greater
        else if (dp[i - 1][j] == dp[i][j - 1]) {
            //continue finding lcs in substring s.substring(0,i-1)
            allLCS(dp, s, t, i - 1, j, set, str);
            //continue finding lcs in substring t.substring(0,j-1)
            allLCS(dp, s, t, i, j - 1, set, str);
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            allLCS(dp, s, t, i - 1, j, set, str);
        } else {
            allLCS(dp, s, t, i, j - 1, set, str);
        }

    }

    private int[][] findLCS(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
}
