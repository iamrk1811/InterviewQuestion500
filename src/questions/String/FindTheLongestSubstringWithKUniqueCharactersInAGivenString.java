package questions.String;

import java.util.HashMap;

public class FindTheLongestSubstringWithKUniqueCharactersInAGivenString {
    //    Q - https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
    public int solve(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int ans = -1;
        int i = -1, j = -1;
        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;

            while (j < s.length() - 1) {
                flag1 = false;
                j++;
                char ch = s.charAt(j);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() == k) {
                    if (ans < j - i) {
                        ans = j - i;
                    }
                } else if (map.size() > k) {
                    break;
                }
            }

            while (i < j) {
                flag2 = false;
                i++;
                char ch = s.charAt(i);

                if (map.containsKey(ch)) {
                    if (map.get(ch) == 1)
                        map.remove(ch);
                    else
                        map.put(ch, map.get(ch) - 1);
                }

                if (map.size() == k) {
                    if (ans < j - i) {
                        ans = j - i;
                    }
                    break;
                }
            }
            if (flag1 && flag2) break;
        }
        return ans;
    }
}
