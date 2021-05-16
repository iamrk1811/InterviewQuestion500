package questions.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumSumOfTwoNumbersFormedFromDigitsOfAnArray {
    //    Q - https://www.geeksforgeeks.org/minimum-sum-two-numbers-formed-digits-array-2/
    public long solve(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        long num1 = 0;
        long num2 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }
        return num1 + num2;
    }
    public int solve2(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) pq.add(val);

        int num1 = 0, num2 = 0;
        while (!pq.isEmpty()) {
            num1 =  num1 * 10 + pq.remove();

            if (!pq.isEmpty())
                num2 = num2 * 10 + pq.remove();
        }
        return num1 + num2;
    }
}
