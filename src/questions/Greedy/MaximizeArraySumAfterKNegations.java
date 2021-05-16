package questions.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeArraySumAfterKNegations {
//    Q - https://www.geeksforgeeks.org/maximize-array-sun-after-k-negation-operations/
    public long solve(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0;
        while (k > 0) {
            if (arr[i] == 0) {
                break;
            } else {
                arr[i] = (-1) * arr[i];
                k--;
            }
            i++;
        }

        long res = 0;
        for (int val : arr) res += val;
        return res;
    }

    public long solve2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) pq.add(val);

        while (k-- > 0) {
            int temp = pq.remove();
            temp *= -1;
            pq.add(temp);
        }

        long res = 0;
        while (!pq.isEmpty()) res += pq.remove();
        return res;
    }
}
