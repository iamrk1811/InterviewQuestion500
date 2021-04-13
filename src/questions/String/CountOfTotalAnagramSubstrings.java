package questions.String;

import java.util.Arrays;
import java.util.HashMap;

public class CountOfTotalAnagramSubstrings {
//    Q - https://www.geeksforgeeks.org/count-total-anagram-substrings/
    public int solve(String str) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char[] chars = str.substring(i, j + 1).toCharArray();
                Arrays.sort(chars);

                String temp = new String(chars);

                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int count = 0;
        for (int n : map.values()) {
            count += n * (n - 1) / 2;
        }
        return count;
    }
}
