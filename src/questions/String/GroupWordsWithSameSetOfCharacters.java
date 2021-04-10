package questions.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupWordsWithSameSetOfCharacters {
//    Q -  https://www.geeksforgeeks.org/print-words-together-set-characters/
//    Q - https://leetcode.com/problems/group-anagrams/
    public List<List<String>> solve(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);

            if (map.containsKey(str)) {
                ArrayList<String> temp = map.get(str);
                temp.add(strs[i]);
                map.put(str, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(str, temp);
            }
        }

        List<List<String>> res = new ArrayList<>();

        String[] keys = map.keySet().toArray(new String[0]);

        for (String key : keys) {
            ArrayList<String> temp = map.get(key);
            res.add(temp);
        }

        return res;
    }
    public List<List<String>> solve2(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> frequency = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (frequency.containsKey(ch)) {
                    frequency.put(ch, frequency.get(ch) + 1);
                } else {
                    frequency.put(ch, 0);
                }
            }

            if (map.containsKey(frequency)) {
                ArrayList<String> temp = map.get(frequency);
                temp.add(str);
                map.put(frequency, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(frequency, temp);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (ArrayList<String> arr : map.values()) {
            res.add(arr);
        }

        return res;
    }
}
