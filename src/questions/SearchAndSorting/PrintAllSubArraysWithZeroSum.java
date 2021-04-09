package questions.SearchAndSorting;

import java.util.HashMap;

public class PrintAllSubArraysWithZeroSum {
//    Q - https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
    public void solve(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                System.out.println(map.get(sum) + 1 + " - " + i);
            } else {
                map.put(sum, i);
            }
        }
    }
}
