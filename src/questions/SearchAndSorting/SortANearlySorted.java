package questions.SearchAndSorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortANearlySorted {
//    Q - https://www.geeksforgeeks.org/nearly-sorted-algorithm/
    public int[] solve(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k + 1) {
                pq.add(arr[i]);
            } else {
                arr[index] = pq.remove();
                pq.add(arr[i]);
                index++;
            }
        }

        while (!pq.isEmpty()) {
            arr[index] = pq.remove();
            index++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
