package questions.Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MatchAPatternAndStringWithoutUsingRegularExpressions {
//    Q - https://www.geeksforgeeks.org/match-a-pattern-and-string-without-using-regular-expressions/
    HashMap<Character, String> resultMap = new HashMap<>();
    public HashMap<Character, String> solve(String str, String pattern) {
        solution(str, pattern, pattern, new HashMap<Character, String>());
        return resultMap;
    }
    private void solution(String str, String pattern, String oldPattern, HashMap<Character, String> map) {
        if (pattern.length() == 0 && str.length() == 0) {
            HashSet<Character> alreadyDone = new HashSet<>();
            for (int i = 0; i < oldPattern.length(); i++) {
                char ch = oldPattern.charAt(i);
                if (!alreadyDone.contains(ch)) {
                    alreadyDone.add(ch);
                    resultMap.put(ch, map.get(ch));
                }
            }
            return;
        }
        if (pattern.length() == 0) return;
        char ch = pattern.charAt(0);
        String restOfThePattern = pattern.substring(1);

        if (map.containsKey(ch)) {
            String previousMatch = map.get(ch);
            if (str.length() >= previousMatch.length()) {
                String left = str.substring(0, previousMatch.length());
                String right = str.substring(previousMatch.length());
                if (previousMatch.equals(left)) {
                    solution(right, restOfThePattern, oldPattern, map);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                map.put(ch, left);
                solution(right, restOfThePattern, oldPattern, map);
                map.remove(ch);
            }
        }
    }
}
