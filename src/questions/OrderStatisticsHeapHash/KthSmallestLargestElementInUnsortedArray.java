package questions.OrderStatisticsHeapHash;

import java.util.PriorityQueue;

public class KthSmallestLargestElementInUnsortedArray {
    //    Q - https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
    public int solve(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val: arr) pq.add(val);

        while (k > 1) { pq.remove(); k--; }
        return pq.remove();
    }
}
