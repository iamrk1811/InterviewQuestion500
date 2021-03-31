package questions.array;

import java.util.HashMap;

public class LongestSubArrayWithSumDivisibleByK {
//    Q - https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
    public int solve(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int len = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            int rmd = sum % k;

            if (rmd < 0) {
                rmd += k;
            }

            if (map.containsKey(rmd)) {
                len = Math.max(len, i - map.get(rmd));
            } else {
                map.put(rmd, i);
            }
        }
        return len;
    }
}
