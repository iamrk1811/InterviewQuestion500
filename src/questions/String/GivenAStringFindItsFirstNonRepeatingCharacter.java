package questions.String;

import java.util.HashMap;

public class GivenAStringFindItsFirstNonRepeatingCharacter {
//    Q - https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
    public char solve(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }
        int index = Integer.MAX_VALUE;
        for (char key : map.keySet()) {
            int temp = map.get(key);
            if (temp != -1) {
                if (index > temp) {
                    index = temp;
                }
            }
        }
        return index != Integer.MAX_VALUE ? s.charAt(index) : '$';
    }
    public char solve2(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) return s.charAt(i);
        }
        return '$';
    }
}
