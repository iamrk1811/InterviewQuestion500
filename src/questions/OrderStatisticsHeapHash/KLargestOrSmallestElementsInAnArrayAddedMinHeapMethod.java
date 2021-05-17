package questions.OrderStatisticsHeapHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestOrSmallestElementsInAnArrayAddedMinHeapMethod {
//    Q - https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
    public ArrayList<Integer> solve(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (k-- > 0) {
            pq.add(arr[i++]);
        }

        while (i < n) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }

            i++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        Collections.reverse(res);
        return res;
    }
}
