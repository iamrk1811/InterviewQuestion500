package questions.OrderStatisticsHeapHash;

import java.util.HashMap;

public class FindTheLengthOfLargestSubArrayWith0Sum {
//    Q - https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
    public int solve(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;

        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                max = Math.max(i + 1, max);
            }

            if (map.containsKey(currentSum)) {
                max = Math.max(i - map.get(currentSum), max);
            } else {
                map.put(currentSum, i);
            }
        }

        return max;
    }
}
