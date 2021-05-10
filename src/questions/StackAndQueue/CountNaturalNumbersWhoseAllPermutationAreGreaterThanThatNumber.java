package questions.StackAndQueue;

import java.util.Stack;

public class CountNaturalNumbersWhoseAllPermutationAreGreaterThanThatNumber {
//    Q - https://www.geeksforgeeks.org/count-natural-numbers-whose-permutation-greater-number/
    public int solve(int n) {
        if (n <= 9) return n;

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 1; i <= 9; i++) {

            stack.push(i);
            result++;

            while (!stack.isEmpty()) {
                int top = stack.pop();
                for (int j = top % 10; j <= 9; j++) {
                    int num = top * 10 + j;
                    if (num <= n) {
                        stack.push(num);
                        result++;
                    }
                }
            }

        }

        return result;
    }
}
