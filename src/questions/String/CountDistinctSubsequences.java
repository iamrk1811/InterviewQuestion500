package questions.String;

import java.util.HashMap;

public class CountDistinctSubsequences {
//    Q - https://www.geeksforgeeks.org/count-distinct-subsequences/
    public int solve(String str) {
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;

        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = str.charAt(i - 1);

            if (lastOccurrence.containsKey(ch)) {
                int last = lastOccurrence.get(ch);
                dp[i] -= dp[last - 1];
            }
            lastOccurrence.put(ch, i);
        }
        return dp[str.length()];
    }
}
