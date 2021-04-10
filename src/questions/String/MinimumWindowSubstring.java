package questions.String;

import java.util.HashMap;

public class MinimumWindowSubstring {
//    Q - https://leetcode.com/problems/minimum-window-substring/
    public String solve(String str, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> strMap = new HashMap<>();

        String ans = "";

        int i = -1, j = -1;

        int matchCount = 0, desiredCount = t.length();

        while (true) {
            boolean flag1 = false, flag2 = false;
//            till reach my target, which is match count == desired match count or else till hit the length()
            while (j < str.length() - 1 && matchCount < desiredCount) {

                j++;
                char ch = str.charAt(j);
                strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
//                increase the match count

                if (strMap.getOrDefault(ch, 0) <= tMap.getOrDefault(ch ,0)) {
                    matchCount++;
                }

                flag1 = true;
            }
//            collect the ans and release
            while (i < j && matchCount == desiredCount) {
//                collecting the possible ans
                String possibleAns = str.substring(i + 1, j + 1);
                if (ans.length() == 0 || ans.length() > possibleAns.length()) {
                    ans = possibleAns;
                }

                i++;

                char ch = str.charAt(i);

//                release the character

                if (strMap.containsKey(ch)) {
                    if (strMap.get(ch) == 1) {
                        strMap.remove(ch);
                    } else {
                        strMap.put(ch, strMap.get(ch) - 1);
                    }
                }

//                decrease the match count
                if (strMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0))
                    matchCount--;

                flag2 = true;
            }

            if (!flag1 && !flag2) break;
        }

        return ans;
    }
}
