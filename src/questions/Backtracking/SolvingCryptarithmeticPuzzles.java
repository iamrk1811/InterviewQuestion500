package questions.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class SolvingCryptarithmeticPuzzles {
//    Q - https://www.geeksforgeeks.org/solving-cryptarithmetic-puzzles-backtracking-8/
    ArrayList<HashMap<Character, Integer>> res = new ArrayList<>();
    public ArrayList<HashMap<Character, Integer>> solve(String str1, String str2, String str3) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder uniqueString = new StringBuilder();
        for (char ch : str1.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, -1);
                uniqueString.append(ch);
            }
        }
        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, -1);
                uniqueString.append(ch);
            }
        }
        for (char ch : str3.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, -1);
                uniqueString.append(ch);
            }
        }

        if (uniqueString.length() > 10) return res;

        solution(uniqueString.toString(), 0,  str1, str2, str3, map);
        return res;
    }
    static boolean[] usedDigits = new boolean[10];
    private void solution(String unique, int index, String s1, String s2, String s3, HashMap<Character, Integer> map) {
        if (index == unique.length()) {
            int num1 = getNumber(s1, map);
            int num2 = getNumber(s2, map);
            int num3 = getNumber(s3, map);
            if (num1 + num2 == num3) {
                res.add(new HashMap<Character, Integer>(map));
            }
            return;
        }

        char ch = unique.charAt(index);
        for (int i = 0; i < 10; i++) {
            if (!usedDigits[i]) {
                usedDigits[i] = true;
                map.put(ch, i);
                solution(unique, index + 1, s1, s2, s3, map);
                map.put(ch, -1);
                usedDigits[i] = false;
            }
        }
    }
    private int getNumber(String s, HashMap<Character, Integer> map) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res.append(map.get(ch));
        }
        return Integer.parseInt(res.toString());
    }
}
