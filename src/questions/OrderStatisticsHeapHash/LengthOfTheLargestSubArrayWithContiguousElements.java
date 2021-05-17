package questions.OrderStatisticsHeapHash;

import java.util.HashSet;

public class LengthOfTheLargestSubArrayWithContiguousElements {
//    Q - https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
    public int solve(int[] arr) {
        int n = arr.length;
        int len = 1;

        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);

            int max = arr[i];
            int min = arr[i];

            for (int j = i + 1; j < n; j++) {
                if (set.contains(arr[j]))
                    break;

                set.add(arr[j]);

                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                if (max - min == j - i) {
                    len = Math.max(len, max - min + 1);
                }
            }
        }
        return len;
    }
}
