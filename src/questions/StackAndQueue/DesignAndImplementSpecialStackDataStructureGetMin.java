package questions.StackAndQueue;

import java.util.Stack;

public class DesignAndImplementSpecialStackDataStructureGetMin {
    //    Q - https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        stack.push(val);

        if (min.size() == 0) {
            min.push(val);
        } else if (min.peek() > val) {
            min.push(val);
        }
    }

    public int pop() {
        if (stack.size() == 0) return -1;

        int popped = stack.pop();
        if (popped == min.peek()) {
            min.pop();
        }

        return popped;
    }

    public int min() {
        return min.peek();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
