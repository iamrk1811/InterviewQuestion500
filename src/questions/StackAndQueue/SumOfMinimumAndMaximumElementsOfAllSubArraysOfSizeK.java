package questions.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinimumAndMaximumElementsOfAllSubArraysOfSizeK {
//    Q - https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
    public int solve(int[] arr, int k) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();

        int sum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {

            if (j - i + 1 < k) {
//                min part before hitting K
                if (min.isEmpty()) {
                    min.add(arr[j]);
                } else {
                    while (!min.isEmpty() && min.peekLast() > arr[j]) {
                        min.removeLast();
                    }
                    min.addLast(arr[j]);
                }
//                max part before hitting K
                if (max.isEmpty()) {
                    max.add(arr[j]);
                } else {
                    while (!max.isEmpty() && max.peekLast() < arr[j]) {
                        max.removeLast();
                    }
                    max.addLast(arr[j]);
                }
                j++;
            } else {
//                when we about to hit K
//                min
                while (!min.isEmpty() && min.peekLast() > arr[j]) {
                    min.removeLast();
                }
                min.addLast(arr[j]);

//                max
                while (!max.isEmpty() && max.peekLast() < arr[j]) {
                    max.removeLast();
                }
                max.addLast(arr[j]);

                sum += min.peekFirst() + max.peekFirst();

                if (arr[i] == min.peekFirst()) {
                    min.removeFirst();
                }
                if (arr[i] == max.peekFirst()) {
                    max.removeFirst();
                }
                i++; j++;
            }

        }

        return sum;
    }
}
