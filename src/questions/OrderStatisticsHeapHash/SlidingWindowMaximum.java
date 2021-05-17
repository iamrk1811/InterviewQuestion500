package questions.OrderStatisticsHeapHash;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
//    Q - https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
    public int[] solve(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];
        int index = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (j - i + 1 < k) {
//                before hit window
                while (!dq.isEmpty() && dq.peekLast() < arr[j]) {
                    dq.removeLast();
                }
                dq.addLast(arr[j]);
                j++;
            } else {
                while (!dq.isEmpty() && dq.peekLast() < arr[j]) {
                    dq.removeLast();
                }
                dq.addLast(arr[j]);

                res[index++] = dq.peekFirst();

                if (arr[i] == dq.peekFirst()) {
                    dq.removeFirst();
                }
                i++; j++;
            }
        }
        return res;
    }
}
