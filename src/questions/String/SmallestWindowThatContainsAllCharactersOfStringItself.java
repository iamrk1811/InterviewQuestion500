package questions.String;

import java.util.HashMap;

public class SmallestWindowThatContainsAllCharactersOfStringItself {
//    Q - https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
    public String solve(String str) {
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!tMap.containsKey(ch)) {
                tMap.put(ch, 1);
            }
        }
        String ans = "";
        HashMap<Character, Integer> strMap = new HashMap<>();
        int i = -1, j = -1, matchCount = 0, desiredCount = tMap.size();

        while (true) {
            boolean flag1 = false, flag2 = false;

            while (j < str.length() - 1 && matchCount < desiredCount) {
                j++;

                char ch = str.charAt(j);

                strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);

                if (strMap.getOrDefault(ch, 0) <= tMap.getOrDefault(ch, 0)) {
                    matchCount++;
                }

                flag1 = true;
            }
            while (i < j && matchCount == desiredCount) {
                String possibleAns = str.substring(i + 1, j + 1);

                if (ans.length() == 0 || ans.length() > possibleAns.length()) {
                    ans = possibleAns;
                }

                i++;

                char ch = str.charAt(i);

                if (strMap.containsKey(ch)) {
                    if (strMap.get(ch) == 1) {
                        strMap.remove(ch);
                    } else {
                        strMap.put(ch, strMap.get(ch) - 1);
                    }
                }

                if (strMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                flag2 = true;
            }

            if (!flag1 && !flag2) break;
        }
        return ans;
    }
}
