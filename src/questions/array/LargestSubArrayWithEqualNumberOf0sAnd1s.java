package questions.array;

import java.util.HashMap;
// Q - https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

public class LargestSubArrayWithEqualNumberOf0sAnd1s {
    public int[] solve(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = arr.length;

        int sum = 0;
        int startIndex = 0;
        int endIndex = -1;

        int maxLen = 0;
//        change 0 t0 -1
        for (int i = 0; i < n; i++) arr[i] = arr[i] == 0 ? -1 : arr[i];

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                startIndex = 0;
                maxLen = i + 1;
                endIndex = i;
            }

            if (map.containsKey(sum)) {
                int lastOccurrence = map.get(sum);
                if (i - lastOccurrence > maxLen) {
                    maxLen = i - lastOccurrence;
                    startIndex = lastOccurrence + 1;
                    endIndex = i;
                }
            } else {
                map.put(sum, i);
            }

        }
        System.out.println("Max " + maxLen);
        System.out.println("START " + startIndex);
        System.out.println("END " + endIndex);
        return new int[]{startIndex, endIndex};
    }
}
