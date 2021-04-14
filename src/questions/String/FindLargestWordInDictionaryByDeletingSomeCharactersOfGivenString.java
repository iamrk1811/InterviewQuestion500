package questions.String;

import java.util.List;

public class FindLargestWordInDictionaryByDeletingSomeCharactersOfGivenString {
//    Q - https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
    public String solve(String s, List<String> dict) {
        String ans = "";
        String str = "";
        for (int x = 0; x < dict.size(); x++) {
            str = dict.get(x);
            int j = 0;
            if (str.length() > ans.length()) {
                for (int i = 0; i < s.length() && j < str.length(); i++) {
                    if (s.charAt(i) == str.charAt(j))
                        j++;
                }
                if (j == str.length())
                    ans = str;
            }
        }
        return ans;
    }
}
