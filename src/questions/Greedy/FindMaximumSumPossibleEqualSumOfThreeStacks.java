package questions.Greedy;

import java.util.Stack;

public class FindMaximumSumPossibleEqualSumOfThreeStacks {
//    Q - https://www.geeksforgeeks.org/find-maximum-sum-possible-equal-sum-three-stacks/
    public long solve(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        Stack<Integer> temp = new Stack<>();
//        stack1
        long sum1 = 0;
        while (!stack1.isEmpty()) {
            sum1 += stack1.peek();
            temp.push(stack1.pop());
        }

        while (!temp.isEmpty()) {
            stack1.push(temp.pop());
        }

        //  stack2
        long sum2 = 0;
        while (!stack2.isEmpty()) {
            sum2 += stack2.peek();
            temp.push(stack2.pop());
        }

        while (!temp.isEmpty()) {
            stack2.push(temp.pop());
        }

        //  stack2
        long sum3 = 0;
        while (!stack3.isEmpty()) {
            sum3 += stack3.peek();
            temp.push(stack3.pop());
        }

        while (!temp.isEmpty()) {
            stack3.push(temp.pop());
        }

        while (true) {
            if (sum1 == sum2 && sum1 == sum3) return sum1;

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stack1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stack2.pop();
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= stack3.pop();
            }
        }
    }
}
