package questions.OrderStatisticsHeapHash;

import java.util.Stack;

public class NextGreaterElement {
    //    Q - https://www.geeksforgeeks.org/next-greater-element/
    public long[] solve(long[] arr, int n) {
        long[] res = new long[n];
        res[n - 1] = -1;

        Stack<Long> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return res;
    }
}
