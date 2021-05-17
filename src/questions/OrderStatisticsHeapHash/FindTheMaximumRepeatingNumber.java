package questions.OrderStatisticsHeapHash;

import java.util.HashMap;

public class FindTheMaximumRepeatingNumber {
    //    Q - https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
    public int solve(int[] arr, int n, int k) {

        for (int i = 0; i < n; i++) {
            arr[arr[i] % k] += k;
        }

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    public int solve2(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }
}
