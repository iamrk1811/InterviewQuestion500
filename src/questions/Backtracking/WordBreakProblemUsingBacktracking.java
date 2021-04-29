package questions.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakProblemUsingBacktracking {
//    Q - https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
    HashSet<String> set;
    public List<String> solve(ArrayList<String> dict, String s)
    {
        set = new HashSet<>(dict);
        List<String> list = new ArrayList<>();
        wordBreakHelper(s, "", list);
        return list;
    }
    void wordBreakHelper(String str, String ans, List<String> list) {
        if (str.length() == 0) {
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            String temp = str.substring(0, i);
            if (set.contains(temp)) {

                if (i == str.length()) {
                    list.add(ans + temp);
                    return;
                }

                wordBreakHelper(str.substring(i, str.length()), ans + temp + " ", list);
            }
        }
    }
}
