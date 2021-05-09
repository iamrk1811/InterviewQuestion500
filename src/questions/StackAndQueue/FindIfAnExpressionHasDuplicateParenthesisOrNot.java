package questions.StackAndQueue;

import java.util.Stack;

public class FindIfAnExpressionHasDuplicateParenthesisOrNot {
//    Q - https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
    public boolean solve(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return true;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size() != 0;
    }
}
