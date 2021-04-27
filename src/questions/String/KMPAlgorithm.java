package questions.String;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithm {
//    Q - 136 from NoteBook
//    Q - https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
    public ArrayList<Integer> solve(String text, String pattern) {
        ArrayList<Integer> res = new ArrayList<>();

        String str = pattern + "#" + text;

        int[] lps = new int[str.length()];

        computeLps(str, lps);

        for (int i = 0; i < str.length(); i++) {
            if (lps[i] == pattern.length()) {
                int index = i - 2 * pattern.length();
//                index -= pattern.length();
                res.add(index);
            }
        }
        return res;
    }
    private void computeLps(String str, int[] lps) {
        int i = 1, len = 0;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
