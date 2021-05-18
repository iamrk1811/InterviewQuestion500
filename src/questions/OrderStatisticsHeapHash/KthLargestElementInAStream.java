package questions.OrderStatisticsHeapHash;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
//    Q - https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
    public int[] solve(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }

            if (pq.size() >= k) {
                res[i] = pq.peek();
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
