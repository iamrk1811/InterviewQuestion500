package questions.String;

import java.util.ArrayList;

public class NaiveAlgorithmForPatternSearching {
//    Q -  136 from NoteBook
    public ArrayList<Integer> solve(String text, String pattern) {
        ArrayList<Integer> res = new ArrayList<>();
        int textLen = text.length();
        int patternLen = pattern.length();

        for (int i = 0; i <= textLen - patternLen; i++) {
            int j = 0;
            for (; j < patternLen; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }

            if (j == patternLen)
                res.add(i);
        }
        return res;
    }
}
