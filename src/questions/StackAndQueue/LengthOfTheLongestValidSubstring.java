package questions.StackAndQueue;

import java.util.Stack;

public class LengthOfTheLongestValidSubstring {
    //    Q - https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
    public int solve(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
