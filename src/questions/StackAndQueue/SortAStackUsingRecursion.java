package questions.StackAndQueue;

import java.util.Stack;

public class SortAStackUsingRecursion {
//    Q - https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
    public Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return stack;
        }

        int temp = stack.pop();

        sort(stack);

        insert(stack, temp);

        return stack;
    }

    private void insert(Stack<Integer> stack, int data) {
        if (stack.isEmpty() || stack.peek() < data) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insert(stack, data);

        stack.push(temp);
    }
}
