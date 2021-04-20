package questions.String;

import java.util.Arrays;

public class LexicographicRankOfAString {
//    Q - https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
    static long[] factArray = new long[26];

    static void fillFactArray() {
        factArray[0] = 0;
        factArray[1] = 1;
        for (int i = 2; i < 26; i++) {
            factArray[i] = i * factArray[i - 1];
        }
    }

    static int[] counts = new int[256];

    static void fillCounts(String s) {
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
    }
    public int solve(String s) {
        fillFactArray();
        fillCounts(s);

        long rank = 0;
        for (int i = 0; i < s.length(); i++) {
            int less = 0;
            for (int j = 0; j < 256; j++) {
                if (j == s.charAt(i))
                    break;
                if (counts[j] > 0)
                    less++;
            }

            counts[s.charAt(i)] = 0;
            rank += less * factArray[s.length() - i - 1];
        }
        return (int) (rank % 1000003) + 1;
    }
}
